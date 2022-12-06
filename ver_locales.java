import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ver_locales extends JFrame{
    private JList list1;
    private JPanel panel1;
    private JList list2;
    private JButton comprarButton;
    private JLabel precioTotal;
    private Local localAux;
    Double aux = 0.0;

    private DefaultListModel lista = new DefaultListModel();
    private DefaultListModel plista = new DefaultListModel();

    public ver_locales(Local local) throws SQLException {
        this.localAux = local;
        setContentPane(panel1);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        Connection connection = DriverManager.getConnection("jdbc:mysql://185.61.126.162:3306/bd_poo", "root" , "Xv,c(!n8xf30");
        PreparedStatement pst = connection.prepareStatement("select * from agregarProducto where idLocalAUX = ?");

        System.out.println(localAux.getId());
        pst.setInt(1, localAux.getId());
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            lista.addElement(new Articulos(rs.getString("nombreProducto"), rs.getString("precioProducto")));
        }

        list1.setModel(lista);


        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Articulos a;
                super.mouseClicked(e);
                JList ls = (JList) e.getSource();
                int index = ls.locationToIndex(e.getPoint());
                a = (Articulos) ls.getModel().getElementAt(index);
                aux += Double.parseDouble(a.getPrecio());
                System.out.println(aux);
                plista.addElement(a);
                list2.setModel(plista);

                precioTotal.setText(String.valueOf(aux));

            }
        });
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String num = precioTotal.getText();
                if(Double.parseDouble(num) > 0) {
                    JOptionPane.showMessageDialog(null, "Su compra ha sido exitosa");
                }
            }
        });
    }

    public void init(Local local) {
        this.localAux = local;
    }
}
