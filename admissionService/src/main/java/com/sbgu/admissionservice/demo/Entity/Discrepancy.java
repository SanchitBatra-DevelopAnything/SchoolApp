package com.sbgu.admissionservice.demo.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "DISCREPANCIES")
public class Discrepancy {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long discrepancyId;
    public String code;
    public String details;

    @ManyToMany(mappedBy = "discrepancies")
    private List<AdmissionRequest> admissionRequestList;


    @ManyToMany(mappedBy = "discrepancies")
    private List<Document> documentList;

}
