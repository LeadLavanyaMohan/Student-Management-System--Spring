package com.ksr.studentmanagementsystem.service.IMPL;

import com.ksr.studentmanagementsystem.dto.CourseDTO;
import com.ksr.studentmanagementsystem.dto.CourseSaveDTO;
import com.ksr.studentmanagementsystem.dto.CourseUpdateDTO;
import com.ksr.studentmanagementsystem.entity.Course;
import com.ksr.studentmanagementsystem.repo.CourseRepository;
import com.ksr.studentmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceIMPL implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {
        Course course = new Course(

                courseSaveDTO.getCourseName(),
                courseSaveDTO.getSyllabus(),
                courseSaveDTO.getDuration()

        );

        courseRepository.save(course);

        return course.getCourseName();
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> getCourses = courseRepository.findAll();
        List<CourseDTO> courseDTOList=new ArrayList<>();

        for(Course course:getCourses){
            CourseDTO courseDTO = new CourseDTO(
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getSyllabus(),
                    course.getDuration()
            );
            courseDTOList.add(courseDTO);
        }
        return courseDTOList;
    }

    @Override
    public String updateCourse(CourseUpdateDTO courseUpdateDTO) {
        if(courseRepository.existsById(courseUpdateDTO.getCourseId()))
        {
            Course course = courseRepository.getById(courseUpdateDTO.getCourseId());
            course.setCourseName(courseUpdateDTO.getCourseName());
            course.setSyllabus(courseUpdateDTO.getSyllabus());
            course.setDuration(courseUpdateDTO.getDuration());
            courseRepository.save(course);

            return course.getCourseName();

        }else{
            System.out.println("Course ID if not found");
        }
        return "";
    }

    @Override
    public boolean deleteCourse(int id) {
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        }
        else{
            System.out.println("Course ID if not found");
        }

        return false;

    }
}
