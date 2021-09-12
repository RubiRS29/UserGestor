package com.AppGestorUser.GestorUser.repositories;

import com.AppGestorUser.GestorUser.dao.IUserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements IUserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List getUsers() {
        String query = "FROM users";
        return  entityManager.createQuery(query).getResultList();
    }
}
