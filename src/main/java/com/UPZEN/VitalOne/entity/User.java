package com.UPZEN.VitalOne.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "SapID is mandatory")
    @Column(name = "sap_id", unique = true)
    private String sapId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.PENDING;

    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Batch is mandatory")
    @Column(name = "batch")
    private String batch;

    @NotBlank(message = "Branch is mandatory")
    @Column(name = "branch")
    private String branch;

    @Column(name = "specialization")
    private String specialization;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", unique = true)
    private String email;

    @Size(min = 10, max = 10, message = "Mobile number must be 10 digits")
    @Column(name = "mobile_number")
    private String mobileNumber;

    // Constructors
    public User() {}

    public User(String sapId, String firstName, String lastName, String batch,
                String branch, String specialization, String email, String mobileNumber) {
        this.sapId = sapId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.batch = batch;
        this.branch = branch;
        this.specialization = specialization;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSapId() { return sapId; }
    public void setSapId(String sapId) { this.sapId = sapId; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getBatch() { return batch; }
    public void setBatch(String batch) { this.batch = batch; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sapId='" + sapId + '\'' +
                ", status=" + status +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", batch='" + batch + '\'' +
                ", branch='" + branch + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}