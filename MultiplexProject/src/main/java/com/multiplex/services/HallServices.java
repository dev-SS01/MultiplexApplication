package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.HallDTO;
import com.multiplex.exception.HallNotFoundExcepiton;

public interface HallServices {
public List<HallDTO> getAllHalls() throws HallNotFoundExcepiton;
public Integer addHall(HallDTO hall);
public HallDTO gethallById(Integer hallId) throws HallNotFoundExcepiton;
public void deleteHallById(Integer hallId) throws HallNotFoundExcepiton;
public void updateMovieByName(Integer hallId, Integer movieId);
}
