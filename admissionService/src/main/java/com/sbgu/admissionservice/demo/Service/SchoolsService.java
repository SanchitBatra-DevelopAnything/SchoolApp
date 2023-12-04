package com.sbgu.admissionservice.demo.Service;

import com.sbgu.admissionservice.demo.Entity.AdmissionRequest;
import com.sbgu.admissionservice.demo.Entity.BasicSchoolData;
import com.sbgu.admissionservice.demo.Entity.School;
import com.sbgu.admissionservice.demo.Error.SchoolNotFoundException;

import java.util.List;

public interface SchoolsService {
    List<School> getAllSchools() throws SchoolNotFoundException;

    List<AdmissionRequest> getAllAdmissionRequests(Long schoolId);

    List<BasicSchoolData> getAllSchoolsBasicData() throws SchoolNotFoundException;
}
