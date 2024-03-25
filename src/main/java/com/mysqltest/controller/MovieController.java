package com.mysqltest.controller;

import com.mysqltest.entity.Movie;
import com.mysqltest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {


    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //POST - Add a movie
    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    //GET - Get all movies & Get movie by ID
    @GetMapping("/")
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable String movieId){
        return movieRepository.findMovieById(Long.valueOf(movieId));
    }

    //PUT - Update a movie
    @PutMapping("/update/{movieId}")
    public Movie updateMovie(@PathVariable String movieId,@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    //DELETE - Delete a movie
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long movieId){
        try{
            movieRepository.deleteById(movieId);
            return ResponseEntity.ok("Movie deleted successfully");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("faild to delete");
        }
    }
}
