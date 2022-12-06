import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ventana_Local extends javax.swing.JFrame{
    private JPanel panel1;
    private JLabel ingresarNombreLocal;
    private JLabel ingresarTipo;
    private JLabel ingresarDireccionLocal;
    private JLabel ingresarTelefonoLocal;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtLocal;
    private JButton guardarEIngresarButton;
    private Local localAux;
    private Local modificar;

    public ventana_Local(Local aux, Local modificar) {
        setContentPane(panel1);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        this.localAux = aux;
        this.modificar = modificar;

        guardarEIngresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresarDatos();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void ingresarDatos() throws SQLException {
        Connection cn = DriverManager.getConnection("jdbc:mysql://185.61.126.162:3306/bd_poo", "root" , "Xv,c(!n8xf30");
        try {
            System.out.println(modificar);
            System.out.println("------------------");
            System.out.println(localAux);

            if (modificar == null)
            {
                PreparedStatement pst = cn.prepareStatement("insert into loginLocal (nombreLocal, tipoLocal, direccionLocal, numeroLocal) values(?,?,?,?)");

                localAux = new Local(0, txtNombre.getText(), txtLocal.getText(), txtDireccion.getText(), txtTelefono.getText());

                pst.setString(1, localAux.getNombreLocal().trim());
                pst.setString(2, localAux.getTipo().trim());
                pst.setString(3, localAux.getDireccionLocal().trim());
                pst.setString(4, localAux.getNumeroLocal().trim());
                pst.executeUpdate();

                pst = cn.prepareStatement("Select * from loginLocal where nombreLocal = ? and tipoLocal = ? and direccionLocal = ? and numeroLocal = ?");

                pst.setString(1, localAux.getNombreLocal().trim());
                pst.setString(2, localAux.getTipo().trim());
                pst.setString(3, localAux.getDireccionLocal().trim());
                pst.setString(4, localAux.getNumeroLocal().trim());

                ResultSet rs = pst.executeQuery();

                while(rs.next()) {
                    System.out.println(rs.getInt("idLocal"));
                    localAux.setId(rs.getInt("idLocal"));
                }


                dispose();
                ventana_agregarProducto_local ventana_ingreso = new ventana_agregarProducto_local(localAux);
                ventana_ingreso.initAtributes(txtNombre.getText());
                ventana_ingreso.init();


                txtNombre.setText("");
                txtLocal.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
            }
            else
            {
                System.out.println("Actualizando");

                txtNombre.setText(modificar.getNombreLocal());
                txtLocal.setText(modificar.getTipo());
                txtDireccion.setText(modificar.getDireccionLocal());
                txtTelefono.setText(modificar.getNumeroLocal());

                PreparedStatement ps = cn.prepareStatement("update loginLocal set nombreLocal = ? , set tipoLocal = ? , direccionLocal = ? , numeroLocal = ? where idLocal = ?");
                ps.setString(1, modificar.getNombreLocal());
                ps.setString(2, modificar.getTipo());
                ps.setString(3, modificar.getDireccionLocal());
                ps.setString(4, modificar.getNumeroLocal());
                ps.setInt(5, modificar.getId());
                ps.executeUpdate();
            }

        }catch (Exception c){
            System.out.println("c = " + c);
        }

    }
}