package org.obot.moviedb.controller;

import org.obot.moviedb.domain.Movie;
import org.obot.moviedb.dto.MovieDTO;
import org.obot.moviedb.service.MovieServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class MovieController {
    private static Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieServiceImpl movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Long> addMovie(@Valid @RequestBody MovieDTO input){
        LOG.info("Post received.");

        try{
            MovieDTO returnDTO = movieService.createMovie(input);
            LOG.info("Post was successful: added a movie.");
            return new ResponseEntity<>(returnDTO.getId(), HttpStatus.CREATED);
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getMovies(){
        LOG.info("Get received.");

        return new ResponseEntity<Object>("nothing happened", HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteMovie(@RequestBody Movie input){
        LOG.info("Delete request received.");


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
