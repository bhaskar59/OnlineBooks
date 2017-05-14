package com.onlineLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineLogin.dao.UserDao;
import com.onlineLogin.daoImpl.UserDaoImpl;
import com.onlineLogin.entity.User;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setCountry(country);
		
		
		UserDao userDao =new UserDaoImpl();

		int status = userDao.updateUser(user);
		if (status > 0) {
			response.sendRedirect("ViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}