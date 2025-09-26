package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.Medicine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MedicineDAOJpaImpl implements MedicineDAO {

    private EntityManager entityManager;

    @Autowired
    public MedicineDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Medicine> findAll() {
        TypedQuery<Medicine> theQuery = entityManager.createQuery("FROM Medicine", Medicine.class);
        return theQuery.getResultList();
    }

    @Override
    public Medicine findById(int theId) {
        return entityManager.find(Medicine.class, theId);
    }

    @Override
    public Medicine save(Medicine theMedicine) {
        return entityManager.merge(theMedicine);
    }

    @Override
    public void deleteById(int theId) {
        Medicine theMedicine = entityManager.find(Medicine.class, theId);
        entityManager.remove(theMedicine);
    }
}