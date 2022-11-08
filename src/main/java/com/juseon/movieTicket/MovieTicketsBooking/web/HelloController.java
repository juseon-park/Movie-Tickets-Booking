package com.juseon.movieTicket.MovieTicketsBooking.web;


import com.juseon.movieTicket.MovieTicketsBooking.domain.hello.HelloDomain;
import com.juseon.movieTicket.MovieTicketsBooking.domain.hello.HelloRepository;
import com.juseon.movieTicket.MovieTicketsBooking.web.dto.HelloResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/test")
    public void hello() {
        String title = "test";
        String seats = "seat";

        helloRepository.save(HelloDomain.builder()
                .title(title)
                .seats(seats)
                .cinema("용산아이파크")
                .build());

    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String
                                                 name,
                                     @RequestParam("amount") int
                                                amount){
        return new HelloResponseDto(name,amount);
    }
    
}
