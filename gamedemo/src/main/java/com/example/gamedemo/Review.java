package com.example.gamedemo;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "review")
@ToString
@Getter
@Builder
@NoArgsConstructor()
@AllArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int review_id;

    private String comment;

    private String reviewerName;

    @Column(name = "game_id", insertable=false, updatable=false)
    private int game_id;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;
}
