package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.Appointment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentDAOJpaImpl implements AppointmentDAO {

    private EntityManager entityManager;

    @Autowired
    public AppointmentDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Appointment> findAll() {
        TypedQuery<Appointment> theQuery = entityManager.createQuery("from Appointment", Appointment.class);
        return theQuery.getResultList();
    }

    @Override
    public Appointment findById(int theId) {
        return entityManager.find(Appointment.class, theId);
    }

    @Override
    public List<Appointment> findByUserId(int userId) {
        TypedQuery<Appointment> theQuery = entityManager.createQuery(
                "from Appointment where userId = :userId", Appointment.class);
        theQuery.setParameter("userId", userId);
        return theQuery.getResultList();
    }

    @Override
    public List<Appointment> findByDoctorName(String doctorName) {
        TypedQuery<Appointment> theQuery = entityManager.createQuery(
                "from Appointment where doctorName like :doctorName", Appointment.class);
        theQuery.setParameter("doctorName", "%" + doctorName + "%");
        return theQuery.getResultList();
    }

    @Override
    public List<Appointment> findByStatus(String status) {
        TypedQuery<Appointment> theQuery = entityManager.createQuery(
                "from Appointment where status = :status", Appointment.class);
        theQuery.setParameter("status", status);
        return theQuery.getResultList();
    }

    @Override
    public Appointment save(Appointment theAppointment) {
        return entityManager.merge(theAppointment);
    }

    @Override
    public void deleteById(int theId) {
        Appointment theAppointment = entityManager.find(Appointment.class, theId);
        entityManager.remove(theAppointment);
    }
}