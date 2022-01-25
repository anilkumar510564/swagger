package com.example.sample.service;

import com.example.sample.exception.StudentAlreadyExistException;
import com.example.sample.exception.StudentByClassRoomNotFoundException;
import com.example.sample.exception.StudentIdNotFoundException;
import com.example.sample.exception.StudentListDoesnotExistException;
import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceImplementation{
    @Autowired
    private StudentRepo studentRepo;
    private final Logger LOG=LoggerFactory.getLogger(this.getClass());
    @Override
    public Student addStudent(Student student) {
        if (!studentRepo.existsById(student.getStudentId())) {
            return studentRepo.save(student);
        }
        else
        {
            throw new StudentAlreadyExistException();
        }
    }

  /*  @Override
    public List<Student> displayStudent() {
        return studentRepo.findAll();

    }*/

    @Override
    public Student getStudentById(int studentId) {
        Student student = null;
        Optional<Student> studentOptional = studentRepo.findById(studentId);
        if (!studentOptional.isPresent())
        {
            throw new StudentIdNotFoundException();
        }

        return studentRepo.getStudentBystudentId(studentId);
    }

    @Override
    public List<Student> getStudentByclassRoom(int classRoom) {
        List<Student> studentOptional = new ArrayList<>();
              studentOptional= studentRepo.getStudentByclassRoom(classRoom);
        if (studentOptional.size()==0) {
            throw new StudentByClassRoomNotFoundException();
        } else {
            return studentRepo.getStudentByclassRoom(classRoom);

        }


    }

    @Override
    public Student updateStudent(Student student) {

            return studentRepo.save(student);


    }
    @Override
    public Student deleteStudentByStudentId(int studentId) {
        Student student = null;
        Optional<Student> studentOptional = studentRepo.findById(studentId);
       if(!studentOptional.isPresent())
        {
            throw new StudentIdNotFoundException();
        }
       else
         {
             studentRepo.deleteById(studentId);
             return null;
        }
    }

    @Override
    public List<Student> getListOfStudent() {
        List<Student> studentOptional = new ArrayList<>();
        studentOptional = studentRepo.findAll();
        if (studentOptional.size() == 0) {
            throw new StudentListDoesnotExistException();
        } else {
            return studentRepo.findAll();
        }
    }

    public Student findStudentById(int studentId)
    {
        Optional<Student> studentOptional = studentRepo.findById(studentId);
        if (!studentOptional.isPresent())
        {
            throw new  StudentIdNotFoundException();
        }
        return studentRepo.findById(studentId).get();
    }

}
