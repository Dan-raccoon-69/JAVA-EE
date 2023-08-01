// ENVIAR Y RECIBIR PARAMETROS A UN JAVA SERVLET
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class Comentarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se reciben los parametros que se enviaron
        String name = request.getParameter("name");
        String perfil = request.getParameter("perfil");
        String id = request.getParameter("id");

        // manipulacion de los parametros
        System.out.println("\nNombre: " + name);
        System.out.println("Perfil: " + perfil);
        System.out.println("Id: " + id);

        // Respuesta al cliente, en este caso es un documento HTML (texto)
        if (perfil.equals("admin")) { 
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<head>");
                out.println("<title>Comentarios</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3>Acceso concedido</h3>");
                out.println("</body>");
                out.println("</html>");
            }
        } else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
    // http://localhost:8080/servlet/comentarios?name=daniel&perfil=admin&id=4852
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se reciben los parametros que se enviaron
        String nombreParam = request.getParameter("nombre");
        String emailParam = request.getParameter("email");
        String gradoParam = request.getParameter("grado");
        String comentariosParam = request.getParameter("comentarios");

        // manipulacion de los parametros
        System.out.println("\nNombre: " + nombreParam);
        System.out.println("E-mail: " + emailParam);
        System.out.println("Grado: " + gradoParam);
        System.out.println("Comentarios: " + comentariosParam);

        // Respuesta al cliente, en este caso es un documento HTML (texto)
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<head>");
                out.println("<title>Comentarios</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3> Gracias por tus comentarios " + nombreParam + "</h3>");
                out.println("<h4> En breve nos comunicaremos contigo. </h4>");
                out.println("</body>");
                out.println("</html>");
            }
    }
}
