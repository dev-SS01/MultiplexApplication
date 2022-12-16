package com.multiplex.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="show")
public class Show {
	@Id
	@Column(name="showid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer showId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="hallId")
private Hall hall;
	public Show() {
		super();
	}
	public Show(Integer showId, Hall hall) {
		super();
		this.showId = showId;
		this.hall = hall;
	}
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", hall=" + hall + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(hall, showId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		return Objects.equals(hall, other.hall) && Objects.equals(showId, other.showId);
	}

	
}
