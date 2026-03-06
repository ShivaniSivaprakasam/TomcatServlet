package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Narayan"),
                @WebInitParam(name = "password", value = "BridgeLabz@1")
        }
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        String validUser = getServletConfig().getInitParameter("user");
        String validPwd = getServletConfig().getInitParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String namePattern = "^[A-Z][a-zA-Z]{2,}$";
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=(?:.*[^a-zA-Z0-9]){1})(?!.*[^a-zA-Z0-9].*[^a-zA-Z0-9]).{8,}$";

        if (!Pattern.matches(namePattern, user)) {
            out.println("<h3 style='color:red'>Invalid Name Format</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request, response);
            return;
        }

        if (!Pattern.matches(passwordPattern, pwd)) {
            out.println("<h3 style='color:red'>Invalid Password Format</h3>");
            out.println("<p>Password must have minimum 8 characters, at least 1 uppercase letter, at least 1 number, and exactly 1 special character.</p>");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request, response);
            return;
        }

        if (user.equals(validUser) && pwd.equals(validPwd)) {
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
            rd.forward(request, response);
        } else {
            out.println("<h3 style='color:red'>Invalid Username or Password</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request, response);
        }
    }
}
