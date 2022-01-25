package com.example.sample.service;

import com.example.sample.model.Department;
import com.example.sample.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceImplementation {
    public Student addStudent(Student student);
   // public List<Student> displayStudent(Student student);
    public Student getStudentById(int studentId);
    public List<Student> getStudentByclassRoom(int classRoom);
    public Student updateStudent(Student student);
    public Student deleteStudentByStudentId(int studentId);
    public List<Student> getListOfStudent();


}
