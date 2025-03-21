package com.ksr.studentmanagementsystem.entity;

import jakarta.persistence.*;

@Entity(name= "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TeacherID",length = 11)
    private int TeacherId;
    @Column(name = "TeacherName",length = 50,nullable = false)
    private String TeacherName;
    @Column(name = "TeacherAddress",length = 50)
    private String address;
    @Column(name = "TeacherPhoneNumber",length = 10)
    private long phoneNumber;

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherName, String address, long phoneNumber) {
        TeacherId = teacherId;
        TeacherName = teacherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Teacher(String teacherName, String address, long phoneNumber) {
        TeacherName = teacherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
