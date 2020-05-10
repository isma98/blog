<%-- 
    Document   : post
    Created on : 20/04/2020, 08:33:56 AM
    Author     : Ismael
--%>

<%@page import="dao.newsDAO"%>
<%@page import="model.news"%>

<%
    int id_news = Integer.parseInt(request.getParameter("news"));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="styles/styles.jsp" %>
    </head>
    <body>
        
        <%@include file="navbar.jsp" %>
        
       <div class="first-content last-content container-content">
            <main class="main">
                <%for(news n: newsDAO.showNews(id_news)){ 
                    String [] str_date = n.getPost_date().split(" ");
                    int views = n.getViews() + 1;
                %>
                    <div class="title-news">	
                        <h3><%= n.getTitle() %></h3>
                        <div class="title-date-news">
                            <i class="far fa-calendar-alt"></i>
                            <span><%= str_date[0] %></span>
                        </div>
                    </div>

                    <div class="box-news_content">
                        <figure>
                            <img src="./services/image_news/<%= n.getContent_image() %>" alt="imagen de noticia">
                        </figure>
                        <div class="news_text">
                            <p>
                              <%= n.getContent_text() %>
                            </p>
                        </div>
                    </div>	
                <% } %>
            </main>

            <aside class="aside">
                <div class="title">	
                    <h3>Noticias destacadas</h3>
                </div>
                <div class="container-aside-news">
                    <% for(news n : newsDAO.toListNewsAside()){ %>
                        <a href="News?news=<%= n.getId() %>&views=<%= n.getViews() %>" class="item-aside-new">
                            <div class="box-aside-new">	
                                <img src="./services/image_news/<%= n.getContent_image() %>" alt="imagen_noticia">
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
