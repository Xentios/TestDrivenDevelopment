package mover;

public interface DatabaseConnectorInterface {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	public String user="root";
	public String password="";
	public String db="mover";
	public String url="jdbc:mysql://localhost/"+db;
	
	
	public boolean connect();
	
	public void writeUser(User user);
	public void writeMovie(Movie movie);
	public String writeRental(Rental rental);
	
	public User getUser(String id);
	public Movie getMovie(String id);
	public Rental getRental(String id);
	
	public boolean haveMovie();
	public boolean hasUser();
	
	public void removeMovie(String id);
	public void removeUser(String name);

	public void returnRental(String id);

	public boolean isMovieRented(String movie);
}
