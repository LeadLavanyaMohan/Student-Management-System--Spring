package com.ksr.studentmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="Batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Batch_Id",length = 11)
    private int batchId;
    @Column(name = "Batch_Name",length = 50,nullable = false)
    private String batchName;

    @Column(name = "Start_Date",length = 10)
    private String startDate;

    @ManyToOne
    @JoinColumn(name="Course_Id",nullable = false)
    private Course course;

    public Batch(int batchId, String batchName, String startDate, Course course) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.startDate = startDate;
        this.course = course;
    }

    public Batch(String batchName, String startDate, Course course) {
        this.batchName = batchName;
        this.startDate = startDate;
        this.course = course;
    }

    public Batch() {
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
