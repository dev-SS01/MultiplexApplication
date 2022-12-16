package com.multiplex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multiplex.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	@Query("select m from Movie m where m.movieName=:movieName")
public List<Movie> getMovieByName(@Param(value="movieName")String movieName);
}
