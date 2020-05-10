<%-- 
    Document   : news-add
    Created on : 23/04/2020, 06:52:28 PM
    Author     : Ismael
--%>

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
    <link rel="stylesheet" href="./styles/form.css">
</head>
<body>
	
    <div class="container">
        <div class="title">
            <h3>Agregar nueva noticia</h3>
        </div>
        <form class="form" action="News" method="post" enctype="multipart/form-data">
            <label for="title">Titulo</label>
            <input class="field" type="text" name="title" placeholder="Titulo de noticia">
            <label for="category">Categoria</label>
            <select class="field" name="id_category">
                <% for(category c : categoryDAO.toListCategories()){ %>
                    <option value="<%= c.getId() %>"><%= c.getTitle() %></option>
                <% } %>
            </select>
            <label for="image">Imagen</label>
            <input type="file" name="image" id="image" accept="image/*">
            <label for="text">Texto de la noticia</label>
            <textarea name="text" cols="40" rows="10"></textarea>

            <div class="container-btn">
                    <input class="danger btn" type="submit" name="action" value="cancelar">	
                    <input class="success btn" type="submit" name="action" value="registrar">
            </div>

        </form>		
    </div>

</body>
</html>
<% } %>