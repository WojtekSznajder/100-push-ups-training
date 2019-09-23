package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Pushups;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserHistoryPushUps;
import pl.coderslab.repository.UserHistoryPushUpsRepo;


import javax.persistence.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Transactional
public abstract class GenericDao<T> {
    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> clazz;
    @Autowired
    private UserHistoryPushUpsRepo userHistoryPushUpsRepo;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }


    public Collection<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery(
                String.format("select s FROM %s s", clazz.getSimpleName()), clazz);

        return query.getResultList();
    }

    public List<Pushups> getTrainingSchedulePushUps(User user) {
        Query query = entityManager.createQuery("Select b from Pushups b where testScore >:testScore");
        query.setParameter("testScore", user.getPushUpsRep());
        return query.getResultList();
    }


    public List<Integer> getTrainingScheduleSitUps(User user) {
        Query query = entityManager.createQuery("Select b from Situps b where testScore >:testScore");
        query.setParameter("testScore", user.getSitUpsRep());
        return query.getResultList();
    }

    public List<Object> getHistorySchedule(User user) {
        List<UserHistoryPushUps> userHistoryPushUps = userHistoryPushUpsRepo.findAllByUsers(user);
        List<Object> trening = new ArrayList<>();
        for(UserHistoryPushUps u : userHistoryPushUps){
            Query query = entityManager.createQuery("Select b from Pushups b where id =:id");

            query.setParameter("id", u.getId());
            trening.add(query.getSingleResult());
        }


        return trening;
    }


    public boolean checkLogin(Cookie[] cookies) {
        String cookieName = "user";
        for (Cookie c : cookies) {
            if (cookieName.equals(c.getName())) {
                return true;
            }
        }
        return false;
    }

    public String getLoginFromCookies (Cookie[] cookies) {
        String cookieName = "user";
        for (Cookie c : cookies) {
            if (cookieName.equals(c.getName())) {
                return c.getValue();
            }
        }
        return "";

    }



    public void save(T entity) {
        entityManager.persist(entity);


    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void delete(long id) {
        entityManager.remove(findById(id));
    }


}