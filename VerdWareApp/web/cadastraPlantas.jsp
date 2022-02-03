<%-- 
    Document   : cadastraPlantas
    Created on : 02/02/2022, 23:37:48
    Author     : javgc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/styles.css" rel="stylesheet" />
    <title>Registro de plantas</title>
  </head>
  <body class="formulario">
    <div class="form tabela col-md-8">
      <div class="cabecalho">
        <h2 class="cadastro">Registro de Plantas</h2>
      </div>
      <form class="form-entrada" method="POST" name="AdicionaPlanta">
        <div class="form-group">
          <input
            class="form-control"
            type="text"
            name="nome"
            placeholder="Nome da planta"
          />
        </div>
        <div class="form-group">
          <input
            class="form-control"
            type="date"
            name="dataPlantio"
            placeholder="Data do plantio"
          />
        </div>
        <div class="form-group">
          <input
            class="form-control"
            type="text"
            name="tipoPlanta"
            placeholder="Tipo de planta"
          />
        </div>
        <div class="form-group">
          <input
            class="form-control"
            type="text"
            name="status"
            placeholder="Status"
          />
        </div>
        <div class="btns">
          <button class="btn btn-form" type="submit">Save</button>
          <button class="btn btn-form mt-1"><a href="Login">Cancel</a></button>
        </div>
      </form>
    </div>
  </body>
</html>
