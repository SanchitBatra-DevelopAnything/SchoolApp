package com.sbgu.admissionservice.demo.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolId;
    private String name;

    @OneToMany(mappedBy = "generatedFor")
    private List<AdmissionRequest> admissionRequests;
}
