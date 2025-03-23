package com.ksr.studentmanagementsystem.service.IMPL;

import com.ksr.studentmanagementsystem.dto.BatchDTO;
import com.ksr.studentmanagementsystem.dto.EnrollmentDTO;
import com.ksr.studentmanagementsystem.dto.EnrollmentSaveDTO;
import com.ksr.studentmanagementsystem.dto.EnrollmentUpdateDTO;
import com.ksr.studentmanagementsystem.entity.Batch;
import com.ksr.studentmanagementsystem.entity.Enrollment;
import com.ksr.studentmanagementsystem.repo.BatchRepository;
import com.ksr.studentmanagementsystem.repo.EnrollmentRepository;
import com.ksr.studentmanagementsystem.repo.StudentRepository;
import com.ksr.studentmanagementsystem.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BatchRepository batchRepository;


    @Override
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
        Enrollment enrollment = new Enrollment(
                studentRepository.getById(enrollmentSaveDTO.getStudentId()),
                batchRepository.getById(enrollmentSaveDTO.getBatchId()),
                enrollmentSaveDTO.getJoinDate(),
                enrollmentSaveDTO.getFee()
        );

        enrollmentRepository.save(enrollment);

        return enrollment.getJoinDate();
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> getEnrollments = enrollmentRepository.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();

        for (Enrollment enrollment : getEnrollments) {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                    enrollment.getEnrollment_Id(),
                    enrollment.getStudent(),
                    enrollment.getBatch(),
                    enrollment.getJoinDate(),
                    enrollment.getFee()
            );
            enrollmentDTOList.add(enrollmentDTO);
        }
        return enrollmentDTOList;
    }
    @Override
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {

        if(enrollmentRepository.existsById(enrollmentUpdateDTO.getEnrollment_Id()))
        {
            Enrollment enrollment = enrollmentRepository.getById(enrollmentUpdateDTO.getEnrollment_Id());
            enrollment.setStudent(studentRepository.getById(enrollmentUpdateDTO.getStudentId()));
            enrollment.setBatch(batchRepository.getReferenceById(enrollmentUpdateDTO.getBatchId()));
            enrollment.setJoinDate(enrollmentUpdateDTO.getJoinDate());
            enrollment.setJoinDate(enrollmentUpdateDTO.getJoinDate());
            enrollmentRepository.save(enrollment);

            return enrollment.getJoinDate();

        }else{
            System.out.println("Enrollment ID is not found");
        }
        return "";
    }


    @Override
    public boolean deleteEnrollment(int id) {
        if(enrollmentRepository.existsById(id)){
            enrollmentRepository.deleteById(id);
        }
        else{
            System.out.println("Enrollment ID if not found");
        }

        return false;

    }
    }



