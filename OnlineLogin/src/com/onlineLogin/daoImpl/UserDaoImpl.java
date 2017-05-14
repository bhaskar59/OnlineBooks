package com.onlineLogin.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineLogin.dao.UserDao;
import com.onlineLogin.entity.User;

public class UserDaoImpl implements UserDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:jtds:sqlserver://PRAMOD-LAPTOP;databaseName=TestMart1",
							"sa", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	@Override
	public int saveUser(User user) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into appuser.application_user(name,password,emaiId,country) values (?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getCountry());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	@Override
	public int updateUser(User user) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("update appuser.application_user set name=?,password=?,emaiId=?,country=? where id=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getCountry());
			ps.setInt(5, user.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	@Override
	public int deleteUser(int id) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from appuser.application_user where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	@Override
	public User getUser(int id) {
		User user = new User();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from appuser.application_user where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setCountry(rs.getString(5));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from appuser.application_user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setCountry(rs.getString(5));
				userList.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}
