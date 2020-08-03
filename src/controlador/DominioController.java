/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dao.ConexaoBanco;
import dao.ProdutoDAO;
import modelo.Produto;
import modelo.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jpedroc
 */
public class DominioController {
    
    private final ProdutoDAO produtoDAO;
    private final ClienteDAO clienteDAO;

    public DominioController() throws ClassNotFoundException, SQLException {
        ConexaoBanco.obterConexao();
        this.produtoDAO = new ProdutoDAO();
        this.clienteDAO = new ClienteDAO();
    }
    
    
    public void inserirProduto(String nome, Integer medida, Double valor, Integer estoque) throws ClassNotFoundException, SQLException{
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setMedida(medida);
        produto.setValor(valor);
        produto.setEstoque(estoque);
        
        produtoDAO.inserir(produto);
    }
    
    public List<Produto> listarProdutos() throws ClassNotFoundException, SQLException {
        return produtoDAO.listar();
    }
    
    public void inserirCliente(String nome, String telefone, String CEP, String endereco, String bairro, String complemento, Integer numero) throws ClassNotFoundException, SQLException{
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCEP(CEP);
        cliente.setEndereco(endereco);
        cliente.setBairro(bairro);
        cliente.setComplemento(complemento);
        cliente.setNumero(numero);
        
        clienteDAO.inserir(cliente);
    }
    
    public List<Cliente> listarClientes() throws ClassNotFoundException, SQLException{
        return clienteDAO.listar();
    }
    
    
}
