/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.news;

/**
 *
 * @author Ismael
 */
public class newsDAO {
    
    public static ArrayList <news> toListNews(){
        
        Connection con = connection.con();
        ArrayList <news> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query =  "SELECT \n" +
                                "   news.id, category.title as category, news.id_category, \n" +
                                "   news.title, news.content_image, \n" +
                                "   news.content_text, news.post_date, news.views \n" +
                                "FROM news \n" +
                                "JOIN category on category.id = news.id_category \n"+ 
                                "ORDER BY news.post_date DESC";
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                news n;
                
                while(rs.next()){
                    n = new news();
                    n.setId(rs.getInt("id"));
                    n.setTitle(rs.getString("title"));
                    n.setCategory_title(rs.getString("category"));
                    n.setId_category(rs.getInt("id_category"));
                    n.setContent_image(rs.getString("content_image"));
                    n.setContent_text(rs.getString("content_text"));
                    n.setPost_date(rs.getString("post_date"));
                    n.setViews(rs.getInt("views"));
                    list.add(n);
                }
            }catch(SQLException e){
                System.out.println("Error al listar las noticias, error: "+e.getLocalizedMessage());
            }finally{
                try{
                    con.close();
                }catch(SQLException ee){
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        
        return list;
        
    }
    
    public static ArrayList <news> toListNewsCategory(int id){
        
        Connection con = connection.con();
        ArrayList <news> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query =  "SELECT \n" +
                                "   news.id, category.title as category, \n" +
                                "   news.title, news.content_image, \n" +
                                "   news.content_text, news.post_date, news.views \n" +
                                "FROM news \n" +
                                "JOIN category on category.id = news.id_category \n"+
                                "AND category.id = "+ id+"\n"+
                                "ORDER BY news.post_date DESC";
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                news n;
                
                while(rs.next()){
                    n = new news();
                    n.setId(rs.getInt("id"));
                    n.setTitle(rs.getString("title"));
                    n.setCategory_title(rs.getString("category"));
                    n.setContent_image(rs.getString("content_image"));
                    n.setContent_text(rs.getString("content_text"));
                    n.setPost_date(rs.getString("post_date"));
                    n.setViews(rs.getInt("views"));
                    list.add(n);
                }
            }catch(SQLException e){
                System.out.println("Error al listar las noticias, error: "+e.getLocalizedMessage());
            }finally{
                try{
                    con.close();
                }catch(SQLException ee){
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        
        return list;
        
    }
    
    public static ArrayList<news> toListNewsTop(){
        Connection con = connection.con();
        ArrayList <news> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query =  "SELECT \n" +
                                "   news.id, category.title as category,news.views, \n" +
                                "   news.title, news.content_image, \n" +
                                "   news.content_text, news.post_date\n" +
                                "FROM news \n" +
                                "JOIN category on category.id = news.id_category\n" +
                                "ORDER BY news.views DESC\n" +
                                "LIMIT 4; ";
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                news n;
                
                while(rs.next()){
                    n = new news();
                    n.setId(rs.getInt("id"));
                    n.setTitle(rs.getString("title"));
                    n.setCategory_title(rs.getString("category"));
                    n.setContent_image(rs.getString("content_image"));
                    n.setContent_text(rs.getString("content_text"));
                    n.setPost_date(rs.getString("post_date"));
                    n.setViews(rs.getInt("views"));
                    list.add(n);
                }
            }catch(SQLException e){
                System.out.println("Error al listar las noticias top, error: "+e.getLocalizedMessage());
            }finally{
                try{
                    con.close();
                }catch(SQLException ee){
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        
        return list;
        
    }
    
    public static ArrayList<news> toListNewsAside(){
        Connection con = connection.con();
        ArrayList <news> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query =  "SELECT \n" +
                                "   news.id, category.title as category,news.views, \n" +
                                "   news.title, news.content_image, \n" +
                                "   news.content_text, news.post_date\n" +
                                "FROM news \n" +
                                "JOIN category on category.id = news.id_category\n" +
                                "ORDER BY news.views DESC\n" +
                                "LIMIT 10; ";
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                news n;
                
                while(rs.next()){
                    n = new news();
                    n.setId(rs.getInt("id"));
                    n.setTitle(rs.getString("title"));
                    n.setCategory_title(rs.getString("category"));
                    n.setContent_image(rs.getString("content_image"));
                    n.setContent_text(rs.getString("content_text"));
                    n.setPost_date(rs.getString("post_date"));
                    n.setViews(rs.getInt("views"));
                    list.add(n);
                }
            }catch(SQLException e){
                System.out.println("Error al listar las noticias mas relevantes, error: "+e.getLocalizedMessage());
            }finally{
                try{
                    con.close();
                }catch(SQLException ee){
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        
        return list;
        
    }
    
    public static ArrayList<news> showNews(int id){
        Connection con = connection.con();
        ArrayList <news> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query =  "SELECT \n" +
                                "   news.id, category.title as category, \n" +
                                "   news.title, news.content_image, \n" +
                                "   news.content_text, news.post_date, news.views \n" +
                                "FROM news \n" +
                                "JOIN category on category.id = news.id_category\n" +
                                "AND news.id = "+ id +"";
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                news n;
                
                while(rs.next()){
                    n = new news();
                    n.setId(rs.getInt("id"));
                    n.setTitle(rs.getString("title"));
                    n.setCategory_title(rs.getString("category"));
                    n.setContent_image(rs.getString("content_image"));
                    n.setContent_text(rs.getString("content_text"));
                    n.setPost_date(rs.getString("post_date"));
                    n.setViews(rs.getInt("views"));
                    list.add(n);
                }
            }catch(SQLException e){
                System.out.println("Error al listar las noticias top, error: "+e.getLocalizedMessage());
            }finally{
                try{
                    con.close();
                }catch(SQLException ee){
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        
        return list;
        
    }
    
    public static ArrayList<news> searchNew(String search){
        Connection con = connection.con();
        ArrayList <news> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query =  "SELECT \n" +
                                "   news.id, category.title as category,news.views, \n" +
                                "   news.title, news.content_image, \n" +
                                "   news.content_text, news.post_date\n" +
                                "FROM news \n" +
                                "JOIN category on category.id = news.id_category\n" +
                                "AND news.title LIKE '%"+ search +"%'\n" +
                                "ORDER BY news.post_date DESC";
                                
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                news n;
                
                while(rs.next()){
                    n = new news();
                    n.setId(rs.getInt("id"));
                    n.setTitle(rs.getString("title"));
                    n.setCategory_title(rs.getString("category"));
                    n.setContent_image(rs.getString("content_image"));
                    n.setContent_text(rs.getString("content_text"));
                    n.setPost_date(rs.getString("post_date"));
                    n.setViews(rs.getInt("views"));
                    list.add(n);
                }
            }catch(SQLException e){
                System.out.println("Error al listar las noticias top, error: "+e.getLocalizedMessage());
            }finally{
                try{
                    con.close();
                }catch(SQLException ee){
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        
        return list;
        
    }
    
    public void updateNews(int id,int idCategory,String title, String image, String text){
        Connection con = connection.con();
        
        if(con ==  null){
            con = connection.con();    
        }
        if(con != null){
            try{
                String SQL = "UPDATE news SET "
                        +   "id_category = ?,"
                        +   "title = ? ,"
                        +   "content_image = ? ,"
                        +   "content_text = ? "
                        +   "WHERE news.id = ?";
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(5, id);
                ps.setInt(1, idCategory);
                ps.setString(2, title);
                ps.setString(3, image);
                ps.setString(4, text);

                ps.executeUpdate();

            }catch(SQLException e){
                System.out.println("Error al actualizar la noticia, error: "+e.getLocalizedMessage());
            }finally {
                try {
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
    }
    
    public void insertNews(int idCategory,String title, String image, String text){
        Connection con = connection.con();
        if(con == null ){
           con = connection.con();
        }
        if(con != null){
            try {
            String SQL = "INSERT INTO news(id_category,title,content_image,content_text,post_date)"
                    + " values (?,?,?,?,now());";
            PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(1, idCategory);
                ps.setString(2, title);
                ps.setString(3, image);
                ps.setString(4, text);
            
            ps.executeUpdate();
            } catch (SQLException ex) {
                 System.out.println("Error al insertar nueva noticia, error: "+ex.getLocalizedMessage());
            }finally {
                try {
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
    }
    
    public void deleteCategory(int id){
        Connection con = connection.con();
        if(con == null ){
           con = connection.con();
        }
        if(con != null){
            try {
            String SQL = "DELETE FROM news WHERE news.id = " + id +"; ";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();
            } catch (SQLException ex) {
                 System.out.println("Error al eliminar la noticia, error: "+ex.getLocalizedMessage());
            }finally {
                try {
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
    }
    
    public void updateView(int id,int views){
        Connection con = connection.con();
        
        if(con ==  null){
            con = connection.con();    
        }
        if(con != null){
            try{
                String SQL = "UPDATE news SET "
                        +   "views = ? "
                        +   "WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(2, id);
                ps.setInt(1, views);

                ps.executeUpdate();

            }catch(SQLException e){
                System.out.println("Error al actualizar las vistas de la noticia, error: "+e.getLocalizedMessage());
            }finally {
                try {
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
    }
    
}
