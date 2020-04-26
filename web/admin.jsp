<%-- 
    Document   : index
    Created on : 20/04/2020, 11:18:33 PM
    Author     : Ismael
--%>

<%@page import="dao.newsDAO"%>
<%@page import="model.news"%>
<%@page import="dao.categoryDAO"%>
<%@page import="model.category"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesion = request.getSession();
    String usuarioValidado = (String) sesion.getAttribute("email");
    
    if (usuarioValidado == null) {
        response.sendRedirect("login.jsp");
    }else{
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>JizaTec Blog</title>
    <meta name="viewport" content="width=device-width, user-scalable=no">

    <link rel="stylesheet" href="./styles/admin.css">

    <script src="./js/jquery/jquery-3.4.1.min.js"></script>
    <script src="./js/main-admin.js"></script>
</head>
<body>

    <navbar class="navbar">
        <ul class="menu">
            <li><a class="tab" href="#category">categorias</a></li>
            <li><a class="tab" href="#news">noticias</a></li>
            <li><a href="User">cerrar sesion</a></li>
        </ul>
    </navbar>

    <div class="content" id="category">
        <div class="title">
            <h4>Categorias</h4>
            <a href="category-add.jsp">agregar</a>
        </div>
            <div class="container-table">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Imagen</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(category c : categoryDAO.toListCategories()){ %>
                            <tr>
                                <td><%= c.getId() %></td>
                                <td><%= c.getTitle() %></td>
                                <td>
                                    <img src="./services/image_categories/<%= c.getImage() %>" alt="imagen de categoria">
                                </td>
                                <td>
                                    <form action="Category" method="post">
                                        <input type="hidden" name="id" value="<%= c.getId() %>">
                                        <input type="hidden" name="image" value="<%= c.getImage() %>">
                                        <input type="hidden" name="title" value="<%= c.getTitle() %>">
                                        <input class="mod btn-form" type="submit" name="action" value="modificar">
                                        <input class="del btn-form" type="submit" name="action" value ="eliminar">
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>	
            </div>
        </div>

        <div class="content" id="news">
            <div class="title">
                <h4>Noticias</h4>
                <a href="news-add.jsp">agregar</a>
            </div>
            <div class="container-table">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Categoria</th>
                            <th>Titulo</th>
                            <th>Imagen</th>
                            <th>Fecha</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(news n : newsDAO.toListNews()){ %>
                            <tr>
                                <td> <%= n.getId() %> </td>
                                <td><%= n.getCategory_title() %></td>
                                <td><%= n.getTitle() %></td>
                                <td>
                                    <img src="./services/image_news/<%= n.getContent_image() %>" alt="imagen noticia">
                                </td>
                                <td><%= n.getPost_date() %></td>
                                <td>
                                    <form action="News" method="post">
                                        <input type="hidden" name="id" value="<%= n.getId() %>">
                                        <input type="hidden" name="id_category" value="<%= n.getId_category() %>">
                                        <input type="hidden" name="category" value="<%= n.getCategory_title() %>">
                                        <input type="hidden" name="image" value="<%= n.getContent_image() %>">
                                        <input type="hidden" name="text" value="<%= n.getContent_text() %>">
                                        <input type="hidden" name="title" value="<%= n.getTitle() %>">
                                        <input class="mod btn-form" type="submit" name="action" value="modificar">
                                        <input class="del btn-form" type="submit" name="action" value ="eliminar">
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>	
        </div>

</body>
</html>	
<% } %>