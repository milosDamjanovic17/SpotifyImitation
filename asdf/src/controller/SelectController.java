package controller;

import service.SpotifySelectService;

public class SelectController {
	
	SpotifySelectService servis = new SpotifySelectService();

	public String stageNameInput(String stageName) {
		
		return servis.vratiID(stageName);
	}

}
