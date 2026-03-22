package com.example.FirstJobApp.Controller;

import com.example.FirstJobApp.Model.Company;
import com.example.FirstJobApp.Model.Job;
import com.example.FirstJobApp.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJobs(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Added successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        return new ResponseEntity<>(jobService.findJobById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJob(id);
        return deleted ? new ResponseEntity<>("Job is been deleted with the id "+id , HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@RequestBody Job job , @PathVariable Long id){
        boolean updated = jobService.updateJob(job,id);
        return updated ? new ResponseEntity<>("Job updated Successfully",HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
