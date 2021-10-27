package org.obot.moviedb.domain;

import javax.persistence.*;

@Entity(name = "films")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Movie_Name")
    private String name;

    @Column(name = "Number_Of_Stars")
    private int stars;

    @Column(name = "Watched")
    private boolean watched;

    public Movie(String name, int stars, boolean watched){
        this.name = name;
        this.stars = stars;
        this.watched = watched;
    }

    public Movie() {

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
