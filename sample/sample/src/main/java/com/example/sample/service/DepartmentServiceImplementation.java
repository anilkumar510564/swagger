package com.example.sample.service;

import com.example.sample.model.Department;
import com.example.sample.model.Student;

import java.util.List;

public interface DepartmentServiceImplementation {
    public Department addDepartment(Department department);
    public Department GetById(int departmentId);
    public List<Department> getListOfDepartment();
    public Department updateDepartment(Department department);
    public Department deleteDepartmentBydepartmentId(int departmentId);


}
