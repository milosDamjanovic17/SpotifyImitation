package controller;

import model.Artist;
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

}
