package com.sbgu.admissionservice.demo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    private String first_name;

    private String last_name;

    private int age;

    private int std_class;

    private String location_latitude;

    private String location_longitude;

    @OneToMany(mappedBy = "generatedBy")
    @JsonManagedReference
    private List<AdmissionRequest> requestsList;
}
