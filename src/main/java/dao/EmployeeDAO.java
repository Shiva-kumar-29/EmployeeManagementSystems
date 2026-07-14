package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Employee;
import util.DBConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
   
	public boolean insertEmployee(Employee employee) {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO employee (name,email,phone,department,salary,joining_date) VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getDepartment());
			ps.setDouble(5, employee.getSalary());
			ps.setString(6, employee.getJoiningDate());
			
			
			
			
			
			//Execute the Insert Query
			int rows = ps.executeUpdate();
			
			if(rows >0) {
				System.out.println("Employee Inserted Successfully");
			}else {
				System.out.println("Employee Not Inserted!");
			}
			
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM employee";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
		    
		     while(rs.next()) {
		    	 Employee employee = new Employee();
		    	 employee.setId(rs.getInt("id"));
		    	 employee.setName(rs.getString("name"));
		    	 employee.setEmail(rs.getString("email"));
		    	 employee.setPhone(rs.getString("phone"));
		    	 employee.setDepartment(rs.getString("department"));
		    	 employee.setSalary(rs.getDouble("salary"));
		    	 employee.setJoiningDate(rs.getString("joining_date"));
		    	 
		    	 employeeList.add(employee);
		     }
		   rs.close();
		   ps.close();
		   connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
	
	public boolean updateEmployee(Employee employee) {
		Connection connection = DBConnection.getConnection();
		
		String sql = "UPDATE employee SET name=?,email=?,phone=?,department=?,salary=?,joining_date=? WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getDepartment());
			ps.setDouble(5, employee.getSalary());
			ps.setString(6, employee.getJoiningDate());
			
			ps.setInt(7, employee.getId());
			
			int rows = ps.executeUpdate();
			if(rows>0) {
				System.out.println("Employee Updated Successfully");
			}else {
				System.out.println("Employee Not Found!");
			}
			
			ps.close();
			connection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void deleteEmployee(int id) {
		Connection connection = DBConnection.getConnection();
		
		String sql = "DELETE FROM employee WHERE id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Employee Deleted Successfully!");

			}else {
				System.out.println("Employee Not Found!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM employee WHERE id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				employee = new Employee();
				
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("email"));
				employee.setPhone(rs.getString("phone"));
				employee.setDepartment(rs.getString("department"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setJoiningDate(rs.getString("joining_date"));
			}
			rs.close();
			ps.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
}
