package com.sbgu.admissionservice.demo.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SchoolNotFoundException.class)
    public ResponseEntity<ErrorMessage> schoolNotFound(SchoolNotFoundException e , WebRequest r)
    {
        ErrorMessage err = ErrorMessage.builder().errorMessage("No Schools Found").status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(err.getStatus()).body(err);
    }

    @ExceptionHandler(AdmissionRequestNotFound.class)
    public ResponseEntity<ErrorMessage> admissionRequestNotFound(AdmissionRequestNotFound e , WebRequest r)
    {
        ErrorMessage err = ErrorMessage.builder().errorMessage("No Request(s) Data available.").status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(err.getStatus()).body(err);
    }


}
