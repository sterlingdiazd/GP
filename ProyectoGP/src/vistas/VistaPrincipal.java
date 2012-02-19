package vistas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controladoresVistas.ControladorVistaPrincipal;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class VistaPrincipal extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ControladorVistaPrincipal cvp;
    private JPanel contentPane;
    private JMenuItem mntmIniciarSesion;
    private JMenuItem mntmManualDeUsuario;
    private JMenuItem mntmSalir;
    private JPanel panel;


    /**
     * Create the frame.
     */
    public VistaPrincipal() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/imagenes/1329440782_kcmdrkonqi.png")));
    	setTitle("Sistema Gestor de Pacientes v.1.0");
	
	initComponents();
	
	
	cvp = new ControladorVistaPrincipal(this);
	mntmIniciarSesion.addActionListener(cvp);
	mntmSalir.addActionListener(cvp);
	mntmManualDeUsuario.addActionListener(cvp);
	panel.addMouseListener(cvp);

	setBounds(100, 100, 850, 650);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
	setVisible(true);
    }
    
    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void initComponents(){
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblBlusycamisV = new JLabel("Sistema Gestor de Pacientes v.1.0");
	lblBlusycamisV.setHorizontalAlignment(SwingConstants.CENTER);
	lblBlusycamisV.setBounds(628, 548, 206, 45);
	contentPane.add(lblBlusycamisV);
	
	panel = new JPanel();
	panel.setBounds(10, 71, 824, 172);
	contentPane.add(panel);
	FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
	panel.setLayout(fl_panel);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/1329440782_kcmdrkonqi.png")));
	panel.add(lblNewLabel);
	
	JLabel label_1 = new JLabel("Sistema Gestor de Pacientes");
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	panel.add(label_1);
	label_1.setFont(new Font("Calibri", Font.BOLD, 30));
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(10, 283, 824, 57);
	contentPane.add(panel_1);
	
	JLabel label = new JLabel("");
	panel_1.add(label);
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnNewMenu = new JMenu("Inicio");
	mnNewMenu.setMnemonic('I');
	menuBar.add(mnNewMenu);
	
	mntmIniciarSesion = new JMenuItem("Iniciar Sesion");
	mnNewMenu.add(mntmIniciarSesion);

	mntmSalir = new JMenuItem("Salir");
	mnNewMenu.add(mntmSalir);
	
	JMenu mnAyuda = new JMenu("Ayuda");
	menuBar.add(mnAyuda);
	
	mntmManualDeUsuario = new JMenuItem("Manual de usuario");
	mnAyuda.add(mntmManualDeUsuario);
    }

    public JMenuItem getMntmIniciarSesion() {
        return mntmIniciarSesion;
    }

    public JMenuItem getMntmManualDeUsuario() {
        return mntmManualDeUsuario;
    }

    public JMenuItem getMntmSalir() {
        return mntmSalir;
    }
}
