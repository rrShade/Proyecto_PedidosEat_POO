import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class ventana_eleccionLocales extends JFrame{


    private JPanel panel1;
    private JButton ingresarLocalButton;
    private JPanel panel2;
    private JList list1;
    private DefaultListModel lista = new DefaultListModel();
    public Local aux;

    public ventana_eleccionLocales() throws SQLException {
        setContentPane(panel1);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


        Connection connection = DriverManager.getConnection("jdbc:mysql://185.61.126.162:3306/bd_poo", "root" , "Xv,c(!n8xf30");
        PreparedStatement pst = connection.prepareStatement("select * from loginLocal");

        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            lista.addElement(new Local(rs.getInt("idLocal"), rs.getString("nombreLocal"), rs.getString("tipoLocal"), rs.getString("direccionLocal"),
                    rs.getString("numeroLocal")));
        }

        list1.setModel(lista);


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

        ingresarLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("id : "+ aux.getId());
                ver_locales lc = null;
                try {
                    lc = new ver_locales(aux);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                lc.setVisible(true);

            }
        });
    }
}
