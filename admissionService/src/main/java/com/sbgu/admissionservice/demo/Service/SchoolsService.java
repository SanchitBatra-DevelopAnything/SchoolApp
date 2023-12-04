package com.sbgu.admissionservice.demo.Service;

import com.sbgu.admissionservice.demo.Entity.School;
import com.sbgu.admissionservice.demo.Error.SchoolNotFoundException;

import java.util.List;

public interface SchoolsService {
    List<School> getAllSchools() throws SchoolNotFoundException;
}
