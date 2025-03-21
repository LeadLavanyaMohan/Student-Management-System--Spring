package com.ksr.studentmanagementsystem.service;

import com.ksr.studentmanagementsystem.dto.TeacherDTO;
import com.ksr.studentmanagementsystem.dto.TeacherSaveDTO;
import com.ksr.studentmanagementsystem.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    boolean deleteTeacher(int id);
}
