package com.classcoordinator.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.coordinator.User;

/**
 * Servlet implementation class CreateProjectServlet
 */
public class CreateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/JavaTunesDataSource")
	DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String projName = request.getParameter("ProjectName");
		String pass= request.getParameter("ProjPassword");
		String userCreate = request.getParameter("userCreate");
		String userID = request.getParameter("userID");
		int projID;
		int ID = Integer.parseInt(userID);
		boolean logIn = true;
		
		User newUser = new User();
		projID = newUser.createProject(projName, pass, userCreate, ID ,ds);
		System.out.println(userCreate);
		System.out.println(userID);
		
		/////////////////
		/////////////////
		
		request.setAttribute("loginResult", logIn);
		request.setAttribute("ProjectName", projName);
		request.setAttribute("ProjectID", projID);
		request.setAttribute("UserID", userID);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/projectResults.jsp");
		rd.forward(request, response);
		
		
		
		
		
	}

}
