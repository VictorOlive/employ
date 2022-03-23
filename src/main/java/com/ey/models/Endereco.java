package com.ey.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
    
    @Id
    @SequenceGenerator(name = "endereco", sequenceName = "sq_tb_endereco" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
    @Column(name = "id_endereco" , length = 9)
    private Integer id;

    @Column(name = "nr_cep" , length = 8)
    private String cep;

    @Column(name = "nm_logradouro" , length = 100)
    private String logradouro;

    @Column(name = "nr_logradouro" , length = 6)
    private String numero;

    @Column(name = "nm_bairro" , length = 70)
    private String bairro;

    @Column(name = "nm_cidade" , length = 100)
    private String cidade;

    @Column(name = "nm_estado" , length = 2)
    private String estado;

    // ----- Contructor & Getters & Setters

    /**
     * @param cep
     * @param logradouro
     * @param numero
     * @param bairro
     * @param cidade
     * @param estado
     */
    public Endereco(String cep, String logradouro, String numero, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public Endereco(){

    }

    public Integer getId() {
        return this.id;
    }    

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
