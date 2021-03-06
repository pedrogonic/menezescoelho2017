<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/jspf/includes.jspf"%>
        
        <script>
            var rsvpResult = '<c:out value="${rsvpResult}"/>';
            var fillBlanks = '<fmt:message bundle="${text}" key="page.rsvp.fill"/>';
            var successTxt = '<fmt:message bundle="${text}" key="page.rsvp.success"/>';
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
                
                <article class="text">
                    <fmt:message bundle="${text}" key="page.rsvp.instructions"/>
                </article>
                
                <c:if test="${empty fbUserID}">
                    <article style="margin-top: 30px;" id="fbLoginButton">
                        <div class="fb-login-button" data-max-rows="1" data-size="medium" 
                             data-button-type="login_with" data-show-faces="false" 
                             data-auto-logout-link="false" data-use-continue-as="true" onlogin="checkLoginState"></div>
                    </article>
                </c:if>
                
                <article id="userInfo" style="margin-top: 20px;">
                            
                    <span id="userPic"></span>

                    <span id="userName"></span>
                            
                </article>
                
                <form   id="rsvpForm"
                            method="post" 
                                action="${contextPath}/Controller?method=rsvp">
                    
                    <input type="hidden" id="guestsNames" name="guestsNames"/>
                    
                    <article id="rsvpArticle">
                        <h1><fmt:message bundle="${text}" key="page.rsvp.guests"/></h1>
                        <div id="fieldsDiv">
                            <p id="rsvp1P"><input type="text" id="rsvp1" class="rsvpField"/></p>
                        </div>
                        <div id="addRemoveDiv">
                            <span id="remove" style="display:none;"><img class="rsvpIcons" src="${contextPath}/img/icons/minus.png" alt=""/></span>
                            <span id="add"><img class="rsvpIcons" src="${contextPath}/img/icons/plus.png" alt=""/></span>
                        </div>
                    </article>
                    
                    <article class="rsvpRadio">
                        <input type="radio" name="attending" value="true" checked><span class="attending">Presente(s)</span>
                        <input type="radio" name="attending" value="false"><span class="attending">Ausente(s)</span>
                    </article>
                    
                    <article>
                        <input type="submit" 
                                   id="submitMsg" 
                                   value="<fmt:message bundle="${text}" key="page.msg.login"/>" 
                                   disabled/>
                        <span id="errorMsg"></span>
                        <span id="successMsg"></span>
                    </article>
                               
                </form>
                                    
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
