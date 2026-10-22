package com.disaster.relief.model;

import jakarta.persistence.Entity;

@Entity
public class FoodVolunteer extends ReliefWorker {

    public FoodVolunteer() {}

    public FoodVolunteer(String id, String name) {
        super(id, name);
    }

    @Override
    public String assignTask() {
        return "Food Volunteer " + getName() + " assigned to Rationing and Food Distribution Center.";
    }
}