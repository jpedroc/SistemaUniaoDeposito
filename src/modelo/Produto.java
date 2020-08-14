/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jpedroc
 */

@Entity(name = "produto")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private Integer medida;
    
    private Double valor;
    
    private Integer estoque;

    public Produto() {
    }

    public Produto(Long id, String nome, Integer medida, Double valor, Integer estoque) {
        this.id = id;
        this.nome = nome;
        this.medida = medida;
        this.valor = valor;
        this.estoque = estoque;
    }
    
    public String toString(){
        return nome.toString() + " " + medida.toString() + " L/Kg";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMedida() {
        return medida;
    }

    public void setMedida(Integer medida) {
        this.medida = medida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    
    
    
}
