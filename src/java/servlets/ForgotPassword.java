/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author 834043
 */
public class ForgotPassword extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService as = new AccountService();
        String email = request.getParameter("email");
        String path = getServletContext().getRealPath("/WEB-INF");
        boolean result= false;
        try {
            result = as.forgotPassword(email, path);
        } catch (Exception ex) {
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == true) getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        else {
            request.setAttribute("message", "Invalid email");
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        }
    }

}
