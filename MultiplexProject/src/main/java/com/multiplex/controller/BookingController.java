package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.BookingDTO;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.services.BookingServices;

@RestController
public class BookingController {

	@Autowired
	private BookingServices bookingServices;
	@GetMapping(value="/booking")
	public ResponseEntity<List<BookingDTO>> getAllBookings() throws BookingNotFoundException{
		List<BookingDTO> bookingList=bookingServices.getAllBookings();
		return new ResponseEntity<List<BookingDTO>>(bookingList,HttpStatus.OK);
	}
	
	@PostMapping(value="/booking")
	public ResponseEntity<String> addBooking(@RequestBody BookingDTO booking){
		bookingServices.addBooking(booking);
		return new ResponseEntity<String>("Booking Created Successfully", HttpStatus.OK);
	}
	
	@GetMapping(value="/booking/{bookingId}")
	public ResponseEntity<BookingDTO> getBookingById(@PathVariable Integer bookingId) throws BookingNotFoundException{
		BookingDTO booking=bookingServices.getBookingById(bookingId);
		return new ResponseEntity<BookingDTO>(booking, HttpStatus.OK);
	}
	@DeleteMapping(value="/booking/{bookingId}")
		public ResponseEntity deleteBookingById(@PathVariable Integer bookingId) throws BookingNotFoundException{
			bookingServices.deleteBookingById(bookingId);
			return new ResponseEntity("Booking Deleted Successfully", HttpStatus.OK);
		}
	}
