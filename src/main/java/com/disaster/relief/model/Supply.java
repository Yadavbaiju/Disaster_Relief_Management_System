package com.disaster.relief.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Supply {
    @Id
    private String batchNumber;
    private int quantity;

    public Supply() {}

    public Supply(String batchNumber, int quantity) {
        this.batchNumber = batchNumber;
        this.quantity = quantity;
    }

    public String getBatchNumber() { return batchNumber; }
    public void setBatchNumber(String batchNumber) { this.batchNumber = batchNumber; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}