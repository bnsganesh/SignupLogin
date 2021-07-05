package control;

import java.util.Scanner;
import java.util.Vector;

import model.User;
import service.Validation;

public class UserChoice {
	
	static Scanner scan = new Scanner(System.in);	// scan to read input from the user
	static Validation validation = new Validation();
	
	// Code Related to User Choice-1	i.e., SignUp
	public static User signUp() {
		try{
			System.out.print("\nEnter your First Name : ");
			String firstName = scan.nextLine();
			System.out.print("Enter your Last Name : ");
			String lastName = scan.nextLine();
			System.out.print("Enter your Gender (0->Male 1->Female) : ");
			boolean gender= (scan.nextInt() == 1) ? false : true;
			System.out.print("Enter your Age : ");
			int age = scan.nextInt();
			scan.nextLine(); // To read unwanted \n
			System.out.print("Enter your Location : ");
			String location = scan.nextLine();
			System.out.print("Enter your Phone Number : ");
			String phno = scan.nextLine();
			
			System.out.println();
			if( validation.validatePersonDetails(firstName, lastName, age, location, phno) ) {
				System.out.print("Enter Username : ");
				String username = scan.nextLine();
				System.out.print("Enter Password : ");
				String password = scan.nextLine();
				if( validation.validateUserDetails(username, password)) {
					System.out.println("You've Sucessfully Created an Account !");
					return new User(firstName, lastName, gender, age, location, phno, username, password);
				}
			}
		}
		catch(Exception e) {
			System.out.println("\nAlert !!!\nYou've Entered mis-match Input.");	// Error-Display for Non-Numeric Input
			scan.nextLine(); // To read unwanted \n
			signUp();
		}
		return null;
	}
	
	// Code Related to User Choice-2	i.e., LogIn
	public static void logIn(Vector<User> userList) {
		try {
			System.out.print("Enter Username : ");
			String username = scan.nextLine();
			System.out.print("Enter Password : ");
			String password = scan.nextLine();
			int i;
			for(i=0; i<userList.size(); i++) {
				if( userList.get(i).getUsername().equals(username)
						&& userList.get(i).getPassword().equals(password)) {
					System.out.println("Hello, "+userList.get(i).getFirstName()+" !");
					System.out.println("\nYou've Sucessfully logged-In." );
					break;
				}
			}
			if(i == userList.size()) {
				System.out.println("\nIn-Valid Username or Password !");
			}
			
		}
		catch(Exception e) {
			System.out.println("\nAlert !!!\nYou've Entered mis-match Input.");	// Error-Display for Non-Numeric Input
		}
	}

}
