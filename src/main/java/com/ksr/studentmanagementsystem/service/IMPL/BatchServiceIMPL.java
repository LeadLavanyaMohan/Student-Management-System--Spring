package com.ksr.studentmanagementsystem.service.IMPL;

import com.ksr.studentmanagementsystem.dto.BatchDTO;
import com.ksr.studentmanagementsystem.dto.BatchSaveDTO;
import com.ksr.studentmanagementsystem.dto.BatchUpdateDTO;
import com.ksr.studentmanagementsystem.dto.CourseDTO;
import com.ksr.studentmanagementsystem.entity.Batch;
import com.ksr.studentmanagementsystem.entity.Course;
import com.ksr.studentmanagementsystem.repo.BatchRepository;
import com.ksr.studentmanagementsystem.repo.CourseRepository;
import com.ksr.studentmanagementsystem.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchServiceIMPL implements BatchService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public String addCourse(BatchSaveDTO batchSaveDTO) {
        Batch batch = new Batch(
                batchSaveDTO.getBatchName(),
                batchSaveDTO.getStartDate(),
                courseRepository.getById(batchSaveDTO.getCourseId())
        );

        batchRepository.save(batch);

        return batch.getBatchName();
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        List<Batch> getBatches = batchRepository.findAll();
        List<BatchDTO> batchDTOList=new ArrayList<>();

        for(Batch batch:getBatches){
            BatchDTO batchDTO = new  BatchDTO(
                    batch.getBatchId(),
                    batch.getBatchName(),
                    batch.getCourse(),
                    batch.getStartDate()
            );
            batchDTOList.add(batchDTO);
        }
        return  batchDTOList;
    }

    @Override
    public String updateBatch(BatchUpdateDTO batchUpdateDTO) {
        if(batchRepository.existsById(batchUpdateDTO.getBatchId()))
        {
            Batch batch = batchRepository.getById(batchUpdateDTO.getBatchId());
            batch.setBatchName(batchUpdateDTO.getBatchName());
            batch.setCourse(courseRepository.getById(batchUpdateDTO.getCourseId()));
            batch.setStartDate(batchUpdateDTO.getStartDate());
            batchRepository.save(batch);

            return batch.getBatchName();

        }else{
            System.out.println("Batch ID is not found");
        }
        return "";
    }
    @Override
    public boolean deleteBatch(int id) {
        if(batchRepository.existsById(id)){
            batchRepository.deleteById(id);
        }
        else{
            System.out.println("Batch ID if not found");
        }

        return false;

    }
}
