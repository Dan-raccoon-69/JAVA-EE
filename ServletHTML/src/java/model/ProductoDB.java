package model;

import java.util.LinkedList;
import java.util.List;

public class ProductoDB {

    private static List<Producto> catalogo;

    public ProductoDB() {
        catalogo = new LinkedList<>();
        // Creacion de 4 productos
        Producto p1 = new Producto(1);
        p1.setCategoria("Electronica");
        p1.setNombre("Audifonos WH-710");
        p1.setPrecio(2300);

        Producto p2 = new Producto(2);
        p2.setCategoria("Electronica");
        p2.setNombre("Pantalla Sony 25Pulg.");
        p2.setPrecio(5000);

        Producto p3 = new Producto(3);
        p3.setCategoria("Telefonia");
        p3.setNombre("IPhone 14");
        p3.setPrecio(20000);

        Producto p4 = new Producto(4);
        p4.setCategoria("Computadora");
        p4.setNombre("NVIDIA RTX 2060");
        p4.setPrecio(6000);
        //Agregamos los productos a la lista
        catalogo.add(p1);
        catalogo.add(p2);
        catalogo.add(p3);
        catalogo.add(p4);
    }

    // retorna todos los productos de la lista
    public List<Producto> getAll() {
        return catalogo;
    }
}
