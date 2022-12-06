import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ventana_Menu extends JFrame {

    private JPanel panel1;
    private JButton ingresarComoClienteButton;
    private JButton ingresarComoLocalButton;

    public ventana_Menu() {
        super("Menu Inicio.");
        setContentPane(panel1);
        setResizable(false);

        ingresarComoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame vc = new ventana_Cliente();
                vc.setSize(800, 500);
                vc.setLocationRelativeTo(null);
                vc.setVisible(true);
                dispose();

            }

        });

        ingresarComoLocalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana_intermediaria vi = null;
                try {
                    vi = new Ventana_intermediaria();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                vi.setSize(800, 500);
                vi.setLocationRelativeTo(null);
                vi.setVisible(true);
                dispose();
            }
        });
    }
}
