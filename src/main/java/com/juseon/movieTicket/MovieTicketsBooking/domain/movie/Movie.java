package com.juseon.movieTicket.MovieTicketsBooking.domain.movie;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;

    @Column(length = 100, nullable = false)
    String title;

    @Column(nullable = false)
    int runningTime;

}
