package com.sbgu.admissionservice.demo.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.query.sqm.tree.AbstractSqmDmlStatement;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "admissions")
public class AdmissionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REQUEST_ID")
    private Long requestId;
    private Status requestStatus;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student generatedBy;

    @OneToMany(mappedBy = "admissionRequest")
    private List<Document> documentList;

    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School generatedFor;

    @OneToOne
    @JoinColumn(name = "generated_appointment_id")
    private Appointment appointment;

    @ManyToMany
    @JoinTable(name  = "request_discrepancy", joinColumns = @JoinColumn(name = "discrepancy_id"),inverseJoinColumns = @JoinColumn(name = "admission_request_id"))
    private List<Discrepancy> discrepancies;

}
