<%-- 
    Document   : atualizaTarefas
    Created on : 02/02/2022, 23:38:41
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
        <form class="form-entrada" name="formTarefa" action="AtualizaTarefa">
            <div class="form-group">
                <input class="form-control" type="text" name="id" readonly value="<%out.print(request.getAttribute("id"));%>">
            </div>
            <div class="form-group">
                <input class="form-control" type="datetime" name="horario" value="<%out.print(request.getAttribute("horario"));%>">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="plantaId" value="<%out.print(request.getAttribute("plantaId"));%>">
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="tipoCuidado" value="<%out.print(request.getAttribute("tipoCuidado"));%>">
            </div>
            <div class ="btns">
                <button class="btn btn-form" type="submit">Save</button>
                <button class="btn btn-form mt-1"><a href="menu.jsp">Cancel</a></button>
            </div>
        </form>
    </div>
</body>
</html>
