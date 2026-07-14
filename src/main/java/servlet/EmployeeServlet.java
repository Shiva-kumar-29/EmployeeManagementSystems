package servlet;
import model.Employee;
import dao.EmployeeDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone= request.getParameter("number");
		String department = request.getParameter("department");
		double salary= Double.parseDouble(request.getParameter("salary"));
		String joiningDate = request.getParameter("joiningdate");
		
		Employee employee = new Employee();
		
		
		employee.setName(name);
		employee.setDepartment(department);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setJoiningDate(joiningDate);
		employee.setSalary(salary);
		
		EmployeeDAO dao = new EmployeeDAO();
		
		dao.insertEmployee(employee);
		
	    response.sendRedirect("index.jsp");
		
	}


}
