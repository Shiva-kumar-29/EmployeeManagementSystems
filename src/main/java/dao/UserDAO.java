package dao;

import model.User;
import util.DBConnection;
import util.PasswordUtil;
import java.sql.*;

public class UserDAO {

	public boolean registerUser(User user) {

	    String sql = "INSERT INTO users(username,password,role,email) VALUES (?,?,?,?)";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        System.out.println("Database Connected Successfully");

	        System.out.println("Username : " + user.getUsername());
	        System.out.println("Email : " + user.getEmail());
	        System.out.println("Role : " + user.getRole());

	        ps.setString(1, user.getUsername());
	        ps.setString(2, PasswordUtil.hashPassword(user.getPassword()));
	        ps.setString(3, user.getRole());
	        ps.setString(4, user.getEmail());

	        int rows = ps.executeUpdate();

	        System.out.println("Rows Inserted : " + rows);

	        return rows > 0;

	    } catch (SQLException e) {

	        System.out.println("Registration Failed");

	        e.printStackTrace();

	        return false;
	    }
	}
	public User validateUser(String username, String password) {
		
		String sql = "SELECT * FROM users WHERE username = ?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String storeHash = rs.getString("password");
				if(PasswordUtil.verifyPassword(password, storeHash)) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));
					
					return user;
				}
				
			}
			return null;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	 public boolean isUsernameTaken(String username) {
	        String sql = "SELECT id FROM users WHERE username = ?";
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, username);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 
}
}