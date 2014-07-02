package com.coordinator;

public class Assignment {
	private String title;
	private int userID;
	private String task;
	private int projID;
	private int assignmentID; 
	
	//constructor
	public Assignment (int newAssignmentID, int newProjID, String newTitle, String newTask, int newUserID )
	{
		this.assignmentID = newAssignmentID;
		this.projID = newProjID;
		this.title = newTitle;
		this.task = newTask;
		this.userID = newUserID;
	}

	//set and get title
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	//set and get task
	public void setTask(String newDescription)
	{
		this.task = newDescription;
	}
	
	public String getTask()
	{
		return this.task;
	}
	
	//set and get userID
	public void setUserID(int newUserID)
	{
		this.userID = newUserID;
	}
	
	public int getUserID()
	{
		return this.userID;
	}
	
	//set projID
	public void setProjID(int newProjID)
	{
		this.projID = newProjID;
	}
	
	public int getProjID()
	{
		return this.projID;
	}
	
	//set projID
	public void setAssignmentID(int newAssignmentID)
	{
		this.assignmentID = newAssignmentID;
	}
		
	public int getAssignmentID()
	{
		return this.assignmentID;
	}
}
