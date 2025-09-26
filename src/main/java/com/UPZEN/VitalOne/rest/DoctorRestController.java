package com.UPZEN.VitalOne.rest;

import com.UPZEN.VitalOne.entity.Doctor;
import com.UPZEN.VitalOne.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRestController {

    private DoctorService doctorService;

    @Autowired
    public DoctorRestController(DoctorService theDoctorService) {
        doctorService = theDoctorService;
    }

    @GetMapping
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctor(@PathVariable int doctorId) {
        Doctor theDoctor = doctorService.findById(doctorId);
        if (theDoctor == null) {
            throw new RuntimeException("Doctor id not found - " + doctorId);
        }
        return theDoctor;
    }

    @GetMapping("/specialization/{specialization}")
    public List<Doctor> getDoctorsBySpecialization(@PathVariable String specialization) {
        return doctorService.findBySpecialization(specialization);
    }

    @GetMapping("/name/{name}")
    public List<Doctor> getDoctorsByName(@PathVariable String name) {
        return doctorService.findByName(name);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor theDoctor) {
        theDoctor.setId(0);
        return doctorService.save(theDoctor);
    }

    @PutMapping
    public Doctor updateDoctor(@RequestBody Doctor theDoctor) {
        return doctorService.save(theDoctor);
    }

    @PatchMapping("/{doctorId}")
    public Doctor patchDoctor(@PathVariable int doctorId, @RequestBody Doctor patchDoctor) {
        Doctor existingDoctor = doctorService.findById(doctorId);

        if (existingDoctor == null) {
            throw new RuntimeException("Doctor id not found - " + doctorId);
        }

        if (patchDoctor.getName() != null) {
            existingDoctor.setName(patchDoctor.getName());
        }
        if (patchDoctor.getSpecialization() != null) {
            existingDoctor.setSpecialization(patchDoctor.getSpecialization());
        }
        if (patchDoctor.getQualification() != null) {
            existingDoctor.setQualification(patchDoctor.getQualification());
        }
        if (patchDoctor.getDepartment() != null) {
            existingDoctor.setDepartment(patchDoctor.getDepartment());
        }
        if (patchDoctor.getContactNumber() != null) {
            existingDoctor.setContactNumber(patchDoctor.getContactNumber());
        }
        if (patchDoctor.getEmail() != null) {
            existingDoctor.setEmail(patchDoctor.getEmail());
        }
        if (patchDoctor.getOfficeRoom() != null) {
            existingDoctor.setOfficeRoom(patchDoctor.getOfficeRoom());
        }
        if (patchDoctor.getAvailableDays() != null) {
            existingDoctor.setAvailableDays(patchDoctor.getAvailableDays());
        }
        if (patchDoctor.getAvailableTimeSlots() != null) {
            existingDoctor.setAvailableTimeSlots(patchDoctor.getAvailableTimeSlots());
        }
        if (patchDoctor.getIsAvailable() != null) {
            existingDoctor.setIsAvailable(patchDoctor.getIsAvailable());
        }

        return doctorService.save(existingDoctor);
    }

    @DeleteMapping("/{doctorId}")
    public String deleteDoctor(@PathVariable int doctorId) {
        Doctor tempDoctor = doctorService.findById(doctorId);
        if (tempDoctor == null) {
            throw new RuntimeException("Doctor id not found - " + doctorId);
        }
        doctorService.deleteById(doctorId);
        return "Deleted doctor id - " + doctorId;
    }
}