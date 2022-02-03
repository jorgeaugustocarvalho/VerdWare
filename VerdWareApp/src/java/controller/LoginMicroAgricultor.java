/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MicroAgricultorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "LoginMicroAgricultor", urlPatterns = {"/LoginMicroAgricultor"})
public class LoginMicroAgricultor extends HttpServlet {
    
    MicroAgricultorDAO microagdao = new MicroAgricultorDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        for (MicroAgricultor microag : microagdao.listarMicroAgricultores()){
            if(email.equals(microag.getEmail()) && senha.equals(microag.getSenha())){
                RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
            }else{
                response.sendRedirect("loginAdmin.jsp");
            }
        }
    }

}
