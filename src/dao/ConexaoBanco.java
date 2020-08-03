/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jpedroc
 */
public class ConexaoBanco {
    
    static Connection conexao;
    
    public static Connection obterConexao() throws ClassNotFoundException, SQLException{
        String server = "localhost:5432";
        String login = "postgres";
        String senha = "root";
        String nomeBanco = "UNIAODEP";
        String url = "jdbc:postgresql://" +server + "/"+nomeBanco;
        
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection(url, login, senha);
        
        return conexao;
    }
    
}
