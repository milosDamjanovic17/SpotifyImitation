package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.CommonConnectMethod;
import model.Artist;
import model.ArtistGenre;

public class Logic {
	
	private void resultSetClose(ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
				System.out.println("ResultSet is closed");
			} catch (SQLException e) {
				System.out.println("ResultSet is not closed.");
				e.printStackTrace();
			}
		}
		
	}
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

	public String selektujID(String stageName) {
		String check = "0";
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = CommonConnectMethod.serverConnect("Spotify");
			System.out.println("Successfully connected to DB Spotify");
			String sql = "SELECT id FROM Artist WHERE stage_name = ?";
			pst = con.prepareStatement(sql);
				pst.setString(1, stageName);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				check = rs.getString("id");
				
			}
				
		} catch (SQLException e) {
			System.out.println("Connection to DB failed.");
			e.printStackTrace();
		} finally {
			resultSetClose(rs);
			preparedStatementClose(pst);
			connectionShut(con);
		}
		return check;
		
	}
	
	public Artist returnArtistDetails (String id) {
		
		Artist artist = new Artist();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = CommonConnectMethod.serverConnect("Spotify");
			System.out.println("Connected to DB");
			String sql = "SELECT * FROM artist WHERE id = ?";
			pst = con.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(id));
			
			rs = pst.executeQuery();
			while(rs.next()) {
				artist.setId(rs.getInt("id"));
				artist.setFirstName(rs.getString("first_name"));
				artist.setLastName(rs.getString("last_name"));
				artist.setStageName(rs.getString("stage_name"));
				artist.setLabel(rs.getString("label"));
				artist.setState(rs.getInt("state"));
				artist.setTop10(rs.getInt("times_in_top10chart"));
				
			} 
			
				
			
		} catch (SQLException e) {
			System.out.println("Failed to execute operation.");
			e.printStackTrace();
		} finally {
			resultSetClose(rs);
			preparedStatementClose(pst);
			connectionShut(con);
		}
		
		return artist;
	}
	public List<ArtistGenre> returnAGmethod(String id) {
		List <ArtistGenre> localListAG = new ArrayList <ArtistGenre>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = CommonConnectMethod.serverConnect("Spotify");
			System.out.println("Connected to DB");
			String query = "SELECT a.id,a.stage_name, g.genre_name\n"
					+ "FROM artist_genre ag\n"
					+ "INNER JOIN artist a ON ag.artist_id = a.id\n"
					+ "INNER JOIN genre g ON ag.genre_id = g.id_genre\n"
					+ "WHERE a.id = ?";
			pst = con.prepareStatement(query);
				pst.setInt(1, Integer.parseInt(id));
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ArtistGenre localWrapper = new ArtistGenre();
				
				localWrapper.setId(rs.getInt("id"));
				localWrapper.setStage_name(rs.getString("stage_name"));
				localWrapper.setGenre_name(rs.getString("genre_name"));
				
			localListAG.add(localWrapper);	
				
			}
		} catch (SQLException e) {
			System.out.println("Execution of returnAGmethod failed.");
			e.printStackTrace();
		} finally {
			resultSetClose(rs);
			preparedStatementClose(pst);
			connectionShut(con);
		}
		
		return localListAG;
	}
	
	
}
