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
 * Servlet implementation class MakeAssignmentServlet
 */
public class MakeAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/JavaTunesDataSource")
	DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stringID = request.getParameter("ProjID");
		String title= request.getParameter("Title");
		String task= request.getParameter("Task");
		String UserID= request.getParameter("UserID");
		int userID = Integer.parseInt(UserID);
		int projectID = Integer.parseInt(stringID);
		Connection conn = null;
		
		String type = "Make";
		
		try {
			conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("Select Aid FROM Assignments");
			//To increase the id by one
			int id = 0;
			//print the info from the result set		
			while (resultSet.next()){
				
				id = resultSet.getInt("Aid");
			}
			int newID = id+1;
			
			String sql = "";
			//Order is Aid, Pid, Title, Task, UserID
			sql = "INSERT INTO Assignments VALUES (" + newID + ", " + projectID + ", '" + title 
					+ "', '" + task + "', " + userID  +")"; 
			stmt.executeUpdate(sql);
			
			
			request.setAttribute("Type", type);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/AssignmentResult.jsp");
			rd.forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {conn.close();}
			catch (SQLException sqle) {}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
