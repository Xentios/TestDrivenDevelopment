package mover;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDB {
	@Test
	public void testConnection(){
		DB db=new DB();
		
		assertTrue(db.connect());
	}
	
	
}
