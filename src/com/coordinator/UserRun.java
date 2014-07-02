package com.coordinator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class UserRun {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String userFirstInput;
		String userName;
		String password;
		String password2;
		User newUser = new User();
		
		//opens the input stream
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome. Type 'Login' if you already have an account or type 'new' if you want to create an account");
		userFirstInput = in.nextLine();
		
		
		if (userFirstInput.equalsIgnoreCase("Login"))
		{
			System.out.println("Enter Your User Name");
		      userName = in.nextLine();
		      
		    System.out.println("Enter Your Password");
		      password = in.nextLine();
		      
		      //newUser.logIn(userName, password);
			
		}
		else if (userFirstInput.equalsIgnoreCase("New"))
		{
			System.out.println("Enter Your User Name");
		      userName = in.nextLine();
		      
		    System.out.println("Enter Your Password");
		      password = in.nextLine();
		      
		    System.out.println("Enter Your Password Again");
		    password2 = in.nextLine();
		    

		    while(!comparePasswords(password, password2))
		    {
		    	System.out.println("Password does not match. Please re-enter your passwords");
		    	
		    	System.out.println("Enter Your Password");
			      password = in.nextLine();
			      
			    System.out.println("Enter Your Password Again");
			    password2 = in.nextLine();
			    
			    comparePasswords(password, password2);
		    }
		    
		    //newUser.CheckUser(userName, password);
		    
			
		}
		
	      
		
		//User newUser = new User("John", "Password");
		//newUser.CheckUser("Anthony", "Password");
		//newUser.CheckUser("Bill", "Password");
		//newUser.logIn("Anthony", "Password");
	}
	
	
	private static boolean comparePasswords(String pass1, String pass2)
	{
		if (!pass1.equals(pass2))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
