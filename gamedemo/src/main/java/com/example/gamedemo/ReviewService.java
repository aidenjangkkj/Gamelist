package com.example.gamedemo;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAllReview();
    ReviewDTO findByGameIdReview(int idx);


    void saveReview(ReviewDTO review);
    void deleteByIdReview(int idx);
}
