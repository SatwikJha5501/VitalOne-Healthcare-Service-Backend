package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.dao.AppointmentRequestDAO;
import com.UPZEN.VitalOne.entity.AppointmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentRequestServiceImpl implements AppointmentRequestService {

    private AppointmentRequestDAO appointmentRequestDAO;

    @Autowired
    public AppointmentRequestServiceImpl(AppointmentRequestDAO theAppointmentRequestDAO) {
        appointmentRequestDAO = theAppointmentRequestDAO;
    }

    @Override
    @Transactional
    public List<AppointmentRequest> findAll() {
        return appointmentRequestDAO.findAll();
    }

    @Override
    @Transactional
    public AppointmentRequest findById(int theId) {
        return appointmentRequestDAO.findById(theId);
    }

    @Override
    @Transactional
    public List<AppointmentRequest> findByUserId(int userId) {
        return appointmentRequestDAO.findByUserId(userId);
    }

    @Override
    @Transactional
    public List<AppointmentRequest> findByStatus(String status) {
        return appointmentRequestDAO.findByStatus(status);
    }

    @Override
    @Transactional
    public AppointmentRequest save(AppointmentRequest theAppointmentRequest) {
        return appointmentRequestDAO.save(theAppointmentRequest);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        appointmentRequestDAO.deleteById(theId);
    }
}