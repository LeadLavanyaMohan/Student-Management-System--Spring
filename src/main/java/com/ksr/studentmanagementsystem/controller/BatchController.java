package com.ksr.studentmanagementsystem.controller;


import com.ksr.studentmanagementsystem.dto.*;
import com.ksr.studentmanagementsystem.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/batch")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @PostMapping(path = "/save")
    public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO){

        String batch = batchService.addCourse(batchSaveDTO);
        return batch+" Record Added Sucessfully";
    }

    @GetMapping("/getAllBatches")
    public List<BatchDTO> getAllBatch(){

        List<BatchDTO> allBatches = batchService.getAllBatches();

        return allBatches;
    }

    @PutMapping(path = "/update")
    public String updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO){

        String batch = batchService.updateBatch(batchUpdateDTO);
        return batch+" Record Updated Sucessfully";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteBatch(@PathVariable(value = "id")int id){

        boolean deleteBatch= batchService.deleteBatch(id);
        return "Record Deleted Sucessfully";
    }
}
