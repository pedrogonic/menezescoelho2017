<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="defaultLang" value="pt_BR" scope="session" />
<c:set var="lang" value="${not empty param.lang ? param.lang : defaultLang}" scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="lang.text" var="text" scope="session" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${text}" key="page.title"/></title>
    </head>
    <body>
        
        <%@include file="/jspf/includes.jspf"%>

        
            
        <section class="content">
            
            <%@include file="/jspf/header.jspf"%>
            
            <%@include file="/jspf/menu.jspf"%>

            <section class="second">
                <p>2</p>
                <fmt:message bundle="${text}" key="ipsum"/>
                <fmt:message bundle="${text}" key="ipsum"/>
                <fmt:message bundle="${text}" key="ipsum"/>
            </section>

            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
