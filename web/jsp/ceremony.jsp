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
                
                <h2><fmt:message bundle="${text}" key="page.ceremony.title"/></h2>
                
                <article class="">
                    <fmt:message bundle="${text}" key="page.ceremony.text"/>
                </article>
                
                <article class="maps">
                    
                    <c:choose>
                        <c:when test="${mobile}">
                            <c:set var="mapsWidth" value="100%"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="mapsWidth" value="600"/>
                        </c:otherwise>
                    </c:choose>
                    
                    <iframe
                        width="<c:out value="${mapsWidth}"/>"
                        height="450"
                        frameborder="0" style="border:0"
                        src="https://www.google.com/maps/embed/v1/place?key=<c:out value="${mapsAPIKey}"></c:out>
                          &q=Capela+Sao+Jose+Rua+Conde+de+Bonfim+Tijuca,Rio+de+Janeiro"
                        allowfullscreen>
                    </iframe>
                    
                </article>
                
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
