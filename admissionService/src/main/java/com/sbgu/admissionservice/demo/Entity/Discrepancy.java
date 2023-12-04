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
@Table(name = "DISCREPANCIES")
@AllArgsConstructor
@NoArgsConstructor
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
