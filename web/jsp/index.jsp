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

            <section class="second">
                <h2><fmt:message bundle="${text}" key="page.index.welcome"/></h2>
                <h1 class="nick"><fmt:message bundle="${text}" key="page.construction"/></h1>
                
                <p><c:out value='${mobile ? "Mobile" : "Desktop"}'/></p>
            </section>

            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
