package com.ksr.studentmanagementsystem.service;

import com.ksr.studentmanagementsystem.dto.EnrollmentDTO;
import com.ksr.studentmanagementsystem.dto.EnrollmentSaveDTO;
import com.ksr.studentmanagementsystem.dto.EnrollmentUpdateDTO;

import java.util.List;

public interface EnrollmentService {


    String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO);



    String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

    boolean deleteEnrollment(int id);

    List<EnrollmentDTO> getAllEnrollments();
}
