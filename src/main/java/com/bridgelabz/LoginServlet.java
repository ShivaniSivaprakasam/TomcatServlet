package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name="user", value="Narayan"),
                @WebInitParam(name="password", value="BridgeLabz")
        }
)

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        String validUser = getServletConfig().getInitParameter("user");
        String validPwd = getServletConfig().getInitParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // UC3 VALIDATION
        String namePattern = "^[A-Z][a-zA-Z]{2,}$";

        if(!Pattern.matches(namePattern, user)) {

            out.println("<h3 style='color:red'>Invalid Name Format</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request,response);
            return;
        }

        if(user.equals(validUser) && pwd.equals(validPwd)) {

            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
            rd.forward(request,response);

        } else {

            out.println("<h3 style='color:red'>Invalid Username or Password</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("/login.html");
            rd.include(request,response);
        }
    }
}