package com.disaster.relief.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReliefWorker {
    @Id
    private String id;
    private String name;

    public ReliefWorker() {} // Required empty constructor for JPA

    public ReliefWorker(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String assignTask();

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}