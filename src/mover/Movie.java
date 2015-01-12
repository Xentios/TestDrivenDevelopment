package mover;

import java.util.Date;

public class Movie {
	private String name;
	private String url;
	private Date date;

	public void setName(String name) {		
		this.name=name;
	}

	public String getName() {		
		return this.name;
	}

	public void setMovieUrl(String url) {		
		this.url=url;
	}

	public String getMovieUrl() {
		return this.url;
	}

	public void setDate(Date date) {
		this.date=date;		
	}

	public Date getDate() {		
		return this.date;
	}
	
	@Override
	public boolean equals(Object obj){
		 if (!(obj instanceof Movie))
	            return false;
	        if (obj == this)
	            return true;

	        Movie rhs = (Movie) obj;
	        if (rhs.getName().equals(this.getName()))
	        	return true;
	        			
		 return false;
	}

}
