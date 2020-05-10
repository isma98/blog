<%-- 
    Document   : category-mod
    Created on : 23/04/2020, 06:52:17 PM
    Author     : Ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    HttpSession sesion = request.getSession();
    String usuarioValidado = (String) sesion.getAttribute("email");
    
    if (usuarioValidado == null) {
        response.sendRedirect("login.jsp");
    }else{
    
    
    int id = Integer.parseInt(request.getParameter("id"));
    String image = request.getParameter("image");
    String title = request.getParameter("title");

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
            <h3>Modificar categoria</h3>
        </div>
        <form class="form" action="Category" method="post" enctype="multipart/form-data">
            
            <input type="hidden" name="id" value="<%= id %>">
            
            <label for="title">Titulo</label>
            <input class="field" type="text" name="title" placeholder="Titulo de categoria" value="<%= title %>">
            <label for="image">Imagen</label>
            
            <input type="file" name="image" id="image" accept="image/*">
            <input type="hidden" name="image_default" value="<%= image %>">

            <div class="container-btn">
                <input class="danger btn" type="submit" name="action" value="cancelar">	
                <input class="success btn" type="submit" name="action" value="actualizar">
            </div>

        </form>		
    </div>

</body>
</html>

<% } %>