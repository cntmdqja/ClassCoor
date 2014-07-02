package com.classcoordinator.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.coordinator.User;

/**
 * Servlet implementation class NewUserServlet
 */
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/JavaTunesDataSource")
	DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName = request.getParameter("UserName");
		String pass= request.getParameter("Password");
		String pass2 = request.getParameter("Password2");
		
		User user = new User();
		if ( User.comparePasswords(pass, pass2))
		{
			user.CheckUser(userName, pass, ds);
			
			request.setAttribute("UserName", userName);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/SignUpResult.jsp");
			rd.forward(request, response);

		}
		else
		{
			//print that the passwords did not match
			
			
			System.out.println("passwords did not match");
		}
		
	}


	

}
