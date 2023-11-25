/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.aulas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
public class NewPruebaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("EJECUTANDO METODO GET");
        // la variable request tiene encapsulada toda la información de los parametros enviados
        
        // obteniendo datos de la vista al controlador
        String parametro1 = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        System.out.println("Nombre: " + parametro1 + "\nEdad " + edad);
        
        // compartiendo datos del controlador a la vista
        // colocas el nombre del parametro a compartir y el valor
        request.setAttribute(parametro1, "VALOR X");
        // lo que va en la vista necesita codigo de jsp
        
    }
    
    /**
     * UN PARAMETRO DE SESION ES ACCESIBLE DESDE CUALQUIER PANTALLA DE LA VISTA - CONTROLADOR
     * va a estar disponible hasta que se cierre la sesión.
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("EJECUTANDO METODO POST");
        String parametro1_ = request.getParameter("apellido");
        String curp_ = request.getParameter("curp");
        System.out.println("Apellido: " + parametro1_ + "\nCurp " + curp_);
        
        // PARAMETRO DE SESION
        HttpSession session = request.getSession();
        session.setAttribute("parametroNew", "texto");
        String ses = (String) session.getAttribute("parametroNew");
        System.out.println("SES: "+ ses);
    }

}
