package model;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Vacantes {
    private int id;
    private Date fechaPublicacion;
    private String nombre;
    private String descripcion;
    private String detalle;

    public Vacantes(int id) {
        this.fechaPublicacion = new Date();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "\nVacantes" + "\nid = " + id + ",\nfechaPublicacion = " + fechaPublicacion + ",\nnombre = " + nombre + ",\ndescripcion = " + descripcion + ", "
                + "\ndetalle = " + detalle;
    }

}
