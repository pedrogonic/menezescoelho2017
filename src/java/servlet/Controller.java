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
    @SuppressWarnings("CallToPrintStackTrace")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Getting page from request Parameter. 
        // If null, parameter was set by postMethod in an Attribute.
        String requestPageParam = request.getParameter("page");
        if (requestPageParam != null && !requestPageParam.equals(""))
            request.setAttribute("page", requestPageParam);
        
        try (Utils.Page page = Utils.Page.valueOf((String)request.getAttribute("page"))) {
        
            HttpSession session = request.getSession();
            
            switch(page){
                case MSG:
                    
                    User user = UserServices.getUserFromSession(session);
                    List<Message> messageList = MessageServices.getAllMessages(user);
//                    Message messagePosted = MessageServices.getMessageFromSession(Message.PostMethod.POST_MESSAGE, session);
//                    Message messageReplied = MessageServices.getMessageFromSession(Message.PostMethod.REPLY_MESSAGE, session);
                    
                    session.setAttribute("messageList", messageList);
//                    session.setAttribute("messagePosted", messagePosted);
//                    session.setAttribute("messageReplied", messageReplied);
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
        
        session.setAttribute("Controller", true);
        
        response.sendRedirect(page.getPageName());
        
    }

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
        
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        try (Message.PostMethod postMethod = Message.PostMethod.valueOf(request.getParameter("method"))) {
            
            switch(postMethod) {

                case POST_MESSAGE:
                    Message postMessage = MessageServices.getMessageFromRequest(request);
                    if ( postMessage != null ) {
                        postMessage = MessageServices.postMessage(postMessage);
                        MessageServices.setMessageToSession(postMessage, postMethod, session);
                    }
                    request.setAttribute("page",Utils.Page.MSG.toString());
                    break;
                    
                case REPLY_MESSAGE:
                    Message replyMessage = MessageServices.getMessageFromRequest(request);
                    if ( replyMessage != null ) {
                        replyMessage = MessageServices.postMessage(replyMessage);
                        MessageServices.setMessageToSession(replyMessage, postMethod, session);
                    }
                    request.setAttribute("page",Utils.Page.MSG.toString());
                    break;
                    
                case TRASH:
                    Message trashMessage = MessageServices.getMessageFromRequest(request);
                    if ( trashMessage != null ) 
                        session.setAttribute("deleteResult", MessageServices.trashMessage(trashMessage));
                    request.setAttribute("page",Utils.Page.MSG.toString());
                    break;
                    
            }

        }
        
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
    }

}
