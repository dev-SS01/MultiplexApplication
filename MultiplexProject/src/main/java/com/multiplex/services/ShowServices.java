package com.multiplex.services;

import java.util.List;

import com.multiplex.dto.ShowDTO;
import com.multiplex.exception.ShowNotFoundException;

public interface ShowServices {
public List<ShowDTO> getAllShows() throws ShowNotFoundException;
public Integer addShow(ShowDTO show);
public ShowDTO getShowById(Integer showId) throws ShowNotFoundException;
public void deleteShowById(Integer showId) throws ShowNotFoundException;
}
