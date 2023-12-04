package com.sbgu.admissionservice.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "criteria")
public class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long criteriaId;

    private String forClass;
    private Long maximumAge;
    private Long maximumKilometers;
}
