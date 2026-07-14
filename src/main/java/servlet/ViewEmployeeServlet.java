package servlet;

import dao.EmployeeDAO;
import model.Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * Servlet implementation class ViewEmployeeServlet
 */
@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAO dao = new EmployeeDAO();
		
		List<Employee>  employeeList = dao.getAllEmployees();
		
		request.setAttribute("employeeList", employeeList);
		
		request.getRequestDispatcher("jsp/ViewEmployee.jsp").forward(request, response);
		
	}

}
