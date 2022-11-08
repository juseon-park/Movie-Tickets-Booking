package com.juseon.movieTicket.MovieTicketsBooking.domain.hello;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class HelloDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String seats;

    private String cinema;

    @Builder
    public HelloDomain(String title, String seats, String cinema){
        this.title = title;
        this.seats = seats;
        this.cinema = cinema;
    }
}
