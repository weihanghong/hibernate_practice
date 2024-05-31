package com.hong.model;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class ScheduleProfile implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    public enum visitType {
        ANNUAL,
        CHECKUP,
        SICK,
        CONSULT
    }
    private visitType type;
    private Date date;

    public ScheduleProfile() {

    }
    public ScheduleProfile(visitType type, Date date) {
        super();
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public visitType getType() {
        return type;
    }

    public void setType(visitType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
