package service;

import java.util.List;

import dao.Logic;
import model.Artist;
import model.ArtistGenre;

public class SpotifySelectService {
	
	Logic logika = new Logic();

	public String vratiID(String stageName) {
		
		return logika.selektujID(stageName);
	}

	public Artist returnDetails(String id) {
		// TODO Auto-generated method stub
		return logika.returnArtistDetails(id);
	}

	public List<ArtistGenre> returnAG(String id) {
		// TODO Auto-generated method stub
		return logika.returnAGmethod(id);
	}

}
