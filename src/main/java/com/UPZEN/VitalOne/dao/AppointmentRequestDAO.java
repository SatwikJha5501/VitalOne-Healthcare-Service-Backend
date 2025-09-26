package com.UPZEN.VitalOne.dao;

import com.UPZEN.VitalOne.entity.AppointmentRequest;
import java.util.List;

public interface AppointmentRequestDAO {
    List<AppointmentRequest> findAll();
    AppointmentRequest findById(int theId);
    List<AppointmentRequest> findByUserId(int userId);
    List<AppointmentRequest> findByStatus(String status);
    AppointmentRequest save(AppointmentRequest theAppointmentRequest);
    void deleteById(int theId);
}