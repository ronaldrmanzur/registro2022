/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.serviciosrest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;

/**
 *
 * @author Manuel
 */
@Builder
@Entity(name = "Categoria")
@Table(name = "t_categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="codcat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nomcat")
    private String nombre;
    @Column(name="estcat")
    private boolean estado;

    public Categoria() {
    }

    public Categoria(long codigo, String nombre, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
