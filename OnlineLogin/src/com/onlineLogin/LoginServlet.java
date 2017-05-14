package com.onlineLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineLogin.dao.UserDao;
import com.onlineLogin.daoImpl.UserDaoImpl;
import com.onlineLogin.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		response.setContentType("text/html");
		User user =new User();
		PrintWriter pw= response.getWriter();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("password"));
		user.setPassword(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		
		UserDao userDao =new UserDaoImpl();
		int status =userDao.saveUser(user); 
		if(status>0){  
            pw.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("LoginForm.html").include(request, response);  
        }else{  
            pw.println("Sorry! unable to save record");  
        }  
	}

}
