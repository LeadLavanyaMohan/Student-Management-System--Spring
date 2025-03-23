package com.ksr.studentmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ksr.studentmanagementsystem.entity.Batch;
import com.ksr.studentmanagementsystem.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EnrollmentSaveDTO {

    @JsonProperty("studentId")
    private int studentId;

    private int batchId;

    private String joinDate;

    private int fee;

    public EnrollmentSaveDTO(int studentId, int batchId, String joinDate, int fee) {
        this.studentId = studentId;
        this.batchId = batchId;
        this.joinDate = joinDate;
        this.fee = fee;
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
