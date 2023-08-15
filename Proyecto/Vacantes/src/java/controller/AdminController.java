/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author Daniel
 */
public class AdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // recibiendo parametros
        String user = request.getParameter("user");
        String password = request.getParameter("pass");
        String mensaje = "";

        // Recuperamos una instancia del objeto HttpSession
        HttpSession session = request.getSession();
        UsuarioDao usuario = new UsuarioDao();
        // se verifica si existe un usuario con sus respectivos datos
        Usuario u1 = usuario.login(user, password);

        RequestDispatcher rd;
        if (u1.getId() > 0) {
            // creamos una variable de session, con el registro de usuario (Bean)
            session.setAttribute("u1", u1);
            rd = request.getRequestDispatcher("/admin.jsp");
            rd.forward(request, response);
        }else {
            mensaje = "Usuario y/o Contraseña incorrectos";
            request.setAttribute("mensaje", mensaje);
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

    }
}
