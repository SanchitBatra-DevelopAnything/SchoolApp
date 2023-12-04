package com.sbgu.admissionservice.demo.Repository;

import com.sbgu.admissionservice.demo.Entity.BasicSchoolData;
import com.sbgu.admissionservice.demo.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {


    @Query(value = "SELECT u.basicData FROM School u")
    List<BasicSchoolData> getAllSchoolsBasicData();
}
