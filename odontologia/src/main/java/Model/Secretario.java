package Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Daniel
 */
@Entity
public class Secretario extends Persona{
    //private int id_secretario;
    private String sector;
    // Relaciones 1 a 1 se hacen mediante instancias - creaciones de objetos 
    // (un secretario tiene 1 usuario)
    @OneToOne
    private Usuario unUsuario;

    public Secretario(String sector, Usuario unUsuario, int id, String curp, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        super(id, curp, nombre, apellido, telefono, direccion, fecha_nacimiento);
        this.sector = sector;
        this.unUsuario = unUsuario;
    }

    /*
    public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
    }
    */

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
    
}
