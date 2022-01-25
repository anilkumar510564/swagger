package com.example.sample.exception;

import com.example.sample.model.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentListDoesnotExistException extends RuntimeException{
    @ExceptionHandler(StudentListDoesnotExistException.class)
    public ResponseEntity<Student> StudentListDoesnotExistException()
    {
        Student student=null;
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Student List is Empty");
        HttpStatus httpStatus=HttpStatus.NO_CONTENT;
        return new ResponseEntity<Student>(student,httpHeaders,httpStatus);
    }

}
