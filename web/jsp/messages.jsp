<%@page import="services.MessageServices"%>
<%@page import="java.util.List"%>
<%@page import="dto.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    List<Message> messageList = (List) session.getAttribute("messageList");
//    if ( messageList == null || messageList.equals("null")) {
//        response.sendRedirect(request.getContextPath()+"/Controller?page="+Utils.Page.MSG);
//        return;
//    }
    
pageContext.setAttribute("rd", request.getContextPath()+"/Controller?page="+Utils.Page.MSG);

    pageContext.setAttribute("messageList", messageList);
    session.removeAttribute("messageList");
    
    Message messagePosted = MessageServices.getMessageFromSession(Message.PostMethod.POST_MESSAGE, session);
    pageContext.setAttribute("messagePosted", messagePosted);
    
    Message messageReplied = MessageServices.getMessageFromSession(Message.PostMethod.REPLY_MESSAGE, session);
    pageContext.setAttribute("messageReplied", messageReplied);
    
    Message.DeleteResult deleteResult = (Message.DeleteResult)session.getAttribute("deleteResult");
    pageContext.setAttribute("deleteResult", deleteResult);
    session.removeAttribute("deleteResult");
    
    Message.DeleteResult resultDeleted = Message.DeleteResult.DELETED;
    pageContext.setAttribute("resultDeleted", resultDeleted);
    
%>    

<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/jspf/includes.jspf"%>
        
        <script>
            var confirmDeletionMsg = '<fmt:message bundle="${text}" key="page.msg.confirm.delete"/>';
            var resultDeleted = '<c:out value="${resultDeleted}"/>';
            var deleteResult = '<c:out value="${deleteResult}"/>';
            var deletedText = '<fmt:message bundle="${text}" key="page.msg.deleted"/>';
        </script>
        
        <link href="<%=request.getContextPath()%>/css/messages.css" rel="stylesheet" type="text/css"/>
        <c:if test="${mobile}">
            <link href="<%=request.getContextPath()%>/css/mobile-messages.css" rel="stylesheet" type="text/css"/>
        </c:if>
        
        <script src="<%=request.getContextPath()%>/js/messages.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/masonry.pkgd.min.js" type="text/javascript"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${text}" key="page.title"/></title>
    </head>
    <body>
        
        <section class="content">
            
            <%@include file="/jspf/header.jspf"%>
            
            <%@include file="/jspf/menu.jspf"%>
            
            <%@include file="/jspf/dialogs.jspf"%>

            <section class="first"></section>
            
            <section class="second">
                
                <article id="newMsg">
                    
                    <% if (!(fbUserID != null && !fbUserID.equals(""))) { %>
                    <article id="fbLoginButton">
                        <div class="fb-login-button" data-max-rows="1" data-size="medium" 
                             data-button-type="login_with" data-show-faces="false" 
                             data-auto-logout-link="false" data-use-continue-as="true"></div>
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
                    
                    <form   id="deleteMessageForm"
                            method="post"
                            action="<%=request.getContextPath()%>/Controller?method=<%=Message.PostMethod.TRASH%>">
                        
                        <input type="hidden" id="deleteMessageID" name="messageID"/>
                        
                    </form>
                    
                </article>
                
                <section class="mural">
                    <c:choose>
                        <c:when test="${empty messageList}">
                            <fmt:message bundle="${text}" key="page.msg.empty"/>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${messageList}" var="msg">
                                <tl:MessageTag message="${msg}"
                                               postMessage="${messagePosted}"
                                               replyMessage="${messageReplied}"
                                               contextPath="${contextPath}"/>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </section>
                            
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
