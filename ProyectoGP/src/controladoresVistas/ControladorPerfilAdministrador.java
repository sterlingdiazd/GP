package controladoresVistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Administrador;
import tableModels.ModeloTablaEncontrados;
import tableModels.UserTableModel;
import vistas.AgregarUsuario;
import vistas.PerfilAdministrador;
import vistas.VistaPrincipal;
import controladores.ControladorAdministrador;
import controladores.ControladorAutentificacion;
import controladores.ControladorGenerico;

public class ControladorPerfilAdministrador implements ActionListener, KeyListener, InputMethodListener{

    private PerfilAdministrador perfilAdministrador;
    private ControladorGenerico controlador;
    private AgregarUsuario vistaUsuario;
    private Administrador usuarioPorEditar;
    private int filaSeleccionada;
    private Administrador usuarioPorBuscar;

    private JTable table;
    private ArrayList<Object> allUsers;
    private String usuarioBuscado;
    private JScrollPane scrollPane;


    public ControladorPerfilAdministrador(PerfilAdministrador pa){
	this.perfilAdministrador = pa;
	controlador = new ControladorAdministrador();
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

	    if( perfilAdministrador.getTxtBuscar().getText().length() != 0 ) {

		perfilAdministrador.setAllUsers( controlador.buscarPorAtributoPrincipal(perfilAdministrador.getTxtBuscar().getText()) );
		perfilAdministrador.getTable().setModel( new ModeloTablaEncontrados( perfilAdministrador.getAllUsers() ) );
		perfilAdministrador.getScrollPane().setViewportView(perfilAdministrador.getTable());
		perfilAdministrador.getUserTableModel().fireTableDataChanged();

	    } else {
		JOptionPane.showMessageDialog(null, "Ingrese el nombre de Administrador y luego presione Enter \nO dele click a Buscar.", "Busqueda de Administrador", 
			JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorPerfilAdministrador.class.getResource("/imagenes/information.png")));
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

    public void configurarVistaAgregarUsuarioParaEditar(){

	vistaUsuario = new AgregarUsuario();
	vistaUsuario.setLocationRelativeTo(perfilAdministrador);
	vistaUsuario.getTxtIdusuario().setEnabled(false);
	vistaUsuario.setTitle("Editar Administrador");
	vistaUsuario.getBtnAgregar().setText("Guardar Edición");
	vistaUsuario.getPanel_Campos().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Editando datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	vistaUsuario.getPanel_Funcionalidades().setBorder(new TitledBorder(null, "Editar Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	vistaUsuario.getBtnAgregar().removeActionListener(vistaUsuario.getActionListerner());

    }

    public void crearUsuarioConCamposEscritosParaBuscar(){

	usuarioPorBuscar = new Administrador(  vistaUsuario.getTxtIdusuario().getText(), vistaUsuario.getTxtNombre().getText(), 
		vistaUsuario.getTxtApellido().getText(), vistaUsuario.getTxtNombreUsuario().getText(), vistaUsuario.getTxtClave().getText(), 
		vistaUsuario.getComboBoxPerfil().getSelectedItem().toString(), vistaUsuario.getTxtCedula().getText(), 
		vistaUsuario.getTxtTelefonos().getText(), vistaUsuario.getTxtDireccion().getText() );
    }

    public void cargarDatosEnCampos(){

	usuarioPorEditar = (Administrador) controlador.buscarTodo().get(filaSeleccionada);
	vistaUsuario.getTxtIdusuario().setText( String.valueOf( usuarioPorEditar.getIdUsuario() ) );
	vistaUsuario.getTxtNombre().setText( usuarioPorEditar.getNombre() );
	vistaUsuario.getTxtApellido().setText(usuarioPorEditar.getApellido());
	vistaUsuario.getTxtCedula().setText( usuarioPorEditar.getCedula());
	vistaUsuario.getTxtClave().setText( usuarioPorEditar.getClave());
	vistaUsuario.getTxtDireccion().setText( usuarioPorEditar.getDireccion());
	vistaUsuario.getTxtNombreUsuario().setText( usuarioPorEditar.getNombreUsuario());
	vistaUsuario.getTxtTelefonos().setText( usuarioPorEditar.getTelefonos());
    }

    public void eliminar(){
	int filaSeleccionada = perfilAdministrador.getTable().getSelectedRow();
	if(filaSeleccionada > 0 || filaSeleccionada == 0){

	    Administrador usuario = (Administrador) controlador.buscarTodo().get(filaSeleccionada);
	    int eliminar = JOptionPane.showConfirmDialog(perfilAdministrador, "¿Esta seguro que desea eliminar a " +  usuario.getNombre() + "?", "Eliminar Administrador", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
	    if(eliminar == 0){
		controlador.eliminar( controlador.buscarTodo().get(filaSeleccionada) );
	    }
	}
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
	usuarioPorEditar = new Administrador(  vistaUsuario.getTxtIdusuario().getText(), vistaUsuario.getTxtNombre().getText(), 
		vistaUsuario.getTxtApellido().getText(), vistaUsuario.getTxtNombreUsuario().getText(), vistaUsuario.getTxtClave().getText(), 
		vistaUsuario.getComboBoxPerfil().getSelectedItem().toString(), vistaUsuario.getTxtCedula().getText(), 
		vistaUsuario.getTxtTelefonos().getText(), vistaUsuario.getTxtDireccion().getText() );

	controlador.modificar(usuarioPorEditar);
	ArrayList<Object> usuariosAutentificados = controlador.buscarPorNombreUsuarioYClave(usuarioPorEditar);
	boolean seEdito = new ControladorAutentificacion().autentificarUsuario(usuarioPorEditar, usuariosAutentificados);

	if(seEdito){
	    JOptionPane.showMessageDialog(vistaUsuario, "Administrador \"" +usuarioPorEditar.getNombreUsuario() + "\"  editado satisfactoriamente. ", "Administrador Editado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
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
	
	    perfilAdministrador.setAllUsers( controlador.buscarPorAtributoPrincipal(perfilAdministrador.getTxtBuscar().getText()) );
	    perfilAdministrador.getTable().setModel( new ModeloTablaEncontrados( perfilAdministrador.getAllUsers() ) );
	    perfilAdministrador.getScrollPane().setViewportView(perfilAdministrador.getTable());
	    perfilAdministrador.getUserTableModel().fireTableDataChanged();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void inputMethodTextChanged(InputMethodEvent paramInputMethodEvent) {
	
    }

    @Override
    public void caretPositionChanged(InputMethodEvent paramInputMethodEvent) {
	// TODO Auto-generated method stub
	
    }

}
