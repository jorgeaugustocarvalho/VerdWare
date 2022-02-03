/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MicroAgricultor;
import model.Tarefa;

/**
 *
 * @author javgc
 */
public class TarefaDAO {
    
    private Connection conexao;
    
    public TarefaDAO(){
        try{
            conexao = ConnectionFactory.criaConexao();
        }catch(Exception e){
            System.out.println("Erro de criação de DAO");
            e.printStackTrace();
        }
    }
    
    public void adicionarTarefa(Tarefa tarefa){
        String insert = "insert into tarefas (horario, planta_id, tipo_cuidado) values (?, ?, ?)";
        
        try{
            PreparedStatement pst = conexao.prepareStatement(insert);
            
            pst.setDate(1, tarefa.getHorario());
            pst.setInt(2, tarefa.getPlantaId());
            pst.setString(3, tarefa.getTipoDeCuidado());
            pst.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Tarefa> listarTarefas(){
        ArrayList<Tarefa> resultado = new ArrayList<>();
            
        String sql = "select * from tarefas";
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setHorario(rs.getDate("horario"));
                tarefa.setPlantaId(rs.getInt("plantaId"));
                tarefa.setTipoDeCuidado(rs.getString("tipoDeCuidado"));
                resultado.add(tarefa);
            }
        }catch(SQLException e){
            System.out.println("Erro de Sql: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public void deletarTarefas(Tarefa tarefa){
        String delete = "delete from tarefas where id=?";
        try{
            PreparedStatement pst = conexao.prepareStatement(delete);
            pst.setInt(1, tarefa.getId());
            pst.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void atualizarTarefas(Tarefa tarefa){
        String update = "update tarefas set horario=?, planta_id=?, tipo_cuidado=? where id=?";
        try{
            PreparedStatement pst = conexao.prepareStatement(update);
            pst.setDate(1, tarefa.getHorario());
            pst.setInt(2, tarefa.getPlantaId());
            pst.setString(3, tarefa.getTipoDeCuidado());
            pst.setInt(4, tarefa.getId());
            
            pst.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void selecionarTarefas(Tarefa tarefa){
        String read = "select * from tarefa where id=?";
        try{
            PreparedStatement pst = conexao.prepareStatement(read);
            pst.setInt(1, tarefa.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                tarefa.setId(rs.getInt(1));
                tarefa.setHorario(rs.getDate(2));
                tarefa.setPlantaId(rs.getInt(3));
                tarefa.setTipoDeCuidado(rs.getString(4));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
