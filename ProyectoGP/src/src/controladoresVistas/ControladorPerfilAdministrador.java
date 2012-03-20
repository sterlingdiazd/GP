package controladoresVistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;

import modelos.Usuario;
import tableModels.UserTableModel;
import vistas.AgregarUsuario;
import vistas.PerfilAdministrador;
import vistas.VistaPrincipal;
import controladores.ControladorAutentificacion;
import controladores.ControladorUsuario;

public class ControladorPerfilAdministrador implements ActionListener, KeyListener{

    private PerfilAdministrador perfilAdministrador;
    private ControladorUsuario controladorUsuario;
    private AgregarUsuario vistaUsuario;
    private Usuario usuarioPorEditar;
    private int filaSeleccionada;
    private Usuario usuarioPorBuscar;

    public ControladorPerfilAdministrador(PerfilAdministrador pa){
	this.perfilAdministrador = pa;
	controladorUsuario = new ControladorUsuario();
	perfilAdministrador.getTxtBuscar().addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	if(e.getSource().equals(perfilAdministrador.getBtnAgregar())){		//	AGREGAR 
	    new AgregarUsuario().setVisible(true);
	    perfilAdministrador.getUserTableModel().fireTableDataChanged();
	}

	if(e.getSource().equals(perfilAdministrador.getBtnEditar())){		//	EDITAR
	    editarUsuario();
	    perfilAdministrador.getUserTableModel().fireTableDataChanged();
	}

	if(e.getSource().equals(perfilAdministrador.getBtnEliminar())){		//	ELIMINAR
	    eliminar();
	    perfilAdministrador.getUserTableModel().fireTableDataChanged();
	}

	if( e.getSource().equals( perfilAdministrador.getBtnBuscar() ) ){	//	BUSCAR
	    System.out.println("Le di a buscar");


	    if(perfilAdministrador.getTxtBuscar().getText().length() != 0 ) {

		/*

		 */
		perfilAdministrador.getBtnBuscar();
		perfilAdministrador.getUserTableModel().fireTableDataChanged();

	    } else {
		JOptionPane.showMessageDialog(null, "Ingrese el nombre de Usuario y luego presione Enter \nO dele click a Buscar.", "Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorPerfilAdministrador.class.getResource("/imagenes/information.png")));

	    }


	}

	if(e.getSource().equals(perfilAdministrador.getMntmCerrarSesion())){
	    perfilAdministrador.dispose();
	    VistaPrincipal vp = new VistaPrincipal();
	    vp.setLocationRelativeTo(null);
	    vp.setVisible(true);
	}

	if(e.getSource().equals(perfilAdministrador.getMntmSalir())){
	    System.exit(0); 
	}
    }

    public void buscar(){

	configurarVistaAgregarUsuarioParaBuscar();
	vistaUsuario.getBtnAgregar().addActionListener(new ActionListener(){

	    @Override	
	    public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vistaUsuario.getBtnAgregar())){

		    crearUsuarioConCamposEscritosParaBuscar();
		    //controladorUsuario.buscarPorParametro(usuarioPorBuscar);
		    ArrayList<Object> usuariosEncontrados = controladorUsuario.buscarPorParametro(usuarioPorBuscar);

		    for(int x = 0; x < usuariosEncontrados.size(); x++){
			System.out.println( ((Usuario) usuariosEncontrados.get(x)).getNombre() );
		    }
		    vistaUsuario.dispose();
		}
	    }
	});

	vistaUsuario.setVisible(true);
    }

    public void configurarVistaAgregarUsuarioParaBuscar(){
	vistaUsuario = new AgregarUsuario();
	vistaUsuario.setLocationRelativeTo(perfilAdministrador);
	vistaUsuario.getTxtIdusuario().setEnabled(true);
	vistaUsuario.setTitle("Buscar Usuario");
	vistaUsuario.getBtnAgregar().setText("Buscar");
	vistaUsuario.getPanel_Campos().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscando datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	vistaUsuario.getPanel_Funcionalidades().setBorder(new TitledBorder(null, "Buscar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	vistaUsuario.getBtnAgregar().removeActionListener(vistaUsuario.getActionListerner());
    }

    public void eliminar(){
	int filaSeleccionada = perfilAdministrador.getTable().getSelectedRow();
	if(filaSeleccionada > 0 || filaSeleccionada == 0){

	    Usuario usuario = (Usuario) controladorUsuario.buscarTodo().get(filaSeleccionada);
	    int eliminar = JOptionPane.showConfirmDialog(perfilAdministrador, "¿Esta seguro que desea eliminar a " +  usuario.getNombre() + "?", "Eliminar Usuario", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
	    if(eliminar == 0){
		controladorUsuario.eliminar( controladorUsuario.buscarTodo().get(filaSeleccionada) );

	    }
	}
    }

    public void configurarVistaAgregarUsuarioParaEditar(){

	vistaUsuario = new AgregarUsuario();
	vistaUsuario.setLocationRelativeTo(perfilAdministrador);
	vistaUsuario.getTxtIdusuario().setEnabled(false);
	vistaUsuario.setTitle("Editar Usuario");
	vistaUsuario.getBtnAgregar().setText("Guardar Edición");
	vistaUsuario.getPanel_Campos().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Editando datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	vistaUsuario.getPanel_Funcionalidades().setBorder(new TitledBorder(null, "Editar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	vistaUsuario.getBtnAgregar().removeActionListener(vistaUsuario.getActionListerner());

    }

    public void crearUsuarioConCamposEscritosParaBuscar(){

	usuarioPorBuscar = new Usuario(  vistaUsuario.getTxtIdusuario().getText(), vistaUsuario.getTxtNombre().getText(), 
		vistaUsuario.getTxtApellido().getText(), vistaUsuario.getTxtNombreUsuario().getText(), vistaUsuario.getTxtClave().getText(), 
		vistaUsuario.getComboBoxPerfil().getSelectedItem().toString(), vistaUsuario.getTxtCedula().getText(), 
		vistaUsuario.getTxtTelefonos().getText(), vistaUsuario.getTxtDireccion().getText() );
    }

    public void cargarDatosEnCampos(){

	usuarioPorEditar = (Usuario) controladorUsuario.buscarTodo().get(filaSeleccionada);

	vistaUsuario.getTxtIdusuario().setText( String.valueOf( usuarioPorEditar.getIdUsuario() ) );
	vistaUsuario.getTxtNombre().setText( usuarioPorEditar.getNombre() );
	vistaUsuario.getTxtApellido().setText(usuarioPorEditar.getApellido());
	vistaUsuario.getTxtCedula().setText( usuarioPorEditar.getCedula());
	vistaUsuario.getTxtClave().setText( usuarioPorEditar.getClave());
	vistaUsuario.getTxtDireccion().setText( usuarioPorEditar.getDireccion());
	vistaUsuario.getTxtNombreUsuario().setText( usuarioPorEditar.getNombreUsuario());
	vistaUsuario.getTxtTelefonos().setText( usuarioPorEditar.getTelefonos());
    }

    public void editarUsuario(){

	filaSeleccionada = perfilAdministrador.getTable().getSelectedRow();
	if(filaSeleccionada > 0 || filaSeleccionada == 0){

	    configurarVistaAgregarUsuarioParaEditar();
	    cargarDatosEnCampos();
	    vistaUsuario.getBtnAgregar().addActionListener(new ActionListener(){

		@Override	
		public void actionPerformed(ActionEvent e) {
		    if(e.getSource().equals(vistaUsuario.getBtnAgregar())){
			modificacion();
		    }
		}
	    });

	    vistaUsuario.setVisible(true);

	} else{
	    JOptionPane.showMessageDialog(perfilAdministrador, "Seleccione la fila que desea editar.", "Adventencia", JOptionPane.INFORMATION_MESSAGE,   new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
	}

    }

    public void modificacion(){
	usuarioPorEditar = new Usuario(  vistaUsuario.getTxtIdusuario().getText(), vistaUsuario.getTxtNombre().getText(), 
		vistaUsuario.getTxtApellido().getText(), vistaUsuario.getTxtNombreUsuario().getText(), vistaUsuario.getTxtClave().getText(), 
		vistaUsuario.getComboBoxPerfil().getSelectedItem().toString(), vistaUsuario.getTxtCedula().getText(), 
		vistaUsuario.getTxtTelefonos().getText(), vistaUsuario.getTxtDireccion().getText() );

	controladorUsuario.modificar(usuarioPorEditar);
	ArrayList<Object> usuariosAutentificados = controladorUsuario.buscarPorParametro(usuarioPorEditar);
	boolean seEdito = new ControladorAutentificacion().autentificarUsuario(usuarioPorEditar, usuariosAutentificados);

	if(seEdito){
	    JOptionPane.showMessageDialog(vistaUsuario, "Usuario \"" +usuarioPorEditar.getNombreUsuario() + "\"  editado satisfactoriamente. ", "Usuario Editado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
	} 	else {
	    JOptionPane.showMessageDialog(vistaUsuario, "No se edito. ", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/information.png")));
	}

	vistaUsuario.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
	if(e.getSource().equals(perfilAdministrador.getTxtBuscar())){

	    if(e.getKeyCode() == 10){

		ArrayList<Object> objectoBuscado = new ArrayList<Object>();
		UserTableModel userTableModel = new UserTableModel(objectoBuscado);

		

		/*
    		 JTable table = new JTable();
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

    			controladorUsuario = new ControladorUsuario();
    			allUsers = new ArrayList<Object>();
    			allUsers = controladorUsuario.buscarTodo();
    			userTableModel = new UserTableModel(allUsers);

    		perfilAdministrador.configurarTablaAndScrollPane();
    		perfilAdministrador.getTable().setModel(userTableModel);
    		perfilAdministrador.getScrollPane().setViewportView(perfilAdministrador.getTable());
		 */

		/*
    		if( new ValicacionCampoLleno().validacionCampoLleno(perfilAdministrador.getTxtBuscar()) ){
    		    ArrayList<Usuario> usuariosBuscado = new ArrayList<Usuario>();
    		    ArrayList<Object> objectoBuscado = new ArrayList<Object>();

    		    objectoBuscado  = controladorUsuario.buscarPorNombreUsuario(perfilAdministrador.getTxtBuscar().getText());
    		    UserTableModel userTableModel = new UserTableModel(objectoBuscado);
		 */

		/*
    		   for(int x = 0; x < objectoBuscado.size(); x ++){

    		       Usuario usuario = (Usuario) objectoBuscado.get(x);
    		       usuariosBuscado.add(usuario);

    		   }
		 */
		/*
		   controladorUsuario.getAllUsers().clear();
		   controladorUsuario.setAllUsers(objectoBuscado);
		   perfilAdministrador.configurarTablaAndScrollPane();
		 */
		/*
		    JTable table = new JTable();
		    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    table.setFillsViewportHeight(true);
		    table.setAlignmentX(Component.CENTER_ALIGNMENT);
		    table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
		    table.setAutoCreateRowSorter(true);
		    table.setModel(userTableModel);

		    perfilAdministrador.getScrollPane().setViewportView(table);
		    //perfilAdministrador.getTable().setModel( userTableModel );

		    //perfilAdministrador.getUserTableModel().fireTableDataChanged();

		} else {
		    JOptionPane.showMessageDialog(null, "Ingrese el nombre de Usuario y luego presione Enter \nO dele click a Buscar.", "Busqueda de Usuario", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorPerfilAdministrador.class.getResource("/imagenes/information.png")));
		}
		 */
	    } 

	}

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
