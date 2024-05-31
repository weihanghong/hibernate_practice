package com.hong.model;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Doctor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private Hospital hospital;

    @OneToOne(cascade = CascadeType.ALL)
    private ScheduleProfile schedule;

    @ManyToMany(targetEntity = Patient.class)
    private Set<Patient> PatientSet;

    public Doctor(){}

    public Doctor(String name, Hospital hospital) {
        super();
        this.name = name;
        this.hospital = hospital;
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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public ScheduleProfile getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleProfile schedule) {
        this.schedule = schedule;
    }

    public Set<Patient> getPatientSet() {
        return PatientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        PatientSet = patientSet;
    }
}
