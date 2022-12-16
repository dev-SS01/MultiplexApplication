package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.BookingDTO;
import com.multiplex.entities.Booking;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.repository.BookingRepository;
@Service(value="bookingservice")
public class BookingServicesImpl implements BookingServices{

	@Autowired
	private BookingRepository bookingRepository; 
	@Override
	public List<BookingDTO> getAllBookings() throws BookingNotFoundException{
          Iterable<Booking> bookings= bookingRepository.findAll();
          List<BookingDTO> booking2= new ArrayList<>();
          bookings.forEach(booking -> {
        	BookingDTO booking1=new BookingDTO();
        	booking1.setBookingId(booking.getBookingId());
        	booking1.setUser(booking.getUser());
        	booking1.setShow(booking.getShow());
        	booking1.setDate(booking.getDate());
        	booking1.setTime(booking.getTime());
        	booking2.add(booking1);
        	});
          if(booking2.isEmpty()) {
        	  throw new BookingNotFoundException();
          }
          return booking2;
          }
	@Override
	public Integer addBooking(BookingDTO booking) {
		Booking bookingEntity=new Booking();
		bookingEntity.setBookingId(booking.getBookingId());
		bookingEntity.setUser(booking.getUser());
		bookingEntity.setDate(booking.getDate());
		bookingEntity.setTime(booking.getTime());
		bookingEntity.setShow(booking.getShow());
		Booking bookingEntity2=bookingRepository.save(bookingEntity);
		return bookingEntity2.getBookingId();

	}
	@Override
	public BookingDTO getBookingById(Integer bookingId) throws BookingNotFoundException{
		Optional<Booking> optional=bookingRepository.findById(bookingId);
		Booking booking=optional.orElseThrow(() -> new BookingNotFoundException());
		BookingDTO booking2=new BookingDTO();
		booking2.setBookingId(booking.getBookingId());
		booking2.setUser(booking.getUser());
		booking2.setShow(booking.getShow());
		booking2.setDate(booking.getDate());
		booking2.setTime(booking.getTime());
		return booking2;

	}
	@Override
	public void deleteBookingById(Integer bookingId) throws BookingNotFoundException{
		Optional<Booking> optional=bookingRepository.findById(bookingId);
		Booking booking=optional.orElseThrow(() -> new BookingNotFoundException());
		BookingDTO booking2=new BookingDTO();
		booking2.setBookingId(booking.getBookingId());
		booking2.setDate(booking.getDate());
		booking2.setTime(booking.getTime());
		booking2.setShow(booking.getShow());
		booking2.setUser(booking.getUser());
		bookingRepository.deleteById(bookingId);
	}
	}

