package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Artist;

public class CommonConnectMethod {

	public static Connection serverConnect(String baseName) throws SQLException {
		
		String username = "root";
		String password = "insearchofsunrise41342005";
		String url = "jdbc:mysql://localhost:3306/" +baseName;
		
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public void greet() {
		
		System.out.println("Greetings from our app! Welcome!");
	}
	
	public Artist setArtist(String firstName, String lastName, String stageName, String label, int state, int top10) {
		
		Artist artist = new Artist();
			artist.setFirstName(firstName);
			artist.setLastName(lastName);
			artist.setStageName(stageName);
			artist.setLabel(label);
			artist.setState(state);
			artist.setTop10(top10);
		
		return artist;	
	}
}
