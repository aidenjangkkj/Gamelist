package com.example.gamedemo;

public class Utils {
    public static GameDTO toDTO(Game entity){
        return GameDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .genre(entity.getGenre())
                .price(entity.getPrice())
                .content(entity.getContent())
                .img(entity.getImg())
                .build();
    }
    public static Game toEntity(GameDTO dto){
        return Game.builder()
                .idx(dto.getIdx())
                .title(dto.getTitle())
                .genre(dto.getGenre())
                .price(dto.getPrice())
                .content(dto.getContent())
                .img(dto.getImg())
                .build();
    }
    public static ReviewDTO toReviewDTO(Review entity){
        return ReviewDTO.builder()
                .review_id(entity.getReview_id())
                .comment(entity.getComment())
                .reviewer_name(entity.getReviewerName())
                .game_id(entity.getGame_id())
                .build();
    }
    public static Review toReviewEntity(ReviewDTO dto){
        return Review.builder()
                .review_id(dto.getReview_id())
                .comment(dto.getComment())
                .reviewerName(dto.getReviewer_name())
                .game_id(dto.getGame_id())
                .build();
    }
}