package com.disaster.relief.model;

import jakarta.persistence.Entity;

@Entity
public class FoodSupply extends Supply {
    private String expiryDate;

    public FoodSupply() {}

    public FoodSupply(String batchNumber, int quantity, String expiryDate) {
        super(batchNumber, quantity);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
}