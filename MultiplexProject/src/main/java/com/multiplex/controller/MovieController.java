package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.MovieDTO;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.services.MovieServices;

@RestController
public class MovieController {

	@Autowired
	private MovieServices movieServices;
	@GetMapping(value= "/movie")
      public ResponseEntity<List<MovieDTO>> getAllMovies() throws MovieNotFoundException{
    	  List<MovieDTO> movieList=movieServices.getAllMovies();
    	  return new ResponseEntity<List<MovieDTO>>(movieList, HttpStatus.OK);
      }
	
	@PostMapping(value= "/movie")
	public ResponseEntity<String> addMovie(@RequestBody MovieDTO movie){
		movieServices.addMovie(movie);
		return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.CREATED);
	}
	
	@GetMapping(value="/movie/{movieId}")
	public ResponseEntity<MovieDTO> getMovieById(@PathVariable Integer movieId) throws MovieNotFoundException{
		MovieDTO movie=movieServices.getMovieById(movieId);
		return new ResponseEntity<MovieDTO>(movie, HttpStatus.OK);
	}
	@DeleteMapping(value="/movie/{movieId}")
	public ResponseEntity deleteMovieById(@PathVariable Integer movieId) throws MovieNotFoundException{
		movieServices.deleteMovie(movieId);
		return new ResponseEntity<String>("API.DELETE_SUCCESS", HttpStatus.OK);
	}
	
	@GetMapping(value="/movie/m/{movieName}")
	public ResponseEntity getUserByName(@PathVariable String movieName) throws MovieNotFoundException{
		return new ResponseEntity(movieServices.getMovieByName(movieName), HttpStatus.OK);
	}
	
	@PutMapping(value="/movie/m/{movieId}")
	public ResponseEntity updateMovieByName(@PathVariable Integer movieId, @RequestBody MovieDTO movieName) throws MovieNotFoundException{
		movieServices.updateMovieByName(movieId, movieName.getMovieName());
		return new ResponseEntity("API.UPDATE_SUCCESS", HttpStatus.ACCEPTED);
	}
}
