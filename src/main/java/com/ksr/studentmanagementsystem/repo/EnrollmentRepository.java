package com.ksr.studentmanagementsystem.repo;

import com.ksr.studentmanagementsystem.entity.Batch;
import com.ksr.studentmanagementsystem.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
}
