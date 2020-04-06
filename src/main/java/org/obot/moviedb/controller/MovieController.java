package org.obot.moviedb.controller;

import org.obot.moviedb.domain.Movie;
import org.obot.moviedb.dto.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class MovieController {
    private static Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    Database database;

    @RequestMapping(value = "/add_movie", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> addMovie(@RequestBody Movie input){
        LOG.info("Post received.");

        try {
            database.addNewMovie(input);
        } catch (SQLException sqle){
            LOG.error(sqle.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        LOG.info("Post Successful: added {} to the database.", input.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get_movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getMovies(){
        LOG.info("Get received.");

        return new ResponseEntity<Object>(database.getAllMovies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_movie", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteMovie(@RequestBody Movie input){
        LOG.info("Delete request received.");

        try{
            database.deleteMovie(input);
        } catch (SQLException sqle){
            LOG.error("Error occurred: {}", sqle);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
