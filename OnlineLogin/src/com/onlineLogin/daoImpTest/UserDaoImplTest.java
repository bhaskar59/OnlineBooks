package com.onlineLogin.daoImpTest;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.onlineLogin.dao.UserDao;
import com.onlineLogin.daoImpl.UserDaoImpl;
import com.onlineLogin.entity.User;


public class UserDaoImplTest {

	
	@Test
	public void testSaveUser(){
		User user =new User();
		user.setCountry("India");
		user.setEmail("munibhaskar59@gmail.com");
		user.setId(1);
		user.setName("muni");
		user.setPassword("bhaskar");
		UserDao userDao= new UserDaoImpl();
		int result = userDao.saveUser(user);
		System.out.println(result);
	}
}
