package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TablaHTML extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        El metodo response sirve para enviar la respuesta de la petición.
        Con el método setContentType especificamos el tipo de respuesta que sera
        enviada al Navegador de Internet.
         */
        response.setContentType("text/html;charset=UTF-8");
        /* 
        - El objeto tipo PrintWriter sirve para escribir la salida, en este caso
        al navegador de Internet.
        - Se puede decir que es equivalente a System.out.println().
        - Este objeto lo recuperamos del objecto response, que todos los Servlets
        reciben por default sin importar si la peticion es GET o POST
         */
        PrintWriter out = response.getWriter();
        // Con el objeto PrintWriter podemos escribir cualquier codigo HTML

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Catalogo de productos</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Catalogo de productos</h3>");
        out.println("<table border='1' style='width:100%;'>");
        out.println("<tr>");
        out.println("<th>Categoria</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Precio</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Electronica</td>");
        out.println("<td>Sterio Sony</td>");
        out.println("<td>$50</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Electronica</td>");
        out.println("<td>Pantalla LCD 30</td>");
        out.println("<td>94</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Telefonia</td>");
        out.println("<td>iPhone 6</td>");
        out.println("<td>$80</td>");
        out.println(" </tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

}
