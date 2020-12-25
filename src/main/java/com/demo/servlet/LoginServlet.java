package com.demo.servlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LoginServlet.class);


    public void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
        logger.info("Forwarding request response to form.jsp file");
        request.getRequestDispatcher("WEB-INF/view/form.jsp").forward(request,response);
        logger.debug("This is a debug statement in login servlet");
    }
}
