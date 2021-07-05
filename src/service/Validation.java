package service;

public class Validation {
	
	public static boolean validateName(String name) {
		name = name.toLowerCase();
		for(int i=0; i<name.length(); i++) {
			if( !(name.charAt(i) >= 'a' && name.charAt(i) <= 'z') ) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validatePersonDetails(String firstName, String lastName, int age, String location, String phno) {
		
		boolean valid = true;
		
		// Validating First Name includes only Characters or Not
		if(!(validateName(firstName))) {
			System.out.println("In-Valid First Name !");
			valid = false;
		}
		
		// Validating Last Name includes only Characters or Not
		if(!validateName(lastName)) {
			System.out.println("In-Valid Last Name !");
			valid = false;
		}
		
		// Validating Age	i.e.,	Age must be greater than 18
		if(age < 18) {
			System.out.println("You're In-Eligible to have Account !");
			valid = false;
		}
		
		// Validating Location includes only Characters or Not
		if(!validateName(location)) {
			System.out.println("In-Valid Location !");
			valid = false;
		}
		
		// Validating Phone Number
		int i;
		for(i=0; i<phno.length(); i++)
			if(!(phno.charAt(i) >= '0' && phno.charAt(i) <= '9'))
				break;
		if( i < phno.length() || phno.length() != 10 ) {
			System.out.println("In-Valid Phone Number !");
			valid = false;
		}
		
		return valid;
	}
	public boolean validateUserDetails(String username, String password) {
		
		boolean valid = true; 
		// validating User Name
		if( !(validateName(username)) ) {
			System.out.println("In-Valid Username !");
			valid = false;
		}
		boolean lower = false, upper = false, digit = false, len = false, special = false;
		len = (password.length() >= 8 && password.length() <= 20) ? true : false;
		for(int i=0; i<password.length(); i++) {
			char ch = password.charAt(i);
			if(ch >= 'a' && ch <= 'z')
				lower = true;
			else if(ch >= 'A' && ch <= 'Z')
				upper = true;
			else if(ch >='0' && ch <='9')
				digit = true;
			else if(ch == ' ') {
				special = false;
				break;
			}
			else
				special = true;
		}
		if( !(upper && lower && digit && len && special) ) {
			System.out.println("In-Valid Password !");
			valid = false;
		}
		return valid;
	}
}
