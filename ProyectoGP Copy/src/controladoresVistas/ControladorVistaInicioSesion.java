package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vistas.PerfilAdministrador;
import vistas.VistaInicioSesion;
import controladores.ControladorInicioSesion;
import enums.Roles;

public class ControladorVistaInicioSesion implements ActionListener{
    
    private ControladorInicioSesion controladorInicioSesion;
    private VistaInicioSesion VistaIC;
    private String usuario;
    private char[] clave;
    private String claveIntroducidaEnString;
    
    public ControladorVistaInicioSesion(VistaInicioSesion VistaIC){
	super();
	this.VistaIC = VistaIC;
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
	    
	    //Guardar datos introducidos por el usuario en la vista, en la variable usuario de esta clase
	    usuario = VistaIC.getTxtUsuarioInicioSesion().getText();
	    clave = VistaIC.getPasswordFieldInicioSesion().getPassword();
	    claveIntroducidaEnString = String.valueOf(clave);

	    //Si los datos no estan en blanco
	    if(!usuario.equalsIgnoreCase("") || !claveIntroducidaEnString.equalsIgnoreCase("")){
		
		//Usar el controlador de inicio sesion para verificar si esos datos estan en la base de datos
		controladorInicioSesion = new ControladorInicioSesion();
		boolean estaEnLaBaseDeDatos = controladorInicioSesion.autentificarUsuario(usuario, claveIntroducidaEnString);
		
		//Si esta en la base de datos
		if(estaEnLaBaseDeDatos){
		    
		    // Si el usuario es administrador, abrir su vista de perfil
		    if(controladorInicioSesion.getUser().getRol().equalsIgnoreCase(Roles.ADMINISTRADOR.getText())){ 
    		        JOptionPane.showMessageDialog(null, "Bienvenido al perfil de Administrador", "Usuario Autentificado" , JOptionPane.INFORMATION_MESSAGE );
    		        new PerfilAdministrador();
    			VistaIC.dispose();
    			
    		    } else if(controladorInicioSesion.getUser().getRol().equalsIgnoreCase(Roles.MEDICO.getText())) { // Si es el Medico, abrir el suyo
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
    
    

