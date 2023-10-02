package com.formationspring.sncfchatp3.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Train")
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="reference",nullable = false, length = 50, unique = true)
    private String reference;

    @Column(name="creation_date")
    private LocalDate creationDate;

    private long travels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getTravels() {
        return travels;
    }

    public void setTravels(long travels) {
        this.travels = travels;
    }
}
