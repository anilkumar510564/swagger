package com.example.sample.exception;

import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepo;
import com.example.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class StudentIdNotFoundException extends RuntimeException
{
    private Student student=null;
    @Autowired
    StudentService studentService;
    @ExceptionHandler(StudentIdNotFoundException.class)
    public ResponseEntity<Student> studentIdNotFoundException() {



        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This student id doesn't exist.");
        return new ResponseEntity<Student>(student, headers, HttpStatus.ALREADY_REPORTED);
    }
}
