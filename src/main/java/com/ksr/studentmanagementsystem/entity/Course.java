package com.ksr.studentmanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name ="Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Course_Id",length = 11)
    private int courseId;
    @Column(name = "Course_Name",length = 50,nullable = false)
    private String courseName;
    @Column(name = "Syllabus",length = 50)
    private String syllabus;
    @Column(name = "Duration",length = 10)
    private String duration;

    @OneToMany(mappedBy = "course")
    private Set<Batch> batches;

    public Course(int courseId, String courseName, String syllabus, String duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public Course(String courseName, String syllabus, String duration) {
        this.courseName = courseName;
        this.syllabus = syllabus;
        this.duration = duration;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
