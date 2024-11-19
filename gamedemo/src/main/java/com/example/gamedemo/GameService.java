package com.example.gamedemo;

import java.util.List;

public interface GameService {
    List<GameDTO> findAll();
    GameDTO findById(int idx);


    void save(GameDTO game);
    void deleteById(int idx);
}
