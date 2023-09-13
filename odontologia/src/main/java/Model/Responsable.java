package Model;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Daniel
 */
@Entity
public class Responsable extends Persona{
    //private int id_responsable;
    private String tipo_responsabilidad;

    public Responsable(String tipo_responsabilidad, String curp, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        super(curp, nombre, apellido, telefono, direccion, fecha_nacimiento);
        //this.id_responsable = id_responsable;
        this.tipo_responsabilidad = tipo_responsabilidad;
    }

    /*
    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }
    */

    public String getTipo_responsabilidad() {
        return tipo_responsabilidad;
    }

    public void setTipo_responsabilidad(String tipo_responsabilidad) {
        this.tipo_responsabilidad = tipo_responsabilidad;
    }

}
