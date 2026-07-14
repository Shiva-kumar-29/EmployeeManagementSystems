package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Employee;

/**
 * Servlet implementation class updateEmployeeServlet
 */
@WebServlet("/updateEmployeeServlet")
public class updateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {

	        // Read values from form
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("number");
	        String department = request.getParameter("department");
	        double salary = Double.parseDouble(request.getParameter("salary"));
	        String joiningDate = request.getParameter("joiningdate");

	        // Create Employee object
	        Employee employee = new Employee();

	        employee.setId(id);
	        employee.setName(name);
	        employee.setEmail(email);
	        employee.setPhone(phone);
	        employee.setDepartment(department);
	        employee.setSalary(salary);
	        employee.setJoiningDate(joiningDate);

	        // Update employee
	        EmployeeDAO dao = new EmployeeDAO();
	        dao.updateEmployee(employee);

	        // Redirect to employee list
	        response.sendRedirect("ViewEmployeeServlet");
	    }

}
