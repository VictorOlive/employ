package com.ey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

    @Id
    @SequenceGenerator(name = "movimentacao", sequenceName = "sq_tb_movimentacao" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimentacao")
    @Column(name = "id_movimentacao" , length = 9)
    private Integer id;
    
    @Column(name = "qt_bebida")
    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "id_bebida")
    private Bebida bebida;

    @ManyToOne
    private Comanda comanda;

    // ----- Contructor & Getters & Setters

    /**
     * @param quantidade
     */
    public Movimentacao(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Movimentacao (){
        
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Comanda getComanda() {
        return this.comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Bebida getBebida() {
        return this.bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
}
