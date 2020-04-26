<%-- 
    Document   : index
    Created on : 20/04/2020, 08:31:38 AM
    Author     : Ismael
--%>

<%@page import="dao.newsDAO"%>
<%@page import="model.news"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JizaTec Blog</title>
        <%@include file="styles/styles.jsp" %>
    </head>
    <body>
        
        <%@include file="navbar.jsp" %>
        
        <div class="first-content container-news">
            <%for(news n : newsDAO.toListNewsTop()){ %>
                <a href="News?news=<%= n.getId() %>" class="item-new">
                    <div class="box-new" style="background-image: url('./assets/images/electronica.jpg');">	
                        <span class="type-new"> <%= n.getCategory_title() %> </span>
                        <span class="title-new"> <%= n.getTitle() %> </span>
                    </div>	
                </a>
            <% } %>
        </div>
        
        <div class="last-content container-content">
            <main class="main">
                <div class="title">	
                    <h3>Lo más reciente</h3>
                </div>
                
                <div class="container-recent-news">	
                    <% for(news n : newsDAO.toListNews()){ 
                        String [] str_date = n.getPost_date().split(" ");
                    %>
                        <a href="News?news=<%= n.getId() %>" class="item-recent-new">
                            <div class="box-recent-new">	
                                <img src="./assets/images/programacion.jpg" alt="">
                                <div class="new-description">
                                    <span class="type-recent-new">
                                            <%= n.getCategory_title() %>
                                    </span>
                                    <div class="box-date-recent-new">
                                        <i class="far fa-calendar-alt"></i>
                                        <span> <%= str_date[0] %> </span>
                                    </div>
                                    <span class="title-recent-new"> <%= n.getTitle() %> </span>	
                                </div>
                            </div>
                        </a>	 
                    <% } %>
                </div>		
            </main>

            <aside class="aside">
                <div class="title">	
                    <h3>Noticias destacadas</h3>
                </div>
                    <div class="container-aside-news">
                        <% for(news n : newsDAO.toListNewsAside()){ %>
                            <a href="News?news=<%= n.getId() %>" class="item-aside-new">
                                <div class="box-aside-new">	
                                    <img src="./assets/images/programacion.jpg" alt="">
                                    <div class="new-aside-description">
                                        <span class="type-aside-new">
                                            <%= n.getCategory_title() %>
                                        </span>
                                        <span class="title-aside-new"> <%= n.getTitle() %> </span>	
                                    </div>
                                </div>
                            </a>
			 <% } %>						
                    </div>
            </aside>
        </div>
        
        <%@include file="footer.jsp" %>
        
    </body>
</html>
