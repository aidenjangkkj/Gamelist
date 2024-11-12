package com.example.gamedemo;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "game")
@ToString
@Getter
@Builder
@NoArgsConstructor()
@AllArgsConstructor


public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idx;

    private String title;
    private String genre;
    private int price;

    @Column(name = "image_url")
    private String img;

    private String content;
    private String review;
}
