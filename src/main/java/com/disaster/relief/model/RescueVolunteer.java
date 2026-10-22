package com.disaster.relief.model;

import jakarta.persistence.Entity;

@Entity
public class RescueVolunteer extends ReliefWorker {

    public RescueVolunteer() {}

    public RescueVolunteer(String id, String name) {
        super(id, name);
    }

    @Override
    public String assignTask() {
        return "Rescue Volunteer " + getName() + " assigned to Search and Rescue operations.";
    }
}