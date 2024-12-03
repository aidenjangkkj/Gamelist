package com.example.gamedemo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewSerImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> findAllReview() {
        return reviewRepository.findAll().stream()
                .map(v->Utils.toReviewDTO(v))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO findByGameIdReview(int idx) {
        return reviewRepository.findById(idx)
                .map(v->Utils.toReviewDTO(v))
                .orElse(null);
    }
    @Override
    public void saveReview(ReviewDTO reviewDTO) {
        Review review = Utils.toReviewEntity(reviewDTO);
        reviewRepository.save(review);
    }

    @Override
    public void deleteByIdReview(int idx) {
        reviewRepository.deleteById(idx);
    }
}
