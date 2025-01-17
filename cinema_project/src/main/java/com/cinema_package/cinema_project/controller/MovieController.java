package com.cinema_package.cinema_project.controller;

import com.cinema_package.cinema_project.entity.Movie;
import com.cinema_package.cinema_project.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    // 3. Get a movie by ID
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    // 6. Delete movie by ID
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "Movie with ID " + id + " has been deleted";
    }

    // 7. Get movies with available seats greater than a specified number
    @GetMapping("/availableSeats/{minSeats}")
    public List<Movie> getMoviesByAvailableSeats(@PathVariable int minSeats) {
        return movieService.getMoviesByAvailableSeats(minSeats);
    }

    // 8. Get movies within a specific price range
    @GetMapping("/priceRange/{minPrice}/{maxPrice}")
    public List<Movie> getMoviesByPriceRange(@PathVariable int minPrice, @PathVariable int maxPrice) {
        return movieService.getMoviesByPriceRange(minPrice, maxPrice);
    }

    // 9. Get movies showing in a specific location
    @GetMapping("/location/{location}")
    public List<Movie> getMoviesByLocation(@PathVariable String location) {
        return movieService.getMoviesByLocation(location);
    }

    // 10. Get all movies sorted by price (ascending)
    @GetMapping("/sortedByPrice")
    public List<Movie> getMoviesSortedByPrice() {
        return movieService.getMoviesSortedByPrice();
    }

}

