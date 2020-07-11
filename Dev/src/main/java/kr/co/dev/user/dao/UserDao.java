package kr.co.dev.user.dao;

import java.sql.SQLException;

import kr.co.dev.user.dto.User;

public interface UserDao {

	public int regUser(String id, String password, String name, int age, String email, String address, String phone, String country)throws Exception;

	public User login(String id, String password)throws ClassNotFoundException, SQLException;
	
	
}
