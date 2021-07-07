package service;

import connect.CommonConnectMethod;
import dao.Logic;
import model.Artist;

public class SpotifyService {

	Logic logika = new Logic();
	CommonConnectMethod common = new CommonConnectMethod();
	
	
	public void insertArtistInDB(Artist artist) {
		
		logika.spotifyArtist(artist);
	}


	public void insertStateInDB(String stateName) {
		
		logika.insertState(stateName);
	}


	public void appGreet() {
		
		common.greet();
	}


	public Artist setArtist(String name, String lastname, String stageName, String label, int state, int top10) {
		
		return common.setArtist(name, lastname, stageName, label, state, top10);
	}

	
}
