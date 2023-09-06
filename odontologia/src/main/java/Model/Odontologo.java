package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Odontologo extends Persona{
    private int id_odontologo;
    private String especialidad;
    // Relaciones 1 a 1 se hacen mediante instancias - creaciones de objetos 
    // (un Odontologo tiene 1 usuario)
    private Usuario unUsuario;
    // Relaciones 1 a 1 se hacen mediante instancias - creaciones de objetos 
    // (un Odontologo tiene 1 horario)
    private Horario unHorario;
    // Relaciones 1 a n se hacen mediante collections de objetos
    // (un paciente tiene n turnos)
    private List <Turno> listaTurnos;

    public Odontologo(int id_odontologo, String especialidad, Usuario unUsuario, Horario unHorario, List<Turno> listaTurnos, String curp, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        super(curp, nombre, apellido, telefono, direccion, fecha_nacimiento);
        this.id_odontologo = id_odontologo;
        this.especialidad = especialidad;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
        this.listaTurnos = listaTurnos;
    }

    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }

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
