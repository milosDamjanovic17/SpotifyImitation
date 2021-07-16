package controller;

import java.util.List;

import model.Artist;
import model.ArtistGenre;
import service.SpotifySelectService;

public class SelectController {
	
	SpotifySelectService servis = new SpotifySelectService();

	public String stageNameInput(String stageName) {
		
		return servis.vratiID(stageName);
	}

	public Artist returnDetails(String id) {
		// TODO Auto-generated method stub
		return servis.returnDetails(id);
	}

	public List<ArtistGenre> returnAG(String id) {
		// TODO Auto-generated method stub
		return servis.returnAG(id);
	}

}
