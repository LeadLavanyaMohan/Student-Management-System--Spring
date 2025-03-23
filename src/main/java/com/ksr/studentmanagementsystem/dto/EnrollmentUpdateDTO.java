package com.ksr.studentmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ksr.studentmanagementsystem.entity.Batch;
import com.ksr.studentmanagementsystem.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EnrollmentUpdateDTO {
    @JsonProperty("enrollment_Id")
    private int enrollment_Id;

    @JsonProperty("studentId")
    private int studentId;

    @JsonProperty("batchId")
    private int batchId;

    private String joinDate;
    private int fee;

    public EnrollmentUpdateDTO(int enrollment_Id, int studentId, int batchId, String joinDate, int fee) {
        this.enrollment_Id = enrollment_Id;
        this.studentId = studentId;
        this.batchId = batchId;
        this.joinDate = joinDate;
        this.fee = fee;
    }

    public int getEnrollment_Id() {
        return enrollment_Id;
    }

    public void setEnrollment_Id(int enrollment_Id) {
        this.enrollment_Id = enrollment_Id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
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
