package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDAOJpaImpl implements DoctorDAO {

    private EntityManager entityManager;

    @Autowired
    public DoctorDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Doctor> findAll() {
        TypedQuery<Doctor> theQuery = entityManager.createQuery("from Doctor", Doctor.class);
        return theQuery.getResultList();
    }

    @Override
    public Doctor findById(int theId) {
        return entityManager.find(Doctor.class, theId);
    }

    @Override
    public List<Doctor> findBySpecialization(String specialization) {
        TypedQuery<Doctor> theQuery = entityManager.createQuery(
                "from Doctor where specialization like :specialization", Doctor.class);
        theQuery.setParameter("specialization", "%" + specialization + "%");
        return theQuery.getResultList();
    }

    @Override
    public List<Doctor> findByName(String name) {
        TypedQuery<Doctor> theQuery = entityManager.createQuery(
                "from Doctor where name like :name", Doctor.class);
        theQuery.setParameter("name", "%" + name + "%");
        return theQuery.getResultList();
    }

    @Override
    public Doctor save(Doctor theDoctor) {
        return entityManager.merge(theDoctor);
    }

    @Override
    public void deleteById(int theId) {
        Doctor theDoctor = entityManager.find(Doctor.class, theId);
        entityManager.remove(theDoctor);
    }
}