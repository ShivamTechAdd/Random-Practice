package com.example.FirstJobApp.Service;

import com.example.FirstJobApp.Model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

}
