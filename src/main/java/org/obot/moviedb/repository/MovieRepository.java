package org.obot.moviedb.repository;

import org.obot.moviedb.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
//    Movie findMoviesBy(String name);
}
