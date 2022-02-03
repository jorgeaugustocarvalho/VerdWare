/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MicroAgricultorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MicroAgricultor;

/**
 *
 * @author javgc
 */
@WebServlet(name = "RegistroMicroAgricultor", urlPatterns = {"/RegistroMicroAgricultor"})
public class RegistroMicroAgricultor extends HttpServlet {

    MicroAgricultor microag = new MicroAgricultor();
    MicroAgricultorDAO microagdao = new MicroAgricultorDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/RegistroMicroAgricultor")){
            registro(request, response);
        }
    }
    
    protected void registro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        microag.setEmail(request.getParameter("email"));
        microag.setLogin(request.getParameter("login"));
        microag.setNome(request.getParameter("nome"));
        microag.setSenha(request.getParameter("senha"));
        
        microagdao.registrarMicroAgricultor(microag);
        response.sendRedirect("login.jsp");
        
    }

}
