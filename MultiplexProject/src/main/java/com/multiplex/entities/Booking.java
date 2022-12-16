package com.multiplex.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@Column(name="bookingid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="userId", unique = true)
	private User user;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="showId", unique = true)
	private Show show;
	private LocalDate date;
	private LocalTime time;

	public Booking() {
		super();
	}
	public Booking(Integer bookingId, User user, Show show, LocalDate date, LocalTime time) {
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
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", show=" + show + ", date=" + date + ", time="
				+ time + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, date, show, time, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return bookingId == other.bookingId && Objects.equals(date, other.date) && Objects.equals(show, other.show)
				&& Objects.equals(time, other.time) && Objects.equals(user, other.user);
	}
	
}
