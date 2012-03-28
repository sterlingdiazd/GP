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
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;

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

	setTitle("Sistema Gestor de Pacientes v.1.0");
	setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/imagenes/1329440782_kcmdrkonqi.png")));

	cvp = new ControladorVistaPrincipal(this);

	initComponents();
	setBounds(100, 100, 850, 650);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
	setVisible(true);
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
	panel.setBounds(10, 71, 824, 268);
	contentPane.add(panel);
	FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
	panel.setLayout(fl_panel);

	JPanel panel_3 = new JPanel();
	panel.add(panel_3);
	panel_3.setBorder(new TitledBorder(null, "Click para iniciar sesion", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
	FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
	flowLayout.setVgap(20);
	flowLayout.setHgap(10);

	JLabel lblNewLabel = new JLabel("");
	panel_3.add(lblNewLabel);
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/1329440782_kcmdrkonqi.png")));

	JLabel label_1 = new JLabel("Sistema Gestor de Pacientes");
	panel_3.add(label_1);
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	label_1.setFont(new Font("Calibri", Font.BOLD, 30));

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

	mntmIniciarSesion.addActionListener(cvp);
	mntmSalir.addActionListener(cvp);
	mntmManualDeUsuario.addActionListener(cvp);
	panel.addMouseListener(cvp);
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
    

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


}
