package Servlets;
import java.io.Serializable;

public class Producto implements Serializable{
    private String descripcion;
    private double precioVenta;
    private boolean activo;
    
    public Producto() { 
        System.out.println("Constructor vacio. No siempre es necesario este metodo");
        this.descripcion="";
        this.activo=true;
    }
    public String getDescripcion() {
        System.out.println("Los métodos getXYZ son ejecutados de forma automatica");
        System.out.println("cuando en un JSP por medio de Expression Language");
        System.out.println("se hace una llamada como ${producto.descripcion} ");
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecioVenta() {
        System.out.println("Los métodos getXYZ son ejecutados de forma automatica");
        System.out.println("cuando en un JSP por medio de Expression Language");
        System.out.println("se hace una llamada como ${producto.precioVenta} ");
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean isActivo() {
        System.out.println("Los métodos getXYZ son ejecutados de forma automatica");
        System.out.println("cuando en un JSP por medio de Expression Language");
        System.out.println("se hace una llamada como ${producto.activo} ");
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * (opcional) Sobreescribimos el metodo toString, de tal forma que si imprimimos el JavaBean
     * con System.out.println(producto) sera mostrado con el formato aqui especificado.
     * @return 
     */ 
    @Override
    public String toString() {
        return "Producto {" + " descripcion = " + descripcion + ", precioVenta = " + precioVenta + ", activo = " + activo + '}';
    }
   
}
