package com.ey;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

    @Id
    @SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimento" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimento")
    @Column(name = "id_estabelecimento" , length = 9)
    private Integer id;
    
    @Column(name = "nm_estabelecimento" , length = 70)
    private String nome;

    @Column(name = "nr_cnpj" , length = 14)
    private String cnpj;

    @Column(name = "nr_completo_telefone", length = 13)
    private String telefone;

    @Column(name = "ds_email", length = 70)
    private String descricao;

    @OneToMany(mappedBy = "estabelecimento", cascade = {CascadeType.ALL})
    private List<Comanda> comandas;

    // ----- Contructor & Getters & Setters

    /**
     * @param nome
     * @param cnpj
     * @param telefone
     * @param descricao
     */
    public Estabelecimento(String nome, String cnpj, String telefone, String descricao) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.descricao = descricao;
    }

    public Estabelecimento (){

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

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Comanda> getComandas() {
        return this.comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    } 
    
}
