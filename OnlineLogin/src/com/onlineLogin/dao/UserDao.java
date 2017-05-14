package com.onlineLogin.dao;

import java.util.List;

import com.onlineLogin.entity.User;

public interface UserDao {

	public int saveUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);
	
	public User getUser(int id);
	
	public List<User> getAllUsers();
}
