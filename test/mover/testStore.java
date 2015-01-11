package mover;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testStore {
	Store store;
	@Before
	public void setUp(){
		store=new Store();
	}
	
	//Start of Movie Tests//////////////////////////////////////////////////////
	@Test
	public void testhaveMovie(){
		assertFalse(store.haveMovie());
	}
	
	@Test
	public void testRegisterMovie(){
		Movie movie=new Movie();
		
		store.registerMovie(movie);
		
		assertTrue(store.haveMovie());
	}
	
	@Test
	public void testGetMovie(){
		Movie movie=testHelpers.createMovie("Hobbit");
		
		store.registerMovie(movie);
		
		assertEquals(movie,store.getMovie("Hobbit"));
	}
	
	@Test
	public void testGetTwoMovie(){
		Movie movieHoobit=testHelpers.createMovie("Hobbit");		
		Movie movieHarry=testHelpers.createMovie("Harry");
		
		store.registerMovie(movieHarry);
		store.registerMovie(movieHoobit);
		
		assertEquals(movieHoobit, store.getMovie("Hobbit"));
		assertEquals(movieHarry, store.getMovie("Harry"));		
	}
	
	@Test
	public void testDeleteMovie(){
		store.registerMovie(testHelpers.createMovie("Hobbit"));
		
		store.removeMovie("Hobbit");
		
		assertEquals(null,store.getMovie("Hobbit"));				
	}
	//End of Movie Tests///////////////////////////////////////////////////////	
	//Start of User Tests//////////////////////////////////////////////////////
	 @Test
	 public void testhaveUser(){		 
		assertFalse(store.haveUser());
	 }
	
	 @Test 
	 public void testregisterUser(){
		 User user=testHelpers.createUser("Harry");	
		 
		 store.registerUser(user);
		 
		 assertTrue(store.haveUser());		 
	 }
	 
	 @Test
	 public void testgetUser(){
		 User user=testHelpers.createUser("Harry");
		 
		 store.registerUser(user);
		 
		 assertEquals(user,store.getUser("Harry"));
	 }
	 @Test
	 public void testgetTwoUsers(){
		 User harry=testHelpers.createUser("Harry");
		 User potter=testHelpers.createUser("Potter");
		 
		 store.registerUser(potter);
		 store.registerUser(harry);
		 
		 assertEquals(harry,store.getUser("Harry"));
		 assertEquals(potter,store.getUser("Potter"));
	 }
	 @Test
	 public void testRemoveUser(){
		 User user=testHelpers.createUser("Harry");
		  
		 store.registerUser(user);
		 store.removeUser("Harry");
		 
		 assertEquals(null,store.getUser("Harry"));
	 }
	//End of User Tests////////////////////////////////////////////////////////
	//Start of Rent Tests//////////////////////////////////////////////////////
	 //Renting Logic is incomplete and may fail to advanced rent logics such of same user same movie
	 @Test
	 public void testRentMovieFail(){		 		 
		 try {
			store.rent("Movie","User");
			fail("Renting should throw exception but it passed");
		} catch (Exception e) {			
		}
	 }
	 
	 @Test
	 public void testRentMovieSuccess(){
		 User user=testHelpers.createUser("Harry");
		 Movie movie=testHelpers.createMovie("Hobbit");		 
		 store.registerMovie(movie);
		 store.registerUser(user);
		 
		 try {
			store.rent("Hobbit","Harry");
		} catch (Exception e) {
			fail("Renting operation should go smooth but it did not");
		}		 
	 }
	 
	 @Test
	 public void testIsMovieRented() throws Exception{
		 User user=testHelpers.createUser("Harry");
		 Movie movie=testHelpers.createMovie("Hobbit");		 
		 store.registerMovie(movie);
		 store.registerUser(user);
		 
		 store.rent("Hobbit","Harry");
		 
		 assertTrue(store.isMovieRented("Hobbit"));
	 }	 
	 @Test
	 public void testReturnNotRentedMovie(){
		 boolean result=store.returnMovie("Not rented movie", "by random user");
		 
		 assertFalse(result);
	 }
	 
	 @Test
	 public void testReturnMovie(){
		 User user=testHelpers.createUser("Harry");
		 Movie movie=testHelpers.createMovie("Hobbit");		 
		 store.registerMovie(movie);
		 store.registerUser(user);
		 try {
			store.rent("Hobbit","Harry");
		} catch (Exception e) {	
		}
		
		boolean result=store.returnMovie(movie.getName(),user.getName());
		 
		assertTrue(result); 		
	 }

	//End of Rent Tests//////////////////////////////////////////////////////
	 		 

		
	
}
