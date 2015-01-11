package mover;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class testMovie {
	Movie movie;
	
	@Before
	public void setUp(){
		movie=new Movie();
	}
	
	@Test
	public void test_set_getName(){
		String name="Hobbit";
		
		movie.setName(name);		
		
		assertEquals("Hobbit",movie.getName());		
	}
	
	@Test
	public void test_set_getMovieUrl(){
		String url="C:\\Videos\\video.mpg";
		
		movie.setMovieUrl(url);
		
		assertEquals("C:\\Videos\\video.mpg", movie.getMovieUrl());		
	}
	
	@Test
	public void test_set_getDate(){		
		Date date=new Date();
		
		movie.setDate(date);
		
		assertEquals(date, movie.getDate());
	}
	
}
