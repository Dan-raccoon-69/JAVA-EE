/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findByNumaula", query = "SELECT a FROM Aula a WHERE a.numaula = :numaula"),
    @NamedQuery(name = "Aula.findByCapacidad", query = "SELECT a FROM Aula a WHERE a.capacidad = :capacidad"),
    @NamedQuery(name = "Aula.findByNombre", query = "SELECT a FROM Aula a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aula.findByEstado", query = "SELECT a FROM Aula a WHERE a.estado = :estado")})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int numaula;

    private int capacidad;
    @Lob
    private String descripcion;

    private String nombre;

    private boolean estado;
    

    public Aula() {
    }

    public Aula(int numaula) {
        this.numaula = numaula;
    }

    public Aula(int numaula, int capacidad, boolean estado) {
        this.numaula = numaula;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getNumaula() {
        return numaula;
    }

    public void setNumaula(int numaula) {
        this.numaula = numaula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Model.Aula[ numaula=" + numaula + " ]";
    }
    
}
