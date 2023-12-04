package com.sbgu.admissionservice.demo.Repository;

import com.sbgu.admissionservice.demo.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
