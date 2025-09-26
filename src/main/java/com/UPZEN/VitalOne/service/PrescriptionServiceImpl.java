package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.dao.PrescriptionDAO;
import com.UPZEN.VitalOne.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionDAO prescriptionDAO;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionDAO prescriptionDAO) {
        this.prescriptionDAO = prescriptionDAO;
    }

    @Override
    public List<Prescription> findAll() {
        return prescriptionDAO.findAll();
    }

    @Override
    public Prescription findById(int id) {
        return prescriptionDAO.findById(id);
    }

    @Transactional
    @Override
    public Prescription save(Prescription prescription) {
        return prescriptionDAO.save(prescription);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        prescriptionDAO.deleteById(id);
    }

    @Override
    public List<Prescription> findByUserId(int userId) {
        return prescriptionDAO.findByUserId(userId);
    }

    @Override
    public List<Prescription> findByDoctorId(int doctorId) {
        return prescriptionDAO.findByDoctorId(doctorId);
    }

    @Override
    public List<Prescription> findByStatus(Prescription.Status status) {
        return prescriptionDAO.findByStatus(status);
    }
}