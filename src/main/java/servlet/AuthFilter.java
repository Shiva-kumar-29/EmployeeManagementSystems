package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String uri = request.getRequestURI();

        boolean isPublicPage =
                uri.endsWith("login.jsp")
                || uri.endsWith("register.jsp")
                || uri.endsWith("otp.jsp")
                || uri.contains("LoginServlet")
                || uri.contains("RegisterServlet")
                || uri.contains("VerifyOTPServlet")
                || uri.contains("/css/")
                || uri.contains("/js/");

        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        if (loggedIn || isPublicPage) {
            chain.doFilter(req, res);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}