package com.sbgu.admissionservice.demo.Repository;

import com.sbgu.admissionservice.demo.Entity.AdmissionRequest;
import com.sbgu.admissionservice.demo.Entity.BasicSchoolData;
import com.sbgu.admissionservice.demo.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {


    @Query(value = "SELECT u.schoolId ,u.basicData FROM School u")
    List<Object> getAllSchoolsBasicData();

    @Query(value = "SELECT u.admissionRequests FROM School u")
    List<AdmissionRequest> getAllAdmissionRequests(Long schoolId);
}
