<%-- 
    Document   : menu
    Created on : 03/02/2022, 00:51:15
    Author     : javgc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login VerdWare</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/styles2.css" rel="stylesheet" />
  </head>
  <body>
    <div class="container">
      <div class="loginBox">
        <div class="logo-vector">
          <h2 class="logo-titulo tracking-in-expand-fwd">VerdWare</h2>
          <div class="vector"></div>
          <button class="btn-add"><a href="ListaPlanta">Minhas plantas</a></button>
          <button class="btn-add"><a href="ListaTarefa">Minhas tarefas</a></button>
          <button class="btn-add"><a href="cadastraPlantas.jsp">Adicionar planta</a></button>
          <button class="btn-add"><a href="cadastraTarefas.jsp">Adicionar tarefa</a></button>
        </div>
        <div class="login">
          <h2 class="titulo-perfil">Meu perfil</h2>
          <img class="img-perfil" src="image/undraw_flowers_vx06.png" />
          <h1 class="subtitulo-perfil">Toninho123</h1>
          <h1 class="subtitulo-perfil">toninho@gmail.com</h1>
        </div>
      </div>
    </div>
  </body>
</html>
