package connection;

import java.sql.*;
import model.User;

public class UserData {
	
	final static String url = "jdbc:mysql://localhost:3306/SignupLogin";
	final static String username = "root";
	final static String password = "ganesh00";
	static Connection con;
	static Statement stmt;
	public static boolean getConnection() {
		try{
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			return true;
		}
		catch(Exception e) {
			System.out.print("\nConnection Problem !");
			return false;
		}
	}
	
	public boolean loadUserData(User user) {
		if(getConnection()) {
			try{
				String query = "SELECT * FROM USER WHERE USERNAME = '"+user.getUsername()+"'";
				if( stmt.executeQuery(query).next() ) {
					System.out.println("\nUsername already Exists !");
					return false;
				}
				else {
					query = "INSERT INTO USER VALUES('"+user.getUsername()+"','"+user.getPassword()+"','"
							+user.getFirstName()+"','"+user.getLastName()+"','"+(user.isGender()?'F':'M')+"',"+user.getAge()+",'"
							+user.getLocation()+"','"+user.getPhno()+"')";
					if( stmt.execute(query) )	
						throw new SQLException();
				}
			}
			catch(Exception e) {
				System.out.println("\nCan't Insert Data !");
				return false;
			}
		}
		return true;
	}
	public User getUserData(String username, String password) {
		if(getConnection()) {
			try {
				String query = "SELECT * FROM USER WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'";
				ResultSet rs = stmt.executeQuery(query);
				if( rs.next() ) {
					
					String firstName = rs.getString("firstname");
					String lastName  = rs.getString("lastname");
					boolean gender  = rs.getString("gender")=="M" ? false : true;
					int age = rs.getInt("age");
					String location = rs.getString("location");
					String phno = rs.getString("phno");
					return new User(firstName, lastName, gender, age, location, phno, username, password);
				}
				else
					System.out.println("No User exists with "+username +" !");
			}
			catch(Exception e) {
				System.out.println("Can't retrieve Data !"+e);
			}
		}
		
		return null;
	}
	
}
