/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UsuarioDao;
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
import model.Usuario;
import model.Vacantes;

/**
 *
 * @author Daniel
 */
public class Homepage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // se guardan las 3 ultimas vacantes
        List<Vacantes> ultimas = new LinkedList<>();
        VacanteDao vac = new VacanteDao();
        ultimas = vac.obtener3Ultimas();
        
         RequestDispatcher rd;
        // compartimos la variable ultimas, para poder acceder la vista con Expression Language
        request.setAttribute("ultimas", ultimas);
        // enviamos respuesta, se renderiza a la vista "index.jsp"
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
