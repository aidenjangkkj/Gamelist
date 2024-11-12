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
                .review(entity.getReview())
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
                .review(dto.getReview())
                .build();
    }
}