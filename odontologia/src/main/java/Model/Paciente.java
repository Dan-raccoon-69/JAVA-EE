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
public class Paciente extends Persona implements Serializable {
    //private int id_paciente;
    private String tiene_OS;
    private String tipoSangre;
    // Relaciones 1 a 1 se hacen mediante instancias - creaciones de objetos 
    // (un paciente tiene 1 responsable)
    @OneToOne
    private Responsable unResponsable;
    // Relaciones 1 a n se hacen mediante collections de objetos
    // (un paciente tiene n turnos)
    @OneToMany(mappedBy="pacien")
    private List <Turno> listaTurnos;

    public Paciente(String tiene_OS, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos, int id, String curp, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        super(id, curp, nombre, apellido, telefono, direccion, fecha_nacimiento);
        this.tiene_OS = tiene_OS;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    /*
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    */

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
