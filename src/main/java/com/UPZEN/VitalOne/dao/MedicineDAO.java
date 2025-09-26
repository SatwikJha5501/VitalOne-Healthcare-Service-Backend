package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.Medicine;
import java.util.List;

public interface MedicineDAO {
    List<Medicine> findAll();
    Medicine findById(int theId);
    Medicine save(Medicine theMedicine);
    void deleteById(int theId);
}