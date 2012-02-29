package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controladoresVistas.ControladorAgregarUsuario;
import enums.Roles;
import javax.swing.SwingConstants;

public class AgregarUsuario extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtIdusuario;
    private JTextField txtUsuario;
    private JTextField txtClave;
    private JTextField txtCedula;
    private JTextField txtDireccion;
    private JTextField txtCargo;
    private JTextField txtCasa;
    private JTextField txtOficina;
    private JTextField txtCelular;
    private JTextField txtBbpin;
    private JTextField txtFacebook;
    private JTextField txtSkype;
    private JTextField txtGmail;
    private JTextField txtHotmail;
    private JTextField txtLinkedin;
    private JLabel lblClave;
    private JLabel lblCedula;
    private JLabel lblDireccion;
    private JLabel lblCargo;
    private JLabel lblPerfil;
    private JLabel lblTelCasa;
    private JLabel lblTelOficina;
    private JLabel lblCelular;
    private JLabel lblFacebook;
    private JLabel lblSkype;
    private JLabel lblGmail;
    private JLabel lblHotmail;
    private JLabel lblLinkedin;
    private ControladorAgregarUsuario controladorAgregarUsuario;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JComboBox<Roles> comboBoxPerfil;

    /**
     * Create the dialog.
     */
    public AgregarUsuario() {
    	setModal(true);
    	setResizable(false);
    	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	setTitle("Agregar Usuario");
	setBounds(100, 100, 460, 403);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	{
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 434, 283);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Insertando datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario");
		lblIdUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdUsuario.setBounds(10, 28, 80, 14);
		panel.add(lblIdUsuario);
		
		txtIdusuario = new JTextField();
		txtIdusuario.setBounds(100, 25, 115, 20);
		panel.add(txtIdusuario);
		txtIdusuario.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre Usuario");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setBounds(10, 59, 80, 14);
		panel.add(lblNombreDeUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Texto/Numero. El nombre de usuario,  ");
		txtUsuario.setBounds(100, 56, 115, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(301, 56, 115, 20);
		txtClave.setToolTipText("Texto. Clave para ingresar al sistema.");
		panel.add(txtClave);
		txtClave.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(100, 118, 115, 20);
		txtCedula.setToolTipText("Texto/Numero. Cedula de Identidad");
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(100, 87, 115, 20);
		txtDireccion.setToolTipText("Texto/Numero. Localidad donde vive. Modelo: C/Nombre Calle #No, Sector, Ciudad");
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setToolTipText("Texto. Puesto, posicion, funcion, empleao que desempeña en la compañia.");
		txtCargo.setBounds(301, 87, 115, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		txtCasa = new JTextField();
		txtCasa.setToolTipText("Numero. Telefono de su hogar.");
		txtCasa.setBounds(301, 118, 115, 20);
		panel.add(txtCasa);
		txtCasa.setColumns(10);
		
		txtOficina = new JTextField();
		txtOficina.setToolTipText("Numero. Telefono/extension/flota de la oficina donde se le pueda contactar.");
		txtOficina.setBounds(100, 150, 115, 20);
		panel.add(txtOficina);
		txtOficina.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(301, 150, 115, 20);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("BB Pin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 185, 80, 14);
		panel.add(lblNewLabel);
		
		txtBbpin = new JTextField();
		txtBbpin.setBounds(100, 181, 115, 20);
		panel.add(txtBbpin);
		txtBbpin.setColumns(10);
		
		txtFacebook = new JTextField();
		txtFacebook.setBounds(301, 182, 115, 20);
		panel.add(txtFacebook);
		txtFacebook.setColumns(10);
		
		txtSkype = new JTextField();
		txtSkype.setBounds(100, 244, 115, 20);
		panel.add(txtSkype);
		txtSkype.setColumns(10);
		
		txtGmail = new JTextField();
		txtGmail.setBounds(100, 213, 115, 20);
		panel.add(txtGmail);
		txtGmail.setColumns(10);
		
		txtHotmail = new JTextField();
		txtHotmail.setBounds(301, 213, 115, 20);
		panel.add(txtHotmail);
		txtHotmail.setColumns(10);
		
		txtLinkedin = new JTextField();
		txtLinkedin.setBounds(301, 244, 115, 20);
		panel.add(txtLinkedin);
		txtLinkedin.setColumns(10);
		
		lblClave = new JLabel("Clave");
		lblClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClave.setBounds(225, 59, 60, 14);
		panel.add(lblClave);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setBounds(10, 121, 80, 14);
		panel.add(lblCedula);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setBounds(10, 90, 80, 14);
		panel.add(lblDireccion);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargo.setBounds(225, 90, 60, 14);
		panel.add(lblCargo);
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerfil.setBounds(225, 28, 60, 14);
		panel.add(lblPerfil);
		
		lblTelCasa = new JLabel("Tel Casa");
		lblTelCasa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelCasa.setBounds(225, 121, 60, 14);
		panel.add(lblTelCasa);
		
		lblTelOficina = new JLabel("Tel Oficina");
		lblTelOficina.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelOficina.setBounds(10, 154, 80, 14);
		panel.add(lblTelOficina);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCelular.setBounds(225, 153, 60, 14);
		panel.add(lblCelular);
		
		lblSkype = new JLabel("Skype");
		lblSkype.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSkype.setBounds(10, 246, 80, 14);
		panel.add(lblSkype);
		
		lblGmail = new JLabel("Gmail");
		lblGmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGmail.setBounds(10, 216, 80, 14);
		panel.add(lblGmail);
		
		lblHotmail = new JLabel("Hotmail");
		lblHotmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotmail.setBounds(225, 216, 60, 14);
		panel.add(lblHotmail);
		
		lblLinkedin = new JLabel("LinkedIn");
		lblLinkedin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLinkedin.setBounds(225, 246, 60, 14);
		panel.add(lblLinkedin);
		
		comboBoxPerfil = new JComboBox<Roles>();
		comboBoxPerfil.setModel(new DefaultComboBoxModel<Roles>(Roles.values()));
		comboBoxPerfil.setBounds(300, 24, 116, 22);
		panel.add(comboBoxPerfil);
		
		lblFacebook = new JLabel("Facebook");
		lblFacebook.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFacebook.setBounds(225, 185, 60, 14);
		panel.add(lblFacebook);
	}
	
	JPanel panel = new JPanel();
	panel.setBounds(10, 300, 385, 60);
	FlowLayout flowLayout = (FlowLayout) panel.getLayout();
	flowLayout.setVgap(-3);
	panel.setBorder(new TitledBorder(null, "Agregar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	contentPanel.add(panel);
	
	btnAgregar = new JButton("Agregar");
	btnAgregar.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/imagenes/add.png")));
	panel.add(btnAgregar);
	
	btnCancelar = new JButton("Cancelar");
	btnCancelar.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/imagenes/delete copia.png")));
	panel.add(btnCancelar);
	
	controladorAgregarUsuario = new ControladorAgregarUsuario(this);
	btnAgregar.addActionListener(controladorAgregarUsuario); 
	btnCancelar.addActionListener(controladorAgregarUsuario);
    }

    public JTextField getTxtIdusuario() {
        return txtIdusuario;
    }

    public void setTxtIdusuario(JTextField txtIdusuario) {
        this.txtIdusuario = txtIdusuario;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JTextField getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(JTextField txtClave) {
        this.txtClave = txtClave;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField gettxtCargo() {
        return txtCargo;
    }

    public void settxtCargo(JTextField txtCargo) {
        this.txtCargo = txtCargo;
    }

    public JComboBox<Roles> getComboBoxPerfil() {
        return comboBoxPerfil;
    }

    public void setComboBoxPerfil(JComboBox<Roles> comboBoxPerfil) {
        this.comboBoxPerfil = comboBoxPerfil;
    }

    public JTextField getTxtCasa() {
        return txtCasa;
    }

    public void setTxtCasa(JTextField txtCasa) {
        this.txtCasa = txtCasa;
    }

    public JTextField getTxtOficina() {
        return txtOficina;
    }

    public void setTxtOficina(JTextField txtOficina) {
        this.txtOficina = txtOficina;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(JTextField txtCelular) {
        this.txtCelular = txtCelular;
    }

    public JTextField getTxtBbpin() {
        return txtBbpin;
    }

    public void setTxtBbpin(JTextField txtBbpin) {
        this.txtBbpin = txtBbpin;
    }

    public JTextField getTxtFacebook() {
        return txtFacebook;
    }

    public void setTxtFacebook(JTextField txtFacebook) {
        this.txtFacebook = txtFacebook;
    }

    public JTextField getTxtSkype() {
        return txtSkype;
    }

    public void setTxtSkype(JTextField txtSkype) {
        this.txtSkype = txtSkype;
    }

    public JTextField getTxtGmail() {
        return txtGmail;
    }

    public void setTxtGmail(JTextField txtGmail) {
        this.txtGmail = txtGmail;
    }

    public JTextField getTxtHotmail() {
        return txtHotmail;
    }

    public void setTxtHotmail(JTextField txtHotmail) {
        this.txtHotmail = txtHotmail;
    }

    public JTextField getTxtLinkedin() {
        return txtLinkedin;
    }

    public void setTxtLinkedin(JTextField txtLinkedin) {
        this.txtLinkedin = txtLinkedin;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
