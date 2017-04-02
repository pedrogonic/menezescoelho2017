package servlet;

import dao.DAOFactory;
import dao.UserDAO;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Authentication", urlPatterns = {"/Authentication"})
public class Authentication extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text;charset=UTF-8");
        
        User user = new User(request.getParameter("fbUserID")
                            , request.getParameter("fbName")
                            , request.getParameter("fbEmail")
                            , request.getParameter("fbUserImg"));
        
        UserDAO userDAO = DAOFactory.getDAOFactory().getUserDAO();
        user = userDAO.insertUpdateUser(user);
        
        request.getSession().setAttribute("userID", user.getUserID());
        request.getSession().setAttribute("fbUserID", user.getFbUserID());
        request.getSession().setAttribute("fbName", user.getUserName());
        request.getSession().setAttribute("fbEmail", user.getUserEmail());
        request.getSession().setAttribute("fbUserImg", user.getUserPicURL());
        
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
