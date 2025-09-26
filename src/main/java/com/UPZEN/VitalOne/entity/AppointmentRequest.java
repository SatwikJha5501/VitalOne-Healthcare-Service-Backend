package com.UPZEN.VitalOne.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment_request")
public class AppointmentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "User ID is mandatory")
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "Symptoms description is mandatory")
    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "tags")
    private String tags; // e.g., "Emergency", "Routine", "Follow-up"

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentRequestStatus status = AppointmentRequestStatus.PENDING;

    @Column(name = "request_date")
    private LocalDateTime requestDate = LocalDateTime.now();

    @Column(name = "preferred_date")
    private LocalDateTime preferredDate;

    @Column(name = "preferred_doctor")
    private String preferredDoctor;

    @Column(name = "additional_notes")
    private String additionalNotes;

    // Constructors
    public AppointmentRequest() {}

    public AppointmentRequest(Integer userId, String symptoms, String tags,
                              LocalDateTime preferredDate, String preferredDoctor,
                              String additionalNotes) {
        this.userId = userId;
        this.symptoms = symptoms;
        this.tags = tags;
        this.preferredDate = preferredDate;
        this.preferredDoctor = preferredDoctor;
        this.additionalNotes = additionalNotes;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public AppointmentRequestStatus getStatus() { return status; }
    public void setStatus(AppointmentRequestStatus status) { this.status = status; }

    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }

    public LocalDateTime getPreferredDate() { return preferredDate; }
    public void setPreferredDate(LocalDateTime preferredDate) { this.preferredDate = preferredDate; }

    public String getPreferredDoctor() { return preferredDoctor; }
    public void setPreferredDoctor(String preferredDoctor) { this.preferredDoctor = preferredDoctor; }

    public String getAdditionalNotes() { return additionalNotes; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }

    @Override
    public String toString() {
        return "AppointmentRequest{" +
                "id=" + id +
                ", userId=" + userId +
                ", symptoms='" + symptoms + '\'' +
                ", tags='" + tags + '\'' +
                ", status=" + status +
                ", requestDate=" + requestDate +
                ", preferredDate=" + preferredDate +
                ", preferredDoctor='" + preferredDoctor + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }
}