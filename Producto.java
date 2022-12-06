import java.util.Scanner;

public abstract class Producto {
    protected String nombre;
    protected String precio;


    public Producto(){

    }

    private String preguntarNombre(){
        Scanner teclado = new Scanner(System.in);
        String nombre = "";
        int valido;
        do{
            System.out.println("Ingrese el nombre de su producto.");
            try{
                nombre = teclado.next();
                valido=1;
            }catch (Exception e){
                System.out.println("ERROR, intentelo nuevamente.");
                teclado.next();
                valido=0;
            }
        }while (valido==0);

        return nombre;
    }
    private String preguntarPrecio(){
        Scanner teclado = new Scanner(System.in);
        int precio = 0;
        int valido;
        do {
            System.out.println("Ingrese el precio de su producto.");
            try {
                precio = teclado.nextInt();
                if (precio<1){
                    System.out.println("ERROR, intentelo nuevamente.");
                    valido=0;
                }else {
                    valido=1;
                }
            }catch (Exception e){
                System.out.println("ERROR, intentelo nuevamente.");
                teclado.next();
                valido=0;
            }
        }while (valido==0);

        return String.valueOf(precio);
    }

    public String getPrecio() {
        return precio;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString(){
        return "Nombre del Producto: " + nombre + ", Precio Producto: $"+ precio;
    }
}
