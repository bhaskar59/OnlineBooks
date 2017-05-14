package com.onlineLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineLogin.dao.UserDao;
import com.onlineLogin.daoImpl.UserDaoImpl;
import com.onlineLogin.entity.User;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='LoginForm.html'>Add New User</a>");  
        out.println("<h1>Users List</h1>");  
        UserDao userDao= new UserDaoImpl();
        List<User> list=userDao.getAllUsers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th>  <th>Edit</th><th>Delete</th></tr>");  
        for(User user:list){  
         out.print("<tr><td>"+user.getId()+"</td><td>"+user.getName()+"</td><td>"+user.getPassword()+"</td> <td>"+user.getEmail()+"</td><td>"+user.getCountry()+"</td><td><a href='EditServlet?id="+user.getId()+"'>edit</a></td>   <td><a href='DeleteServlet?id="+user.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }}