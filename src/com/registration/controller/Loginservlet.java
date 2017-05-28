package com.registration.controller;

import com.registration.model.UsersDAO;
import com.registration.utility.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mdawwas on 5/28/17.
 */
@WebServlet(name = "Login servlet",urlPatterns = {"/login.do"})
public class Loginservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("user");
        String pswd = request.getParameter("pswd");
        /*try {
            User user = new UsersDAO().getUser(userName);
            if(user == null || user.getPassword() != pswd) {
                throw new SQLException();
            }else{
                Cookie loginCookie = new Cookie("user",userName);
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);
                request.setAttribute("name",user.getName());
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        response.sendRedirect("loginSuccess.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
