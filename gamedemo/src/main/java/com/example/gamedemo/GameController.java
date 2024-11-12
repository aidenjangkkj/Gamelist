package com.example.gamedemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class GameController {


    @Autowired
    GameService gameService;
    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/game")
    public String list(Model model) {
        model.addAttribute("games", gameService.findAll());
        return "list";
    }
    @RequestMapping("/game/{idx}")
    public String read(@PathVariable long idx, Model model){
        model.addAttribute("game",gameService.findById(idx));
        return "read";
    }
    @RequestMapping("/game/search")
    public String search(@RequestParam Optional<String> title, Model model) {
        List<Game> games = gameRepository.findAll();
        List<Game> filteredGames = title
                .map(t -> games.stream()
                        .filter(game -> game.getTitle().toLowerCase().contains(t.toLowerCase()))
                        .collect(Collectors.toList()))
                .orElse(games);
        model.addAttribute("games", filteredGames);
        if (filteredGames.isEmpty()) {
            model.addAttribute("message", "검색 결과 없음");
        }
        return "searchlist";
    }
    @RequestMapping("/game/add")
    public String add(@ModelAttribute GameDTO game){
        gameService.save(game);
        return "redirect:/game";

    }
    @RequestMapping("/game/addform")
    public String addform(){
        return "addform";
    }
    @RequestMapping("/game/delete/{idx}")
    public String delete(@PathVariable long idx){
        gameService.deleteById(idx);
        return "redirect:/game";
    }
    @RequestMapping("/game/updateform/{idx}")
    public String updateform(@PathVariable Long idx, Model model){
        GameDTO game = gameService.findById(idx);
        model.addAttribute("game",game);
        return "updateform";

    }
    @RequestMapping("/game/update")
    public String update(@ModelAttribute GameDTO game){
        gameService.save(game);
        return "redirect:/game";
    }
}
