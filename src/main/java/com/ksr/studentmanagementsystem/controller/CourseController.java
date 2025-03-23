package com.ksr.studentmanagementsystem.controller;

import com.ksr.studentmanagementsystem.dto.*;
import com.ksr.studentmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping(path = "/save")
    public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO){

        String course = courseService.addCourse(courseSaveDTO);
        return course+" Record Added Sucessfully";
    }

    @GetMapping("/getAllCourse")
    public List<CourseDTO> getAllCourse(){

        List<CourseDTO> allCourses = courseService.getAllCourses();

        return allCourses;
    }

    @PutMapping(path = "/update")
    public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO){

        String course = courseService.updateCourse(courseUpdateDTO);
        return course+" Record Updated Sucessfully";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCourse(@PathVariable(value = "id")int id){

        boolean deleteCourse= courseService.deleteCourse(id);
        return "Record Deleted Sucessfully";
    }

}
