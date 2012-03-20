package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controladoresVistas.ControladorAgregarUsuario;
import enums.Roles;

public class AgregarUsuario extends JDialog {

    /**
     * Componentes que son utiles para el Controlador de vista
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtIdusuario;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtClave;
    private JTextField txtNombreUsuario;
    private JTextField txtCedula;
    private JTextField txtTelefonos;
    private JLabel lblApellido;
    private JLabel lblNombre;
    private JLabel lblCedula;
    private JLabel lblPerfil;
    private JLabel lblClave_1;
    private ControladorAgregarUsuario controladorAgregarUsuario;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JComboBox<Roles> comboBoxPerfil;
    private JTextField txtDireccion;
    private JPanel panel_Campos;
    private JPanel panel_Funcionalidades;
    private ActionListener actionListerner;

    /**
     * Create the dialog.
     */
    public AgregarUsuario() {

    	setModal(true);
    	setResizable(false);
    	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	setTitle("Agregar Usuario");
	setBounds(100, 100, 460, 360);
	setLocationRelativeTo(null);
	
	initComponents();
	
	
	txtIdusuario.setEnabled(false);
	
	//controladorAgregarUsuario = new ControladorAgregarUsuario(this);
	actionListerner = new ControladorAgregarUsuario(this);
	
	btnAgregar.addActionListener(actionListerner);
	btnCancelar.addActionListener(actionListerner);
	
    }



    public ActionListener getActionListerner() {
        return actionListerner;
    }



    public void setActionListerner(ActionListener actionListerner) {
        this.actionListerner = actionListerner;
    }



    public void initComponents(){
	getContentPane().setName("COmpoenente Content Pane");
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPanel.setName("Nombre content pane");
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	{
		panel_Campos = new JPanel();
		panel_Campos.setBounds(10, 11, 434, 233);
		panel_Campos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Insertando datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.add(panel_Campos);
		panel_Campos.setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario");
		lblIdUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdUsuario.setBounds(27, 27, 80, 14);
		panel_Campos.add(lblIdUsuario);
		
		txtIdusuario = new JTextField();
		txtIdusuario.setBounds(27, 52, 115, 20);
		panel_Campos.add(txtIdusuario);
		txtIdusuario.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre Usuario");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setBounds(27, 97, 80, 14);
		panel_Campos.add(lblNombreDeUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Texto/Numero. El nombre de usuario,  ");
		txtNombre.setBounds(165, 52, 115, 20);
		panel_Campos.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(290, 52, 115, 20);
		txtApellido.setToolTipText("Texto. Clave para ingresar al sistema.");
		panel_Campos.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(165, 122, 115, 20);
		txtClave.setToolTipText("Texto/Numero. Cedula de Identidad");
		panel_Campos.add(txtClave);
		txtClave.setColumns(10);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(27, 122, 115, 20);
		txtNombreUsuario.setToolTipText("Texto/Numero. Localidad donde vive. Modelo: C/Nombre Calle #No, Sector, Ciudad");
		panel_Campos.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setToolTipText("Texto. Puesto, posicion, funcion, empleao que desempeña en la compañia.");
		txtCedula.setBounds(27, 186, 115, 20);
		panel_Campos.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTelefonos = new JTextField();
		txtTelefonos.setToolTipText("Numero. Telefono de su hogar.");
		txtTelefonos.setBounds(165, 186, 115, 20);
		panel_Campos.add(txtTelefonos);
		txtTelefonos.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setBounds(290, 27, 80, 14);
		panel_Campos.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(165, 27, 80, 14);
		panel_Campos.add(lblNombre);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setHorizontalAlignment(SwingConstants.LEFT);
		lblCedula.setBounds(27, 158, 60, 14);
		panel_Campos.add(lblCedula);
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerfil.setBounds(290, 97, 60, 14);
		panel_Campos.add(lblPerfil);
		
		lblClave_1 = new JLabel("Clave");
		lblClave_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblClave_1.setBounds(165, 97, 60, 14);
		panel_Campos.add(lblClave_1);
		
		comboBoxPerfil = new JComboBox<Roles>();
		comboBoxPerfil.setModel(new DefaultComboBoxModel<Roles>(Roles.values()));
		comboBoxPerfil.setBounds(290, 121, 116, 22);
		panel_Campos.add(comboBoxPerfil);
		
		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setBounds(165, 161, 115, 14);
		panel_Campos.add(lblTelefonos);
		
		txtDireccion = new JTextField();
		txtDireccion.setToolTipText("Numero. Telefono de su hogar.");
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(290, 186, 115, 20);
		panel_Campos.add(txtDireccion);
		
		JLabel label = new JLabel("Direccion");
		label.setBounds(290, 161, 46, 14);
		panel_Campos.add(label);
	}
	
	panel_Funcionalidades = new JPanel();
	panel_Funcionalidades.setName("Panel_Funcionalidades");
	panel_Funcionalidades.setBounds(10, 255, 434, 60);
	FlowLayout fl_panel_Funcionalidades = (FlowLayout) panel_Funcionalidades.getLayout();
	fl_panel_Funcionalidades.setVgap(-3);
	panel_Funcionalidades.setBorder(new TitledBorder(null, "Agregar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	contentPanel.add(panel_Funcionalidades);
	
	btnAgregar = new JButton("Agregar");
	btnAgregar.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/imagenes/add.png")));
	panel_Funcionalidades.add(btnAgregar);
	
	btnCancelar = new JButton("Cancelar");
	btnCancelar.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/imagenes/delete copia.png")));
	panel_Funcionalidades.add(btnCancelar);
    }
    
    
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }
    
    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(JTextField txtClave) {
        this.txtClave = txtClave;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtTelefonos() {
        return txtTelefonos;
    }

    public void setTxtTelefonos(JTextField txtTelefonos) {
        this.txtTelefonos = txtTelefonos;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JComboBox<Roles> getComboBoxPerfil() {
        return comboBoxPerfil;
    }

    public void setComboBoxPerfil(JComboBox<Roles> comboBoxPerfil) {
        this.comboBoxPerfil = comboBoxPerfil;
    }
    
    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtIdusuario() {
        return txtIdusuario;
    }
    
    public JPanel getPanel_Campos() {
        return panel_Campos;
    }

    public void setPanel_Campos(JPanel panel_Campos) {
        this.panel_Campos = panel_Campos;
    }

    public JPanel getPanel_Funcionalidades() {
        return panel_Funcionalidades;
    }

    public void setPanel_Funcionalidades(JPanel panel_Funcionalidades) {
        this.panel_Funcionalidades = panel_Funcionalidades;
    }
}
