package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOJpaImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);
        return theQuery.getResultList();
    }

    @Override
    public User findById(int theId) {
        return entityManager.find(User.class, theId);
    }

    @Override
    public User findBySapId(String sapId) {
        TypedQuery<User> theQuery = entityManager.createQuery(
                "from User where sapId=:sapId", User.class);
        theQuery.setParameter("sapId", sapId);
        return theQuery.getSingleResult();
    }

    @Override
    public User save(User theUser) {
        return entityManager.merge(theUser);
    }

    @Override
    public void deleteById(int theId) {
        User theUser = entityManager.find(User.class, theId);
        entityManager.remove(theUser);
    }
}