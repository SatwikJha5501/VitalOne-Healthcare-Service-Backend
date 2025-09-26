package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.entity.Doctor;
import java.util.List;

public interface DoctorService {
    List<Doctor> findAll();
    Doctor findById(int theId);
    List<Doctor> findBySpecialization(String specialization);
    List<Doctor> findByName(String name);
    Doctor save(Doctor theDoctor);
    void deleteById(int theId);
}