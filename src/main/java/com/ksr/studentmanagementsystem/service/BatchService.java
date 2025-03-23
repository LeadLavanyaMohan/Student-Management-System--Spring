package com.ksr.studentmanagementsystem.service;

import com.ksr.studentmanagementsystem.dto.BatchDTO;
import com.ksr.studentmanagementsystem.dto.BatchSaveDTO;
import com.ksr.studentmanagementsystem.dto.BatchUpdateDTO;

import java.util.List;

public interface BatchService {

  

    String addCourse(BatchSaveDTO batchSaveDTO);

    List<BatchDTO> getAllBatches();

    String updateBatch(BatchUpdateDTO batchUpdateDTO);

    boolean deleteBatch(int id);
}
