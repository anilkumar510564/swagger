package com.example.sample.exception;

import com.example.sample.model.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class StudentAlreadyExistException extends RuntimeException{
   private Student student=null;
    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<Student> studentAlreadyExistException() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This student already exist.");
        return new ResponseEntity<Student>(student, headers, HttpStatus.ALREADY_REPORTED);
    }
}
