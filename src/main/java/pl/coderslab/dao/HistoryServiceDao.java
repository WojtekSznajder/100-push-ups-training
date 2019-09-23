package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.UserHistoryPushUps;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HistoryServiceDao extends  GenericDao<UserHistoryPushUps>{

    public HistoryServiceDao() {
        super(UserHistoryPushUps.class);
    }





}
