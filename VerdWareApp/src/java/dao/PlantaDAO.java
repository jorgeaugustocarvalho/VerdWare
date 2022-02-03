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
import model.Planta;

/**
 *
 * @author javgc
 */
public class PlantaDAO {
    
    private Connection conexao;
    
    public PlantaDAO(){
        try{
            conexao = ConnectionFactory.criaConexao();
        }catch(Exception e){
            System.out.println("Erro de criação de DAO");
            e.printStackTrace();
        }
    }
    
    public void registrarPlanta(Planta planta){
        String insert = "insert into plantas (nome, data_plantio, tipo_planta, status) values (?, ?, ?, ?)";
        
        try{
            PreparedStatement pst = conexao.prepareStatement(insert);
            
            pst.setString(1, planta.getNome());
            pst.setDate(2, planta.getDataPlantio());
            pst.setString(3, planta.getTipoPlanta());
            pst.setString(4, planta.getStatus());
            
            pst.execute();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Planta> listarPlantas(){
        ArrayList<Planta> resultado = new ArrayList<>();
            
        String sql = "select * from plantas";
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                Planta planta = new Planta();
                planta.setId(rs.getInt("id"));
                planta.setNome(rs.getString("nome"));
                planta.setDataPlantio(rs.getDate("dataPlantio"));
                planta.setTipoPlanta(rs.getString("tipoPlanta"));
                planta.setStatus(rs.getString("status"));
                resultado.add(planta);
            }
        }catch(SQLException e){
            System.out.println("Erro de Sql: " + e.getMessage());
        }
        
        return resultado;
    }
    
    public void deletarPlantas(Planta planta){
        String delete = "delete from plantas where id=?";
        try{
            PreparedStatement pst = conexao.prepareStatement(delete);
            pst.setInt(1, planta.getId());
            pst.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void atualizarPlantas(Planta planta){
        String update = "update tarefas set nome=?, data_plantio=?, tipo_planta=?, status=? where id=?";
        try{
            PreparedStatement pst = conexao.prepareStatement(update);
            pst.setString(1, planta.getNome());
            pst.setDate(2, planta.getDataPlantio());
            pst.setString(3, planta.getTipoPlanta());
            pst.setString(4, planta.getStatus());
            pst.setInt(4, planta.getId());
            
            pst.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void selecionarPlanta(Planta planta){
        String read = "select * from plantas where id=?";
        try{
            PreparedStatement pst = conexao.prepareStatement(read);
            pst.setInt(1, planta.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                planta.setId(rs.getInt(1));
                planta.setDataPlantio(rs.getDate(2));
                planta.setTipoPlanta(rs.getString(3));
                planta.setStatus(rs.getString(4));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
