package com.UPZEN.VitalOne.rest;

import com.UPZEN.VitalOne.entity.AppointmentRequest;
import com.UPZEN.VitalOne.service.AppointmentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment-requests")
public class AppointmentRequestRestController {

    private AppointmentRequestService appointmentRequestService;

    @Autowired
    public AppointmentRequestRestController(AppointmentRequestService theAppointmentRequestService) {
        appointmentRequestService = theAppointmentRequestService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentRequest>> findAll() {
        try {
            List<AppointmentRequest> appointmentRequests = appointmentRequestService.findAll();
            return new ResponseEntity<>(appointmentRequests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<AppointmentRequest> getAppointmentRequest(@PathVariable int requestId) {
        try {
            AppointmentRequest theAppointmentRequest = appointmentRequestService.findById(requestId);
            if (theAppointmentRequest == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(theAppointmentRequest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AppointmentRequest>> getAppointmentRequestsByUser(@PathVariable int userId) {
        try {
            List<AppointmentRequest> appointmentRequests = appointmentRequestService.findByUserId(userId);
            return new ResponseEntity<>(appointmentRequests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AppointmentRequest>> getAppointmentRequestsByStatus(@PathVariable String status) {
        try {
            List<AppointmentRequest> appointmentRequests = appointmentRequestService.findByStatus(status);
            return new ResponseEntity<>(appointmentRequests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<AppointmentRequest> addAppointmentRequest(@RequestBody AppointmentRequest theAppointmentRequest) {
        try {
            theAppointmentRequest.setId(0);
            AppointmentRequest dbAppointmentRequest = appointmentRequestService.save(theAppointmentRequest);
            return new ResponseEntity<>(dbAppointmentRequest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<AppointmentRequest> updateAppointmentRequest(@RequestBody AppointmentRequest theAppointmentRequest) {
        try {
            AppointmentRequest dbAppointmentRequest = appointmentRequestService.save(theAppointmentRequest);
            return new ResponseEntity<>(dbAppointmentRequest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{requestId}")
    public ResponseEntity<AppointmentRequest> patchAppointmentRequest(@PathVariable int requestId, @RequestBody AppointmentRequest patchAppointmentRequest) {
        try {
            AppointmentRequest existingAppointmentRequest = appointmentRequestService.findById(requestId);

            if (existingAppointmentRequest == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            if (patchAppointmentRequest.getUserId() != null) {
                existingAppointmentRequest.setUserId(patchAppointmentRequest.getUserId());
            }
            if (patchAppointmentRequest.getSymptoms() != null) {
                existingAppointmentRequest.setSymptoms(patchAppointmentRequest.getSymptoms());
            }
            if (patchAppointmentRequest.getTags() != null) {
                existingAppointmentRequest.setTags(patchAppointmentRequest.getTags());
            }
            if (patchAppointmentRequest.getStatus() != null) {
                existingAppointmentRequest.setStatus(patchAppointmentRequest.getStatus());
            }
            if (patchAppointmentRequest.getRequestDate() != null) {
                existingAppointmentRequest.setRequestDate(patchAppointmentRequest.getRequestDate());
            }
            if (patchAppointmentRequest.getPreferredDate() != null) {
                existingAppointmentRequest.setPreferredDate(patchAppointmentRequest.getPreferredDate());
            }
            if (patchAppointmentRequest.getPreferredDoctor() != null) {
                existingAppointmentRequest.setPreferredDoctor(patchAppointmentRequest.getPreferredDoctor());
            }
            if (patchAppointmentRequest.getAdditionalNotes() != null) {
                existingAppointmentRequest.setAdditionalNotes(patchAppointmentRequest.getAdditionalNotes());
            }

            AppointmentRequest updatedAppointmentRequest = appointmentRequestService.save(existingAppointmentRequest);
            return new ResponseEntity<>(updatedAppointmentRequest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<String> deleteAppointmentRequest(@PathVariable int requestId) {
        try {
            AppointmentRequest tempAppointmentRequest = appointmentRequestService.findById(requestId);
            if (tempAppointmentRequest == null) {
                return new ResponseEntity<>("Appointment request id not found - " + requestId, HttpStatus.NOT_FOUND);
            }

            appointmentRequestService.deleteById(requestId);
            return new ResponseEntity<>("Deleted appointment request id - " + requestId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting appointment request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}