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
import java.sql.Statement;
import java.util.ArrayList;
import model.MicroAgricultor;

/**
 *
 * @author javgc
 */
public class MicroAgricultorDAO {
    
    private Connection conexao;
    
    public MicroAgricultorDAO(){
        try{
            conexao = ConnectionFactory.criaConexao();
        }catch(Exception e){
            System.out.println("Erro de criação de DAO");
            e.printStackTrace();
        }
    }
    
    public void registrarMicroAgricultor(MicroAgricultor microAg){
        String insert = "insert into microagricultores (nome, login, email, senha) values (?, ?, ?, ?)";
        
        try{
            PreparedStatement pst = conexao.prepareStatement(insert);
            
            pst.setString(2, microAg.getNome());
            pst.setString(3, microAg.getLogin());
            pst.setString(4, microAg.getEmail());
            pst.setString(5, microAg.getSenha());
            pst.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<MicroAgricultor> listarMicroAgricultores(){
        ArrayList<MicroAgricultor> resultado = new ArrayList<>();
            
        String sql = "select * from microagricultores";
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                MicroAgricultor microag = new MicroAgricultor();
                microag.setId(rs.getInt("id"));
                microag.setNome(rs.getString("nome"));
                microag.setLogin(rs.getString("login"));
                microag.setEmail(rs.getString("email"));
                microag.setSenha(rs.getString("senha"));
                resultado.add(microag);
            }
        }catch(SQLException e){
            System.out.println("Erro de Sql: " + e.getMessage());
        }
        
        return resultado;
    }
 
}
