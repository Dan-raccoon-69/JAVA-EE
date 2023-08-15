/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author Daniel
 */
public class UsuarioDao {
    public static final String url = "jdbc:mysql://localhost:3306/sistemadb";
    public static final String usuario = "root";
    public static final String contraseña = "616263646566676869";

    PreparedStatement ps;
    ResultSet rs;
    
    private Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }
    
    public Usuario login(String user, String pass){
        try {
            Connection conn = getConnection();
            String sql = "select * from usuario where username=? and password = md5(?) and estatus = 'activo' limit 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            Usuario usuario = new Usuario(0);
            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setEstatus(rs.getString("estatus"));
            }
            return usuario;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
}
