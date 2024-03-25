package com.mysqltest.repository;

import com.mysqltest.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findMovieById(Long MovieId);

}
