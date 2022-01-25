package com.example.sample.repository;

import com.example.sample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
public Student getStudentBystudentId(int studentId);
public List<Student> getStudentByclassRoom(int classRoom);


}
