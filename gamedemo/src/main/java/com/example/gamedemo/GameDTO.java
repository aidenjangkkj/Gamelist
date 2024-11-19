package com.example.gamedemo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private int idx;
    private String title;
    private String genre;
    private String content;
    private int price;
    private String img;
}
