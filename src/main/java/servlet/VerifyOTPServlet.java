package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import dao.UserDAO;
import model.User;

@WebServlet("/VerifyOTPServlet")
public class VerifyOTPServlet extends HttpServlet {


protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

	System.out.println("===== VerifyOTPServlet Executed =====");
    HttpSession session = request.getSession();


    int enteredOTP =
            Integer.parseInt(request.getParameter("otp"));


    int generatedOTP =
            (Integer) session.getAttribute("otp");



    if(enteredOTP == generatedOTP){


    	 System.out.println("OTP Verified Successfully");

    	    String username = (String) session.getAttribute("username");
    	    String email = (String) session.getAttribute("email");
    	    String password = (String) session.getAttribute("password");
    	    User user = new User();

    	    user.setUsername(username);
    	    user.setEmail(email);
    	    user.setPassword(password);
    	    user.setRole("EMPLOYEE");
    	    
    	    UserDAO userDAO = new UserDAO();

    	    boolean status = userDAO.registerUser(user);
    	    
    	    if (status) {

    	        // Remove temporary registration data from the session
    	        session.removeAttribute("otp");
    	        session.removeAttribute("username");
    	        session.removeAttribute("email");
    	        session.removeAttribute("password");

    	        response.sendRedirect("login.jsp");

    	    } else {

    	        request.setAttribute("error", "Registration failed. Please try again.");

    	        request.getRequestDispatcher("otp.jsp").forward(request, response);

    	    }

    }
    else{


        request.setAttribute(
                "error",
                "Invalid OTP");


        request.getRequestDispatcher("otp.jsp")
               .forward(request,response);

    }


}

}