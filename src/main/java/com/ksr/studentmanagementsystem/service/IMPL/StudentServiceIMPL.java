package com.ksr.studentmanagementsystem.service.IMPL;

import com.ksr.studentmanagementsystem.dto.StudentDTO;
import com.ksr.studentmanagementsystem.dto.StudentSaveDTO;
import com.ksr.studentmanagementsystem.dto.StudentUpdateDTO;
import com.ksr.studentmanagementsystem.entity.Student;
import com.ksr.studentmanagementsystem.repo.StudentRepository;
import com.ksr.studentmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        Student student = new Student(

                studentSaveDTO.getStudentName(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhoneNumber()

        );

        studentRepository.save(student);

        return student.getAddress();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Student student:getStudents)
        {
            StudentDTO studentDTO= new StudentDTO(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getAddress(),
                    student.getPhoneNumber()
            );
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if(studentRepository.existsById(studentUpdateDTO.getStudentId()))
        {
            Student student = studentRepository.getById(studentUpdateDTO.getStudentId());
            student.setStudentName(studentUpdateDTO.getStudentName());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhoneNumber(studentUpdateDTO.getPhoneNumber());
            studentRepository.save(student);

            return student.getStudentName();

        }else{
            System.out.println("Student ID if not found");
        }
        return "";
    }

    @Override
    public boolean deleteStudent(int id) {

        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
        else{
            System.out.println("Student ID if not found");
        }

        return false;
    }

}
