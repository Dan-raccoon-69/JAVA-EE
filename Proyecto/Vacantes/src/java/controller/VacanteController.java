/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.Dbconexion;
import dao.VacanteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vacantes;

/**
 *
 * @author Daniel
 */
public class VacanteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreParametro = request.getParameter("nombre");
        String descripcionParametro = request.getParameter("descripcion");
        String detalleParametro = request.getParameter("detalle");

        Vacantes vac1 = new Vacantes(0);
        vac1.setNombre(nombreParametro);
        vac1.setDescripcion(descripcionParametro);
        vac1.setDetalle(detalleParametro);

        System.out.println(vac1);

        VacanteDao vac = new VacanteDao();
        boolean resultado = vac.insertar(vac1);

        String mensaje = "";
        if (resultado) {
            mensaje = "La vacante fue guardada correctamente.";
        } else {
            mensaje = "Ocurrio un error, La vacante no fue grabada.";
        }
        RequestDispatcher rd;
        // compartimos la variable msg, para poder acceder la vista con Expression Language
        request.setAttribute("mensaje", mensaje);
        // enviamos respuesta, se renderiza a la vista "mensaje.jsp"
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
        
        List<Vacantes> list2 = new LinkedList<>();
        list2 = vac.obtener3Ultimas();
        for (Vacantes vacantes : list2) {
            System.out.println(vacantes);
        }
    }

}
