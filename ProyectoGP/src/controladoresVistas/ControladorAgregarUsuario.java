package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelos.Administrador;
import vistas.AgregarUsuario;
import vistas.PerfilAdministrador;
import controladores.ControladorAdministrador;
import controladores.ControladorAutentificacion;
import controladores.ControladorGenerico;
import controladores.ControladorUsuario;

public class ControladorAgregarUsuario implements ActionListener {

    private AgregarUsuario au;
    private Administrador usuario;
    private ControladorGenerico controlador;

    public ControladorAgregarUsuario(AgregarUsuario au){
	this.au = au;
	controlador = new ControladorAdministrador();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	if( e.getSource().equals( au.getBtnAgregar() ) ){

	    //Si los datos no estan en blanco
	    if(au.getTxtNombre().getText().equalsIgnoreCase("") || au.getTxtApellido().getText().equalsIgnoreCase("") || au.getTxtNombreUsuario().getText().equalsIgnoreCase("") 
		    || au.getTxtClave().getText().equalsIgnoreCase("") || au.getComboBoxPerfil().getSelectedItem().toString().equalsIgnoreCase("") ){



	    }  else {

		//Hay que cambiar la clave por un passwordfield

		usuario = new Administrador( "", au.getTxtNombre().getText(), au.getTxtApellido().getText(), au.getTxtNombreUsuario().getText(),
			au.getTxtClave().getText(), au.getComboBoxPerfil().getSelectedItem().toString(),
			au.getTxtCedula().getText(), au.getTxtTelefonos().getText(), au.getTxtDireccion().getText() );
		
		controlador.agregar(usuario);
		ArrayList<Object> usuariosAutentificados = controlador.buscarPorNombreUsuarioYClave(usuario);

		boolean seInserto = new ControladorAutentificacion().autentificarUsuario(usuario, usuariosAutentificados);

		if(seInserto){

		    JOptionPane.showMessageDialog(au, "Administrador \"" +usuario.getNombreUsuario() + "\"  agregado satisfactoriamente. ", "Administrador Agregado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));

		} 	else {
		    JOptionPane.showMessageDialog(au, "No se inserto. ", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/information.png")));
		}
		au.dispose();
	    }

	    if(e.getSource().equals(au.getBtnCancelar())){
		au.dispose();
	    }

	}
    }


    /**
     * Metodo para comprobar si se inserto, enviarlo al administrador de perfil, luego que se inserte, y entonces volver a ponerlo visible.
     */ 

}