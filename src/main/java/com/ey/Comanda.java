package com.ey;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comanda")
public class Comanda {
    
    @Id
    @SequenceGenerator(name = "comanda", sequenceName = "sq_tb_comanda" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comanda")
    @Column(name = "id_comanda" , length = 9)
    private Integer id;

    @Column(name = "nm_plano", length = 8)
    private String nome;

    @Column(name = "ds_metodo_pagamento", length = 17)
    private String descricao;

    @Column(name = "nr_comanda", length = 6)
    private Integer numero;

    @Column(name = "vl_comanda")
    private Double valor;

    @Column(name = "dt_insercao")
    private LocalDateTime data = LocalDateTime.now();

    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.ALL})
    private List<Movimentacao> movimentacoes;

    @ManyToOne
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Consumidor consumidor;

    // ----- Contructor & Getters & Setters
    /**
     * @param nome
     * @param descricao
     * @param numero
     * @param valor
     */
    public Comanda(String nome, String descricao, Integer numero, Double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.numero = numero;
        this.valor = valor;
    }

    public Comanda (){
        
    }
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    
    public Consumidor getConsumidor() {
        return this.consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }
    
    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public List<Movimentacao> getMovimentacoes() {
        return this.movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
}
