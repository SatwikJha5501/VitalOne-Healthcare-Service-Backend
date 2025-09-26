package com.UPZEN.VitalOne.rest;

import com.UPZEN.VitalOne.entity.Medicine;
import com.UPZEN.VitalOne.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineRestController {

    private MedicineService medicineService;

    @Autowired
    public MedicineRestController(MedicineService theMedicineService) {
        medicineService = theMedicineService;
    }

    @GetMapping
    public List<Medicine> findAll() {
        return medicineService.findAll();
    }

    @GetMapping("/{medicineId}")
    public Medicine getMedicine(@PathVariable int medicineId) {
        Medicine theMedicine = medicineService.findById(medicineId);
        if (theMedicine == null) {
            throw new RuntimeException("Medicine id not found - " + medicineId);
        }
        return theMedicine;
    }

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine theMedicine) {
        theMedicine.setId(0); // Force save new item
        return medicineService.save(theMedicine);
    }

    @PutMapping
    public Medicine updateMedicine(@RequestBody Medicine theMedicine) {
        return medicineService.save(theMedicine);
    }

    @DeleteMapping("/{medicineId}")
    public String deleteMedicine(@PathVariable int medicineId) {
        Medicine tempMedicine = medicineService.findById(medicineId);
        if (tempMedicine == null) {
            throw new RuntimeException("Medicine id not found - " + medicineId);
        }
        medicineService.deleteById(medicineId);
        return "Deleted medicine id - " + medicineId;
    }
}