package tags;

import dto.Message;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class MessageTag extends SimpleTagSupport {

    private Message message;
    private Message postMessage;
    private Message replyMessage;
    private String contextPath;
    
    
    public void setMessage(Message message) { this.message = message; }
    
    public void setPostMessage(Message postMessage) { this.postMessage = postMessage; }
    
    public void setReplyMessage(Message replyMessage) { this.replyMessage = replyMessage; }
    
    public void setContextPath(String contextPath) { this.contextPath = contextPath; }
    
    /**
     * 
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            
            boolean equalsPosted = message.equals(postMessage);
            boolean equalsReplied = message.equals(replyMessage);
            
            
            out.println("<article class=\"msg "
                    + ( equalsPosted ? " postedMsg " : "" )
                    + ( equalsReplied ? " repliedMsg " : "" )
                    + " \" >");
            
            out.println("<article class=\"msgUserInfo\">");
            out.println("<img class=\"fbProfilePic\" src=\"" + message.getUser().getUserPicURL() + "\" />");
            out.println("<span class=\"msgUserName\" style=\"color:" + message.getColor() + ";\">"
                            + message.getUser().getUserName() 
                            + "</span>");
            out.println("</article>");
            
            out.println("<article class=\"msgDate\">" + message.getFormattedTime() + "</article>");
            
            out.println("<article class=\"msgBody\">");
            out.println(message.getBody());
            out.println("</article>");
            
            if ( message.getReply() != null ) {
                out.println("<article class=\"msgReply\">");
                out.println(message.getReply());
                out.println("</article>");
            }
            
            if ( message.isTrashable() ) {
                out.println("<article class=\"msgTrash\">");
                out.println("<img class=\"trashIcon\" src=\"" + contextPath + "/img/icons/trash.png\""
                                        + "onclick=\"confirmTrash('" + message.getMessageID() + "');\" />");
                out.println("</article>");
            }
            
            out.println("</article>");
            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in MessageTag tag", ex);
        }
    }
    
}
