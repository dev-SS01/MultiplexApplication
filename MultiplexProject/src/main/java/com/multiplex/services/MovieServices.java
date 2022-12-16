package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.MovieDTO;
import com.multiplex.exception.MovieNotFoundException;

public interface MovieServices {
public List<MovieDTO> getAllMovies()throws MovieNotFoundException;
public Integer addMovie(MovieDTO movie);
public MovieDTO getMovieById(Integer movieId) throws MovieNotFoundException;
public void deleteMovie(Integer movieId) throws MovieNotFoundException;
public List<MovieDTO> getMovieByName(String movieName) throws MovieNotFoundException;
public void updateMovieByName(Integer movieId, String movieName) throws MovieNotFoundException;
}
