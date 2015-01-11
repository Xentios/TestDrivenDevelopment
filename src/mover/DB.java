package mover;

import java.sql.*;


public class DB implements DatabaseConnectorInterface {
	Connection con;

	@Override
	public boolean connect() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url,user, password );			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return true;
	}

	@Override
	public void writeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String writeRental(Rental rental) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(String id) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movie getMovie(String id) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rental getRental(String id) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean haveMovie() {
		return false;		
	}

	@Override
	public void removeMovie(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeUser(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnRental(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isMovieRented(String movie) {
		// TODO Auto-generated method stub
		return false;
	}


}
