import java.util.Scanner;

public class Local {
    private String nombreLocal;
    private String tipo;
    private String direccionLocal;
    private String numeroLocal;
    private int id;
    public Local(int id, String nombreLocal, String tipo, String direccionLocal, String numeroLocal) {
        this.id = id;
        this.nombreLocal = nombreLocal;
        this.tipo = tipo;
        this.direccionLocal = direccionLocal;
        this.numeroLocal = numeroLocal;
    }

    private String preguntaNombre(){
        Scanner teclado = new Scanner(System.in);
        String nombreLocal = "";
        int valido;
        do {
            System.out.println("Ingrese el nombre de su Local");
            try{
                nombreLocal = teclado.nextLine();
                valido = 1;
            }catch (Exception e){
                System.out.println("Ingreso un dato erroneo, vuelva a intentarlo nuevamente.");
                teclado.next();
                valido = 0;
            }
        }while (valido == 0);
        return nombreLocal;
    }
    private String preguntaTipo(){
        Scanner teclado = new Scanner(System.in);
        String tipoLocal = "";
        int valido;
        do {
            System.out.println("Ingrese el tipo de local");
            System.out.println("[Sandwicheria, Pizzeria, Hamburgueseria, Bar,etc...]");
            try{
                tipoLocal = teclado.nextLine();
                valido = 1;
            }catch (Exception e){
                System.out.println("Ingreso un dato erroneo, vuelva a intentarlo nuevamente.");
                teclado.next();
                valido = 0;
            }
        }while (valido == 0);
        return tipoLocal;
    }
    private String preguntaDirecLocal(){
        Scanner teclado = new Scanner(System.in);
        String direccionLocal = "";
        int valido;
        do {
            System.out.println("Ingrese la direccion de su local");
            try{
                direccionLocal = teclado.nextLine();
                valido = 1;
            }catch (Exception e){
                System.out.println("Ingreso un dato erroneo, vuelva a intentarlo nuevamente.");
                teclado.next();
                valido = 0;
            }
        }while (valido == 0);
        return direccionLocal;
    }
    private String preguntaTelefonoLocal(){
        Scanner teclado = new Scanner(System.in);
        String telefonoLocal = "";
        int valido;
        do {
            System.out.println("Ingrese el numero de contacto de su local luego del +569");
            try {
                if (telefonoLocal.length()==8){
                    valido = 1;
                }else {
                    System.out.println("El numero ingresado es erroneo, vuelva a intentelo nuevamente.");
                    valido = 0;
                }
            }catch (Exception e){
                System.out.println("Ingreso un dato erroneo, vuelva a intentarlo nuevamente.");
                valido = 0;
            }
        }while (valido==0);
        return telefonoLocal;
    }
    public String getTipo(){
        return tipo;
    }
    public String getNombreLocal(){
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccionLocal() {
        return direccionLocal;
    }

    public void setDireccionLocal(String direccionLocal) {
        this.direccionLocal = direccionLocal;
    }

    public String getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "" +
                "Nombre Del Local: " + nombreLocal + '\'' +
                "| Tipo De Local: " + tipo + '\'' +
                "| Direccion Del Local: " + direccionLocal + '\'' +
                "| Numero Del Local: " + numeroLocal + '\'' +
                "| ID: " + id;
    }
}
