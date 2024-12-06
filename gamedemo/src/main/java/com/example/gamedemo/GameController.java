package com.example.gamedemo;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    ReviewService reviewService;


    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping("/game")
    public String list(Model model) {
        model.addAttribute("games", gameService.findAll());

        return "list";
    }
    @RequestMapping("/game/{idx}")
    public String read(@PathVariable int idx, Model model) {
        List<Review> reviewsList = reviewRepository.findAll();

        List<Review> filteredReviews = reviewsList.stream()
                .filter(review -> review.getGame().getIdx() == idx)
                .collect(Collectors.toList());

        List<String> reviewComments = filteredReviews.stream()
                .map(Review::getComment)
                .collect(Collectors.toList());

        List<String> reviewerNames = filteredReviews.stream()
                .map(Review::getReviewerName)
                .collect(Collectors.toList());

        model.addAttribute("game", gameService.findById(idx));
        model.addAttribute("reviewComments", reviewComments);
        model.addAttribute("reviewerNames", reviewerNames);

        return "read";
    }

    @RequestMapping("/game/search")
    public String search(
            @RequestParam Optional<String> title,
            @RequestParam Optional<String> genre,
            @RequestParam Optional<Integer> minPrice,
            @RequestParam Optional<Integer> maxPrice,
            Model model) {

        List<Game> games = gameRepository.findAll();

        List<Game> filteredGames = games.stream()
                .filter(game -> title.map(t -> game.getTitle().toLowerCase().contains(t.toLowerCase())).orElse(true)) // 타이틀 조건
                .filter(game -> genre.map(g -> game.getGenre().toLowerCase().contains(g.toLowerCase())).orElse(true)) // 장르 조건
                .filter(game -> minPrice.map(min -> game.getPrice() >= min).orElse(true)) // 최소 가격 조건
                .filter(game -> maxPrice.map(max -> game.getPrice() <= max).orElse(true)) // 최대 가격 조건
                .collect(Collectors.toList());

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
    public String delete(@PathVariable int idx){
        gameService.deleteById(idx);
        return "redirect:/game";
    }
    @RequestMapping("/game/updateform/{idx}")
    public String updateform(@PathVariable Integer idx, Model model){
        GameDTO game = gameService.findById(idx);
        model.addAttribute("game",game);
        return "updateform";

    }
    @RequestMapping("/game/update")
    public String update(@ModelAttribute GameDTO game){
        gameService.save(game);
        return "redirect:/game";
    }

    @RequestMapping("/game/review/{idx}")
    public String review(@PathVariable Integer idx, Model model) {
        GameDTO game = gameService.findById(idx);
        if (game == null) {
            throw new IllegalArgumentException("Game not found with ID: " + idx);
        }
        model.addAttribute("game", game);

        List<ReviewDTO> reviews = reviewService.findByGameIdReview(idx);
        model.addAttribute("reviews", reviews);

        model.addAttribute("newReview", new ReviewDTO());
        return "review";
    }


    @RequestMapping(value = "/game/review/add/{idx}", method = RequestMethod.POST)
    public String addReview(@PathVariable Integer idx, @ModelAttribute("newReview") ReviewDTO reviewDTO) {
        reviewDTO.setGame_id(idx);
        reviewService.saveReview(reviewDTO);
        return "redirect:/game/" + idx;
    }

}
