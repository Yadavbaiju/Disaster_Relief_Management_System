package com.disaster.relief.model;

import jakarta.persistence.Entity;

@Entity
public class MedicalSupply extends Supply {
    private boolean requiresRefrigeration;

    public MedicalSupply() {}

    public MedicalSupply(String batchNumber, int quantity, boolean requiresRefrigeration) {
        super(batchNumber, quantity);
        this.requiresRefrigeration = requiresRefrigeration;
    }

    public boolean isRequiresRefrigeration() { return requiresRefrigeration; }
    public void setRequiresRefrigeration(boolean requiresRefrigeration) { this.requiresRefrigeration = requiresRefrigeration; }
}