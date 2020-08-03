/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author jpedroc
 */
public class ClienteDAO {
    
    Statement stm;
    
     public void inserir(Cliente cliente) throws ClassNotFoundException, SQLException {
        stm = ConexaoBanco.obterConexao().createStatement();
        
        String sql = "INSERT INTO Cliente(nome, telefone, cep, endereco, complemento, bairro, numero) " +
                 "VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = ConexaoBanco.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setString(1, cliente.getNome());
        pstm.setString(2, cliente.getTelefone());
        pstm.setString(3, cliente.getCEP());
        pstm.setString(4, cliente.getEndereco());
        pstm.setString(5, cliente.getComplemento());
        pstm.setString(6, cliente.getBairro());
        pstm.setInt(7, cliente.getNumero());
        
        pstm.execute();
        
        ResultSet response = pstm.getGeneratedKeys();
        if( response.next() ){
            Integer id = response.getInt(1);
            cliente.setId(Long.parseLong(id.toString()));
        }
    }
     
     public List<Cliente> listar() throws ClassNotFoundException, SQLException {
        Cliente cliente;
        stm = ConexaoBanco.obterConexao().createStatement();
        List<Cliente> listaClientes = new ArrayList<>();
        
        String sql = "SELECT * FROM cliente";
        
        ResultSet response = stm.executeQuery(sql);
        
        while( response.next() ){
            cliente = new Cliente( 
                    response.getLong("id"), 
                    response.getString("nome"), 
                    response.getString("telefone"), 
                    response.getString("cep"), 
                    response.getString("endereco"),
                    response.getString("complemento"),
                    response.getString("bairro"),
                    response.getInt("numero"));
            listaClientes.add(cliente);
        }
            
        return listaClientes;
    } 
    
}
