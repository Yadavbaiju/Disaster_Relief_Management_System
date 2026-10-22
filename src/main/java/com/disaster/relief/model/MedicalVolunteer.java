package com.disaster.relief.model;

import jakarta.persistence.Entity;

@Entity
public class MedicalVolunteer extends ReliefWorker {

    public MedicalVolunteer() {}

    public MedicalVolunteer(String id, String name) {
        super(id, name);
    }

    @Override
    public String assignTask() {
        return "Medical Volunteer " + getName() + " assigned to Triage and First Aid Unit.";
    }
}