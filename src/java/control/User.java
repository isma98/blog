/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ismael
 */
@WebServlet(name = "User", urlPatterns = {"/User"})
public class User extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sesion = request.getSession(true);
            RequestDispatcher dispatcher;
            userDAO u = new userDAO();
	            
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String mensaje = "", retorno = "";
            
            int login = 0;
            
            Boolean status = u.validarUsuario(email, pass);
            
            if (status) {
                sesion.setAttribute("login", "1");
                sesion.setAttribute("email", email);
                sesion.setAttribute("password", pass);
                sesion.setMaxInactiveInterval(-1);
                System.out.println("Usuario valido");
                retorno = "/admin.jsp";
                
            } else {
                retorno = "/login.jsp";
                sesion.setAttribute("login", "0");
                sesion.setAttribute("mensaje", mensaje);
                mensaje += "Password Incorrecto, favor de rectificar";
                System.out.println("Usuario no valido");
                System.out.println(mensaje);
            }
            
            dispatcher = getServletContext().getRequestDispatcher(retorno);
            dispatcher.forward(request, response);
        }catch(Exception e){
            System.out.println("Error al recibir datos de usuario, error: "+e.getLocalizedMessage());
        }
    }

}
