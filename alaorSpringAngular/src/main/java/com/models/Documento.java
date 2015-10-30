package com.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by alaor on 30/10/15.
 */
@Entity
@Table(name = "Documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "titulo")
    @NotNull
    private String titulo;

    @Column(name = "codigo")
    @NotNull
    private String codigo;

    @Column(name = "texto")
    @NotNull
    private String texto;

    public Documento() {
    }

    public Documento(long id) {
        this.id = id;
    }

    public Documento(String titulo, String codigo, String texto) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.texto = texto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
