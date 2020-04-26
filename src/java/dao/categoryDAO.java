/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.category;
import control.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ismael
 */
public class categoryDAO {
    
    //list all categories
    public static ArrayList <category> accessToCategory(int id){
       
        Connection con = connection.con();
        ArrayList <category> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query = "SELECT * FROM category WHERE id = "+ id +"";
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                category c;
                
                while(rs.next()){
                    c = new category();
                    c.setId(rs.getInt("id"));
                    c.setImage(rs.getString("image"));
                    c.setTitle(rs.getString("title"));
                    list.add(c);
                }
                
            }catch(SQLException e){
                System.out.println("Error al listar la categoria, error: "+e.getLocalizedMessage());
            }finally{
                try {
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        return list;
    }
            
    
    public static ArrayList <category> toListCategories(){
       
        Connection con = connection.con();
        ArrayList <category> list = new ArrayList<>();
        
        if(con == null){
            con = connection.con();
        }
        if(con != null){
            try{
                String query = "SELECT * FROM category";
                
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                
                category c;
                
                while(rs.next()){
                    c = new category();
                    c.setId(rs.getInt("id"));
                    c.setTitle(rs.getString("title"));
                    c.setImage(rs.getString("image"));
                    list.add(c);
                }
                
            }catch(SQLException e){
                System.out.println("Error al listar las categorias en el menu, error: "+e.getLocalizedMessage());
            }finally{
                try {
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
        return list;
    }
    
    
    public void updateCategories(int id,String image,String title){
        Connection con = connection.con();
        
        if(con ==  null){
            con = connection.con();    
        }
        if(con != null){
            try{
                String SQL = "UPDATE category SET "
                        +   "image = ?,"
                        +   "title = ? "
                        +   "WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt(3, id);
                ps.setString(1, image);
                ps.setString(2, title);

                ps.executeUpdate();

            }catch(SQLException e){
                System.out.println("Error al actualizar la categoria, error: "+e.getLocalizedMessage());
            }finally {
                try {
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("SQL ERROR-2 " + ee.getSQLState() + ee.getMessage());
                }
            }
        }
    }
    
    public void insertCategory(String title, String image){
        Connection con = connection.con();
        if(con == null ){
           con = connection.con();
        }
        if(con != null){
            try {
            String SQL = "INSERT INTO category(title,image)"
                    + " values (?,?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, title);
            ps.setString(2, image);
            
            ps.executeUpdate();
            } catch (SQLException ex) {
                 System.out.println("Error al insertar categoria, error: "+ex.getLocalizedMessage());
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
            String SQL = "DELETE FROM category WHERE category.id = " + id +"; ";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();
            } catch (SQLException ex) {
                 System.out.println("Error al eliminar categoria, error: "+ex.getLocalizedMessage());
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
