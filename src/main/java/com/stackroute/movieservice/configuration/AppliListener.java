package com.stackroute.movieservice.configuration;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AppliListener implements ApplicationListener<ContextRefreshedEvent> {
    private MovieRepository movieRepository;

    @Value("${movieId: default}")
    int movieId;

    @Value("${movieTitle: default}")
    String movieTitle;


    @Autowired
    public AppliListener(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    @Order(1)
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("application listener");
        movieRepository.save(new Movie(movieId,movieTitle,"movie-data"));
    }
}
