package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.dao.MedicineDAO;
import com.UPZEN.VitalOne.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineDAO medicineDAO;

    @Autowired
    public MedicineServiceImpl(MedicineDAO theMedicineDAO) {
        medicineDAO = theMedicineDAO;
    }

    @Override
    public List<Medicine> findAll() {
        return medicineDAO.findAll();
    }

    @Override
    public Medicine findById(int theId) {
        return medicineDAO.findById(theId);
    }

    @Transactional
    @Override
    public Medicine save(Medicine theMedicine) {
        return medicineDAO.save(theMedicine);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        medicineDAO.deleteById(theId);
    }
}