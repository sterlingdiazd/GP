package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelos.Administrador;
import vistas.PerfilAdministrador;
import vistas.VistaInicioSesion;
import vistas.VistaPrincipal;
import controladores.ControladorAdministrador;
import controladores.ControladorAutentificacion;
import controladores.ControladorGenerico;
import enums.Roles;

public class ControladorVistaInicioSesion implements ActionListener{

    private ControladorAutentificacion controladorAutentificacion;
    private ControladorGenerico controlador;
    private VistaInicioSesion VistaIC;
    private VistaPrincipal VP;
    private String nombreUsuario;
    private char[] clave;
    private String claveIntroducidaEnString;

    public ControladorVistaInicioSesion(VistaInicioSesion VistaIC, VistaPrincipal VP){
	super();
	this.VistaIC = VistaIC;
	this.VP = VP;
	controlador = new ControladorAdministrador();
	controladorAutentificacion = new ControladorAutentificacion();
    }

    /**
     * Borra los datos de los campos asignados.
     */
    public void LimpiarCampos(){
	VistaIC.setTxtUsuarioInicioSesion("");
	VistaIC.setPasswordFieldInicioSesion((char) 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	//Si le dan a borrar
	if(e.getSource().equals(VistaIC.getBtnLimpiar())){
	    LimpiarCampos();
	}

	//Si le dan a entrar
	if(e.getSource().equals(VistaIC.getBtnIniciarSesion())){
	    
	    nombreUsuario = VistaIC.getTxtUsuarioInicioSesion().getText();
	    clave = VistaIC.getPasswordFieldInicioSesion().getPassword();
	    claveIntroducidaEnString = String.valueOf(clave);

	    if(!nombreUsuario.equalsIgnoreCase("") || !claveIntroducidaEnString.equalsIgnoreCase("") ){

		//Guardar datos introducidos por el nombreUsuario en la vista

		Administrador usuario = new Administrador( "", "", "", nombreUsuario, claveIntroducidaEnString, "", "", "", "" );
		ArrayList<Object> usuariosAutentificados = controlador.buscarPorNombreUsuarioYClave(usuario);

		boolean estaEnLaBaseDeDatos = controladorAutentificacion.autentificarUsuario(usuario, usuariosAutentificados);
		
		//Si esta en la base de datos
		if(estaEnLaBaseDeDatos){

		    String usuarioAutentificado = controladorAutentificacion.getUsuario().getRol();

		    // Si el nombreUsuario es administrador, abrir su vista de perfil
		    if(usuarioAutentificado.equalsIgnoreCase(Roles.ADMINISTRADOR.getText())){

			JOptionPane.showMessageDialog(null, "Bienvenido al perfil de Administrador", "Administrador Autentificado" , JOptionPane.INFORMATION_MESSAGE );
			VistaIC.dispose();
			VP.dispose();
			new PerfilAdministrador();

		    } else if(usuarioAutentificado.equalsIgnoreCase(Roles.MEDICO.getText())) { // Si es el Medico, abrir el suyo

			JOptionPane.showMessageDialog(null, "Ingresando al perfil de Medico", "Perfil de Supervisor", JOptionPane.INFORMATION_MESSAGE );

		    } else { // Entonces es cajero, y abrir el suyo

			JOptionPane.showMessageDialog(null, "Ingresando al perfil de Asistente", "Perfil de Cajero", JOptionPane.INFORMATION_MESSAGE );

		    }
		}
	    } else {
		JOptionPane.showMessageDialog(VistaIC, "Introduzca sus datos de acceso", "Adventencia", JOptionPane.ERROR_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/warning_mini.png")) );
	    }
	} 
    }

}



