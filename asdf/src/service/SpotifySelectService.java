package service;

import dao.Logic;

public class SpotifySelectService {
	
	Logic logika = new Logic();

	public String vratiID(String stageName) {
		
		return logika.selektujID(stageName);
	}

}
