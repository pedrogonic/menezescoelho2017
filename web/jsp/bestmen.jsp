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
                
                <h2><fmt:message bundle="${text}" key="page.bestmen.parents"/></h2>
                
                <p>Agradecemos o apoio em todos os momentos (inclusive agora, nessa fase de obras e preparativos para casamento), o carinho de sempre, os conselhos, as orientações e por serem o maior exemplo que podemos ter de um lar.</p>
            
                <h2><fmt:message bundle="${text}" key="page.bestmen.title"/></h2>
                
                <p>Escolher nossos padrinhos não foi tarefa fácil, vide o número deles.<br/>
                Mas nos cercamos de pessoas que nos querem bem e confiamos nelas para nos ajudar nessa nova etapa da nossa vida.</p>
                
                <c:forEach items="${bestPersonList}" var="bestPerson">
                    
                    <tl:BestMenTag bestPerson="${bestPerson}"/>
                        
                </c:forEach>
                
                
            </section>
                    
            <section class="third"></section>
            
            <%@include file="/jspf/footer.jspf"%>
            
        </section>
        
    </body>
</html>
