package com.sbgu.admissionservice.demo.Service;

import com.sbgu.admissionservice.demo.Entity.AdmissionRequest;
import com.sbgu.admissionservice.demo.Entity.BasicSchoolData;
import com.sbgu.admissionservice.demo.Entity.School;
import com.sbgu.admissionservice.demo.Error.AdmissionRequestNotFound;
import com.sbgu.admissionservice.demo.Error.SchoolNotFoundException;

import java.util.List;

public interface SchoolsService {
    List<School> getAllSchools() throws SchoolNotFoundException;

    List<AdmissionRequest> getAllAdmissionRequests(Long schoolId) throws AdmissionRequestNotFound;

    List<Object> getAllSchoolsBasicData() throws SchoolNotFoundException;

    School findSchoolById(Long schoolId) throws SchoolNotFoundException;
}
