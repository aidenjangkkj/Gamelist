package com.example.gamedemo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private int review_id;
    private String comment;
    private String reviewer_name;
    private String content;
    private int game_id;
}
