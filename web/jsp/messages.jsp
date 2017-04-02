<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                    
                    <form>
                        <article id="userInfo">
                            
                            <span id="userPic"></span>
                            
                            <span id="userName"></span>
                            
                            <input type="color" name="colorpicker" id="colorpicker" 
                                   onchange="changeColor()"/>
                            
                            <br/>
                        </article>
                        
                        <textarea id="newMsgBody" class="msgTextarea"
                                rows="5" cols="30"></textarea>
                        <br/>
                        
                        <button id="submitMsg" onclick="beforeSubmit()" disabled>
                            <fmt:message bundle="${text}" key="page.msg.submit"/>
                        </button>
                    </form>
                    
                </article>
                
                <section class="mural">
                    <article class="msg fieldset">Teste</article>
                    <article class="msg fieldset">Teste</article>
                    <article class="msg fieldset">Teste</article>
                    <article class="msg fieldset">Teste</article>
                    <article class="msg fieldset">Teste</article>
                    <article class="msg fieldset">Teste</article>
                </section>
                            
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
