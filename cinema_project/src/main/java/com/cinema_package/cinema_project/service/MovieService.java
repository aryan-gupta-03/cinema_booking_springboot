package com.cinema_package.cinema_project.service;
import com.cinema_package.cinema_project.entity.Movie;
import com.cinema_package.cinema_project.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie existingMovie = getMovieById(id);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setDate(movie.getDate());
        existingMovie.setLocation(movie.getLocation());
        existingMovie.setTotalSeats(movie.getTotalSeats());
        existingMovie.setAvailableSeats(movie.getAvailableSeats());
        existingMovie.setPrice(movie.getPrice());
        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getMoviesByAvailableSeats(int minSeats) {
        return movieRepository.findByAvailableSeatsGreaterThan(minSeats);
    }

    public List<Movie> getMoviesByPriceRange(int minPrice, int maxPrice) {
        return movieRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Movie> getMoviesByLocation(String location) {
        return movieRepository.findByLocation(location);
    }

    public List<Movie> getMoviesSortedByPrice() {
        return movieRepository.findAllByOrderByPriceAsc();
    }

}
