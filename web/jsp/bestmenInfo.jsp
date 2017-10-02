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
            
                <h2><fmt:message bundle="${text}" key="page.bestmeninfo.title"/></h2>
                
                <article class="info">
                    
                    <fmt:message bundle="${text}" key="page.bestmeninfo.text1"/>
                    <br/>
                    <br/>
                    <fmt:message bundle="${text}" key="page.bestmeninfo.text2"/>
                    <br/>
                    <fmt:message bundle="${text}" key="page.bestmeninfo.text3"/>
                    
                </article>
                    
                <h2><fmt:message bundle="${text}" key="page.bestmeninfo.dress"/></h2>
                
                <h2><fmt:message bundle="${text}" key="page.bestmeninfo.women"/></h2>
                
                <article class="main_photo">
                    <img src="../img/bestmen/Madrinhas.png" alt=""/>
                </article>
                
                <h2><fmt:message bundle="${text}" key="page.bestmeninfo.men"/></h2>

                <article class="main_photo">
                    <img src="../img/bestmen/Padrinhos.png" alt=""/>
                </article>
                
            </section>
                    
            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
