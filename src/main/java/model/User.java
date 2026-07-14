package model;

public class User {
  
	private int id;
	private String username;
	private String password;
	private String role;
	private String email;
	
	public User() {
		
	}
	
	public User(String username,String password) {
		this.username = username;
		this.password = password;
	
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwrod) {
		this.password = passwrod;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
