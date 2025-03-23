package com.ksr.studentmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Enrollment_Id",length = 11)
    private int enrollment_Id;


    @ManyToOne
    @JoinColumn(name="StudentID",nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="Batch_Id",nullable = false)
    private Batch batch;


    @Column(name = "Join_Date",length = 11)
    private String joinDate;

    @Column(name = "Fee",length = 11)
    private int fee;

    public Enrollment(int enrollment_Id, Student student, Batch batch, String joinDate, int fee) {
        this.enrollment_Id = enrollment_Id;
        this.student = student;
        this.batch = batch;
        this.joinDate = joinDate;
        this.fee = fee;
    }

    public Enrollment() {
    }

    public Enrollment(Student student, Batch batch, String joinDate, int fee) {
        this.student = student;
        this.batch = batch;
        this.joinDate = joinDate;
        this.fee = fee;
    }

    public int getEnrollment_Id() {
        return enrollment_Id;
    }

    public void setEnrollment_Id(int enrollment_Id) {
        this.enrollment_Id = enrollment_Id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollment_Id=" + enrollment_Id +
                ", student=" + student +
                ", batch=" + batch +
                ", joinDate='" + joinDate + '\'' +
                ", fee=" + fee +
                '}';
    }
}
