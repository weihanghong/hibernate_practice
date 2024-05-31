package com.hong.model;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
public class Specialty implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private Doctor doctor;

    public Specialty() {}

    public Specialty(String name, Doctor doctor) {
        super();
        this.name = name;
        this.doctor = doctor;
    }

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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
