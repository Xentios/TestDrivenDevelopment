package mover;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Store {	
	private HashMap<String,Movie> movieList=new HashMap<>();
	private HashMap<String,User> userList=new HashMap<>();
	private HashMap<String,String> rentList=new HashMap<>();//TODO this will not be sufficient
	
	private long rentLenght=(1000*60*60*24);	
	private Date returndates=new Date(new Date().getTime()+rentLenght);//Rent time make more elegant TODO
	private int price=20;
	
	public void registerMovie(Movie movie) {		
		movieList.put(movie.getName(), movie);
	}

	public boolean haveMovie() {	
		//Warning using !
		return !movieList.isEmpty();
	}

	public Movie getMovie(String name) {		
		return movieList.get(name);
	}

	public void removeMovie(String name) {
		movieList.remove(name);		
	}

	public boolean haveUser() {	
		//Warning using !
		return !userList.isEmpty();
	}

	public void registerUser(User user) {
		userList.put(user.getName(), user);
	}

	public User getUser(String name) {
		return userList.get(name);
	}

	public void removeUser(String name) {
		userList.remove(name);		
	}

	public void rent(String movie, String user) throws Exception {
		if (userList.containsKey(user) && movieList.containsKey(movie)){
			//Rental rental=new Rental(movieList.get(movie), userList.get(user), new Date(), returndates,price);
			//Convert to this?
			rentList.put(movie,user);
		}else{
			throw new Exception();		
		}
		
	}
	public boolean isMovieRented(String movie) {		
		return rentList.containsKey(movie);
	}

	public long moviesrentedby(String user) {
		return rentList.entrySet().stream().filter(entry->entry.getValue().equals(user)).count();
	}

	public boolean returnMovie(String movie, String user) {		
		return rentList.remove(movie,user);
	}

	
		
}
