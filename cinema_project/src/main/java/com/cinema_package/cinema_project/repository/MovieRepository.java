package com.cinema_package.cinema_project.repository;

import com.cinema_package.cinema_project.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // This is crucial for using List in your repository

public interface MovieRepository extends JpaRepository<Movie,Long>{
    List<Movie> findByGenre(String genre);
    List<Movie> findByAvailableSeatsGreaterThan(int minSeats);
    List<Movie> findByPriceBetween(int minPrice, int maxPrice);
    List<Movie> findByLocation(String location);
    List<Movie> findAllByOrderByPriceAsc();
}
