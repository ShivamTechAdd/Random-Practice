package com.example.FirstJobApp.Service;


import com.example.FirstJobApp.Model.Job;
import com.example.FirstJobApp.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(()-> new RuntimeException("This Job is Not Present !!"));
    }

    @Override
    public boolean deleteJob(Long id) {
        jobRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateJob(Job job, Long id) {
        Job savedJob = jobRepository.findById(id).orElseThrow(()-> new RuntimeException("This Job is Not Present !!"));

        savedJob.setTitle(job.getTitle());
        savedJob.setDescription(job.getDescription());
        savedJob.setMinSalary(job.getMinSalary());
        savedJob.setMaxSalary(job.getMaxSalary());
        savedJob.setLocation(job.getLocation());
        jobRepository.save(savedJob);
        return true;
    }
}


































































