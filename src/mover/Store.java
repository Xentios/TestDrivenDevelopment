package mover;

public class Store {	
	
	private DatabaseConnectorInterface dcon;

	public Store(DatabaseConnectorInterface dcon) {
		this.dcon=dcon;
		dcon.connect();
	}

	public void registerMovie(Movie movie) {		
		dcon.writeMovie(movie);		
	}

	public boolean haveMovie() {		
		return dcon.haveMovie();
	}

	public Movie getMovie(String name) {		
		return dcon.getMovie(name);
	}

	public void removeMovie(String name) {
		dcon.removeMovie(name);		
	}

	public boolean haveUser() {	
		return dcon.hasUser();		
	}

	public void registerUser(User user) {
		dcon.writeUser(user);
	}

	public User getUser(String name) {
		return dcon.getUser(name);
	}

	public void removeUser(String name) {
		dcon.removeUser(name);
	}

	public String rent(Rental rental) {
		return dcon.writeRental(rental);		
	}
	
	public boolean isMovieRented(String movie) {		
		return dcon.isMovieRented(movie);
	}

	
	public void returnMovie(String id) {		
		dcon.returnRental(id);
	}

	public Rental getRental(String id) {		 
		return dcon.getRental(id);
	}

	
		
}
