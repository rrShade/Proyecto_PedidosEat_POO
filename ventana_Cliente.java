import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ventana_Cliente extends JFrame{
    private JPanel panel1;
    private JTextField txtNumero;
    private JTextField txtDireccion;
    private JButton guardarDatos;


    private DefaultListModel listaModel = new DefaultListModel();



    public ventana_Cliente() {
        setContentPane(panel1);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);


        guardarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection;
                    connection = DriverManager.getConnection("jdbc:mysql://185.61.126.162:3306/bd_poo", "root" , "Xv,c(!n8xf30");
                    PreparedStatement pst = connection.prepareStatement("insert into loginCliente (numeroCliente, direccionCliente) values(?,?)");


                    pst.setString(1, txtNumero.getText().trim());
                    pst.setString(2, txtDireccion.getText().replaceAll(" ", "").trim());
                    pst.executeUpdate();

                    txtNumero.setText("");
                    txtDireccion.setText("");

                    JOptionPane.showMessageDialog(null, "Registro exitoso!");


                    ventana_eleccionLocales eleccionLocal = new ventana_eleccionLocales();
                    eleccionLocal.setVisible(true);


                    dispose();
                }catch (Exception c){
                    System.out.println("c = " + c);
                }
            }
        });
    }
}
