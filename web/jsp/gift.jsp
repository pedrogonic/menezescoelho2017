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
                
                <h2 style="text-align:center;"><fmt:message bundle="${text}" key="page.gift.title"/></h2>
                
                <article class="giftLink">
                    <a target="_blank" href="<%=Utils.GIFT_LIST_FAST%>">
                        <img src="${contextPath}/img/icons/fast.png" alt="FAST"/>
                    </a>
                </article>
                
                <article class="giftLink">
                    <a target="_blank" href="<%=Utils.GIFT_LIST_CAMICADO%>">
                        <img src="${contextPath}/img/icons/camicado.png" alt="Camicado"/>
                    </a>
                </article>
                
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
