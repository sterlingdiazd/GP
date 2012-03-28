package controladoresVistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelos.Administrador;
import vistas.AgregarUsuario;
import vistas.PerfilAdministrador;
import controladores.ControladorAutentificacion;
import controladores.ControladorUsuario;
public class ControladorEditarUsuario implements ActionListener {

    private PerfilAdministrador perfilAdministrador;
    private AgregarUsuario editarUsuario;
    private ControladorUsuario controladorUsuario = new ControladorUsuario();
    private Administrador usuarioPorEditar;

    public ControladorEditarUsuario(PerfilAdministrador perfilAdministrador, AgregarUsuario editarUsuario) {
	this.perfilAdministrador = perfilAdministrador;
	this.editarUsuario = editarUsuario;	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	
	//Si le dan a editar
	if(e.getSource().equals(editarUsuario.getBtnAgregar())){

	    

		
		
		
		

	    
	}

	//Si le dana canelar
	if(e.getSource().equals(editarUsuario.getBtnCancelar())){
	    editarUsuario.dispose();
	}
    }

    

  
}

