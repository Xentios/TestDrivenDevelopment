package mover;

import java.util.Date;

public class Rental {
	private String id;
	private Movie movie;
	private User user;
	private Date rentdate;
	private Date returndate;
	private int price;

	public Rental(Movie movie, User user, Date rentdate,Date returndate,int price) {
		this.movie=movie;
		this.user=user;
		this.rentdate=rentdate;
		this.returndate=returndate;
		this.price=price;
	}

	public Movie getMovie() {		
		return this.movie;
	}
	
	public User getUser(){
		return this.user;
	}
	
	public Date getRentDate(){
		return this.rentdate;
	}
	
	public Date getReturnDate(){
		return this.returndate;
	}
	public int getPrice(){
		return this.price;
	}

	public String getID() {
		return this.id;
	}
	public void setID(String id){
		this.id=id;
	}
}

