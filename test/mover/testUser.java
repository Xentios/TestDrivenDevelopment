package mover;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testUser {
	User user;
	@Before
	public void setUp(){
		user=new User();
	}
	
	@Test
	public void test_set_getName(){
		String name="Customer";
		
		user.setName(name);
		
		assertEquals("Customer",user.getName());		
	}
	
	@Test
	public void testEquals(){
		User x=new User();
		User y=new User();
		x.setName("Harry");
		y.setName("Harry");
		
		assertEquals(x,y);		
	}

}
