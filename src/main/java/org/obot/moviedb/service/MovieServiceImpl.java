package org.obot.moviedb.service;

import org.obot.moviedb.domain.Movie;
import org.obot.moviedb.dto.MovieDTO;
import org.obot.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieDTO createMovie(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setStars(movieDTO.getStars());
        movie.setWatched(movieDTO.isWatched());

        Movie savedMovie = movieRepository.save(movie);
        movieDTO.setId(savedMovie.getId());

        return movieDTO;
    }

}
