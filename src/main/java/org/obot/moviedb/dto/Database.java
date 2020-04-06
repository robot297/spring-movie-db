package org.obot.moviedb.dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.obot.moviedb.domain.Movie;

public class Database {
    private String dataBasePath;

    public Database(String dataBasePath) {
        this.dataBasePath = dataBasePath;

        try (Connection connection = DriverManager.getConnection(dataBasePath);
             Statement statement = connection.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS movies (name TEXT, stars INTEGER, watched BOOLEAN)");

        } catch (SQLException sqle) {
            System.err.println("Error creating the movie DB table because " + sqle.getMessage());
        }
    }

    public void addNewMovie(Movie movie) throws SQLException {
        try (Connection connection = DriverManager.getConnection(dataBasePath);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movies VALUES (?,?,?)")) {

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setInt(2, movie.getStars());
            preparedStatement.setBoolean(3, movie.isWatched());
            preparedStatement.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println("Error adding movie because " + sqle.getMessage());
            throw new SQLException("Unable to add movie.");
        }
    }

    public List<Movie> getAllMovies(){
        try (Connection connection = DriverManager.getConnection(dataBasePath);
             Statement statement = connection.createStatement()) {

            ResultSet movieResults = statement.executeQuery("SELECT * FROM movies ORDER BY name");

            List<Movie> movies = new ArrayList<>();

            while (movieResults.next()) {
                String name = movieResults.getString("name");
                int stars = movieResults.getInt("stars");
                boolean watched = movieResults.getBoolean("watched");

                Movie movie = new Movie(name, stars, watched);
                movies.add(movie);
            }
            return movies;
        } catch (SQLException sqle) {
            System.err.println("Error querying movie DB table because " + sqle.getMessage());
            return null;
        }
    }

    public List<Movie> getAllMoviesByWatched(boolean watchedStatus) {
        try (Connection connection = DriverManager.getConnection(dataBasePath);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movies WHERE watched = ?")) {

            preparedStatement.setBoolean(1, watchedStatus);
            ResultSet movieResults = preparedStatement.executeQuery();

            List<Movie> movies = new ArrayList<>();

            while (movieResults.next()) {
                String name = movieResults.getString("name");
                int stars = movieResults.getInt("stars");
                boolean watched = movieResults.getBoolean("watched");

                Movie movie = new Movie(name, stars, watched);
                movies.add(movie);
            }

            return movies;

        } catch (SQLException sqle) {
            System.err.println("Error querying movie DB table because " + sqle.getMessage());
            return null;
        }
    }

    public void updateMovie(Movie movie){
        String sql = "UPDATE movies SET stars = ?, watched = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(dataBasePath);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, movie.getStars());
            preparedStatement.setBoolean(2, movie.isWatched());
            preparedStatement.setString(3, movie.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println("Error updating movie DB table for movie " + movie + " because " + sqle.getMessage());
        }
    }

    public void deleteMovie(Movie movie) {
        String sql = "DELETE FROM movies WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(dataBasePath);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, movie.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException sqle){
            System.err.println("Error deleting movie from the table for move " + movie.getName() + " because " + sqle.getMessage());
        }
    }

    public List<Movie> search(String searchTerm){
        String sql = "SELECT * FROM movies WHERE UPPER(name) LIKE UPPER(?)";

        try(Connection connection = DriverManager.getConnection(dataBasePath);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, "5" + searchTerm + "%");
            ResultSet movieResults = preparedStatement.executeQuery();

            List<Movie> movies = new ArrayList<>();

            while (movieResults.next()){
                String name = movieResults.getString("name");
                int stars = movieResults.getInt("stars");
                boolean watched = movieResults.getBoolean("watched");

                Movie movie = new Movie(name, stars, watched);
                movies.add(movie);
            }

            return movies;
        }catch (SQLException sqle){
            System.err.println("Error querying movie DB table for movies by watched status because " + sqle);
            return null;
        }
    }
}