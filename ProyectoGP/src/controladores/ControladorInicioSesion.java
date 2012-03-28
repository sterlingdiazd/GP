package controladores;

import java.util.ArrayList;

import modelos.Administrador;
import javax.swing.JOptionPane;


/**
 * Utiliza la conexion para verificar si los datos ingresados por el usuario, que han sido recibidos, se encuentran en la base de datos.
 * @author Sterling Diaz
 * @author sterlingdiazd@gmail.com 
 * @version 1.0 Modulo de Usuarios 
 */
public class ControladorInicioSesion extends ConexionHeredada {
    
    @SuppressWarnings("unused") // No se usa en esta clase, porque en el constructor de la clase que instancia, se utiliza y transforma. Otras variables transformadas por esta variables, si se utilizan.
    private ConexionHeredada conexion = new ConexionHeredada();
    private ControladorUsuario controladorUsuario;
    private Administrador user;
    private ArrayList<Object> usuarioInicioSesion;
    private ArrayList<Administrador> usuarioInicioSesionUSUARIO;
    
    public ControladorInicioSesion(){
	controladorUsuario = new ControladorUsuario();
	usuarioInicioSesion =  new ArrayList<Object>();
	usuarioInicioSesionUSUARIO = new ArrayList<Administrador>();
    }

    public boolean autentificarUsuario(String nombreUsuario, String claveIntroducidaEnString){
	
	boolean autentificado = false;
	Administrador usuario = new Administrador(null, null, null, nombreUsuario, claveIntroducidaEnString, null, null, null, null);
	usuarioInicioSesion = controladorUsuario.buscarPorNombreUsuarioYClave(usuario);
	
	 for(int x = 0; x < usuarioInicioSesion.size(); x++){
	     Administrador us = (Administrador) usuarioInicioSesion.get(x);
	     usuarioInicioSesionUSUARIO.add(us);
	 }
	//usuarioRetornado = (Administrador) usuarioInicioSesion.get(1);
	try{
	    user = usuarioInicioSesionUSUARIO.get(0);
	    if(nombreUsuario.equalsIgnoreCase(user.getNombreUsuario()) && claveIntroducidaEnString.equalsIgnoreCase(user.getClave())){ //Si el usuario esta registrado, autentificar
		autentificado = true;
	    } 
	} catch (NullPointerException e){
	    JOptionPane.showMessageDialog(null,  "Nombre de usuario o clave incorrecta.", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
	}
	return autentificado;	
    }
    
    public Administrador getUser(){
	System.out.println(user.getNombre());
	return user;
    }
}
