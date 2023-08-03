package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoginBean;

public class Login extends HttpServlet {

   // 2. El controller recibibe la petición de tipo POST.
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // 3. Se reciben o validan los datos enviados por el usuario 
      String name = request.getParameter("name");
      String password = request.getParameter("password");

      LoginBean bean = new LoginBean(name, password);
      // 4. Realizamos la logica de negocio (procesar datos)
      boolean status = bean.validate();

      // 5. Compartimos el objeto, para poder usarlo en la vista (JSP)
      request.setAttribute("user", bean);
      
      // 6. Dependiendo de nuestra lógica, redireccionamos (enviamos una respuesta)
      if (status) {
         RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
         rd.forward(request, response);
      } else {
         RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
         rd.forward(request, response);
      }
   }

}
