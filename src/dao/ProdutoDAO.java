/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Produto;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jpedroc
 */
public class ProdutoDAO extends GenericDAO{
    
    public Produto buscarPorId(Long id){
        Produto produto = null;
        Session sessao = null;
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            Criteria consulta = sessao.createCriteria(Produto.class);
                                     
            produto = (Produto) consulta.add( Restrictions.eq("id", id)).uniqueResult();

            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException ex) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        
        return produto;
    }
}
