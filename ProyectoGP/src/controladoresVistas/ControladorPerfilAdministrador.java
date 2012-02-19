package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelos.Usuario;
import vistas.AgregarUsuario;
import vistas.EditarUsuario;
import vistas.PerfilAdministrador;
import vistas.VistaPrincipal;
import controladores.ControladorUsuario;

public class ControladorPerfilAdministrador implements ActionListener{

    private PerfilAdministrador VistaPA;
    private EditarUsuario editarUsuario;
    private AgregarUsuario agregarUsuario;
    private ControladorUsuario controladorUsuario;
    
    public ControladorPerfilAdministrador(PerfilAdministrador pa){
	this.VistaPA = pa;
    }
    
    public ControladorPerfilAdministrador(AgregarUsuario au){
	this.agregarUsuario = au;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	
	//AGREGAR USUARIO
	if(e.getSource().equals(VistaPA.getBtnAgregar())){
	    
	    agregarUsuario = new AgregarUsuario();
	    agregarUsuario.setLocationRelativeTo(VistaPA);
	    agregarUsuario.getTxtIdusuario().setEnabled(false);
	    agregarUsuario.setVisible(true);
	}
	if(e.getSource().equals(VistaPA.getBtnEditar())){
	    
	    int filaSeleccionada = VistaPA.getTable().getSelectedRow();
	    if(filaSeleccionada > 0 || filaSeleccionada == 0){
		
		editarUsuario = new EditarUsuario(filaSeleccionada);
		editarUsuario.setLocationRelativeTo(VistaPA);
		editarUsuario.getTxtIdusuario().setEnabled(false);
		editarUsuario.setVisible(true);
		
		/*
		ArrayList<Usuario> allUsers = new ArrayList<Usuario>();
		allUsers = controladorUsuario.findAllUsers();
		Usuario user = allUsers.get( VistaPA.getTable().getSelectedRow());
		*/
	
	    } else{
		//Poner iconos en los optionPane's
		JOptionPane.showMessageDialog(VistaPA, "Seleccione la fila que desea editar.", "Adventencia", JOptionPane.INFORMATION_MESSAGE,   new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
		    
		    
	    }
	    
	}
	
	
	if(e.getSource().equals(VistaPA.getMntmCerrarSesion())){
	    VistaPA.dispose();
	    VistaPrincipal vp = new VistaPrincipal();
	    vp.setLocationRelativeTo(null);
	    vp.setVisible(true);
	}
	if(e.getSource().equals(VistaPA.getMntmSalir())){
	    System.exit(0); 
	}
    }
}
