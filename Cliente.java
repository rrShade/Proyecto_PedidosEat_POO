import java.util.Scanner;

public class Cliente extends Persona{
    private String numeroCliente;
    private String direccion;

    public Cliente() {

    }

    public Cliente(String nombre, int edad, String numeroCliente, String direccion) {
        super(nombre, edad);
        this.numeroCliente = numeroCliente;
        this.direccion = direccion;
    }

    public Cliente(String numeroCliente, String direccion) {
        this.numeroCliente = numeroCliente;
        this.direccion = direccion;
    }

    public String validarNumero() {
        Scanner teclado = new Scanner(System.in);
        String numeroPersonas = "";
        int valido;
        do {
            try{
                numeroPersonas = teclado.next();
                if (numeroPersonas.length()==8){
                    valido=1;
                }else {
                    System.out.println("ERROR, intentelo nuevamente.");
                    teclado.next();
                    valido=0;
                }
            }catch (Exception e){
                System.out.println("ERROR, intentelo nuevamente.");
                teclado.next();
                valido=0;
            }
        }while(valido==0);

        return numeroPersonas;
    }
    private String preguntarDireccion(){
        Scanner teclado = new Scanner(System.in);
        String direccionPersona = "";
        int valido;
        do {
            System.out.println("Ingrese su Direccion.");
            try {
                direccionPersona = teclado.nextLine();
                valido=1;
            }catch (Exception e){
                System.out.println("ERROR, intentelo nuevamente");
                teclado.next();
                valido=0;
            }
        }while (valido==0);

        return direccionPersona;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numeroContacto = +569 " + this.numeroCliente + '\'' +
                ", direccion = " + this.direccion + '\'' +
                '}';
    }
}
