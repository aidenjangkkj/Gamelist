package com.example.gamedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameSerImpl implements GameService{
    @Autowired
    private GameRepository gameRepository;
    @Override
    public List<GameDTO> findAll() {
        return gameRepository.findAll().stream()
                .map(v->Utils.toDTO(v))
                .collect(Collectors.toList());
    }

    @Override
    public GameDTO findById(int idx) {
        return gameRepository.findById(idx)
                .map(v->Utils.toDTO(v))
                .orElse(null);
    }
    @Override
    public void save(GameDTO gameDTO) {
        Game game = Utils.toEntity(gameDTO);
        gameRepository.save(game);
    }

    @Override
    public void deleteById(int idx) {
        gameRepository.deleteById(idx);
    }
}
