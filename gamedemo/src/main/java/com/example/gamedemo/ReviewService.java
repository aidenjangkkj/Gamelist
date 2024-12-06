package com.example.gamedemo;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAllReview();
    List<ReviewDTO> findByGameIdReview(int gameId);

    void saveReview(ReviewDTO review);
    void deleteByIdReview(int idx);
}
