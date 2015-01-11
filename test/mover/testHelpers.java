package mover;

import java.util.Date;

public class testHelpers {
	static Movie createMovie(String name){
		Movie movie=new Movie();
		movie.setName(name);
		return movie;		
	}
	static User createUser(String name){
		User user=new User();
		user.setName(name);
		return user;
	}
	static Rental createRental(String moviename,String username) {		
		Movie movie=createMovie(moviename);
		User user=createUser(username);
		return new Rental(movie, user, new Date(), new Date(new Date().getTime()+1000*60*60*24), 10);
	}


}
