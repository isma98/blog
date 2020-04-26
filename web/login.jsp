<%-- 
    Document   : login
    Created on : 20/04/2020, 11:20:26 PM
    Author     : Ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>JizaTec Blog</title>
        <meta name="viewport" content="width=device-width, user-scalable=no">

        <link rel="stylesheet" href="./styles/login.css">

        <script src="./js/jquery/jquery-3.4.1.min.js"></script>
        <script src="./js/main.js"></script>
    </head>
    <body>

        <div class="container">
            <div class="title">
                    <h3>Panel de Administración</h3>
            </div>
            <form class="form" action="User" method="post">
                    <input class="field" type="email" name="email" placeholder="correo" required>
                    <input class="field" type="password" name="password" placeholder="contraseña" required>
                    <input class="btn" type="submit" name="submit" value="entrar">
            </form>		
        </div>

    </body>
</html>
