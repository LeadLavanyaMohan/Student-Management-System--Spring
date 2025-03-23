package com.ksr.studentmanagementsystem.dto;

import com.ksr.studentmanagementsystem.entity.Batch;
import com.ksr.studentmanagementsystem.entity.Student;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EnrollmentDTO {

    private int enrollment_Id;

    private Student student;

    private Batch batch;

    private String joinDate;

    private int fee;

    public EnrollmentDTO(int enrollment_Id, Student student, Batch batch, String joinDate, int fee) {
        this.enrollment_Id = enrollment_Id;
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
}
