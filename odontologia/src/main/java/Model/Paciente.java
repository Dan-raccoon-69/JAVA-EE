/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Paciente extends Persona {
    private int id_paciente;
    private String tiene_OS;
    private String tipoSangre;
    // Relaciones 1 a 1 se hacen mediante instancias - creaciones de objetos 
    // (un paciente tiene 1 responsable)
    private Responsable unResponsable;
    // Relaciones 1 a n se hacen mediante collections de objetos
    // (un paciente tiene n turnos)
    private List <Turno> listaTurnos;

    public Paciente(int id_paciente, String tiene_OS, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos, String curp, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        super(curp, nombre, apellido, telefono, direccion, fecha_nacimiento);
        this.id_paciente = id_paciente;
        this.tiene_OS = tiene_OS;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getTiene_OS() {
        return tiene_OS;
    }

    public void setTiene_OS(String tiene_OS) {
        this.tiene_OS = tiene_OS;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
    
    

}
