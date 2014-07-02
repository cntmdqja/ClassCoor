package com.coordinator;
import java.util.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Project implements Serializable{
	
	private String title;
	private Date dateCreated;
	private int leaderID;
	private String leaderName;
	List<Integer> userIDList = new ArrayList<Integer>();
	//public ArrayList<String> projectAcessList = new ArrayList<String>();
	List<Assignment> assignmentList = new ArrayList<Assignment>();
	private int projectID;
	private String projPassword;
	
	
	public Project (String name, String projPass, String username, int userid)
	{
		title = name;
		projPassword = projPass;
		leaderName = username;
		leaderID = userid;
		//we're adding id of users to later confirm if the user has access to this project or not
		userIDList.add(userid);
	}

	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String Title)
	{
		this.title = Title;
	}

	public int getLeaderID()
	{
		return leaderID;
	}
	
	public void setLeaderID(int LeadID)
	{
		this.leaderID = LeadID;
	}
	
	public void setLeaderName( String name)
	{
		this.leaderName = name;
	}
	
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public void setDateCreated(Date StartDate)
	{
		this.dateCreated = StartDate;
	}
	
	

	
	public void addUser(int userID)
	{
		userIDList.add(userID);
	}
}
