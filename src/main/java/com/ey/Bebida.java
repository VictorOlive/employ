package com.ey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bebida")
public class Bebida {
    
    @Id
    @SequenceGenerator(name = "bebida", sequenceName = "sq_tb_bebida" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bebida")
    @Column(name = "id_bebida" , length = 8)
    private Integer id;
    
    @Column(name = "nm_estilo_bebida", length = 30)
    private String estilo;
    
    @Column(name = "nm_subestilo_bebida", length = 30)
    private String subEstilo;
    
    @Column(name = "nm_marca_bebida", length = 30)
    private String marca;
    
    @Column(name = "vl_bebida")
    private Double valor;

    // ----- Contructor & Getters & Setters

    /**
     * @param estilo
     * @param subEstilo
     * @param marca
     * @param valor
     */
    public Bebida(String estilo, String subEstilo, String marca, Double valor) {
        this.estilo = estilo;
        this.subEstilo = subEstilo;
        this.marca = marca;
        this.valor = valor;
    }
    
    public Bebida (){
        
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstilo() {
        return this.estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getSubEstilo() {
        return this.subEstilo;
    }

    public void setSubEstilo(String subEstilo) {
        this.subEstilo = subEstilo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
