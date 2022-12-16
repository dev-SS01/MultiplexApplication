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

import com.multiplex.dto.HallDTO;
import com.multiplex.dto.MovieDTO;
import com.multiplex.exception.HallNotFoundExcepiton;
import com.multiplex.services.HallServices;

@RestController
public class HallController {

	@Autowired
	private HallServices hallServices;
	@GetMapping(value= "/hall")
	public ResponseEntity<List<HallDTO>> getAllHalls() throws HallNotFoundExcepiton{
		List<HallDTO> hallList=hallServices.getAllHalls();
		return new ResponseEntity<List<HallDTO>>(hallList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/hall")
	public ResponseEntity<String> addHall(@RequestBody HallDTO hall){
		hallServices.addHall(hall);
		return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.OK);
	}
	
	@GetMapping(value="/hall/{hallId}")
	public ResponseEntity<HallDTO> getHallbyId(@PathVariable Integer hallId) throws HallNotFoundExcepiton{
		HallDTO hall=hallServices.gethallById(hallId);
		return new ResponseEntity<HallDTO>(hall, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/hall/{hallId}")
	public ResponseEntity deleteHallById(@PathVariable Integer hallId) throws HallNotFoundExcepiton{
		hallServices.deleteHallById(hallId);
		return new ResponseEntity("API.DELETE_SUCCESS", HttpStatus.OK);
	}
	
	@PutMapping(value="/hall/h/{hallId}")
	public ResponseEntity updateMovieByName(@PathVariable Integer hallId, @RequestBody MovieDTO movie) {
		hallServices.updateMovieByName(hallId, movie.getMovieId());
		return new ResponseEntity("API.UPDATE_SUCCESS", HttpStatus.ACCEPTED);
	}
}
