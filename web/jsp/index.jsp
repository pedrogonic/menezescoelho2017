<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
        <%@include file="/jspf/includes.jspf"%>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${text}" key="page.title"/></title>
    </head>
    <body>
        
        <section class="content">
            
            <%@include file="/jspf/header.jspf"%>
            
            <%@include file="/jspf/menu.jspf"%>

            <section class="first"></section>
            
            <section class="second">
                <h2><fmt:message bundle="${text}" key="page.index.welcome"/><span id="fbName"></span>!</h2>
                <!--h1 class="nick"><fmt:message bundle="${text}" key="page.construction"/></h1-->
                
                <!--p><fmt:message bundle="${text}" key="page.version"/>: <c:out value='${mobile ? "Mobile" : "Desktop"}'/></p-->
                
                <article class="main_photo">
                    
                    <img src="https://lh3.googleusercontent.com/LQJTK8nBaVbb75Tb1MNBdaqffvof33VVd0jTiGVJ9dzXS4tCenb6W4okEBlghxdzf6Otzm2S6AVJ1oRjW3HJxlzKq1EGJV8kDbVqJTTXrZhNmL0FnG5XONaes3HQy0qtBsxVcw6_6Q"/>
                    
                </article>
                
                <article class="info">
                    
                    <fmt:message bundle="${text}" key="page.index.text1"/>
                    <br/>
                    <br/>
                    <fmt:message bundle="${text}" key="page.index.text2"/>
                    <br/>
                    <fmt:message bundle="${text}" key="page.index.text3"/>
                    <br/>
                    <br/>
                    <fmt:message bundle="${text}" key="page.index.text4"/>
                    
                </article>
                
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
