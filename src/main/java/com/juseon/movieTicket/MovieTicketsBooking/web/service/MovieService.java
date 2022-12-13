package com.juseon.movieTicket.MovieTicketsBooking.web.service;

import com.juseon.movieTicket.MovieTicketsBooking.domain.movie.Movie;
import com.juseon.movieTicket.MovieTicketsBooking.domain.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public List<Movie> getMovieList(){
        return movieRepository.findAll();
    }


}
