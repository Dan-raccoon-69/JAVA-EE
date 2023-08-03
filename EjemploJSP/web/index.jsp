<%-- 
    Document   : index
    Created on : 3 ago 2023, 11:00:14
    Author     : Daniel
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<String> lista = new ArrayList<>();
            lista.add("Laptop");
            lista.add("Bocina");
            lista.add("Monitor");
            lista.add("Teclado");
            lista.add("Mouse");
        %>
        <select>
            <%
                for (String string : lista) {
                    out.println("<option>" + string + "</option>");
                }
            %>
        </select>
    </body>
</html>
