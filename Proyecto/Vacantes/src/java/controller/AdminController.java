/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UsuarioDao;
import dao.VacanteDao;
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
        } else {
            mensaje = "Usuario y/o Contraseña incorrectos";
            request.setAttribute("mensaje", mensaje);
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

    }

    private void eliminarVacante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // se recibe el id de la vacante que vamos a eliminar
        int idVacante = Integer.parseInt(request.getParameter("idVacante"));
        VacanteDao vac = new VacanteDao();
        int respuesta = vac.borrarVacante(idVacante);
        String mensaje = "";
        if (respuesta == 1) {
            mensaje = "La vacante fue eliminada correctamente.";
        } else {
            mensaje = "La vacante no fue eliminada correctamente.";
        }
        request.setAttribute("mensaje", mensaje);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        // se recupera la session activa que viene junto con el request
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String mensaje = "";

        switch (action) {
            case "login":
                // si no hay usuario, osea null, se va a dirigir hacia el login
                if (session.getAttribute("u1") == null) {
                    request.setAttribute("mensaje", mensaje);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    // significa que si hay un usuario y simplmente se redirige a admin.jsp
                    rd = request.getRequestDispatcher("/admin.jsp");
                    rd.forward(request, response);
                }
                break;
            case "logout":
                // Salir, cerramos la session
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/homePage");
                break;
            case "crear":
                // si no hay usuario, osea null, se va a dirigir hacia el login
                if (session.getAttribute("u1") == null) {
                    mensaje = "Acceso Denegado.";
                    request.setAttribute("mensaje", mensaje);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    // significa que si hay un usuario y simplmente se redirige al formulario para crear la vacante
                    rd = request.getRequestDispatcher("/frmvacantes.jsp");
                    rd.forward(request, response);
                }
                break;
            case "eliminar":
                if (session.getAttribute("u1") == null) {
                    mensaje = "Acceso Denegado.";
                    request.setAttribute("mensaje", mensaje);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    this.eliminarVacante(request, response);
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}
