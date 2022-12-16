package com.multiplex.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@Column(name="movieid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer movieId;
private String movieName;
@DateTimeFormat
private LocalDate date;
@DateTimeFormat
private LocalTime time;
public Movie() {
	super();
}
public Movie(Integer movieId, String movieName, LocalDate date, LocalTime time) {
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
@Override
public int hashCode() {
	return Objects.hash(date, movieId, movieName, time);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Movie other = (Movie) obj;
	return Objects.equals(date, other.date) && movieId == other.movieId && Objects.equals(movieName, other.movieName)
			&& Objects.equals(time, other.time);
}

}
