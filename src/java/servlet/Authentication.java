/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedrogonic
 */
@WebServlet(name = "Authentication", urlPatterns = {"/Authentication"})
public class Authentication extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text;charset=UTF-8");
        
        request.getSession().setAttribute("fbUserID", request.getParameter("fbUserID"));
        request.getSession().setAttribute("fbName", request.getParameter("fbName"));
        request.getSession().setAttribute("fbEmail", request.getParameter("fbEmail"));
        request.getSession().setAttribute("fbUserImg", request.getParameter("fbUserImg"));
        
        try (PrintWriter out = response.getWriter()) {
            out.println("Login successful for user: " + request.getParameter("fbUserID"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for saving Facebook login info";
    }// </editor-fold>

}
