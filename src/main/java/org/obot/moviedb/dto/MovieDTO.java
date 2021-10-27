package org.obot.moviedb.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MovieDTO {

    private Long id;

    @NotEmpty(message = "Gotta send a movie name.")
    @Size(min = 2, max = 50, message = "Improper field size.")
    private String name;

    private int stars;

    private boolean watched;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String name, int stars, boolean watched) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.watched = watched;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}