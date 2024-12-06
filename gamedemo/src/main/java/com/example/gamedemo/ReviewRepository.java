package com.example.gamedemo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    List<Review> findByGame_Idx(int gameIdx);
}
