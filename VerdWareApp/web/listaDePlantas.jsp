<%-- 
    Document   : listaDePlantas
    Created on : 02/02/2022, 23:19:14
    Author     : javgc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Planta"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    ArrayList<Planta> lista = (ArrayList<Planta>) request.getAttribute("planta");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de plantas</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/styles.css" rel="stylesheet">
    </head>
    <body>
        <h1>Lista de Plantas</h1>
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Data Plantio</th>
                <th>Tipo planta</th>
                <th>Status</th>
                <th>Edição</th>
                <th>Deletar</th>
            </tr>
            <%
                for (int i = 0; i < lista.size(); i++){
                    
            %>
            <tr>
                <td><span><%=lista.get(i).getId()%></span></td>
                <td><span><%=lista.get(i).getNome()%></span></td>
                <td><span><%=lista.get(i).getDataPlantio()%></span></td>
                <td><span><%=lista.get(i).getTipoPlanta()%></span></td>
                <td><span><%=lista.get(i).getStatus()%></span></td>
                <td><span><a href="SelecionaPlanta?id=<%=lista.get(i).getId()%>"<button class="btn btn-success">Editar</button></a></span></td>
                <td><span><a href="DeletaPlanta?id=<%=lista.get(i).getId()%>" <button class="btn btn-danger">Excluir</button></span></td>
            </tr>
            <%
                }
            %>
           
        </table>
        <button class="btn btn-dark btn-block"><a href="menu.jsp">Voltar para o menu</a></button>
    </body>
</html>