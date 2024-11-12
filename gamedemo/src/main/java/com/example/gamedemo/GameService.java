package com.example.gamedemo;

import java.util.List;

public interface GameService {
    List<GameDTO> findAll();
    GameDTO findById(long idx);
    void save(GameDTO game);
    void deleteById(long idx);
}
