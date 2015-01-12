package mover;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


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
	
	public void close(){
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createDatabase(){
		//Database
		String sql="CREATE DATABASE mover";	
		//updateCommit(sql);
		//Tables
		sql="CREATE TABLE users (user varchar(255))";
		updateCommit(sql);
		sql="CREATE TABLE movies (movie varchar(255))";
		updateCommit(sql);
		sql="CREATE TABLE rentals (ID int NOT NULL AUTO_INCREMENT ,moviename varchar(255),username varchar(255), PRIMARY KEY (ID) )";
		updateCommit(sql);		
	}
	public void destroyDatabase(){
		String sql="DROP TABLE users";
		updateCommit(sql);
		String sql2="DROP TABLE movies";
		updateCommit(sql2);	
		String sql3="DROP TABLE rentals";
		updateCommit(sql3);	
	}
	
	@Override
	public void writeUser(User user) {		
		String sql="INSERT INTO users (user) VALUES ('"+user.getName()+"')";
		updateCommit(sql);
	}
	

	@Override
	public void writeMovie(Movie movie) {
		String sql="INSERT INTO movies  (movie) VALUES ('"+movie.getName()+"')";
		updateCommit(sql);		
	}

	@Override
	public String writeRental(Rental rental) {
		String sql="INSERT INTO rentals  (moviename,username) VALUES ('"+rental.getMovie().getName()+"','"+rental.getUser().getName()+"')";
		updateCommit(sql);	
		
		sql="SELECT * from rentals ORDER BY id DESC LIMIT 1";
		return readOne(sql);
	}

	@Override
	public User getUser(String id) {		
		String sql="SELECT * FROM users WHERE user='"+id+"'";
		String answer=readOne(sql);
		if (answer==null)
			return null;
		User user=new User();
		user.setName(answer);		
		return user;
	}

	@Override
	public Movie getMovie(String id) {	
		String sql="SELECT * FROM movies WHERE movie='"+id+"'";
		String answer=readOne(sql);
		if (answer==null)
			return null;
		Movie movie=new Movie();
		movie.setName(answer);
		return movie;
	}

	@Override
	public Rental getRental(String id) {
		//Fix this later.
		String sql="SELECT * FROM rentals WHERE id='"+id+"'";
		String answer=readOne(sql);
		if (answer==null)
			return null;
		Movie mov=new Movie();
		mov.setName("Hobbit");
		User user=new User();
		user.setName("Harry");
		Rental rental=new Rental(mov,user,new Date(),new Date(),10);		
		return rental;
		
	}

	@Override
	public boolean haveMovie() {
		String sql="SELECT * FROM movies";
		ResultSet set=readALL(sql);		
		try {
			return set.isBeforeFirst();
		} catch (SQLException e) {
			return false;			
		}
	}

	@Override
	public void removeMovie(String id) {
		String sql="Delete FROM movies WHERE movie='"+id+"'";	
		updateCommit(sql);
	}

	@Override
	public boolean hasUser() {
		String sql="Select * From users";
		ResultSet set=readALL(sql);
		try {
			return set.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void removeUser(String name) {
		try {
			String sql="Delete From users";
			 Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void returnRental(String id) {
		try{
		String sql="Delete From rentals";
		 Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean isMovieRented(String id) {
		String sql="Select * From rentals where id='"+id+"'";
		ResultSet set=readALL(sql);
		try {
			return set.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	private void updateCommit(String sql) {
		try {
			PreparedStatement sta=con.prepareStatement(sql);
			sta.executeUpdate();			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}
	
	private ResultSet readALL(String sql){
		try {
			PreparedStatement sta=con.prepareStatement(sql);
			ResultSet set=sta.executeQuery();			
			return set;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String readOne(String sql){
		try {
			PreparedStatement sta=con.prepareStatement(sql);
			ResultSet set=sta.executeQuery();			
			if (set.next()){
				return set.getString(1);
			}else{
				return null;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
		return null;
	}
}
