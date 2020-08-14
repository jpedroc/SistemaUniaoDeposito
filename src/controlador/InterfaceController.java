/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import view.CadastrarClienteDialog;
import view.CadastrarProdutoDialog;
import view.ListarClientes;
import view.ListarProdutos;
import view.RealizarVendaDialog;
import view.UniaoDeposito;

/**
 *
 * @author jpedroc
 */
public class InterfaceController {

    DominioController gerDom;
    private UniaoDeposito telaPrincipal;
    private CadastrarClienteDialog dlgCadastrarCliente;
    private CadastrarProdutoDialog dlgCadastrarProduto;
    private ListarClientes dlgListarClientes;
    private ListarProdutos dlgListarProdutos;
    private RealizarVendaDialog dlgRealizarVenda;
    
    
    public InterfaceController() throws ClassNotFoundException, SQLException {
        
        telaPrincipal = null;
        dlgCadastrarCliente = null;
        dlgCadastrarProduto = null;
        dlgListarClientes = null;
        dlgListarProdutos = null;
        dlgRealizarVenda = null;
        
        try {
            gerDom = new DominioController();
        } catch ( HibernateException ex) {
            JOptionPane.showMessageDialog(telaPrincipal, ex );
            System.exit(-1);
        }
        
    }

    public DominioController getGerDominio() {
        return gerDom;
    }
     
    public void janPrincipal() {        
       // abrirJanela(frmPrinc);              
       if (telaPrincipal == null){            
            telaPrincipal = new UniaoDeposito(this);
        }        
        telaPrincipal.setVisible(true); 
    }
    
    public void janCadCliente(){
        // ABRIR a janela de CADASTRO DE CLIENTE                
        if(dlgCadastrarCliente == null){
            dlgCadastrarCliente = new CadastrarClienteDialog(telaPrincipal, true, this);
        }
        dlgCadastrarCliente.setVisible(true);
    }
    
    public void janCadProduto() {
        // ABRIR a janela de CADASTRO DE PRODUTO                
        if(dlgCadastrarProduto == null){
            dlgCadastrarProduto = new CadastrarProdutoDialog(telaPrincipal, true, this);
        }
        dlgCadastrarProduto.setVisible(true);
    }
    
    public void janListarCliente(){
        // ABRIR a janela de LISTAR DE CLIENTE                
        if(dlgListarClientes == null){
            dlgListarClientes = new ListarClientes(telaPrincipal, true, this);
        }
        dlgListarClientes.setVisible(true);
    }
    
    public void janListarProduto() {
        // ABRIR a janela de LISTAR DE PRODUTO                
        if(dlgListarProdutos == null){
            dlgListarProdutos = new ListarProdutos(telaPrincipal, true, this);
        }
        dlgListarProdutos.setVisible(true);
    }
    
    public void janRealizarVenda() {
        // ABRIR a janela de Realizar Venda                
        if(dlgRealizarVenda == null){
            dlgRealizarVenda = new RealizarVendaDialog(telaPrincipal, true, this);
        }
        dlgRealizarVenda.setVisible(true);
    }
        

    // FUNÇÃO GENÉRICA
    public void carregarCombo( JComboBox combo, Class classe ) {
        System.out.println("Entrou");
        List<?> lista;
        try {
            lista = gerDom.listar(classe);
            combo.setModel( new DefaultComboBoxModel( lista.toArray() ) );
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(telaPrincipal, "Erro ao carregar COMBO. " + ex );
        }          
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Look and Feel não encontrado");
        }
        //</editor-fold>
        

         InterfaceController gerIG;
         gerIG = new InterfaceController();
         gerIG.janPrincipal();
         
    }
    
}
