package controladores;

import java.util.ArrayList;

import modelos.Administrador;
/**
 * Verificar si los datos ingresados por el usuario, que han sido recibidos, se encuentran en la base de datos.
 * @author Sterling Diaz
 * @author sterlingdiazd@gmail.com 
 * @version 1.0 Modulo de Usuarios 
 */
public class ControladorAutentificacion {

// No se usa en esta clase, porque en el constructor de la clase que instancia, se utiliza y transforma. Otras variables transformadas por esta variables, si se utilizan.
    private ArrayList<Administrador> usuariosAutentificados;
    private Administrador usuario;

    public ControladorAutentificacion(){
	usuariosAutentificados = new ArrayList<Administrador>();
    }

    public boolean autentificarUsuario( Administrador usuario,  ArrayList<Object> objectsPorAutentificar){

	boolean autentificado = false;

	for(int x = 0; x < objectsPorAutentificar.size(); x++){
	    
	    Administrador us = (Administrador) objectsPorAutentificar.get(x);
	    usuariosAutentificados.add(us);
	    
	    if(usuario.getNombreUsuario().equalsIgnoreCase(usuariosAutentificados.get(x).getNombreUsuario()) && usuario.getClave().equalsIgnoreCase( usuariosAutentificados.get(x).getClave() )){ //Si el usuario esta registrado, autentificar
		this.usuario = usuariosAutentificados.get(x);
		autentificado = true;
		break;
	    } 
	}
	return autentificado;
    }
    

    public Administrador getUsuario() {
        return usuario;
    }

}
