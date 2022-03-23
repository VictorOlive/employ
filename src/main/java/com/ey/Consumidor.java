package com.ey;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "tb_consumidor")
public class Consumidor {

    @Id
    @SequenceGenerator(name = "consumidor", sequenceName = "sq_tb_consumidor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumidor")
    @Column(name = "id_consumidor", length = 9)
    private Integer id;

    @Column(name = "nr_completo_celular", length = 13)
    private String celular;

    @Column(name = "nm_completo", length = 100)
    private String nome;

    @Column(name = "ds_email", length = 70)
    private String email;

    @Column(name = "nr_cpf", length = 11)
    private String cpf;

    @Column(name = "ds_genero", length = 30)
    private String genero;

    @Column(name = "dt_nascimento")
    private LocalDateTime dtNascimento;

    @OneToMany(mappedBy = "consumidor", cascade = {
            CascadeType.ALL }, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Comanda.class)
    private List<Comanda> comandas = new ArrayList<>();

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

    public Consumidor() {}

    public void addComanda(Comanda comanda) {
        this.comandas.add(comanda);
        comanda.setConsumidor(this);
    }

    public void removeComada(Comanda comanda) {
        this.comandas.remove(comanda);
        comanda.setConsumidor(null);
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

    @Override
    public String toString() {
        return "Consumidor [celular=" + celular + ", comandas=" + comandas + ", cpf=" + cpf + ", dtNascimento="
                + dtNascimento + ", email=" + email + ", genero=" + genero + ", id=" + id + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((celular == null) ? 0 : celular.hashCode());
        result = prime * result + ((comandas == null) ? 0 : comandas.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Consumidor other = (Consumidor) obj;
        if (celular == null) {
            if (other.celular != null)
                return false;
        } else if (!celular.equals(other.celular))
            return false;
        if (comandas == null) {
            if (other.comandas != null)
                return false;
        } else if (!comandas.equals(other.comandas))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (dtNascimento == null) {
            if (other.dtNascimento != null)
                return false;
        } else if (!dtNascimento.equals(other.dtNascimento))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    
}
