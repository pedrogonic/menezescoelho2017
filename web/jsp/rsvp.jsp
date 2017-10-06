<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/jspf/includes.jspf"%>
        
        <script>
            var rsvpResult = '<c:out value="${rsvpResult}"/>';
        </script>
        
        <script src="${contextPath}/js/rsvp.js" type="text/javascript"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${text}" key="page.title"/></title>
    </head>
    <body>
        
        <section class="content">
            
            <%@include file="/jspf/header.jspf"%>
            
            <%@include file="/jspf/menu.jspf"%>

            <section class="first"></section>
            
            <section class="second">
                
                <h2><fmt:message bundle="${text}" key="page.rsvp.title"/></h2>
                
                <p><fmt:message bundle="${text}" key="page.rsvp.instructions"/></p>
                
                <c:if test="${empty fbUserID}">
                    <article id="fbLoginButton">
                        <div class="fb-login-button" data-max-rows="1" data-size="medium" 
                             data-button-type="login_with" data-show-faces="false" 
                             data-auto-logout-link="false" data-use-continue-as="true"></div>
                    </article>
                </c:if>
                
                <form   id="rsvpForm"
                            method="post" 
                                action="${contextPath}/Controller?method=rsvp">
                    
                    <input type="hidden" id="guestsNames" name="guestsNames"/>
                    
                    <article id="rsvpArticle">
                        <div id="fieldsDiv">
                            <input type="text" id="rsvp1" class="rsvpField"/>
                        </div>
                        <span id="remove" style="display:none;">-</span>
                        <span id="add">+</span>
                    </article>
                    <article>
                        <input type="submit" 
                                   id="submitMsg" 
                                   value="<fmt:message bundle="${text}" key="page.msg.login"/>" 
                                   disabled/>
                    </article>
                               
                </form>
                                    
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
