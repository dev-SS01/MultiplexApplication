package com.multiplex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.ShowDTO;
import com.multiplex.entities.Show;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.repository.ShowRepository;

@Service(value="showservice")
public class ShowServicesImpl implements ShowServices{

	@Autowired
	private ShowRepository showRepository;
	@Override
	public List<ShowDTO> getAllShows() throws ShowNotFoundException{
		Iterable<Show> shows=showRepository.findAll();
		List<ShowDTO> shows2=new ArrayList<>();
		shows.forEach(show -> {
			ShowDTO shows1=new ShowDTO();
			shows1.setHall(show.getHall());
			shows1.setShowId(show.getShowId());
			shows2.add(shows1);
		});
		if(shows2.isEmpty()) {
			throw new ShowNotFoundException();
		}
		return shows2;
	}
	@Override
	public Integer addShow(ShowDTO show) {
		Show showEntity=new Show();
		showEntity.setShowId(show.getShowId());
		showEntity.setHall(show.getHall());
		Show showEntity2=showRepository.save(showEntity);
		return showEntity2.getShowId();

	}
	@Override
	public ShowDTO getShowById(Integer showId) throws ShowNotFoundException{
		Optional<Show> optional=showRepository.findById(showId);
		Show show=optional.orElseThrow(() -> new ShowNotFoundException());
		ShowDTO show2=new ShowDTO();
		show2.setShowId(show.getShowId());
		show2.setHall(show.getHall());
		return show2;

	}
	@Override
	public void deleteShowById(Integer showId) throws ShowNotFoundException{
		Optional<Show> optional=showRepository.findById(showId);
		Show show=optional.orElseThrow(() -> new ShowNotFoundException());
		ShowDTO show2=new ShowDTO();
		show2.setShowId(show.getShowId());
		show2.setHall(show.getHall());
		showRepository.deleteById(showId);
	}

}
