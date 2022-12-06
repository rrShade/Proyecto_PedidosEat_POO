import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Ventana_intermediaria extends JFrame{
    private JList list1;
    private JButton okButton;
    private JButton registrarLocalButton;
    private JPanel panel1;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private DefaultListModel listaModel = new DefaultListModel();
    public Local aux;


    public Ventana_intermediaria() throws SQLException {
        setContentPane(panel1);
        setResizable(false);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        Connection connection = DriverManager.getConnection("jdbc:mysql://185.61.126.162:3306/bd_poo", "root" , "Xv,c(!n8xf30");
        PreparedStatement pst = connection.prepareStatement("select * from loginLocal");

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            listaModel.addElement(new Local(rs.getInt("idLocal"), rs.getString("nombreLocal"), rs.getString("tipoLocal"), rs.getString("direccionLocal"),
                    rs.getString("numeroLocal")));
        }

        list1.setModel(listaModel);


        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                JList ls = (JList) e.getSource();
                int index = ls.locationToIndex(e.getPoint());
                aux = (Local) ls.getModel().getElementAt(index);
                System.out.println(aux);
            }
        });

        registrarLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_Local vl = new ventana_Local(aux, null);
                vl.setVisible(true);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana_agregarProducto_local ap_local = new ventana_agregarProducto_local(aux);
                ap_local.setVisible(true);
                dispose();
            }
        });


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actualizar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void eliminar() throws SQLException {
        int index = list1.getSelectedIndex();

        String sql = "delete from loginLocal where nombreLocal=" + index;

        Connection connection = DriverManager.getConnection("jdbc:mysql://185.61.126.162:3306/bd_poo", "root" , "Xv,c(!n8xf30");
        Statement st = connection.createStatement();

        int n = st.executeUpdate(sql);

        if(n>=0) {
            listaModel.remove(index);
            list1.updateUI();
            JOptionPane.showMessageDialog(null,  "Registro eliminado");
        }
    }

    public void actualizar() throws SQLException {
        System.out.println(aux);
        ventana_Local actualizarDatos = new ventana_Local(null, aux);
        actualizarDatos.setVisible(true);

    }
}
