package view;

import java.util.Scanner;

import controller.SelectController;

public class MainViewForSelect {

	public static void main(String[] args) {
		
		SelectController kontrola = new SelectController();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Insert stage name: ");
			String stageName = s.nextLine();
		s.close();	
		
		String artistID = kontrola.stageNameInput(stageName);
		if(artistID != "0") {
			System.out.println("ID of " +stageName +" is " +artistID);
		}else {
			System.out.println("Selected stage name not found.");
		}
		
	}

}
