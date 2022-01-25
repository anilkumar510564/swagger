package com.example.sample.controller;

import com.example.sample.model.Department;
import com.example.sample.model.Student;
import com.example.sample.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentCont {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "addDepartment",method = RequestMethod.POST,produces = "application/json")

    public ResponseEntity<Department> addDepartment(Department department)
    {
        Department departmentTemp=departmentService.addDepartment(department);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Department added successfully");
        HttpStatus httpStatus=HttpStatus.CREATED;
        return new  ResponseEntity<Department>(departmentTemp,httpHeaders,httpStatus);
    }

    @RequestMapping(value = "departmentById",method = RequestMethod.GET,produces = "application/json")

    public ResponseEntity<Department> departmentById(int departmentId)
    {
        Department departmentTemp=departmentService.GetById(departmentId);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Department with id "+departmentId+ " successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<Department>(departmentTemp,httpHeaders,httpStatus);
    }

    @RequestMapping(value = "ListOfDepartment",method = RequestMethod.GET,produces = "application/json")

    public ResponseEntity<List<Department>> getListOfDepartment()
    {
        List<Department> departmentTemp=new ArrayList<>();
                departmentTemp=departmentService.getListOfDepartment();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Departments fetched successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<List<Department>>(departmentTemp,httpHeaders,httpStatus);
    }
    @RequestMapping(value = "updateDepartment",method = RequestMethod.POST,produces = "application/json")

    public ResponseEntity<Department> updateDepartment(Department department)
    {
        Department departmentTemp=departmentService.updateDepartment(department);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("message","Department updated successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<Department>(departmentTemp,httpHeaders,httpStatus);
    }

   /* @RequestMapping(value = "deleteDepartment/{departmentId}",method = RequestMethod.DELETE,produces = "application/json")

    public ResponseEntity<Department> deleteDepartment( int departmentId)
    {
        Department department=null;
        Department departmentTemp=departmentService.deleteDepartmentBydepartmentId(departmentId);
        HttpHeaders httpHeaders=new HttpHeaders();
       // LOG.info("student deleted successfully");
        httpHeaders.add("message","Student with "+departmentId+ " deleted successfully");
        HttpStatus httpStatus=HttpStatus.OK;
        return new  ResponseEntity<Department>(departmentTemp,httpHeaders,httpStatus);
    }*/

}
