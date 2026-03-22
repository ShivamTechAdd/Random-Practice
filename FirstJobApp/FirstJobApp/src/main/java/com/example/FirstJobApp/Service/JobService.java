package com.example.FirstJobApp.Service;

import com.example.FirstJobApp.Model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job findJobById(Long id);
    boolean deleteJob(Long id);
    boolean updateJob(Job job, Long id);
}


















