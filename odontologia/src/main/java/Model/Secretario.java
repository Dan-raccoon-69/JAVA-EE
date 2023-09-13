package Model;

import java.util.Date;
import javax.persistence.Entity;

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
    private Usuario unUsuario;

    public Secretario(String sector, Usuario unUsuario, String curp, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        super(curp, nombre, apellido, telefono, direccion, fecha_nacimiento);
        //this.id_secretario = id_secretario;
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
