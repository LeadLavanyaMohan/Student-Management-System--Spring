package com.ksr.studentmanagementsystem.repo;

import com.ksr.studentmanagementsystem.entity.Course;
import com.ksr.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course,Integer> {
}
