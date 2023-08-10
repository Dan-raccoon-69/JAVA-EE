package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vacantes;

/**
 *
 * @author Daniel
 */
public class VacanteDao {

    public static final String url = "jdbc:mysql://localhost:3306/sistemadb";
    public static final String usuario = "root";
    public static final String contraseña = "616263646566676869";

    PreparedStatement ps;

    public boolean insertar(Vacantes vacante) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "insert into vacante values(?,?,?,?,?)";
        try {
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, vacante.getId());
            ps.setString(2, formato.format(vacante.getFechaPublicacion()));
            ps.setString(3, vacante.getNombre());
            ps.setString(4, vacante.getDescripcion());
            ps.setString(5, vacante.getDetalle());
            // ExecuteUpdate se utiliza para insertar, eliminar o modificar
            int r = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public List<Vacantes> obtener3Ultimas() {
        try {
            Connection conn = getConnection();
            String sql = "select * from vacante order by id desc limit 3";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Vacantes> list = new LinkedList<>();
            Vacantes vacante;
            while (rs.next()) {
                vacante = new Vacantes(rs.getInt("id"));
                vacante.setNombre(rs.getString("nombre"));
                vacante.setDescripcion(rs.getString("descripcion"));
                vacante.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                vacante.setDetalle(rs.getString("detalle"));
                list.add(vacante);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }
}
