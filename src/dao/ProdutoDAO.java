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
import modelo.Produto;

/**
 *
 * @author jpedroc
 */
public class ProdutoDAO {
    
    Statement stm;
    
     public void inserir(Produto produto) throws ClassNotFoundException, SQLException {
        stm = ConexaoBanco.obterConexao().createStatement();
        
        String sql = "INSERT INTO Produto(nome, medida, valor, estoque) " +
                 "VALUES(?, ?, ?, ?)";
        
        PreparedStatement pstm = ConexaoBanco.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setString(1, produto.getNome());
        pstm.setInt(2, produto.getMedida());
        pstm.setDouble(3, produto.getValor());
        pstm.setInt(4, produto.getEstoque());
        
        pstm.execute();
        
        ResultSet response = pstm.getGeneratedKeys();
        if( response.next() ){
            Integer id = response.getInt(1);
            produto.setId(Long.parseLong(id.toString()));
        }
    }
     
     public List<Produto> listar() throws ClassNotFoundException, SQLException {
        Produto produto;
        stm = ConexaoBanco.obterConexao().createStatement();
        List<Produto> listaProdutos = new ArrayList<>();
        
        String sql = "SELECT * FROM Produto";
        
        ResultSet response = stm.executeQuery(sql);
        
        while( response.next() ){
            produto = new Produto( response.getLong("id"), response.getString("nome"), response.getInt("medida"), response.getDouble("valor"), response.getInt("estoque"));
            listaProdutos.add(produto);
        }
            
        return listaProdutos;
    } 
    
}
