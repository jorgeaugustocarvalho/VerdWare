/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PlantaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Planta;

/**
 *
 * @author javgc
 */
@WebServlet(name = "PlantaController", urlPatterns = {"/PlantaController", "/ListaPlanta", "/AdicionaPlanta", "/DeletaPlanta", "/AtualizaPlanta", "/SelecionaPlanta"})
public class PlantaController extends HttpServlet {

    Planta planta = new Planta();
    PlantaDAO plantadao = new PlantaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  action = request.getServletPath();
        System.out.println(action);
        if(action.equals("/ListaPlanta")) {
            listaPlanta(request, response);
        }else if(action.equals("/SelecionaPlanta")){
            selecionaPlanta(request, response);
        }else if(action.equals("/DeletaPlanta")){
            deletaPlanta(request, response);
        }else if(action.equals("/AtualizaPlanta")){
            atualizaPlanta(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        if(action.equals("/AdicionaPlanta")){
            adicionaPlanta(request, response);
        } 
    }

    protected void listaPlanta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ArrayList<Planta> resultado = plantadao.listarPlantas();

        request.setAttribute("planta", resultado);

        RequestDispatcher rd = request.getRequestDispatcher("/listaDePlantas.jsp");
        rd.forward(request, response);
    }
    
    protected void adicionaPlanta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        planta.setNome(request.getParameter("nome"));
        planta.setDataPlantio(Date.valueOf(request.getParameter("dataPlantio")));
        planta.setTipoPlanta(request.getParameter("tipoPlanta"));
        planta.setStatus(request.getParameter("status"));
        
        plantadao.registrarPlanta(planta);
        response.sendRedirect("listaDePlantas.jsp");
        
    }
    
    protected void deletaPlanta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPlanta = Integer.parseInt(request.getParameter("id"));
        planta.setId(idPlanta);
        plantadao.deletarPlantas(planta);
        response.sendRedirect("ListaPlanta");
    }
    
    protected void selecionaPlanta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int idPlanta = Integer.parseInt(request.getParameter("id"));
        planta.setId(idPlanta);
        
        plantadao.selecionarPlanta(planta);
        request.setAttribute("id", planta.getId());
        request.setAttribute("nome", planta.getNome());
        request.setAttribute("dataPlantio", planta.getDataPlantio());
        request.setAttribute("tipoPlanta", planta.getTipoPlanta());
        request.setAttribute("status", planta.getStatus());
        
        RequestDispatcher rd = request.getRequestDispatcher("/atualizaPlantas.jsp");
        rd.forward(request, response);
    }
    
    protected void atualizaPlanta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPlanta = Integer.parseInt(request.getParameter("id"));
        planta.setId(idPlanta);
        planta.setNome(request.getParameter("nome"));
        planta.setDataPlantio(Date.valueOf(request.getParameter("dataPlantio")));
        planta.setTipoPlanta(request.getParameter("tipoPlanta"));
        planta.setStatus(request.getParameter("status"));
        
        plantadao.atualizarPlantas(planta);
        response.sendRedirect("ListaPlanta");
    }
}
