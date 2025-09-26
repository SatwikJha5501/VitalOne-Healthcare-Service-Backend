package com.UPZEN.VitalOne.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Doctor name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Specialization is mandatory")
    @Column(name = "specialization")
    private String specialization;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "department")
    private String department;

    @Size(min = 10, max = 10, message = "Contact number must be 10 digits")
    @Column(name = "contact_number")
    private String contactNumber;

    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @Column(name = "office_room")
    private String officeRoom;

    @Column(name = "available_days")
    private String availableDays;

    @Column(name = "available_time_slots")
    private String availableTimeSlots;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    // Constructors
    public Doctor() {}

    public Doctor(String name, String specialization, String qualification,
                  String department, String contactNumber, String email,
                  String officeRoom, String availableDays, String availableTimeSlots) {
        this.name = name;
        this.specialization = specialization;
        this.qualification = qualification;
        this.department = department;
        this.contactNumber = contactNumber;
        this.email = email;
        this.officeRoom = officeRoom;
        this.availableDays = availableDays;
        this.availableTimeSlots = availableTimeSlots;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOfficeRoom() { return officeRoom; }
    public void setOfficeRoom(String officeRoom) { this.officeRoom = officeRoom; }

    public String getAvailableDays() { return availableDays; }
    public void setAvailableDays(String availableDays) { this.availableDays = availableDays; }

    public String getAvailableTimeSlots() { return availableTimeSlots; }
    public void setAvailableTimeSlots(String availableTimeSlots) { this.availableTimeSlots = availableTimeSlots; }

    public Boolean getIsAvailable() { return isAvailable; }
    public void setIsAvailable(Boolean isAvailable) { this.isAvailable = isAvailable; }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                ", department='" + department + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", officeRoom='" + officeRoom + '\'' +
                ", availableDays='" + availableDays + '\'' +
                ", availableTimeSlots='" + availableTimeSlots + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}