package mover;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class testRental {
	Rental rental;
	@Before
	public void setUp(){
		Movie movie= testHelpers.createMovie("Avatar");
		User user=testHelpers.createUser("Ang");
		Date rentdate=new Date();
		Date returndate=new Date(rentdate.getTime() + (1000 * 60 * 60 * 24));//Possible fail at special times	
		int price=10;
		rental=new Rental(movie,user,rentdate,returndate,price);
	}
	
	@Test
	public void testgetMovie(){
		Movie movie=rental.getMovie();
		
		assertEquals("Avatar",movie.getName());
	}
	
	@Test
	public void testgetUser(){
		User user=rental.getUser();
		
		assertEquals("Ang", user.getName());		
	}
	
	@Test
	public void testGetRentDate(){
		Date date=rental.getRentDate();
		
		assertEquals(new Date(), date);
	}
	
	@Test
	public void testGetReturnDate(){
		Date date=rental.getReturnDate();
		
		assertEquals(new Date(new Date().getTime()+1000*60*60*24),date);//Adding 1 day to the current time.Poorly
	}
	

}
