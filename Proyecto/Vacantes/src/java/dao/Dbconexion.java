package dao;

import java.sql.*;

/**
 *
 * @author Daniel
 */
public class Dbconexion {

    /*Constantes de instancia de la clase
    Se declaran constantes, porque van a ser siempre los mismos valores
    cada vez que se vaya a crear un objeto de tipo DbConnection
     */
 /*
    static String bd = "sistemadb";
    static String login = "root";
//En mi caso la contraseña que instale por default en MySQL Workbench fue: sqlquimia, en el mayor de los casos es: admin (ajusta este parámetro)
    static String password = "616263646566676869";
    //static String url = "jdbc:mysql://localhost/" + bd;
     static String url = "jdbc:mysql://localhost:3306/"+bd+"?useSSL=false";
    //static String url = "jdbc:mysql://localhost/" + bd;
    //Esta variable va a guardar la conexión
    Connection conn = null;
     */
    public static final String url = "jdbc:mysql://localhost:3306/sistemadb";
    public static final String usuario = "root";
    public static final String contraseña = "616263646566676869";

    public Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL: " + e.getMessage());
        }
        return conexion;
    }

    /*
    //Quitamos de memoria la conexión
    public void disconnect() {
        System.out.println("Closing database: [" + conn + "] OK");
        if (conn != null) {
            try {
                System.out.println("Desconectado de " + bd + " OK");
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
*/
}
