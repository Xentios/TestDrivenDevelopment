package mover;

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


}
