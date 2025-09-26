package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.dao.AppointmentDAO;
import com.UPZEN.VitalOne.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDAO appointmentDAO;

    @Autowired
    public AppointmentServiceImpl(AppointmentDAO theAppointmentDAO) {
        appointmentDAO = theAppointmentDAO;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentDAO.findAll();
    }

    @Override
    public Appointment findById(int theId) {
        return appointmentDAO.findById(theId);
    }

    @Override
    public List<Appointment> findByUserId(int userId) {
        return appointmentDAO.findByUserId(userId);
    }

    @Override
    public List<Appointment> findByDoctorName(String doctorName) {
        return appointmentDAO.findByDoctorName(doctorName);
    }

    @Override
    public List<Appointment> findByStatus(String status) {
        return appointmentDAO.findByStatus(status);
    }

    @Transactional
    @Override
    public Appointment save(Appointment theAppointment) {
        return appointmentDAO.save(theAppointment);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        appointmentDAO.deleteById(theId);
    }
}