package com.example.sample.controller;

import com.example.sample.model.Department;
import com.example.sample.model.Student;
import com.example.sample.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class StudentCont {
    @Autowired
    private StudentService studentService;
    private final Logger LOG= LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "addStudent",method = RequestMethod.POST,produces = "application/json")

    public ResponseEntity<Student> addStudent( Student student)
    {
      Student studentTemp=studentService.addStudent(student);
        HttpHeaders httpHeaders=new HttpHeaders();
        LOG.info("student added successfully");
        httpHeaders.add("message","Student added successfully");
        HttpStatus httpStatus=HttpStatus.CREATED;
        return new  ResponseEntity<Student>(studentTemp,httpHeaders,httpStatus);
    }
   /* @RequestMapping(value = "disStudent",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<List<Student>> displayStudent(Student student)
    {
        List<Student> studentList=new ArrayList<>();
        studentList=studentService.displayStudent(student);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Student fetched successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return  new ResponseEntity<List<Student>>(studentList,httpHeaders,httpStatus);


    }*/
    @RequestMapping(value = "getStudentById",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Student> getStudentById(int studentId)
    {

        Student studentTemp=studentService.getStudentById(studentId);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Student with id " +studentId+ " fetched successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return  new ResponseEntity<Student>(studentTemp,httpHeaders,httpStatus);


    }
    @RequestMapping(value = "getStudentByClassRoom",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<List<Student>> getStudentByClassRoom(int classRoom)
    {
       List<Student> studentList=new ArrayList<>();
        studentList=studentService.getStudentByclassRoom(classRoom);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Student with classRoom " +classRoom+ " fetched successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return  new ResponseEntity<List<Student>>(studentList,httpHeaders,httpStatus);
    }
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST,produces = "application/json")

    public ResponseEntity<Student> updateStudent( Student student)
    {
        Student studentTemp=studentService.updateStudent(student);
        HttpHeaders httpHeaders=new HttpHeaders();
        LOG.info("student updated successfully");
        httpHeaders.add("message","Student with id " + student.getStudentId() +  " updated successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<Student>(studentTemp,httpHeaders,httpStatus);
    }
    @RequestMapping(value = "deleteStudent/{studentId}",method = RequestMethod.DELETE,produces = "application/json")

    public ResponseEntity<Student> deleteStudent( int studentId)
    {
        Student student=null;
        Student studentTemp=studentService.deleteStudentByStudentId(studentId);
        HttpHeaders httpHeaders=new HttpHeaders();
        LOG.info("student deleted successfully");
        httpHeaders.add("message","Student with "+studentId+ " deleted successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<Student>(studentTemp,httpHeaders,httpStatus);
    }

    @RequestMapping(value = "studentById",method = RequestMethod.GET,produces = "application/json")

    public ResponseEntity<Student> studentByStudentId( int studentId)
    {
        Student student=null;
        Student studentTemp=studentService.findStudentById(studentId);
        HttpHeaders httpHeaders=new HttpHeaders();
        LOG.info("student with id "+studentId+" successfully");
        httpHeaders.add("message","Student with id "+studentId+ " fetched successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<Student>(studentTemp,httpHeaders,httpStatus);
    }

    @RequestMapping(value = "ListOfStudent",method = RequestMethod.GET,produces = "application/json")

    public ResponseEntity<List<Student>> getListOfStudent()
    {
        List<Student> studentTemp=new ArrayList<>();
        studentTemp=studentService.getListOfStudent();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Students fetched successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<List<Student>>(studentTemp,httpHeaders,httpStatus);
    }


}
