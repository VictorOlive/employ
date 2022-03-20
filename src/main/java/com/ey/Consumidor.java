package com.ey;

import java.time.LocalDateTime;
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
@Table(name = "tb_consumidor")
public class Consumidor {
    
    @Id
    @SequenceGenerator(name = "consumidor", sequenceName = "sq_tb_consumidor" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumidor")
    @Column(name = "id_consumidor" , length = 9)
    private Integer id;

    @Column(name = "nr_completo_celular" , length = 13)
    private String celular;

    @Column(name = "nm_completo" , length = 100)
    private String nome;

    @Column(name = "ds_email" , length = 70)
    private String email;

    @Column(name = "nr_cpf" , length = 11)
    private String cpf;

    @Column(name = "ds_genero" , length = 30)
    private String genero;

    @Column(name = "dt_nascimento")
    private LocalDateTime dtNascimento;

    @OneToMany(mappedBy = "consumidor", cascade = {CascadeType.ALL})
    private List<Comanda> comandas;

    // ----- Contructor & Getters & Setters

    /**
     * @param celular
     * @param nome
     * @param email
     * @param cpf
     * @param genero
     * @param dtNascimento
     */
    public Consumidor(String celular, String nome, String email, String cpf, String genero,
            LocalDateTime dtNascimento) {
        this.celular = celular;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.genero = genero;
        this.dtNascimento = dtNascimento;
    }
    
    public Consumidor(){

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDateTime getDtNascimento() {
        return this.dtNascimento;
    }

    public void setDtNascimento(LocalDateTime dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public List<Comanda> getComandas() {
        return this.comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
