<%-- 
    Document   : navbar
    Created on : 20/04/2020, 08:29:21 AM
    Author     : Ismael
--%>

<%@page import="dao.categoryDAO"%>
<%@page import="model.category"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header class="header">
    <input type="checkbox" id="chk-menu">
    <div class="container-logo">
        <figure class="box-logo">
            <a href="index.jsp">
                <img class="logo" src="./assets/images/logo_2.png" alt="logo">
            </a>
        </figure>
        <label for="chk-menu" class="btn-menu" onclick="changeIconMenu()">
            <i id="btn-menu" class="btn fas fa-bars"></i>
        </label>
    </div>
    <nav class="menu">
        <form class="menu__search" action="Search" method="post">
            <input type="search" name="search" placeholder="Buscar..">
            <label for="search">
                <i class="icon-search fas fa-search"></i>
            </label>
        </form>
        <ul class="menu__principal menu__list">
            <li class="item"><a href="index.jsp">inicio</a></li>
            <li class="item" id="item-sub-menu">
                categoria
                <ul class="menu__secondary menu__list">
                    <%for(category c: categoryDAO.toListCategories()){ %>
                        <li class="sub-item item"><a href="Category?val=<%= c.getId() %>"><%= c.getTitle() %></a></li>
                    <% } %>
                </ul>
            </li>
        </ul>
    </nav>
</header>
