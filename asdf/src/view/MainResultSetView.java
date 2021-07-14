package view;

import java.util.Scanner;

import controller.SelectController;
import model.Artist;

public class MainResultSetView {

	public static void main(String[] args) {
		
		SelectController kontroler = new SelectController();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Type ID:");
		String id = s.nextLine();
		s.close();
		
		Artist artist = kontroler.returnDetails(id);
			int check = artist.getId();
			if(check != 0) {
				System.out.println("ID: " +artist.getId());
				System.out.println("Name: " +artist.getFirstName() +" " +artist.getLastName());
				System.out.println("Stage name: " +artist.getStageName());
				System.out.println("Label: " +artist.getLabel());
				System.out.println("State: " +artist.getState());
				System.out.println("TOP 10: " +artist.getTop10());
			} else {
				System.out.println("Index out of bounds.");
			}
			
	}

}