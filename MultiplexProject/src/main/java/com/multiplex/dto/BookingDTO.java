package com.multiplex.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.multiplex.entities.Show;
import com.multiplex.entities.User;

public class BookingDTO {
private Integer bookingId;
private User user;
private Show show;
private LocalDate date;
private LocalTime time;
public BookingDTO() {
	super();
}
public BookingDTO(Integer bookingId, User user, Show show, LocalDate date, LocalTime time) {
	super();
	this.bookingId = bookingId;
	this.user = user;
	this.show = show;
	this.date = date;
	this.time = time;
}
public Integer getBookingId() {
	return bookingId;
}
public void setBookingId(Integer bookingId) {
	this.bookingId = bookingId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Show getShow() {
	return show;
}
public void setShow(Show show) {
	this.show = show;
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
	return "BookingDTO [bookingId=" + bookingId + ", user=" + user + ", show=" + show + ", date=" + date
			+ ", time=" + time + "]";
}

}
