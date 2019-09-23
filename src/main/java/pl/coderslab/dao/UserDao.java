package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao extends GenericDao <User> {
        private EntityManager entityManager;


    public UserDao() {
        super(User.class);
    }





}
