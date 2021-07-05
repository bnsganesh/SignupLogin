package control;

import java.util.Scanner;

import connection.UserData;
import model.User;
import service.Validation;

public class UserChoice {
	
	static Scanner scan = new Scanner(System.in);	// scan to read input from the user
	static Validation validation = new Validation();
	static UserData userData = new UserData(); 
	// Code Related to User Choice-1	i.e., SignUp
	public static void signUp() {
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
					if( userData.loadUserData(new User(firstName, lastName, gender, age, location, phno, username, password)) ) {
						System.out.println("\nYou've Sucessfully Created an Account !");
						System.out.print("\nPlease provide your Credentials for Log-In");
						logIn();
					}
					
				}
			}
		}
		catch(Exception e) {
			System.out.println("\nAlert !!!\nYou've Entered mis-match Input.");	// Error-Display for Non-Numeric Input
			scan.nextLine(); // To read unwanted \n
			signUp();
		}
	}
	
	// Code Related to User Choice-2	i.e., LogIn
	public static void logIn() {
		try {
			System.out.print("\nEnter Username : ");
			String username = scan.nextLine();
			System.out.print("Enter Password : ");
			String password = scan.nextLine();
			User user = userData.getUserData(username, password);
			if( user != null)
				System.out.println("\nHello, "+ user.getFirstName()+" :)");
			
		}
		catch(Exception e) {
			System.out.println("\nAlert !!!\nYou've Entered mis-match Input."+e);	// Error-Display for Non-Numeric Input
		}
	}

}
