package control;

import java.util.Scanner;
import java.util.Vector;

import model.User;

public class Main {
	public static void main(String[] args) {
		Vector<User> userList = new Vector<User>();
		
		Scanner scan = new Scanner(System.in);	// scan to read input from the user
		System.out.println("-------->>>>>----------  Welcome  ----------<<<<<--------");	// Displaying the Welcome Text
		
		
		int choice;
		do {
			System.out.println("\n---------------------------------------------------------");
			System.out.println("1 - Sign Up\t2 - Login\t0 - Close");	// Displaying the User Options
			System.out.println("---------------------------------------------------------");
			System.out.print("Your Choice : ");	// Asking the User option
			try {
				choice = scan.nextInt();	// Reading User Choice
				switch(choice) {	// Checking Choice
					case 1:
						User user = UserChoice.signUp();	// SignUp Choice
						if(user != null)
							userList.add(user);
						break;
					case 2:
						UserChoice.logIn(userList);		// LogIn Choice
						break;
					case 0:
						System.out.println("\nYou're about to Close !");	// Displaying Exiting Message
						break;
					default:
						System.out.println("\nIn-valid Option, Retry Again !");	// Displaying Invalid Option entry Message
				}
				
			}
			catch(Exception e) {
				System.out.println("\nAlert !!!\nSomething went Wrong.");	// Error-Display for Non-Numeric Input
				choice = -1;	// Continue for next Iteration	i.e.,	-1 != 0
			}
		}while(choice != 0);
		scan.close();// Closed Taking Input from the User
		System.out.println("\n--------<<<<<-------   Thank You !   ------->>>>>--------");	// Displaying the Closing Text
		
	}
}
