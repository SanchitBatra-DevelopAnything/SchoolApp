package com.sbgu.admissionservice.demo.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "documents")
@Builder
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;

    private String name;

    @Enumerated(EnumType.STRING)
    private DocType type;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="admission_request_id")
    private AdmissionRequest admissionRequest;
}
