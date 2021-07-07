package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.CommonConnectMethod;
import model.Artist;

public class Logic {
	
	private void preparedStatementClose(PreparedStatement ps) {
		
		if(ps != null) {
			try {
				ps.close();
				System.out.println("Prepared Statement is closed");
			} catch (SQLException e) {
				System.out.println("Prepared Statement is not closed.");
				e.printStackTrace();
			}
		}
		
	}
	
	private void connectionShut(Connection con) {
		
		if(con != null) {
			try {
				con.close();
				System.out.println("Connection to DB is now closed.");
			} catch (SQLException e) {
				System.out.println("Connection to DB is not closed");
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	

	public void spotifyArtist(Artist artist) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = CommonConnectMethod.serverConnect("Spotify");
			System.out.println("Connected to selected DB.");
			String query = "INSERT INTO Artist VALUES (null,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
				ps.setString(1, artist.getFirstName());
				ps.setString(2, artist.getLastName());
				ps.setString(3, artist.getStageName());
				ps.setString(4, artist.getLabel());
				ps.setInt(5, artist.getState());
				ps.setInt(6, artist.getTop10());
			ps.execute();
			System.out.println("Artist " +artist.getStageName() +" is successfully added to Spotify DB.");
			
			
		} catch (SQLException e) {
			System.out.println("Failed to connect to DB.");
			e.printStackTrace();
		} finally {
			preparedStatementClose(ps);
			connectionShut(con);
		}
			
	}
	
	public void insertState (String stateName) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = CommonConnectMethod.serverConnect("Spotify");
			System.out.println("Connected to Spotify DB");
			String query = "INSERT INTO State VALUES (null,?)";
			ps = con.prepareStatement(query);
				ps.setString(1, stateName);
			ps.execute();
			System.out.println("State " +stateName +" is successfully added to table State.");
		} catch (SQLException e) {
			System.out.println("Connection to Spotify DB failed.");
			e.printStackTrace();
		} finally {
			preparedStatementClose(ps);
			connectionShut(con);
		}
		
	}
	public void insertGenre(String genreName) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = CommonConnectMethod.serverConnect("Spotify");
			System.out.println("Connection with Spotify DB is established");
			String query = "INSERT INTO Genre VALUES (null,?)";
			ps = con.prepareStatement(query);
				ps.setString(1, genreName);
			ps.execute();
			System.out.println("Genre " +genreName +" successfully added to table Genre.");
		} catch (SQLException e) {
			System.out.println("Connection to DB failed.");
			e.printStackTrace();
		} finally {
			preparedStatementClose(ps);
			connectionShut(con);
		}
		
		
	}
	
	
}
