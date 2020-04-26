/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.newsDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
@WebServlet(name = "News", urlPatterns = {"/News"})
@MultipartConfig
public class News extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("post.jsp").forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        
        switch(action){
            case "cancelar":
                request.getRequestDispatcher("admin.jsp").forward(request, response);
                break;
            case "registrar":
                saveNews(request,response);
                break;
            case "modificar":
                request.getRequestDispatcher("news-mod.jsp").forward(request, response);
                break;
            case "actualizar":
                modNews(request, response);
                break;
            case "eliminar":
                deleteNews(request, response);
                break;
            default:   
                System.out.println("Accion desconocida en noticias");
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
    
    private void saveNews(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        
        String title = request.getParameter("title");
        int idCategory = Integer.parseInt(request.getParameter("id_category"));
        String text = request.getParameter("text");
        String name_file = null;

        newsDAO n = new newsDAO();

        final String ruta = "C:\\Users\\Ismael\\Documents\\NetBeansProjects\\Blog\\web\\services\\image_news";
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

        n.insertNews(idCategory, title, name_file, text);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    
    private void modNews(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int idCategory = Integer.parseInt(request.getParameter("id_category"));
        String text = request.getParameter("text");
        
        /*
        System.out.print(id);
        System.out.print(title);
        */
        String name_file = null;

        newsDAO n = new newsDAO();

        final String ruta = "C:\\Users\\Ismael\\Documents\\NetBeansProjects\\Blog\\web\\services\\image_news";
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

        n.updateNews(id, idCategory, title, name_file, text);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    
    private void deleteNews(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        
         newsDAO n = new newsDAO();
        
        n.deleteCategory(id);
        
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
