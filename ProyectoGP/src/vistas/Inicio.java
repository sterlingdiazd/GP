package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Inicio extends JDialog {

    private final JPanel contentPanel = new JPanel();
    /**
     * Create the dialog.
     */
    public Inicio() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/fondo.jpg")));
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBounds(10, 11, 422, 251);
	contentPanel.add(panel);
	

    }

}
