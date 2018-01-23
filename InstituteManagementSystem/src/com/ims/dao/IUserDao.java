package com.ims.dao;

import java.util.List;

import com.ims.actions.UserDetails;
import com.ims.actions.Users;

public interface IUserDao {


	List<Users> readUsersFromDb();
	boolean validateUser(String u, String p);
	List<Users> getAllUsers();
	//Users addUser(Users user);
	UserDetails addUser(UserDetails user);
} 
