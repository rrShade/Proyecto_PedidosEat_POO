import java.util.List;

public class Articulos extends Producto{

    public Articulos(String nombre, String precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
