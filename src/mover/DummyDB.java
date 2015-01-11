package mover;

import java.util.HashMap;
import java.util.UUID;

public class DummyDB implements DatabaseConnectorInterface {
	
	private HashMap<String,Movie> movieList=new HashMap<>();
	private HashMap<String,User> userList=new HashMap<>();
	private HashMap<String,Rental> rentList=new HashMap<>();

	@Override
	public boolean connect() {	
		return true;
	}

	@Override
	public void writeUser(User user) {
		userList.put(user.getName(), user);
	}

	@Override
	public void writeMovie(Movie movie) {
		movieList.put(movie.getName(), movie);
	}

	@Override
	public String writeRental(Rental rental)  {
		User user=rental.getUser();
		Movie movie=rental.getMovie();
		System.out.println(movie.getName());
		if (userList.containsKey(user.getName()) && movieList.containsKey(movie.getName())){
			rental.setID(getNewId());//Gets a random new id.
			rentList.put(rental.getID(), rental);
			return rental.getID();
		}else{
			return "";
		}
	}

	@Override
	public Movie getMovie(String name) {
		return movieList.get(name);
		
	}

	@Override
	public boolean haveMovie() {
		return !movieList.isEmpty();		
	}

	@Override
	public User getUser(String name) {
		return userList.get(name);
	}

	@Override
	public Rental getRental(String id) {		
		return rentList.get(id);
	}

	@Override
	public void removeMovie(String name) {
		movieList.remove(name);		
	}

	@Override
	public boolean hasUser() {
		return !userList.isEmpty();
	}

	@Override
	public void removeUser(String name) {
		userList.remove(name);		
	}

	public String getNewId(){
		//Creates random string, secure enough for a test run or even a samll implementation 
		return UUID.randomUUID().toString();
	}

	@Override
	public void returnRental(String id) {
		rentList.remove(id);
	}

	@Override
	public boolean isMovieRented(String movie) {
		return rentList.containsKey(movie);
	}
	
	
}
