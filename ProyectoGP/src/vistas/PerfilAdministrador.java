package vistas;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import tableModels.UserTableModel;
import controladores.MantenimientoUsuario;
import controladoresVistas.ControladorPerfilAdministrador;

public class PerfilAdministrador extends JDialog {

    /**
     * Version 1.0 Modulo de Usuarios
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private UserTableModel userTableModel;
    private ArrayList<Object> allUsers;

    private MantenimientoUsuario controladorUsuario;
    private ControladorPerfilAdministrador controladorPerfilAdministrador;
    private JButton btnBuscar;
    private JButton btnEditar;
    private JButton btnAgregarUsuario;
    private JButton btnEliminar;
    private JMenuItem mntmCerrarSesion;
    private JMenuItem mntmManualDeUsuario;
    private JMenuItem mntmSalir;
    private JTextField txtBuscar;
    private JScrollPane scrollPane;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JTextField textField;
    private JButton button_3;
    private JTable table_1;

    public PerfilAdministrador() {

	setModal(true);
	setResizable(false);
	setTitle("Perfil Administrador - Sistema Gestor de Pacientes");
	setFont(new Font("Cal+ibri", Font.PLAIN, 12));
	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 800,600);
	setLocationRelativeTo(null);

	cargarTabla();
	configurarTablaAndScrollPane();
	initComponents();

	controladorPerfilAdministrador = new ControladorPerfilAdministrador(this);
	btnAgregarUsuario.addActionListener(controladorPerfilAdministrador);
	btnEditar.addActionListener(controladorPerfilAdministrador);
	btnBuscar.addActionListener(controladorPerfilAdministrador);
	txtBuscar.addInputMethodListener(controladorPerfilAdministrador);
	btnEliminar.addActionListener(controladorPerfilAdministrador);
	mntmCerrarSesion.addActionListener(controladorPerfilAdministrador);
	mntmSalir.addActionListener(controladorPerfilAdministrador);

	setVisible(true);
    }

    public JTextField getTxtBuscar() {
	return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
	this.txtBuscar = txtBuscar;
    }

    public void cargarTabla(){
	controladorUsuario = new MantenimientoUsuario();
	allUsers = new ArrayList<Object>();
	allUsers = controladorUsuario.buscarTodo();
	userTableModel = new UserTableModel(allUsers);
    }

    public void configurarTablaAndScrollPane(){

	table = new JTable();
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	table.setAlignmentX(Component.CENTER_ALIGNMENT);
	table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
	table.setAutoCreateRowSorter(true);
	table.setModel(userTableModel);

	scrollPane = new JScrollPane();
	scrollPane.setAutoscrolls(true);
	scrollPane.setEnabled(false);
	scrollPane.setBounds(10, 20, 719, 291);
	scrollPane.setViewportView(table);
    }

    public void initComponents(){
	getContentPane().setLayout(new BorderLayout());
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 54, 764, 486);
	contentPanel.add(tabbedPane);

	JPanel panelUsuarios = new JPanel();
	panelUsuarios.setBounds(new Rectangle(1000, 0, 0, 0));
	panelUsuarios.setSize(new Dimension(1500, 0));
	panelUsuarios.setToolTipText("Usuarios");
	tabbedPane.addTab("Usuarios", new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/usuario.png")), panelUsuarios, "Mantenimiento de Usuarios");
	tabbedPane.setDisplayedMnemonicIndexAt(0, 1);
	tabbedPane.setMnemonicAt(0, 1);
	panelUsuarios.setLayout(null);

	JPanel panelTablaUsuarios = new JPanel();
	panelTablaUsuarios.setAutoscrolls(true);
	panelTablaUsuarios.setBounds(new Rectangle(0, 0, 600, 0));
	panelTablaUsuarios.setBounds(10, 75, 739, 322);
	panelUsuarios.add(panelTablaUsuarios);
	panelTablaUsuarios.setBorder(new TitledBorder(null, "Listado de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
	panelTablaUsuarios.setBackground(SystemColor.control);
	panelTablaUsuarios.setLayout(null);
	panelTablaUsuarios.add(scrollPane);

	JPanel panelFuncionalidadesUsuarios = new JPanel();
	FlowLayout fl_panel_Funcionalidades = (FlowLayout) panelFuncionalidadesUsuarios.getLayout();
	fl_panel_Funcionalidades.setVgap(0);
	panelFuncionalidadesUsuarios.setBounds(10, 5, 739, 65);
	panelUsuarios.add(panelFuncionalidadesUsuarios);
	panelFuncionalidadesUsuarios.setBorder(new TitledBorder(null, "Funcionalidades", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	btnAgregarUsuario = new JButton("Agregar");
	btnAgregarUsuario.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/add.png")));
	panelFuncionalidadesUsuarios.add(btnAgregarUsuario);

	btnEditar = new JButton("Editar");
	btnEditar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/edit.png")));
	panelFuncionalidadesUsuarios.add(btnEditar);

	btnEliminar = new JButton("Eliminar");
	btnEliminar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/delete copia.png")));
	panelFuncionalidadesUsuarios.add(btnEliminar);

	txtBuscar = new JTextField();
	txtBuscar.setText(null);
	panelFuncionalidadesUsuarios.add(txtBuscar);
	txtBuscar.setColumns(10);

	btnBuscar = new JButton("Buscar");
	btnBuscar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/search.png")));
	panelFuncionalidadesUsuarios.add(btnBuscar);
	
	JPanel panel = new JPanel();
	tabbedPane.addTab("Enfermedades", new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/enfermedades.png")), panel, "Enfermedades");
	panel.setLayout(null);
	
	JPanel panel_1 = new JPanel();
	FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
	flowLayout.setVgap(0);
	panel_1.setBorder(new TitledBorder(null, "Funcionalidades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel_1.setBounds(10, 5, 739, 65);
	panel.add(panel_1);
	
	button = new JButton("Agregar");
	button.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/add.png")));
	panel_1.add(button);
	
	button_1 = new JButton("Editar");
	button_1.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/edit.png")));
	panel_1.add(button_1);
	
	button_2 = new JButton("Eliminar");
	button_2.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/delete copia.png")));
	panel_1.add(button_2);
	
	textField = new JTextField();
	textField.setText((String) null);
	textField.setColumns(10);
	panel_1.add(textField);
	
	button_3 = new JButton("Buscar");
	button_3.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/search.png")));
	panel_1.add(button_3);
	
	JPanel panelEnfermedades = new JPanel();
	panelEnfermedades.setLayout(null);
	panelEnfermedades.setBounds(new Rectangle(0, 0, 600, 0));
	panelEnfermedades.setBackground(SystemColor.menu);
	panelEnfermedades.setAutoscrolls(true);
	panelEnfermedades.setBounds(10, 75, 739, 322);
	panel.add(panelEnfermedades);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setEnabled(false);
	scrollPane_1.setAutoscrolls(true);
	scrollPane_1.setBounds(10, 20, 719, 291);
	panelEnfermedades.add(scrollPane_1);
	
	table_1 = new JTable();
	scrollPane_1.setViewportView(table_1);
	table_1.setModel(userTableModel);
	
	JPanel panel_6 = new JPanel();
	panel_6.setBorder(new TitledBorder(null, "Datos del Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel_6.setBounds(10, 5, 764, 45);
	contentPanel.add(panel_6);

	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);

	JMenu mnNewMenu = new JMenu("Inicio");
	mnNewMenu.setMnemonic('I');
	menuBar.add(mnNewMenu);

	mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
	mnNewMenu.add(mntmCerrarSesion);

	mntmSalir = new JMenuItem("Salir");
	mnNewMenu.add(mntmSalir);

	JMenu mnAyuda = new JMenu("Ayuda");
	menuBar.add(mnAyuda);

	mntmManualDeUsuario = new JMenuItem("Manual de usuario");
	mnAyuda.add(mntmManualDeUsuario);

    }

    public JScrollPane getScrollPane() {
	return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
	this.scrollPane = scrollPane;
    }

    public UserTableModel getUserTableModel() {
	return userTableModel;
    }

    public void setUserTableModel(UserTableModel userTableModel) {
	this.userTableModel = userTableModel;
    }

    public JButton getBtnBuscar() {
	return btnBuscar;
    }

    public JButton getBtnEditar() {
	return btnEditar;
    }

    public JButton getBtnAgregar() {
	return btnAgregarUsuario;
    }

    public JButton getBtnEliminar() {
	return btnEliminar;
    }

    public JMenuItem getMntmCerrarSesion() {
	return mntmCerrarSesion;
    }

    public JMenuItem getMntmManualDeUsuario() {
	return mntmManualDeUsuario;
    }

    public JMenuItem getMntmSalir() {
	return mntmSalir;
    }

    public JTable getTable() {
	return table;
    }

    public void setTable(JTable table) {
	this.table = table;
    }

    public ArrayList<Object> getAllUsers() {
	return allUsers;
    }

    public void setAllUsers(ArrayList<Object> allUsers) {
	this.allUsers = allUsers;
    }
}
