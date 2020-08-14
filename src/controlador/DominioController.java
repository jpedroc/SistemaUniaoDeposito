/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.GenericDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import modelo.Produto;
import modelo.Cliente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Venda;
import org.hibernate.HibernateException;

/**
 *
 * @author jpedroc
 */
public class DominioController {
    
    private final ProdutoDAO produtoDAO;
    private final ClienteDAO clienteDAO;
    private final VendaDAO vendaDAO;
    private final GenericDAO genericDAO;

    public DominioController() throws ClassNotFoundException, SQLException {
        ConexaoHibernate.getSessionFactory();
        this.produtoDAO = new ProdutoDAO();
        this.clienteDAO = new ClienteDAO();
        this.genericDAO = new GenericDAO();
        this.vendaDAO = new VendaDAO();
    }
    
    public List listar( Class classe) throws HibernateException {
        return genericDAO.listar( classe );
    }
    
    
    public void inserirProduto(String nome, Integer medida, Double valor, Integer estoque) throws ClassNotFoundException, SQLException{
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setMedida(medida);
        produto.setValor(valor);
        produto.setEstoque(estoque);
        
        produtoDAO.inserir(produto);
    }
    
    public void inserirVenda(Cliente cliente, List listaProdutos){
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setListaProdutos(listaProdutos);
        venda.setDataVenda(new Date());
        
        vendaDAO.inserir(venda);
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
    
}
