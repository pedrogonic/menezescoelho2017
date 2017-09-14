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
                
                <h2><fmt:message bundle="${text}" key="page.party.title"/></h2>
                
                <article class="">
                    <fmt:message bundle="${text}" key="page.party.text"/>
                </article>
                
                <article class="maps">
                    
                    <iframe
                        width="600"
                        height="450"
                        frameborder="0" style="border:0"
                        src="https://www.google.com/maps/embed/v1/place?key=<c:out value="${mapsAPIKey}"></c:out>
                          &q=espaço+1+casa+de+eventos+Rio+de+Janeiro"
                        allowfullscreen>
                    </iframe>
                    
                </article>
                
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
