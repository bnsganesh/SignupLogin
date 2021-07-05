package model;

public class Person {	// Details of a Person
	
	String firstName;	// First Name
	String lastName;	// Last Name	i.e., Surname
	boolean gender;		// Gender	true -> Male	false -> Female
	int age;			// Person Age	i.e., Age>18
	String location;	// Location
	String phno;		// Phone Number
	
	public Person(String firstName, String lastName, boolean gender, int age, String location, String phno) {
	
		// Get and Assign Values to the Fields while Initializing an Object
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.phno = phno;
	}
	
	// Getters and Setters of Every Individual Field
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}
}
