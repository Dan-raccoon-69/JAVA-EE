/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.VacanteDao;
import java.io.IOException;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action.equals("ver")) {
           this.verDetalles(request, response);
        }
        
        if (action.equals("vertodas")) {
           this.verTodasVacantes(request, response);
        }
        
    }
    
    protected void verDetalles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VacanteDao vac = new VacanteDao();
        Vacantes vacante = vac.getById(id);
        
        RequestDispatcher rd;
        // compartimos la variable msg, para poder acceder la vista con Expression Language
        request.setAttribute("vacante", vacante);
        // enviamos respuesta, se renderiza a la vista "mensaje.jsp"
        rd = request.getRequestDispatcher("/detalle.jsp");
        rd.forward(request, response);
    }
    
    protected void verTodasVacantes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Vacantes> todas = new LinkedList<>();
        VacanteDao vac = new VacanteDao();
        todas = vac.obtenerTodasLasVacantes();
        
         RequestDispatcher rd;
        // compartimos la variable ultimas, para poder acceder la vista con Expression Language
        request.setAttribute("todas", todas);
        // enviamos respuesta, se renderiza a la vista "index.jsp"
        rd = request.getRequestDispatcher("/vacantes.jsp");
        rd.forward(request, response);
    }
    
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
    }
}
