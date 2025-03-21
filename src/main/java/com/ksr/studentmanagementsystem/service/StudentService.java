package com.ksr.studentmanagementsystem.service;

import com.ksr.studentmanagementsystem.dto.StudentDTO;
import com.ksr.studentmanagementsystem.dto.StudentSaveDTO;
import com.ksr.studentmanagementsystem.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    boolean deleteStudent(int id);
}
