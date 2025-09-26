package com.UPZEN.VitalOne.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "manufacturing_date", nullable = false)
    private LocalDate manufacturingDate;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private MedicineType type;

    @Column(name = "description")
    private String description;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "composition")
    private String composition;

    @Column(name = "uses")
    private String uses;

    @Column(name = "side_effects")
    private String sideEffects;

    // Enum for Medicine Types
    public enum MedicineType {
        TABLET, CAPSULE, SYRUP, INJECTION, OINTMENT, DROPS, INHALER, OTHER
    }

    // Constructors
    public Medicine() {}

    public Medicine(String name, double price, LocalDate manufacturingDate, LocalDate expiryDate,
                    MedicineType type, String description, String manufacturer, int quantityInStock,
                    String batchNumber, String composition, String uses, String sideEffects) {
        this.name = name;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.type = type;
        this.description = description;
        this.manufacturer = manufacturer;
        this.quantityInStock = quantityInStock;
        this.batchNumber = batchNumber;
        this.composition = composition;
        this.uses = uses;
        this.sideEffects = sideEffects;
    }

    // Getters and Setters (same pattern as Employee)
    // [Include all getters and setters for each field]
    // toString method

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public MedicineType getType() {
        return type;
    }

    public void setType(MedicineType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturingDate=" + manufacturingDate +
                ", expiryDate=" + expiryDate +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", batchNumber='" + batchNumber + '\'' +
                ", composition='" + composition + '\'' +
                ", uses='" + uses + '\'' +
                ", sideEffects='" + sideEffects + '\'' +
                '}';
    }
}