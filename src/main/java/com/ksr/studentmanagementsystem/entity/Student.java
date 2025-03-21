package com.ksr.studentmanagementsystem.entity;


import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StudentID",length = 11)
    private int studentId;
    @Column(name = "StudentName",length = 50,nullable = false)
    private String StudentName;
    @Column(name = "StudentAddress",length = 50)
    private String address;
    @Column(name = "StudentPhoneNumber",length = 10)
    private long phoneNumber;

    public Student() {
    }

    public Student(int studentId, String StudentName, String address, long phoneNumber) {
        this.studentId = studentId;
        this.StudentName= StudentName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Student(String StudentName, String address, long phoneNumber) {
        this.StudentName = StudentName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        this.StudentName = studentName;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", StudentName='" + StudentName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
