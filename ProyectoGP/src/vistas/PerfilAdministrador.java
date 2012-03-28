package vistas;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import tableModels.UserTableModel;
import controladores.ControladorUsuario;
import controladoresVistas.ControladorPerfilAdministrador;

public class PerfilAdministrador extends JDialog {

    /**
     * Version 1.0 Modulo de Usuarios
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable tableUsuarios;
    private UserTableModel userTableModel;
    private ArrayList<Object> allUsers;

    private ControladorUsuario controladorUsuario;
    private ControladorPerfilAdministrador controladorPerfilAdministrador;
    private JButton btnBuscar;
    private JButton btnEditar;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JMenuItem mntmCerrarSesion;
    private JMenuItem mntmManualDeUsuario;
    private JMenuItem mntmSalir;
    private JTextField txtBuscar;
    private JScrollPane scrollPaneUsuarios;

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
	btnAgregar.addActionListener(controladorPerfilAdministrador);
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
	controladorUsuario = new ControladorUsuario();
	allUsers = new ArrayList<Object>();
	allUsers = controladorUsuario.buscarTodo();
	userTableModel = new UserTableModel(allUsers);
    }

    public void configurarTablaAndScrollPane(){

	tableUsuarios = new JTable();
	tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tableUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	tableUsuarios.setFillsViewportHeight(true);
	tableUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
	tableUsuarios.setPreferredScrollableViewportSize(new Dimension(1000, 400));
	tableUsuarios.setAutoCreateRowSorter(true);
	tableUsuarios.setModel(userTableModel);

	scrollPaneUsuarios = new JScrollPane();
	scrollPaneUsuarios.setAutoscrolls(true);
	scrollPaneUsuarios.setEnabled(false);
	scrollPaneUsuarios.setBounds(10, 20, 719, 305);
	scrollPaneUsuarios.setViewportView(tableUsuarios);
    }

    public void initComponents(){
	getContentPane().setLayout(new BorderLayout());
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 54, 764, 476);
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
	panelTablaUsuarios.setBounds(10, 75, 739, 336);
	panelUsuarios.add(panelTablaUsuarios);
	panelTablaUsuarios.setBorder(new TitledBorder(null, "Listado de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
	panelTablaUsuarios.setBackground(SystemColor.control);
	panelTablaUsuarios.setLayout(null);
	panelTablaUsuarios.add(scrollPaneUsuarios);

	JPanel panelFuncionalidadesUsuarios = new JPanel();
	FlowLayout fl_panel_Funcionalidades = (FlowLayout) panelFuncionalidadesUsuarios.getLayout();
	fl_panel_Funcionalidades.setVgap(0);
	panelFuncionalidadesUsuarios.setBounds(10, 5, 739, 65);
	panelUsuarios.add(panelFuncionalidadesUsuarios);
	panelFuncionalidadesUsuarios.setBorder(new TitledBorder(null, "Funcionalidades", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	btnAgregar = new JButton("Agregar");
	btnAgregar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/add.png")));
	panelFuncionalidadesUsuarios.add(btnAgregar);

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
	
	JPanel panelEnfermedades = new JPanel();
	panelEnfermedades.setBounds(new Rectangle(1000, 0, 0, 0));
	panelEnfermedades.setSize(new Dimension(1500, 0));
	panelEnfermedades.setToolTipText("Usuarios");
	tabbedPane.addTab("Usuarios", new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/usuario.png")), panelEnfermedades, "Mantenimiento de Usuarios");
	tabbedPane.setDisplayedMnemonicIndexAt(0, 1);
	tabbedPane.setMnemonicAt(0, 1);
	panelEnfermedades.setLayout(null);

	JPanel panelTablaEnfermedades = new JPanel();
	panelTablaEnfermedades.setAutoscrolls(true);
	panelTablaEnfermedades.setBounds(new Rectangle(0, 0, 600, 0));
	panelTablaEnfermedades.setBounds(10, 75, 739, 336);
	panelEnfermedades.add(panelTablaEnfermedades);
	panelTablaEnfermedades.setBorder(new TitledBorder(null, "Listado de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
	panelTablaEnfermedades.setBackground(SystemColor.control);
	panelTablaEnfermedades.setLayout(null);
	panelTablaEnfermedades.add(scrollPaneUsuarios);

	JPanel panelFuncionalidadesEnfermedades = new JPanel();
	fl_panel_Funcionalidades.setVgap(0);
	panelFuncionalidadesEnfermedades.setBounds(10, 5, 739, 65);
	panelEnfermedades.add(panelFuncionalidadesEnfermedades);
	panelFuncionalidadesEnfermedades.setBorder(new TitledBorder(null, "Funcionalidades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	
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
	return scrollPaneUsuarios;
    }

    public void setScrollPane(JScrollPane scrollPane) {
	this.scrollPaneUsuarios = scrollPane;
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
	return btnAgregar;
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
	return tableUsuarios;
    }

    public void setTable(JTable table) {
	this.tableUsuarios = table;
    }

    public ArrayList<Object> getAllUsers() {
	return allUsers;
    }

    public void setAllUsers(ArrayList<Object> allUsers) {
	this.allUsers = allUsers;
    }

}
