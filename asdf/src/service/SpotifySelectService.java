package service;

import dao.Logic;
import model.Artist;

public class SpotifySelectService {
	
	Logic logika = new Logic();

	public String vratiID(String stageName) {
		
		return logika.selektujID(stageName);
	}

	public Artist returnDetails(String id) {
		// TODO Auto-generated method stub
		return logika.returnArtistDetails(id);
	}

}
