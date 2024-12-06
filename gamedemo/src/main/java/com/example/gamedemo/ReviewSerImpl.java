package com.example.gamedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewSerImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<ReviewDTO> findAllReview() {
        return reviewRepository.findAll().stream()
                .map(Utils::toReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findByGameIdReview(int gameId) {
        return reviewRepository.findByGame_Idx(gameId).stream()
                .map(Utils::toReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveReview(ReviewDTO reviewDTO) {
        Game game = gameRepository.findById(reviewDTO.getGame_id())
                .orElseThrow(() -> new IllegalArgumentException("Game not found with ID: " + reviewDTO.getGame_id()));

        Review review = Utils.toReviewEntity(reviewDTO, game);

        reviewRepository.save(review);
    }

    @Override
    public void deleteByIdReview(int idx) {
        reviewRepository.deleteById(idx);
    }
}
