package com.UPZEN.VitalOne.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "User ID is mandatory")
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "Doctor name is mandatory")
    @Column(name = "doctor_name")
    private String doctorName;

    @NotNull(message = "Appointment date and time is mandatory")
    @Column(name = "appointment_datetime")
    private LocalDateTime appointmentDateTime;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "tags")
    private String tags;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentStatus status = AppointmentStatus.PENDING;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "notes")
    private String notes;

    // Constructors
    public Appointment() {}

    public Appointment(Integer userId, String doctorName, LocalDateTime appointmentDateTime,
                       String symptoms, String tags, String diagnosis, String notes) {
        this.userId = userId;
        this.doctorName = doctorName;
        this.appointmentDateTime = appointmentDateTime;
        this.symptoms = symptoms;
        this.tags = tags;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public LocalDateTime getAppointmentDateTime() { return appointmentDateTime; }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) { this.appointmentDateTime = appointmentDateTime; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public AppointmentStatus getStatus() { return status; }
    public void setStatus(AppointmentStatus status) { this.status = status; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", userId=" + userId +
                ", doctorName='" + doctorName + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", symptoms='" + symptoms + '\'' +
                ", tags='" + tags + '\'' +
                ", status=" + status +
                ", diagnosis='" + diagnosis + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}