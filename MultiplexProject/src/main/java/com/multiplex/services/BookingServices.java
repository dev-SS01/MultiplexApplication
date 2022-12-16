package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.BookingDTO;
import com.multiplex.exception.BookingNotFoundException;

public interface BookingServices {
public List<BookingDTO> getAllBookings() throws BookingNotFoundException;
public Integer addBooking(BookingDTO booking);
public BookingDTO getBookingById(Integer bookingId) throws BookingNotFoundException;
public void deleteBookingById(Integer bookingId) throws BookingNotFoundException;
}
