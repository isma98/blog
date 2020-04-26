/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.categoryDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Ismael
 */
@WebServlet(name = "Category", urlPatterns = {"/Category"})
@MultipartConfig
public class Category extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("category.jsp").forward(request, response);
        /*
        try{
            int id_category = Integer.parseInt(request.getParameter("val"));
            request.getRequestDispatcher("category.jsp").forward(request, response);
        }catch(Exception e){
            System.out.println("Error al recibir el valor de la categoria, error: "+e.getLocalizedMessage());
        }*/
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        
        System.out.println("accion: "+action);
        /*
        if(action == null){ System.out.println("El valor de la accion ES nulo");}
        if(action != null){ System.out.println("El valor de la accion NO es nulo");}
        
        request.getRequestDispatcher("admin.jsp").forward(request, response);
       */
        
        switch(action){
            case "cancelar":
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                break;
            case "registrar":
                saveCategory(request,response);
                break;
            case "modificar":
                request.getRequestDispatcher("category-mod.jsp").forward(request, response);
                break;
            case "actualizar":
                modCategory(request, response);
                break;
            case "eliminar":
                deleteCategory(request, response);
                break;
            default:   
                System.out.println("Accion desconocida en categorias");
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                break;
        }
        
    
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        // LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    private void saveCategory(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        String title = request.getParameter("title");
        String name_file = null;

        categoryDAO c = new categoryDAO();

        final String ruta = "C:\\Users\\Ismael\\Documents\\NetBeansProjects\\Blog\\web\\services\\image_categories";
        final Part image = request.getPart("image");
        name_file = getFileName(image);
        OutputStream salida = null;
        InputStream contenido = null;

        File folder2 = new File(ruta);
        if(!folder2.isDirectory()) {
            folder2.mkdirs();
        }

        try {
            salida = new FileOutputStream(new File(ruta + File.separator + name_file));
            contenido = image.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while((read = contenido.read(bytes)) != -1) {
                salida.write(bytes, 0 , read);
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Ocurrio un error al guardar la imagen de la categoria, err: "+fne);
        } finally {
            if (salida != null) {
                salida.close();
            }
            if (contenido != null) {
                contenido.close();
            }
        }

        c.insertCategory(title, name_file);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    
    private void modCategory(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        
        System.out.print(id);
        System.out.print(title);
        
        String name_file = null;

        categoryDAO c = new categoryDAO();

        final String ruta = "C:\\Users\\Ismael\\Documents\\NetBeansProjects\\Blog\\web\\services\\image_categories";
        final Part image = request.getPart("image");
        name_file = getFileName(image);
        OutputStream salida = null;
        InputStream contenido = null;

        File folder2 = new File(ruta);
        if(!folder2.isDirectory()) {
            folder2.mkdirs();
        }

        try {
            salida = new FileOutputStream(new File(ruta + File.separator + name_file));
            contenido = image.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while((read = contenido.read(bytes)) != -1) {
                salida.write(bytes, 0 , read);
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Ocurrio un error al guardar la imagen de la categoria, err: "+fne);
        } finally {
            if (salida != null) {
                salida.close();
            }
            if (contenido != null) {
                contenido.close();
            }
        }

        c.updateCategories(id,name_file,title);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    
    private void deleteCategory(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        categoryDAO c = new categoryDAO();
        
        c.deleteCategory(id);
        
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    
}
