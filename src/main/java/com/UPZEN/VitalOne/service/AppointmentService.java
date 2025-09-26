package com.UPZEN.VitalOne.service;

import com.UPZEN.VitalOne.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
    Appointment findById(int theId);
    List<Appointment> findByUserId(int userId);
    List<Appointment> findByDoctorName(String doctorName);
    List<Appointment> findByStatus(String status);
    Appointment save(Appointment theAppointment);
    void deleteById(int theId);
}