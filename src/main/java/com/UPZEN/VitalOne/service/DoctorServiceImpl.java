package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.dao.DoctorDAO;
import com.UPZEN.VitalOne.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorDAO doctorDAO;

    @Autowired
    public DoctorServiceImpl(DoctorDAO theDoctorDAO) {
        doctorDAO = theDoctorDAO;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorDAO.findAll();
    }

    @Override
    public Doctor findById(int theId) {
        return doctorDAO.findById(theId);
    }

    @Override
    public List<Doctor> findBySpecialization(String specialization) {
        return doctorDAO.findBySpecialization(specialization);
    }

    @Override
    public List<Doctor> findByName(String name) {
        return doctorDAO.findByName(name);
    }

    @Transactional
    @Override
    public Doctor save(Doctor theDoctor) {
        return doctorDAO.save(theDoctor);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        doctorDAO.deleteById(theId);
    }
}