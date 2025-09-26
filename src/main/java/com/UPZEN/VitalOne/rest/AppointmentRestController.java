package com.UPZEN.VitalOne.rest;

import com.UPZEN.VitalOne.entity.Appointment;
import com.UPZEN.VitalOne.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentRestController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentRestController(AppointmentService theAppointmentService) {
        appointmentService = theAppointmentService;
    }

    @GetMapping
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointment(@PathVariable int appointmentId) {
        Appointment theAppointment = appointmentService.findById(appointmentId);
        if (theAppointment == null) {
            throw new RuntimeException("Appointment id not found - " + appointmentId);
        }
        return theAppointment;
    }

    @GetMapping("/user/{userId}")
    public List<Appointment> getAppointmentsByUser(@PathVariable int userId) {
        return appointmentService.findByUserId(userId);
    }

    @GetMapping("/doctor/{doctorName}")
    public List<Appointment> getAppointmentsByDoctor(@PathVariable String doctorName) {
        return appointmentService.findByDoctorName(doctorName);
    }

    @GetMapping("/status/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status) {
        return appointmentService.findByStatus(status);
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment theAppointment) {
        theAppointment.setId(0);
        return appointmentService.save(theAppointment);
    }

    @PutMapping
    public Appointment updateAppointment(@RequestBody Appointment theAppointment) {
        return appointmentService.save(theAppointment);
    }

    @PatchMapping("/{appointmentId}")
    public Appointment patchAppointment(@PathVariable int appointmentId, @RequestBody Appointment patchAppointment) {
        Appointment existingAppointment = appointmentService.findById(appointmentId);

        if (existingAppointment == null) {
            throw new RuntimeException("Appointment id not found - " + appointmentId);
        }

        if (patchAppointment.getUserId() != null) {
            existingAppointment.setUserId(patchAppointment.getUserId());
        }
        if (patchAppointment.getDoctorName() != null) {
            existingAppointment.setDoctorName(patchAppointment.getDoctorName());
        }
        if (patchAppointment.getAppointmentDateTime() != null) {
            existingAppointment.setAppointmentDateTime(patchAppointment.getAppointmentDateTime());
        }
        if (patchAppointment.getSymptoms() != null) {
            existingAppointment.setSymptoms(patchAppointment.getSymptoms());
        }
        if (patchAppointment.getTags() != null) {
            existingAppointment.setTags(patchAppointment.getTags());
        }
        if (patchAppointment.getStatus() != null) {
            existingAppointment.setStatus(patchAppointment.getStatus());
        }
        if (patchAppointment.getDiagnosis() != null) {
            existingAppointment.setDiagnosis(patchAppointment.getDiagnosis());
        }
        if (patchAppointment.getNotes() != null) {
            existingAppointment.setNotes(patchAppointment.getNotes());
        }

        return appointmentService.save(existingAppointment);
    }

    @DeleteMapping("/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId) {
        Appointment tempAppointment = appointmentService.findById(appointmentId);
        if (tempAppointment == null) {
            throw new RuntimeException("Appointment id not found - " + appointmentId);
        }
        appointmentService.deleteById(appointmentId);
        return "Deleted appointment id - " + appointmentId;
    }
}