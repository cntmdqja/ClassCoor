package com.coordinator;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;
import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import com.classcoordinator.web.resources.ProjectList;
import com.classcoordinator.web.resources.projRef;




public class User {

	private String userName;
	private String password;
	private int userID;
	//protected Map<String, String> userData = new HashMap<String, String>();
	//public boolean isInData = true;
	public boolean loginWorked = false;
	private boolean userExist = false; 
	private boolean isAdmin = false;

	
	public User()
	{
		
	}
	
	public User(String inputUserName, String inputPassword)
	{
		
		//CheckUser (inputUserName, inputPassword);	
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName; 
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserID ()
	{
		return userID;
	}
	
	
	/*
	 * checks to see if the username already exist in our "database"
	 * if they do not exist, then the function invokes the newUser function to add them
	 */
	public void CheckUser (String UserName, String Password, DataSource ds)
	{
		//reset flag for next user
		userExist = false;
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			
			System.out.println("You have succesfully connected");
			
			
			
			//create the result set for the date you want to extract
			ResultSet resultSet = stmt.executeQuery("Select ID, Name, Password FROM Employee");
			int id = 0;
			//print the info from the result set		
			while (resultSet.next()){
				
				id = resultSet.getInt("ID");
				String name = resultSet.getString("Name");
				String password = resultSet.getString("Password");
				
				if (name.equalsIgnoreCase(UserName))
				{
					System.out.println("Username " + UserName + " already exist. Please enter a new username");
					userExist = true;
					break;
				}
				
				//System.out.println(id);
				//System.out.println(name);
				//System.out.println(password);
				
				
			}
			
			//if user doesnt exist, add him
			if (!userExist)
			{
				int newID = id+1;
				String sql = "";
				sql = "INSERT INTO Employee VALUES (" + newID + ", '" + UserName + "', '" + Password + "')"; 
				stmt.executeUpdate(sql);
				userID = newID;
				System.out.println("Welcome " + UserName + "!");
				
				if(UserName.equalsIgnoreCase("Anthony Laurain"))
				{
					isAdmin = true;
				}
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();}
			catch (SQLException sqle) {}}
			
		}
		
	
	/*
	 * adds the specified username to our "database"
	 */
	public void newUser(String UserName, String Password)
	{
		//userData.put(UserName, Password);	
		
	}
	
	public boolean logIn(String UserName, String Password, DataSource ds)
	{	
		//we have this to return if the logged in was successful or not
		boolean Logged = false;
		
		userExist = false;
		Connection conn = null;
		try {

			conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			
			
			//create the result set for the date you want to extract
			ResultSet resultSet = stmt.executeQuery("SELECT ID, Name, Password FROM Employee");
			//print the info from the result set
			while (resultSet.next()){
				
				String name = resultSet.getString("Name");
				String password = resultSet.getString("Password");
				int newid = resultSet.getInt("ID");
				
				if (name.equalsIgnoreCase(UserName))
				{
					userExist = true;
					
					if (password.equals(Password))
					{
						System.out.println("Welcome " + UserName);
						userName = UserName;
						this.password = Password;
						userID = newid;
						Logged = true;
						if(UserName.equalsIgnoreCase("Anthony Laurain"))
						{
							isAdmin = true;
						}
					}
					else
					{
						System.out.println("Incorrect Password");
					}
				}
			}
			if (!userExist)
			{
				System.out.println("Username does not exist");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();}
			catch (SQLException sqle) {} 
		}
		return Logged;
		
	}
	
	public int createProject(String title, String projPass, String username, int userid, DataSource ds)
	{
		
		int projectID=0;
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("Select ID, Name, Password FROM Project");
			int id = 0;
			//print the info from the result set		
			while (resultSet.next()){
				
				id = resultSet.getInt("ID");
			}
			

				int newID = id+1;
				//Project newProject = new Project(title, projPass, username, userid);
				//ProjectList.projList.add(newProject);
				
				String sql = "";
				sql = "INSERT INTO Project VALUES (" + newID + ", '" + title + "', '" + projPass + "')"; 
				stmt.executeUpdate(sql);
				projectID = newID;
				System.out.println("New Project " + title + " was created!");
		
				
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();}
			catch (SQLException sqle) {}}
	
		return projectID;
	}
	
	public static boolean comparePasswords(String pass1, String pass2)
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
	
	
	/////////////////////////////////////////////////////
	//	These functions are to edit the assignment within the 
	//	projects. User can edit the description and title of the
	//	assignment he's assigned to. User can only edit assignments
	//	that he has privilage to.
	//////////////////////////////////////////////////////
	public void editDescription()
	{
		
	}
	
	
}
