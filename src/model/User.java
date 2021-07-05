package model;

public class User extends Person{	// Every User is a Person

	String username;
	String password;
	public User(String firstName, String lastName, boolean gender, int age, String location, String phno,
			String username, String password) {
		
		// Get and Assign values to the Fields, while Initializing an Object
		super(firstName, lastName, gender, age, location, phno);		// Calling and passing values to the Person Constructor
		this.username = username;
		this.password = password;
	}
	
	// Getter and Setter of Every Individual Field
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
