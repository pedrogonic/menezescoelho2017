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
                
                <h2><fmt:message bundle="${text}" key="page.about.title"/></h2>
                
                <article class="main_photo">
                
                    <img src="https://lh3.googleusercontent.com/kllmnV6UIulSJ_XIld7cjaCmItMVEurjbxsfIm6mJjL_tG0tfu77mr5p4v83ntq2Hi_N75ESpXOx1BeG2TW89kzO7WCeuZU_8dc0F3wPQRAgIJpjz3NfdbaRFj7XAdEymmILD6sx9A"/>
                
                </article>
                
                <article class="aboutText">
                    <fmt:message bundle="${text}" key="page.about.text"/>
                </article>
                    
            </section>

            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
