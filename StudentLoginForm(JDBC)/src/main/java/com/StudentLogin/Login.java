package com.StudentLogin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        User user=new User(userName,password);
        LoginDao logindao=new LoginDao();
        if(logindao.insert(user)) {
            response.sendRedirect("LoginSuccessful.jsp");
        }
        else
        {
            response.sendRedirect("Login.jsp");
        }

    }

}
