package org.obot.moviedb.domain;

public class Movie {

    private int id;
    private String name;
    private int stars;
    private boolean watched;

    public Movie(String name, int stars, boolean watched){
        this.name = name;
        this.stars = stars;
        this.watched = watched;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
