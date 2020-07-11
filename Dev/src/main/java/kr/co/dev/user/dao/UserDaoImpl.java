package kr.co.dev.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import kr.co.dev.user.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public int regUser(String id, String password, String name, int age, String email, String address,
			String phone, String country) throws SQLException, ClassNotFoundException {
		
		   String dbId = "root";
		   String dbPassword = "";//localhost:3306/test?
		   String url = "jdbc:mysql://localhost:3306/dev?serverTimezone=UTC&useUnicode=true& useUnicode=true&characterEncoding=utf-8";
		   
		   Class.forName("com.mysql.jdbc.Driver");
		   
		   Connection conn = DriverManager.getConnection(url, dbId, dbPassword);
		   
		   String sql = "INSERT INTO userInfo(id, password, name, age, email, address, phone, country) values (?, ?, ?, ?, ?, ?, ?, ?)";
		   
		   PreparedStatement pst = conn.prepareStatement(sql);
		   
		   pst.setString(1, id);
		   pst.setString(2, password);
		   pst.setString(3, name);
		   pst.setInt(4, age);
		   pst.setString(5, email);
		   pst.setString(6, address);
		   pst.setString(7, phone);
		   pst.setString(8, country);
		   
		   int result = pst.executeUpdate();
		   
		   return result;
	}

	@Override
	public User login(String id, String password) throws ClassNotFoundException, SQLException {
		
		String dbId = "root";
		String dbPassword = "";//localhost:3306/test?
		String url = "jdbc:mysql://localhost:3306/dev?serverTimezone=UTC&useUnicode=true& useUnicode=true&characterEncoding=utf-8";
		   
		Class.forName("com.mysql.jdbc.Driver");
		   
		Connection conn = DriverManager.getConnection(url, dbId, dbPassword);
		
		String sql = "Select * from userinfo where id = ? and password = ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setString(1, id);
		pst.setString(2, password);
		
		ResultSet rs = pst.executeQuery();
		
		User user = null;

		if(rs.next()) {
			user = new User();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setPhone(rs.getString("phone"));
			user.setCountry(rs.getString("country"));
			user.setAuth(rs.getInt("auth"));
			user.setReg_date(rs.getString("reg_date"));
		}
		
		return user;
		
	}

}
