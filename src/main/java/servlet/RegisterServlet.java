package servlet;

import dao.UserDAO;
import model.User;
import util.EmailUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    System.out.println("====RegisterServlet Excecuted====");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();

        if (userDAO.isUsernameTaken(username)) {
            request.setAttribute("error", "Username already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
      // Generate OTP
        Random random = new Random();
        
        int otp = 100000 + random.nextInt(900000);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("otp", otp);

        session.setAttribute("username",username);

        session.setAttribute("email",email);

        session.setAttribute("password",password);
        
        // for testing first
        System.out.println("OTP :" + otp);
        EmailUtility.sendOTP(email,otp);
        System.out.println("******** OTP REDIRECT CODE EXECUTED ********");
        request.getRequestDispatcher("/otp.jsp").forward(request, response);
        
      
    }
}