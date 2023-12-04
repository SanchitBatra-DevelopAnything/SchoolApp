package com.sbgu.admissionservice.demo.Controller;

import com.sbgu.admissionservice.demo.Entity.AdmissionRequest;
import com.sbgu.admissionservice.demo.Entity.BasicSchoolData;
import com.sbgu.admissionservice.demo.Entity.School;
import com.sbgu.admissionservice.demo.Error.AdmissionRequestNotFound;
import com.sbgu.admissionservice.demo.Error.SchoolNotFoundException;
import com.sbgu.admissionservice.demo.Service.SchoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/schools")
public class SchoolsController {

    @Autowired
    private SchoolsService schoolsService;

    @GetMapping
    public ResponseEntity<Object> getAllSchoolsBasicData() throws SchoolNotFoundException
    {
        List<Object> schoolsList= schoolsService.getAllSchoolsBasicData();
        return ResponseEntity.status(HttpStatus.OK).body(schoolsList);
    }

    @GetMapping("/requests/{schoolId}")
    public ResponseEntity<Object> getAllAdmissionRequests(@PathVariable("schoolId") Long schoolId) throws AdmissionRequestNotFound
    {
        List<AdmissionRequest> admissionRequests = schoolsService.getAllAdmissionRequests(schoolId);
        return ResponseEntity.status(HttpStatus.OK).body(admissionRequests);
    }
}
