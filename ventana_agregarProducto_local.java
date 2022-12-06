import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ventana_agregarProducto_local extends JFrame{

    private JPanel panel1;
    private JTextField txt1;
    private JTextField txt2;
    private JLabel ingresarProducto;
    private JLabel ingresarPrecio;
    private JButton guardarProductoButton;
    private Local aux;
    String title;

    public ventana_agregarProducto_local(Local aux) {
        setContentPane(panel1);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        this.aux=aux;

        guardarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
    }

    public void initAtributes(String title1) {
        this.title = title1;
    }

    public void addProduct() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://185.61.126.162:3306/bd_poo", "root" , "Xv,c(!n8xf30");
            PreparedStatement pst = connection.prepareStatement("insert into agregarProducto (idLocalAUX, nombreProducto, precioProducto) values(?,?,?)");

            String nombre = txt1.getText();
            String precio = txt2.getText();

            pst.setInt(1, aux.getId());
            pst.setString(2, nombre.trim());
            pst.setString(3, precio.trim());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Exitoso :)");

            txt1.setText("");
            txt2.setText("");

        }catch (Exception c){
            System.out.println("c = " + c);
        }
    }

    public void init(){
        this.setTitle(title);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setVisible(true);
    }
}
