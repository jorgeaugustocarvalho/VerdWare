/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TarefaDAO;
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
import model.Tarefa;

/**
 *
 * @author javgc
 */
@WebServlet(name = "TarefaController", urlPatterns = {"/TarefaController", "/ListaTarefa", "/DeletaTarefa", "/AtualizaTarefa", "/SelecionaTarefa", "/AdicionaTarefa"})
public class TarefaController extends HttpServlet {


    Tarefa tarefa = new Tarefa();
    TarefaDAO tarefadao = new TarefaDAO();
    
    public TarefaController(){
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/ListaTarefa")){
            listaTarefas(request, response);
        }else if(action.equals("/DeletaTarefa")){
            deletaTarefa(request, response);
        }else if(action.equals("/AtualizaTarefa")){
            atualizaTarefas(request, response);
        }else if(action.equals("/SelecionaTarefa")){
            selecionaTarefa(request, response);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/AdicionaTarefa")){
            salvaTarefas(request, response);
        }
    }
    
    protected void salvaTarefas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        tarefa.setHorario(Date.valueOf(request.getParameter("horario")));
        tarefa.setPlantaId(Integer.parseInt(request.getParameter("plantaId")));
        tarefa.setTipoDeCuidado(request.getParameter("tipoDeCuidado"));
        
        tarefadao.adicionarTarefa(tarefa);
        response.sendRedirect("listarTarefas.jsp");
        
    }
    
    protected void listaTarefas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        ArrayList<Tarefa> resultado = tarefadao.listarTarefas();
        
        request.setAttribute("tarefa", resultado);
        
        RequestDispatcher rd = request.getRequestDispatcher("listaDeTarefas.jsp");
        rd.forward(request, response);
    }

    protected void deletaTarefa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int idConta = Integer.parseInt(request.getParameter("id"));
        tarefa.setId(idConta);
        tarefadao.deletarTarefas(tarefa);
        response.sendRedirect("ListaTarefa");
    }
    
    protected void atualizaTarefas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idTarefa = Integer.parseInt(request.getParameter("id"));
        tarefa.setId(idTarefa);
        tarefa.setHorario(Date.valueOf(request.getParameter("horario")));
        tarefa.setPlantaId(Integer.parseInt(request.getParameter("plantaId")));
        tarefa.setTipoDeCuidado(request.getParameter("tipoDeCuidado"));
        
        tarefadao.atualizarTarefas(tarefa);
        response.sendRedirect("ListaConta");
    }
    
    protected void selecionaTarefa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int idTarefa = Integer.parseInt(request.getParameter("id"));
        tarefa.setId(idTarefa);
        
        tarefadao.selecionarTarefas(tarefa);
        request.setAttribute("id", tarefa.getId());
        request.setAttribute("horario", tarefa.getHorario());
        request.setAttribute("plantaId", tarefa.getPlantaId());
        request.setAttribute("tipoDeCuidado", tarefa.getTipoDeCuidado());
        
        RequestDispatcher rd = request.getRequestDispatcher("atualizaTarefas.jsp");
        rd.forward(request, response);
    }
}
