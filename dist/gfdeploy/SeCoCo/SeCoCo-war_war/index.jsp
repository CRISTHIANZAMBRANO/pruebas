<%-- 
    Document   : index
    Created on : 1/10/2020, 12:56:45 PM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form action="./UsuarioServlet" method="POST">
            <table>
                <tr>
                    <td>Cedula</td>
                    <td><input type="text" name="cedula" value="${usuarios.cedula}" /></td>
                </tr>
                <tr>
                    <td> Nombre</td>
                    <td><input type="text" name="nombre" value="${usuarios.nombre}" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" value="${usuarios.apellido}" /></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input type="text" name="correo" value="${usuarios.correo}" /></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="text" name="clave" value="${usuarios.clave}" /></td>
                </tr>
                <tr>
                    <td colspan="2"> 
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />

                    </td>
                </tr>
            </table>
        </form>

        <br>
        <table border="1">
            <th>Cedula</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo</th>
             <th>Clave</th>
                <c:forEach  items="${allUsuarios}" var="stud">
                <tr>
                    <td>${stud.cedula}</td>
                    <td>${stud.nombre}</td>
                    <td>${stud.apellido}</td>
                    <td>${stud.correo}</td>
                    <td>${stud.clave}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>