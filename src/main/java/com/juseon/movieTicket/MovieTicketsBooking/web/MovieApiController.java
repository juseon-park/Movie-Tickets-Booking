package com.juseon.movieTicket.MovieTicketsBooking.web;

import com.juseon.movieTicket.MovieTicketsBooking.domain.movie.Movie;
import com.juseon.movieTicket.MovieTicketsBooking.web.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieApiController {

    private final MovieService movieService;
    @GetMapping("/movielists")
    public List<Movie> movieDto(){
        List<Movie> movies = movieService.getMovieList();
        return movies;
    }
}

