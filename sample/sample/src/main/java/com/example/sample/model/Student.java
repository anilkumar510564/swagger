package com.example.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String name;
    private String address;
    private int classRoom;
    @ManyToOne
    @JoinColumn(name ="departmentId",nullable = true)
    private Department department;

    public Student() {
        super();
    }

    public Student(String name, String address, int classRoom) {
        this.name = name;
        this.address = address;
        this.classRoom = classRoom;
    }

    public Student(String name, String address, int classRoom, Department department) {
        super();
        this.name = name;
        this.address = address;
        this.classRoom = classRoom;
        this.department = department;
    }

    public Student(int studentId, String name, String address, int classRoom) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.classRoom = classRoom;
    }

    public Student(int studentId, String name, String address, int classRoom, Department department) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.classRoom = classRoom;
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", classRoom=" + classRoom +
                ", department=" + department +
                '}';
    }
}
