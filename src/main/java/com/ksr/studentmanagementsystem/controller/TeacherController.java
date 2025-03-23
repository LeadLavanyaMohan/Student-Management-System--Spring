package com.ksr.studentmanagementsystem.controller;

import com.ksr.studentmanagementsystem.dto.*;
import com.ksr.studentmanagementsystem.entity.Student;
import com.ksr.studentmanagementsystem.exceptions.ResourceNotFoundException;
import com.ksr.studentmanagementsystem.repo.TeacherRepository;
import com.ksr.studentmanagementsystem.service.StudentService;
import com.ksr.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepository teacherRepository;



    @PostMapping(path = "/save")
    public String saveTeachers(@RequestBody TeacherSaveDTO teacherSaveDTO){

        String TeacherName = teacherService.addTeacher(teacherSaveDTO);
        return TeacherName+" Record Added Sucessfully";
    }

    @GetMapping("/getAllTeacher")
    public List<TeacherDTO> getAllTeacher(){

        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();

        return allTeachers;
    }

    @PutMapping(path = "/update")
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO){

        String staff = teacherService.updateTeacher(teacherUpdateDTO);
        return staff+" Record Updated Sucessfully";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteTeacher(@PathVariable(value = "id")int id){

        boolean deleteTeacher = teacherService.deleteTeacher(id);
        return "Record Deleted Sucessfully";
    }

//    @GetMapping(path = "getStudentById/{id}")
//    public Student getstudentById(@PathVariable  int id){
//
//        return teacherRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Record is not found"));
//    }
}
