package com.multiplex.dto;

import com.multiplex.entities.Movie;

public class HallDTO {
private Integer hallId;
private Movie movie;
private Integer seatsNo;

public HallDTO() {
	super();
}

public HallDTO(Integer hallId, Movie movie, Integer seatsNo) {
	super();
	this.hallId = hallId;
	this.movie = movie;
	this.seatsNo = seatsNo;
}

public Integer getHallId() {
	return hallId;
}

public void setHallId(Integer hallId) {
	this.hallId = hallId;
}

public Movie getMovie() {
	return movie;
}

public void setMovie(Movie movie) {
	this.movie = movie;
}

public Integer getSeatsNo() {
	return seatsNo;
}

public void setSeatsNo(Integer seatsNo) {
	this.seatsNo = seatsNo;
}

@Override
public String toString() {
	return "HallDTO [hallId=" + hallId + ", movie=" + movie + ", seatsNo=" + seatsNo + "]";
}



}
