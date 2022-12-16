package com.multiplex.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieDTO {
	private Integer movieId;
	private String movieName;
	private LocalDate date;
	private LocalTime time;
	public MovieDTO() {
		super();
	}
	public MovieDTO(Integer movieId, String movieName, LocalDate date, LocalTime time) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.date = date;
		this.time = time;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", date=" + date + ", time=" + time + "]";
	}
}
