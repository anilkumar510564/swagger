package com.example.sample.exception;

import com.example.sample.model.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class StudentByClassRoomNotFoundException extends RuntimeException{

    private Student student=null;
    @ExceptionHandler(StudentByClassRoomNotFoundException.class)
    public ResponseEntity<List<Student>> studentAlreadyExistException() {
   List<Student> studentList=new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("message", "This student with class Room doesn't exist.");
        return new ResponseEntity<List<Student>>(studentList, headers, HttpStatus.ALREADY_REPORTED);
    }
}
