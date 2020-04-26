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

/**
 *
 * @author Ismael
 */
public class userDAO {
    
    public Boolean validarUsuario(String email, String password) {
        Boolean status = false;
        Connection con = connection.con();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            String sql = "SELECT * FROM users \n" +
                "WHERE email = ? AND password = ? ";
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                // System.out.println("Query: \n" + ps.toString());
                rs = ps.executeQuery();
                if (rs.next()) {
                    status = true;
                }
            } catch (SQLException e) {
                System.out.println("ERROR validando usuario: " + e.getSQLState() + ": " + e.getMessage());
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    ps = null;
                    rs = null;
                    con.close();
                } catch (SQLException ee) {
                    System.out.println("ERROR SQL: " + ee.getSQLState() + ee.getMessage());
                }
            }
        } else {
            System.out.println("ERROR SQL: Conexión nula");
        }
        return status;
    }
}
