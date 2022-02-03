<%-- 
    Document   : listaDeTarefas
    Created on : 03/02/2022, 00:00:38
    Author     : javgc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Tarefa"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    ArrayList<Tarefa> lista = (ArrayList<Tarefa>) request.getAttribute("tarefa");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/styles.css" rel="stylesheet">
    </head>
    <body>
        <h1>Lista de Tarefas</h1>
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Horário</th>
                <th>plantaId</th>
                <th>Tipo de Cuidado</th>
                <th>Edição</th>
                <th>Deletar</th>
            </tr>
            <%
                for (int i = 0; i < lista.size(); i++){
                    
            %>
            <tr>
                <td><span><%=lista.get(i).getId()%></span></td>
                <td><span><%=lista.get(i).getHorario()%></span></td>
                <td><span><%=lista.get(i).getPlantaId()%></span></td>
                <td><span><%=lista.get(i).getTipoDeCuidado()%></span></td>
                <td><span><a href="SelecionaTarefa?id=<%=lista.get(i).getId()%>"<button class="btn btn-success">Editar</button></a></span></td>
                <td><span><a href="DeletaTarefa?id=<%=lista.get(i).getId()%>" <button class="btn btn-danger">Excluir</button></span></td>
            </tr>
            <%
                }
            %>
           
        </table>
        <button class="btn btn-dark btn-block"><a href="menu.jsp">Voltar para o menu</a></button>
    </body>
</html>