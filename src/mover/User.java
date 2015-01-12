package mover;

public class User {
	private String name;

	public void setName(String name) {		
		this.name=name;
	}

	public String getName() {		
		return this.name;
	}

	@Override
	public boolean equals(Object obj){
		 if (!(obj instanceof User))
	            return false;
	        if (obj == this)
	            return true;

	        User rhs = (User) obj;
	        if (rhs.getName().equals(this.getName()))
	        	return true;
	        			
		 return false;
	}
}
