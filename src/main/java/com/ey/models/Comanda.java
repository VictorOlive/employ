package com.ey.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @SequenceGenerator(name = "comanda", sequenceName = "sq_tb_comanda", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comanda")
    @Column(name = "id_comanda", length = 9)
    private Integer id;

    @Column(name = "nm_plano", length = 8)
    private String nome;

    @Column(name = "ds_metodo_pagamento", length = 17)
    private String descricao;

    @Column(name = "nr_comanda", length = 6)
    private Integer numero;

    @Column(name = "vl_comanda")
    private Double valor = 0.0d;

    @Column(name = "dt_insercao")
    private LocalDateTime data = LocalDateTime.now();

    @OneToMany(mappedBy = "comanda", cascade = { CascadeType.ALL })
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    @ManyToOne
    private Estabelecimento estabelecimento;

    @ManyToOne(fetch = FetchType.EAGER)
    private Consumidor consumidor;

        // ----- Contructor & Getters & Setters
    /**
     * @param estabelecimento
     * @param consumidor
     * @param numero
     */

    public Comanda(Estabelecimento estabelecimento, Consumidor consumidor, Integer numero) {
        this.estabelecimento = estabelecimento;
        this.consumidor = consumidor;
        this.numero = numero;
    }

    public Comanda() {

    }

    public void addMovimentacao(Movimentacao movimentacao) {
        this.movimentacoes.add(movimentacao);
        movimentacao.setComanda(this);
        this.setValor(
                this.getValor()
                        +
                        (movimentacao.getQuantidade() * movimentacao.getBebida().getValor()));
    }

    public void removeMovimentacao(Movimentacao movimentacao) {
        this.movimentacoes.remove(movimentacao);
        movimentacao.setComanda(null);
        this.setValor(
            this.getValor()
                    -
                    (movimentacao.getQuantidade() * movimentacao.getBebida().getValor()));
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((consumidor == null) ? 0 : consumidor.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((estabelecimento == null) ? 0 : estabelecimento.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((movimentacoes == null) ? 0 : movimentacoes.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comanda other = (Comanda) obj;
        if (consumidor == null) {
            if (other.consumidor != null)
                return false;
        } else if (!consumidor.equals(other.consumidor))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (estabelecimento == null) {
            if (other.estabelecimento != null)
                return false;
        } else if (!estabelecimento.equals(other.estabelecimento))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (movimentacoes == null) {
            if (other.movimentacoes != null)
                return false;
        } else if (!movimentacoes.equals(other.movimentacoes))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Comanda [data=" + data + ", descricao=" + descricao
                + ", id=" + id + ", movimentacoes=" + movimentacoes + ", nome="
                + nome + ", numero=" + numero + ", valor=" + valor + "]";
    }
}
