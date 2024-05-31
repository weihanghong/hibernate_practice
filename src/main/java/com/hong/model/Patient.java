package com.hong.model;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
public class Patient implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    public Patient(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    public Patient(){}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}