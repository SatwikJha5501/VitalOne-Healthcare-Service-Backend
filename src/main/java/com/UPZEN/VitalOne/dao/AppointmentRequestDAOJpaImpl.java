package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.AppointmentRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRequestDAOJpaImpl implements AppointmentRequestDAO {

    private EntityManager entityManager;

    @Autowired
    public AppointmentRequestDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<AppointmentRequest> findAll() {
        TypedQuery<AppointmentRequest> theQuery = entityManager.createQuery("from AppointmentRequest", AppointmentRequest.class);
        return theQuery.getResultList();
    }

    @Override
    public AppointmentRequest findById(int theId) {
        return entityManager.find(AppointmentRequest.class, theId);
    }

    @Override
    public List<AppointmentRequest> findByUserId(int userId) {
        TypedQuery<AppointmentRequest> theQuery = entityManager.createQuery(
                "from AppointmentRequest where userId = :userId", AppointmentRequest.class);
        theQuery.setParameter("userId", userId);
        return theQuery.getResultList();
    }

    @Override
    public List<AppointmentRequest> findByStatus(String status) {
        TypedQuery<AppointmentRequest> theQuery = entityManager.createQuery(
                "from AppointmentRequest where status = :status", AppointmentRequest.class);
        theQuery.setParameter("status", status);
        return theQuery.getResultList();
    }

    @Override
    public AppointmentRequest save(AppointmentRequest theAppointmentRequest) {
        return entityManager.merge(theAppointmentRequest);
    }

    @Override
    public void deleteById(int theId) {
        AppointmentRequest theAppointmentRequest = entityManager.find(AppointmentRequest.class, theId);
        if (theAppointmentRequest != null) {
            entityManager.remove(theAppointmentRequest);
        }
    }
}