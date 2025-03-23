package com.ksr.studentmanagementsystem.controller;

import com.ksr.studentmanagementsystem.dto.*;
import com.ksr.studentmanagementsystem.service.BatchService;
import com.ksr.studentmanagementsystem.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(path = "/save")
    public String Enrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO){

        String enrollment = enrollmentService.addEnrollment(enrollmentSaveDTO);
        return "Enrolled on" +enrollment+" Sucessfully";
    }
    @GetMapping("/getAllEnrollments")
    public List<EnrollmentDTO> getAllEnrollment(){

        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();

        return allEnrollments;
    }

    @PutMapping(path = "/update")
    public String updateEnrollment(@RequestBody EnrollmentUpdateDTO enrollmentUpdateDTO){

        String enrollment = enrollmentService.updateEnrollment(enrollmentUpdateDTO);
        return "Enrolled on "+enrollment+" Sucessfully";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnrollment(@PathVariable(value = "id")int id){

        boolean deleteEnrollment= enrollmentService.deleteEnrollment(id);
        return "Record Deleted Sucessfully";
    }

}
