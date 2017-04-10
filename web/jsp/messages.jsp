<%@page import="services.MessageServices"%>
<%@page import="java.util.List"%>
<%@page import="dto.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    List<Message> messageList = (List) session.getAttribute("messageList");
    if ( messageList == null || messageList.equals("null")) {
        response.sendRedirect(request.getContextPath()+"/Controller?page="+Utils.Page.MSG);
        return;
    }
    
    pageContext.setAttribute("messageList", messageList);
    session.removeAttribute("messageList");
    
    Message messagePosted = MessageServices.getMessageFromSession(Message.PostMethod.POST_MESSAGE, session);
    pageContext.setAttribute("messagePosted", messagePosted);
    
    Message messageReplied = MessageServices.getMessageFromSession(Message.PostMethod.REPLY_MESSAGE, session);
    pageContext.setAttribute("messageReplied", messageReplied);
    
%>    

<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/jspf/includes.jspf"%>
        
        
        <script src="<%=request.getContextPath()%>/js/messages.js" type="text/javascript"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${text}" key="page.title"/></title>
    </head>
    <body>
        
        <section class="content">
            
            <%@include file="/jspf/header.jspf"%>
            
            <%@include file="/jspf/menu.jspf"%>

            <section class="first"></section>
            
            <section class="second">
                
                <article id="newMsg">
                    
                    <% if (!(fbUserID != null && !fbUserID.equals(""))) { %>
                    <article id="fbLoginButton">
                        <fb:login-button scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>
                    </article>
                    <% } %>
                    
                    <form   id="postMessageForm"
                            method="post" 
                            action="<%=request.getContextPath()%>/Controller?method=<%=Message.PostMethod.POST_MESSAGE%>">
                        <article id="userInfo">
                            
                            <span id="userPic"></span>
                            
                            <span id="userName"></span>
                            
                            <input type="color" name="color" id="colorpicker" 
                                   onchange="changeColor()"/>
                            
                            <br/>
                        </article>
                        
                        <textarea id="newMsgBody" name="body" class="msgTextarea"
                                rows="5" cols="30"></textarea>
                        <br/>
                        
                        <input type="submit" 
                               id="submitMsg" 
                               value="<fmt:message bundle="${text}" key="page.msg.submit"/>" 
                               disabled/>
                    </form>
                    
                </article>
                
                <section class="mural">
                    <%for (Message msg : messageList) {%>
                    <article class="msg fieldset"><%=msg.getBody()%></article>
                    <%}%>
                </section>
                            
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
