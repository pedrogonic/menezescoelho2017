<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="lang.text" var="text" scope="session" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${text}" key="page.title"/></title>
        <link rel="shortcut icon" href="${contextPath}/img/error.ico" />
        <link href="${contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <img id="error_page_img" src="${contextPath}/img/icons/error.png" alt=""/>
        <h1 id="error_title"><fmt:message bundle="${text}" key="error.title"/></h1>
        <p id="error_instructions"><fmt:message bundle="${text}" key="error.instructions"/></p>
    </body>
</html>
