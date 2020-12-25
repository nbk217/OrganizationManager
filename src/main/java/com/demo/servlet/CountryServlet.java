package com.demo.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ServerCloneException;


public class CountryServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        request.setAttribute("name",request.getParameter("name"));
//        request.setAttribute("password",request.getParameter("password"));
//        request.getRequestDispatcher("WEB-INF/view/form.jsp").forward(request,response);

        request.setAttribute("regionName", request.getParameter("name"));
        request.getRequestDispatcher("WEB-INF/view/countries.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("regionName", request.getParameter("name"));
        request.getRequestDispatcher("WEB-INF/view/countries.jsp").forward(request,response);
    }
}
