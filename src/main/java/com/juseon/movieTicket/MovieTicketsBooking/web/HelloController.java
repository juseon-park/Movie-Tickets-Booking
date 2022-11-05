package com.juseon.movieTicket.MovieTicketsBooking.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/main")

    public String hello()
    {
        return "시이이작";
    }
    
}
