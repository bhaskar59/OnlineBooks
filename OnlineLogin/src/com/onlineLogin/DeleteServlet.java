package com.onlineLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineLogin.dao.UserDao;
import com.onlineLogin.daoImpl.UserDaoImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		UserDao userDao =new UserDaoImpl();
		userDao.deleteUser(id);
		response.sendRedirect("ViewServlet");
	}
}