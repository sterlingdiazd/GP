package vistas;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import controladoresVistas.ControladorVistaInicioSesion;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.UIManager;

public class VistaInicioSesion extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsuarioInicioSesion;
    private JPasswordField passwordFieldInicioSesion;
    private ControladorVistaInicioSesion controladorVistaIC;
    private JButton btnIniciarSesion;
    private JButton btnLimpiar;
   
    public VistaInicioSesion(VistaPrincipal VP) {
	
    	setResizable(false);
	setModal(true);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VistaInicioSesion.class.getResource("/imagenes/1327957933_Key.png")));
    	setTitle("Iniciar Sesion - Sistema Gestor de Pacientes");
	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 455, 240);
	
	initComponentes();
	
	controladorVistaIC = new ControladorVistaInicioSesion(this, VP);
	btnIniciarSesion.addActionListener(controladorVistaIC);	
	btnLimpiar.addActionListener(controladorVistaIC);
    }

    public JTextField getTxtUsuarioInicioSesion() {
        return txtUsuarioInicioSesion;
    }
    
    public JTextField setTxtUsuarioInicioSesion(String usuario) {
	txtUsuarioInicioSesion.setText(usuario);
	return txtUsuarioInicioSesion;
    }
    
    public JPasswordField getPasswordFieldInicioSesion() {
        return passwordFieldInicioSesion;
    }

    public JTextField setPasswordFieldInicioSesion(char usuario) {
	passwordFieldInicioSesion.setText("");
	return passwordFieldInicioSesion;
    }
    
    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }
    
    public JButton getBtnLimpiar(){
	return btnLimpiar;
    }
    
    public void initComponentes(){
	contentPane = new JPanel();
	contentPane.setEnabled(false);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Iniciar Sesion", TitledBorder.CENTER, TitledBorder.TOP, null, null));
	panel.setBounds(25, 30, 400, 150);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblUsuario = new JLabel("Administrador");
	lblUsuario.setBounds(30, 35, 100, 14);
	panel.add(lblUsuario);
	
	JLabel lblClave = new JLabel("Clave");
	lblClave.setBounds(30, 74, 100, 14);
	panel.add(lblClave);
	
	txtUsuarioInicioSesion = new JTextField();
	txtUsuarioInicioSesion.setToolTipText("Introduzca su nombre de usuario");
	txtUsuarioInicioSesion.setPreferredSize(new Dimension(100, 20));
	txtUsuarioInicioSesion.setBounds(126, 32, 150, 20);
	panel.add(txtUsuarioInicioSesion);
	txtUsuarioInicioSesion.setColumns(10);
	
	passwordFieldInicioSesion = new JPasswordField();
	passwordFieldInicioSesion.setToolTipText("Introduzca su clave de acceso");
	passwordFieldInicioSesion.setPreferredSize(new Dimension(100, 20));
	passwordFieldInicioSesion.setBounds(126, 71, 150, 20);
	panel.add(passwordFieldInicioSesion);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(30, 105, 340, 27);
	panel.add(panel_1);
	
	btnIniciarSesion = new JButton("Iniciar Sesion");
	btnIniciarSesion.setToolTipText("Click para iniciar sesion");
	btnIniciarSesion.setPreferredSize(new Dimension(100, 23));
	panel_1.add(btnIniciarSesion);
	
	btnLimpiar = new JButton("Limpiar");
	btnLimpiar.setToolTipText("Click para borrar datos de los campos");
	btnLimpiar.setPreferredSize(new Dimension(100, 23));
	btnLimpiar.setSize(150, 30);
	panel_1.add(btnLimpiar);
	
	JLabel label = new JLabel("");
	label.setBounds(306, 27, 64, 64);
	panel.add(label);
	label.setIcon(new ImageIcon(VistaInicioSesion.class.getResource("/imagenes/1327957942_Lock.png")));
    }
    
}
