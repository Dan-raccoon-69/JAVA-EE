/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.VacanteDao;
import java.io.IOException;
import java.io.PrintWriter;
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
public class BuscarController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String VacanteAbuscar = request.getParameter("query");

        VacanteDao vac = new VacanteDao();
        List<Vacantes> todas = new LinkedList<>();
        todas = vac.buscar(VacanteAbuscar);

        RequestDispatcher rd;
        // compartimos la variable msg, para poder acceder la vista con Expression Language
        request.setAttribute("todas", todas);
        // enviamos respuesta, se renderiza a la vista "vacantes.jsp"
        rd = request.getRequestDispatcher("/vacantes.jsp");
        rd.forward(request, response);
    }

}
