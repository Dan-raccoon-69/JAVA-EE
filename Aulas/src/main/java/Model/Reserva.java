/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int idreserva;
    
    @JoinColumn(name = "numaula", referencedColumnName = "numaula")
    @ManyToOne(optional = false)
    private Aula numaula;
    
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Reserva() {
    }

    public Reserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public Aula getNumaula() {
        return numaula;
    }

    public void setNumaula(Aula numaula) {
        this.numaula = numaula;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String toString() {
        return "Model.Reserva[ idreserva=" + idreserva + " ]";
    }
    
}
