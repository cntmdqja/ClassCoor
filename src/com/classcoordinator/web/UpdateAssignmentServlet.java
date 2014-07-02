package com.classcoordinator.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UpdateAssignmentServlet
 */
public class UpdateAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/JavaTunesDataSource")
	DataSource ds;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean success = false;
		String type = "Update"; 
		String title= request.getParameter("Title");
		String task= request.getParameter("Task");
		String UserID= request.getParameter("UserID");
		String AID= request.getParameter("AssignmentID");
		int userID = Integer.parseInt(UserID);
		int AssignmentID = Integer.parseInt(AID);
		Connection conn = null;
		int LoopAid;
		int LoopUid;
		boolean IDExist=false; //only for the case if success is false
		
		try {
			conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select Aid, UserID FROM Assignments");
			
			while (resultSet.next()){
				
				LoopAid = resultSet.getInt("Aid");
				LoopUid = resultSet.getInt("UserID");
				if(LoopAid == AssignmentID)
				{
					//if the user ID doesn't match you have no authority to edit this
					if(LoopUid == userID){
						//everything matches
						String sql = "";
						//Order is Aid, Pid, Title, Task, UserID
						sql = "UPDATE Assignments ";
						
						if(task != ""){
							String newTask = "SET Task='" + task + "'";
							sql = sql + newTask;
						}
						
						//now finishing up query, we can just do AID since we're grabbing it from user right away. See the top
						sql = sql + " WHERE Aid =" + AID;
						stmt.executeUpdate(sql);
						success = true;
						IDExist = true;
						break;
						
					}
					else
					{
						IDExist = true; //we know it's there, just no authoritay
						request.setAttribute("Message", "You have no authority");
						break;
					}
					
				}
				
			}
			if(!IDExist)
			{
				System.out.println("no assignment");
				request.setAttribute("Message", "Assignment  Doesn't Exist");
			}	
				
			request.setAttribute("Type", type);
			request.setAttribute("success", success);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/AssignmentResult.jsp");
			rd.forward(request, response);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();}
			catch (SQLException sqle) {}}
		request.setAttribute("Type", type);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
