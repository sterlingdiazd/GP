package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelos.Usuario;
import vistas.EditarUsuario;
import vistas.PerfilAdministrador;
import controladores.ControladorInicioSesion;
import controladores.ControladorUsuario;
import java.util.Scanner;
public class ControladorEditarUsuario implements ActionListener{

    private EditarUsuario eu;
    private ArrayList<Usuario> allUsers  = new ArrayList<Usuario>();
    private ControladorUsuario controladorUsuario = new ControladorUsuario();
    private Usuario user;
    
    public ControladorEditarUsuario(EditarUsuario editarUsuario) {
	eu = editarUsuario;
	allUsers = controladorUsuario.findAllUsers();
	user = allUsers.get( eu.getFilaSeleccionada());
	cargarDatosEnTextFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	
	//Si le dan a editar
	if(e.getSource().equals(eu.getBtnEditar())){
	    //Hay que cambiar la clave por un passwordfield
	    user = new Usuario(  Integer.valueOf(eu.getTxtIdusuario().getText()), eu.getTxtUsuario().getText(), eu.getTxtClave().getText(), eu.getTxtCedula().getText(),
		    eu.getTxtDireccion().getText(), eu.getTxtCargo().getText(), eu.getComboBoxPerfil().getSelectedItem().toString(),
		    eu.getTxtCasa().getText(), eu.getTxtOficina().getText(), eu.getTxtCelular().getText(), eu.getTxtBbpin().getText(),
		    eu.getTxtFacebook().getText(), eu.getTxtSkype().getText(), eu.getTxtGmail().getText(), eu.getTxtHotmail().getText(), eu.getTxtLinkedin().getText()  );
	    controladorUsuario.modificar(user);
	    ControladorInicioSesion cis = new ControladorInicioSesion();
	    boolean seInserto = cis.autentificarUsuario(user.getNombreUsuario(), user.getClave());
	    if(seInserto){
		JOptionPane.showMessageDialog(null, "Usuario \"" +user.getNombreUsuario() + "\"  agregado satisfactoriamente. ", "Usuario Agregado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
		eu.dispose();
	    
	    } else {
		JOptionPane.showMessageDialog(null, "No se inserto. ", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/information.png")));
	    }
	
	} 
	//Si le dana canelar
	if(e.getSource().equals(eu.getBtnCancelar())){
	    eu.dispose();
	}
	if(e.getSource().equals(eu.getBtnEditar())){
	    
	}

    }
    /**
     * Metodo para comprobar si se inserto, enviarlo al administrador de perfil, luego que se inserte, y entonces volver a ponerlo visible.
     */
    //public boolean 
    
    public void cargarDatosEnTextFields(){
	    eu.getTxtIdusuario().setText( String.valueOf( user.getIdUsuario() ) );
	    eu.getTxtUsuario().setText(user.getNombreUsuario());
	    eu.getTxtClave().setText(user.getClave());
	    eu.getTxtCedula().setText(user.getCedulaUsuario());
	    eu.getTxtDireccion().setText(user.getDireccionUsuario());
	    eu.getTxtCargo().setText(user.getCargoUsuario());
	    eu.getComboBoxPerfil().getModel().setSelectedItem(user.getPerfilUsuario());
	    eu.getTxtCasa().setText(user.getTel_Casa_Usuario());
	    eu.getTxtOficina().setText(user.getTel_Oficina_Usuario());
	    eu.getTxtCelular().setText(user.getCelular_Usuario());
	    eu.getTxtBbpin().setText(user.getBB_Pin_Usuario());
	    eu.getTxtFacebook().setText(user.getFacebook());
	    eu.getTxtSkype().setText(user.getSkype());
	    eu.getTxtGmail().setText(user.getGmail());
	    eu.getTxtHotmail().setText(user.getHotmail());
	    eu.getTxtLinkedin().setText(user.getLinkedIn());
    }


    
    
}
