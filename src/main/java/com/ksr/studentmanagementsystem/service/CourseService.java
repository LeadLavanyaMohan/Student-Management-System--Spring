package com.ksr.studentmanagementsystem.service;

import com.ksr.studentmanagementsystem.dto.CourseDTO;
import com.ksr.studentmanagementsystem.dto.CourseSaveDTO;
import com.ksr.studentmanagementsystem.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourses();

    String updateCourse(CourseUpdateDTO courseUpdateDTO);

    boolean deleteCourse(int id);
}
