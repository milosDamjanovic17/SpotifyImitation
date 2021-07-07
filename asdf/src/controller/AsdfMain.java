package controller;

import model.Artist;
import service.SpotifyService;

public class AsdfMain {

	public static void main(String[] args) {
		
		SpotifyService servis = new SpotifyService();
		servis.appGreet();
		
		String name = "Sam";
		String lastname = "Divine";
		String stageName = "Sam Divine";
		String label = "Defected";
		int state = 4;
		int top10 = 3;
		
		String stateName = "Lebanon";
		
		
		Artist artist = servis.setArtist(name,lastname,stageName,label,state,top10);
					
		servis.insertArtistInDB(artist);
		servis.insertStateInDB(stateName);
	}

}
