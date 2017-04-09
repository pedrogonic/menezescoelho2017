package servlet;

import dto.Message;
import dto.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.Utils;
import services.MessageServices;
import services.UserServices;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (Utils.Page page = Utils.Page.valueOf(request.getParameter("page"))) {
        
            HttpSession session = request.getSession();
            
            switch(page){
                case MSG:
                    
                    User user = UserServices.getUserFromSession(session);
                    List<Message> messageList = MessageServices.getAllMessages(user);
                    Message messagePosted = MessageServices.getMessageFromSession(Message.Action.POSTED.getActionName(), session);
                    Message messageReplied = MessageServices.getMessageFromSession(Message.Action.REPLIED.getActionName(), session);
                    
                    session.setAttribute("messageList", messageList);
                    session.setAttribute("messagePosted", messagePosted);
                    session.setAttribute("messageReplied", messageReplied);
                    break;
                    
            }
        
            redirect(request,response,page);
            
        } catch (Exception e){ e.printStackTrace(); redirect(request, response, Utils.Page.ERROR); }
        
    }
    
    protected void redirect(HttpServletRequest request
                , HttpServletResponse response
                , Utils.Page page)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        session.setAttribute("mobile", Utils.isMobile(request));
        
        session.setAttribute("daysToGo", Long.toString(Utils.daysToGo()));
        
        response.sendRedirect(page.getPageName());
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        return "Controller";
    }// </editor-fold>

}
