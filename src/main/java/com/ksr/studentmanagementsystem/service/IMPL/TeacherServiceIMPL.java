package com.ksr.studentmanagementsystem.service.IMPL;

import com.ksr.studentmanagementsystem.dto.TeacherDTO;
import com.ksr.studentmanagementsystem.dto.TeacherSaveDTO;
import com.ksr.studentmanagementsystem.dto.TeacherUpdateDTO;
import com.ksr.studentmanagementsystem.entity.Teacher;
import com.ksr.studentmanagementsystem.repo.TeacherRepository;
import com.ksr.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {

        Teacher  teacher = new Teacher(
                teacherSaveDTO.getTeacherName(),
                teacherSaveDTO.getAddress(),
                teacherSaveDTO.getPhoneNumber()
                );
        teacherRepository.save(teacher);

        return teacher.getTeacherName();


    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> getTeacher= teacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        for(Teacher teacher:getTeacher)
        {
            TeacherDTO teacherDTO = new TeacherDTO(
                    teacher.getTeacherId(),
                    teacher.getTeacherName(),
                    teacher.getAddress(),
                    teacher.getPhoneNumber()
            );
            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }

    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {

        if(teacherRepository.existsById(teacherUpdateDTO.getTeacherId())){
            Teacher teacher = teacherRepository.getById(teacherUpdateDTO.getTeacherId());
            teacher.setTeacherName(teacherUpdateDTO.getTeacherName());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhoneNumber(teacherUpdateDTO.getPhoneNumber());
            teacherRepository.save(teacher);

            return teacher.getTeacherName();
        }else {
            System.out.println("Teacher is not found ...!");
        }
        return "";
    }

    @Override
    public boolean deleteTeacher(int id) {
        if(teacherRepository.existsById(id))
        {
            teacherRepository.deleteById(id);
        }else {
            System.out.println("Teacher is not found ...!");
        }
        return false;
    }
}
