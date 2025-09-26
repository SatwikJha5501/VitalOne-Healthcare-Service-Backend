package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.entity.Prescription;
import java.util.List;

public interface PrescriptionService {
    List<Prescription> findAll();
    Prescription findById(int id);
    Prescription save(Prescription prescription);
    void deleteById(int id);
    List<Prescription> findByUserId(int userId);
    List<Prescription> findByDoctorId(int doctorId);
    List<Prescription> findByStatus(Prescription.Status status);
}