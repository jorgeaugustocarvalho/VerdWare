<%-- 
    Document   : atualizaPlantas
    Created on : 02/02/2022, 23:29:58
    Author     : javgc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/styles.css" rel="stylesheet">
    <title>Plantas</title>
</head>
<body class='formulario'>
    <div class="form tabela col-md-8">
        <div class="cabecalho">
            <h4 class="cadastro">Editar Planta</h4>
        </div>
        <form class="form-entrada" name="formPlanta" action="AtualizaPlanta">
            <div class="form-group">
                <input class="form-control" type="text" name="id" readonly value="<%out.print(request.getAttribute("id"));%>">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>">
            </div>
            <div class="form-group">
                <input class="form-control" type="date" name="dataPlantio" value="<%out.print(request.getAttribute("dataPlantio"));%>">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="tipoPlanta" value="<%out.print(request.getAttribute("tipoPlanta"));%>">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="status" value="<%out.print(request.getAttribute("status"));%>">
            </div>
            <div class ="btns">
                <button class="btn btn-form" type="submit">Save</button>
                <button class="btn btn-form mt-1"><a href="menu.jsp">Cancel</a></button>
            </div>
        </form>
    </div>
</body>
</html>