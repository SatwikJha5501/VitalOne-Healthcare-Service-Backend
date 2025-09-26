package com.UPZEN.VitalOne.rest;

import com.UPZEN.VitalOne.entity.Prescription;
import com.UPZEN.VitalOne.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionRestController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionRestController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public List<Prescription> findAll() {
        return prescriptionService.findAll();
    }

    @GetMapping("/{id}")
    public Prescription findById(@PathVariable int id) {
        return prescriptionService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Prescription> findByUserId(@PathVariable int userId) {
        return prescriptionService.findByUserId(userId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Prescription> findByDoctorId(@PathVariable int doctorId) {
        return prescriptionService.findByDoctorId(doctorId);
    }

    @GetMapping("/status/{status}")
    public List<Prescription> findByStatus(@PathVariable Prescription.Status status) {
        return prescriptionService.findByStatus(status);
    }

    @PostMapping
    public Prescription addPrescription(@RequestBody Prescription prescription) {
        // Ensure status is set to ACTIVE regardless of input
        prescription.setStatus(Prescription.Status.ACTIVE);
        return prescriptionService.save(prescription);
    }

    @PutMapping
    public Prescription updatePrescription(@RequestBody Prescription prescription) {
        return prescriptionService.save(prescription);
    }

    @DeleteMapping("/{id}")
    public String deletePrescription(@PathVariable int id) {
        prescriptionService.deleteById(id);
        return "Deleted prescription with id: " + id;
    }
}