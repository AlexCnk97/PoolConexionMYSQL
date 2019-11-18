<%-- 
    Document   : index
    Created on : 11-18-2019, 04:39:58 PM
    Author     : cnk
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Usuario.Usuario"%>
<%@page import="operaciones.Operaciones"%>
<%@page import="conexion.Pool"%>
<%
    Pool pool = new Pool();
    pool.Conectar();
    
    Operaciones.abrirConexion(pool);
    
    
    Operaciones.iniciarTransaccion();
    ArrayList<Usuario> list = Operaciones.getTodos(new Usuario());
    Operaciones.commit();
    list.get(0).getNombreUsuario();

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=list.get(0).getNombreUsuario()%></title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
    </body>
</html>
