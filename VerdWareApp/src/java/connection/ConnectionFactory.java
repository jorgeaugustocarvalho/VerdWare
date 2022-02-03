/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author javgc
 */
public class ConnectionFactory {
    
    private static Connection conexao = null;  
    
    public static Connection criaConexao() throws SQLException {
        if ( conexao == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver foi carregado");
                conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/verdbank", "root", "root");
                System.out.println("Conexão realizada com sucesso!");
            } catch ( ClassNotFoundException e){
                System.out.println("Driver não encontrado");
            }
        }
        
        return conexao;
    }
    
}
