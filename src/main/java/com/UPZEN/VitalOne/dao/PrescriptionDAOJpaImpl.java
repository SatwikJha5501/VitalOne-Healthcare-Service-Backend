package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.Prescription;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PrescriptionDAOJpaImpl implements PrescriptionDAO {

    private EntityManager entityManager;

    @Autowired
    public PrescriptionDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Prescription> findAll() {
        return entityManager.createQuery("FROM Prescription", Prescription.class).getResultList();
    }

    @Override
    public Prescription findById(int id) {
        return entityManager.find(Prescription.class, id);
    }

    @Override
    public Prescription save(Prescription prescription) {
        return entityManager.merge(prescription);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Prescription.class, id));
    }

    @Override
    public List<Prescription> findByUserId(int userId) {
        return entityManager.createQuery(
                        "FROM Prescription WHERE userId = :userId", Prescription.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Prescription> findByDoctorId(int doctorId) {
        return entityManager.createQuery(
                        "FROM Prescription WHERE doctorId = :doctorId", Prescription.class)
                .setParameter("doctorId", doctorId)
                .getResultList();
    }

    @Override
    public List<Prescription> findByStatus(Prescription.Status status) {
        return entityManager.createQuery(
                        "FROM Prescription WHERE status = :status", Prescription.class)
                .setParameter("status", status)
                .getResultList();
    }
}