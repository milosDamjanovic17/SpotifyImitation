package view;

import java.util.List;
import java.util.Scanner;

import controller.SelectController;
import model.ArtistGenre;

public class ArtistGenreView {

	public static void main(String[] args) {
		
		SelectController kontroler = new SelectController();
		Scanner s = new Scanner(System.in);
		System.out.println("Type ID: ");
			String id = s.nextLine();
		s.close();
		
		List <ArtistGenre> listaAG = kontroler.returnAG(id);
		
		for(ArtistGenre ag: listaAG) {
			System.out.println(ag.getId() +" " +ag.getStage_name() +" " +ag.getGenre_name());
		}
		
	}

}
