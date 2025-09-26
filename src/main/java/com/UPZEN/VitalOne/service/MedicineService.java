package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.entity.Medicine;
import java.util.List;

public interface MedicineService {
    List<Medicine> findAll();
    Medicine findById(int theId);
    Medicine save(Medicine theMedicine);
    void deleteById(int theId);
}