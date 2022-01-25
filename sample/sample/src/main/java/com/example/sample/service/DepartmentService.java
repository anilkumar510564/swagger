package com.example.sample.service;

import com.example.sample.model.Department;
import com.example.sample.model.Student;
import com.example.sample.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements DepartmentServiceImplementation{

@Autowired
private DepartmentRepo departmentRepo;
    @Override
    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department GetById(int departmentId) {
        return departmentRepo.findById(departmentId).get();
    }

    @Override
    public List<Department> getListOfDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department deleteDepartmentBydepartmentId(int departmentId) {
        departmentRepo.deleteById(departmentId);
        return null;
    }


}
