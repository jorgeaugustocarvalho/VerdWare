<%-- 
    Document   : index
    Created on : 02/02/2022, 23:35:41
    Author     : javgc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro MicroAgricultor</title>
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/styles.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="loginBox" >
                <div class="logo-vector">
                    <h2 class="logo-titulo tracking-in-expand-fwd">VerdWare</h2>
                    <div class="vector">
                        <img class="img" src="./image/undraw_environment_iaus.png">
                    </div>

                    <p class="frase">O app para os fanáticos de plantas ;)!</p>
                </div>
                <div class="login">
                    <h2 class="titulo">Registro</h2>
                    <form class="form" method="post" action="RegistroMicroAgricultor">
                        <input type="hidden" name="id" >
                        <div class="input">
                            <input class="input-text" type="text" placeholder="Insira seu nome" name="nome">
                        </div>
                        <div class="input">
                            <input class="input-text" type="text" placeholder="Insira seu login(nome de usuário)" name="login">
                        </div>
                        <div class="input">
                            <input class="input-text" type="text" placeholder="Insira seu email" name="email">
                        </div>
                        <div class="input">
                            <input class="input-text" type="password" placeholder="Insira sua senha" name="senha">
                        </div>
                        <div class = "d-flex justify-content-center">
                            <button class="btn btn-success" type="submit" data-dismiss="modal">Entrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
