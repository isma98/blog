<%-- 
    Document   : category-add
    Created on : 23/04/2020, 06:52:05 PM
    Author     : Ismael
--%>
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
            <h3>Agregar nueva categoria</h3>
        </div>
        <form class="form" action="Category" method="post" enctype="multipart/form-data">
            <label for="title">Titulo</label>
            <input class="field" type="text" name="title" placeholder="Titulo de categoria">
            <label for="image">Imagen</label>
            <input type="file" name="image" id="image" accept="image/*">

            <div class="container-btn">
                <input class="danger btn" type="submit" name="action" value="cancelar">	
                <input class="success btn" type="submit" name="action" value="registrar">
            </div>

        </form>		
    </div>

</body>
</html>
<% } %>