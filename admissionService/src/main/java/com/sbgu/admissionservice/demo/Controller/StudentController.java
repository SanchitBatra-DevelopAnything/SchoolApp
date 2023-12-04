package com.sbgu.admissionservice.demo.Controller;

import com.sbgu.admissionservice.demo.Entity.Status;
import com.sbgu.admissionservice.demo.Entity.Student;
import com.sbgu.admissionservice.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/test")
    public ResponseEntity<Object> addStudent()
    {
        Student s2 = Student.builder().first_name("dasjkhdkasd").build();
        studentRepo.save(s2);
        return ResponseEntity.status(HttpStatus.OK).body(s2);
    }
}
