package pl.coderslab.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Pushups;

import javax.persistence.EntityManager;

@Repository
public class PushUpsDao extends GenericDao <Pushups> {
    private EntityManager entityManager;


    public PushUpsDao() {
        super(Pushups.class);
    }


}
