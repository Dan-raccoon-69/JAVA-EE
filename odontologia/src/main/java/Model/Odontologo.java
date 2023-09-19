package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Daniel
 */
@Entity
public class Odontologo extends Persona implements Serializable{
    //private int id_odontologo;
    private String especialidad;
    // Relaciones 1 a 1 se hacen mediante instancias - creaciones de objetos 
    // (un Odontologo tiene 1 usuario)
    @OneToOne
    private Usuario unUsuario;
    // Relaciones 1 a 1 se hacen mediante instancias - creaciones de objetos 
    // (un Odontologo tiene 1 horario)
    @OneToOne
    private Horario unHorario;
    // Relaciones 1 a n se hacen mediante collections de objetos
    // (un paciente tiene n turnos)
    @OneToMany (mappedBy="odonto")
    // va a ir a la clase turno y buscara algo que se llame "turn" 
    private List <Turno> listaTurnos;

    public Odontologo(String especialidad, Usuario unUsuario, Horario unHorario, List<Turno> listaTurnos, int id, String curp, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        super(id, curp, nombre, apellido, telefono, direccion, fecha_nacimiento);
        this.especialidad = especialidad;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
        this.listaTurnos = listaTurnos;
    }

    /*
    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }
    */

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
 
}
