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
    private JTable table;
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
    private JScrollPane scrollPane;

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
	scrollPane.setBounds(10, 20, 719, 305);
	scrollPane.setViewportView(table);
    }

    public void initComponents(){
	getContentPane().setLayout(new BorderLayout());
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(10, 54, 764, 476);
	contentPanel.add(tabbedPane);

	JPanel panel_2 = new JPanel();
	panel_2.setBounds(new Rectangle(1000, 0, 0, 0));
	panel_2.setSize(new Dimension(1500, 0));
	panel_2.setToolTipText("Usuarios");
	tabbedPane.addTab("Usuarios", new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/usuario.png")), panel_2, "Mantenimiento de Usuarios");
	tabbedPane.setDisplayedMnemonicIndexAt(0, 1);
	tabbedPane.setMnemonicAt(0, 1);
	panel_2.setLayout(null);

	JPanel panel = new JPanel();
	panel.setAutoscrolls(true);
	panel.setBounds(new Rectangle(0, 0, 600, 0));
	panel.setBounds(10, 75, 739, 336);
	panel_2.add(panel);
	panel.setBorder(new TitledBorder(null, "Listado de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
	panel.setBackground(SystemColor.control);
	panel.setLayout(null);
	panel.add(scrollPane);

	JPanel panel_1 = new JPanel();
	FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
	flowLayout.setVgap(0);
	panel_1.setBounds(10, 5, 739, 65);
	panel_2.add(panel_1);
	panel_1.setBorder(new TitledBorder(null, "Funcionalidades", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	btnAgregar = new JButton("Agregar");
	btnAgregar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/add.png")));
	panel_1.add(btnAgregar);

	btnEditar = new JButton("Editar");
	btnEditar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/edit.png")));
	panel_1.add(btnEditar);

	btnEliminar = new JButton("Eliminar");
	btnEliminar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/delete copia.png")));
	panel_1.add(btnEliminar);

	txtBuscar = new JTextField();
	txtBuscar.setText(null);
	panel_1.add(txtBuscar);
	txtBuscar.setColumns(10);

	btnBuscar = new JButton("Buscar");
	btnBuscar.setIcon(new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/search.png")));
	panel_1.add(btnBuscar);


	JPanel panel_3 = new JPanel();
	tabbedPane.addTab("Productos", new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/products.png")), panel_3, "Mantenimiento de Productos");
	tabbedPane.setMnemonicAt(1, 2);
	tabbedPane.setDisplayedMnemonicIndexAt(1, 2);

	JPanel panel_4 = new JPanel();
	tabbedPane.addTab("New tab", new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/estadisticas.png")), panel_4, null);

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
