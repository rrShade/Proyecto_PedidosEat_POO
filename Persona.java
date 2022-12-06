import java.util.Scanner;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    public Persona(){
        this.nombre = preguntaNombre();
        this.edad = preguntaEdad();
    }
    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    private String preguntaNombre(){
        Scanner teclado = new Scanner(System.in);
        String nombrePersona = "";
        int valido;
        do {
            System.out.println("Ingrese su nombre");
            try{
                nombrePersona = teclado.nextLine();
                valido = 1;
            }catch (Exception e){
                System.out.println("Error al ingresar un dato, intentelo nuevamente.");
                teclado.next();
                valido = 0;
            }
        }while (valido==0);
        return nombrePersona;
    }
    private int preguntaEdad(){
        Scanner teclado = new Scanner(System.in);
        int edadPersona = 0;
        int valido;
        do{
            System.out.println("(Debe cumplir con una edad mayor a 12)");
            System.out.println("Ingrese su Edad");
            try{
                edadPersona= teclado.nextInt();
                if (edadPersona<12 || edadPersona>99){
                    System.out.println("Error al ingresar un dato, intentelo nuevamente.");
                    valido=0;
                }else{
                    valido=1;
                }
            }catch (Exception e){
                System.err.println("Error al ingresar un dato, intentelo nuevamente.");
                teclado.next();
                valido=0;
            }
        }while(valido==0);

        return edadPersona;
    }
}

