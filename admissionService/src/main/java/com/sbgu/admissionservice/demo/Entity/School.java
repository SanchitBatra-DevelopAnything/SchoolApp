package com.sbgu.admissionservice.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "school")
@AllArgsConstructor
@NoArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolId;
    private String name;

    @OneToMany(mappedBy = "generatedFor")
    private List<AdmissionRequest> admissionRequests;

    private String website;

    private String location_latitude;
    private String location_longitude;
}
