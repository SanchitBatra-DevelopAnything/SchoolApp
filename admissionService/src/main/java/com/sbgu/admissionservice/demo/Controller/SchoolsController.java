package com.sbgu.admissionservice.demo.Controller;

import com.sbgu.admissionservice.demo.Entity.School;
import com.sbgu.admissionservice.demo.Error.SchoolNotFoundException;
import com.sbgu.admissionservice.demo.Service.SchoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/schools")
public class SchoolsController {

    @Autowired
    private SchoolsService schoolsService;

    @GetMapping
    public ResponseEntity<Object> getAllSchools() throws SchoolNotFoundException
    {
        List<School> schoolsList= schoolsService.getAllSchools();
        return ResponseEntity.status(HttpStatus.OK).body(schoolsList);
    }
}
