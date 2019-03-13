package com.stackroute.movieservice.configuration;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//first priority
@Component
@PropertySource("classpath:application.properties")
public class CommandList implements CommandLineRunner {
    @Autowired
    Environment environment;

    private String name;
    private MovieRepository movieRepository;

    @Autowired
    public CommandList(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    @Order(2)
    public void run(String... args) throws Exception {
        System.out.println("command line");
        movieRepository.save(new Movie(2,environment.getProperty("movieTitle2"),"movie-data-2"));
    }
}
