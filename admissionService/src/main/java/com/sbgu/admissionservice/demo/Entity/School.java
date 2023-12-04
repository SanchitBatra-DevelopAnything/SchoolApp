package com.sbgu.admissionservice.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class School{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolId;

    @Embedded
    BasicSchoolData basicData;

    @OneToMany(mappedBy = "generatedFor" , fetch = FetchType.LAZY)
    private List<AdmissionRequest> admissionRequests;

    @OneToMany
    @JoinColumn(name = "school_id") //unidirectional mapping.
    private List<Criteria> criterias;

}
