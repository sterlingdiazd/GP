package controladores;

import java.util.ArrayList;

import modelos.Usuario;
/**
 * Utiliza la conexion para verificar si los datos ingresados por el usuario, que han sido recibidos, se encuentran en la base de datos.
 * @author Sterling Diaz
 * @author sterlingdiazd@gmail.com 
 * @version 1.0 Modulo de Usuarios 
 */
public class ControladorAutentificacion {

// No se usa en esta clase, porque en el constructor de la clase que instancia, se utiliza y transforma. Otras variables transformadas por esta variables, si se utilizan.
    private ArrayList<Usuario> usuariosAutentificados;
    private Usuario usuario;

    public ControladorAutentificacion(){
	usuariosAutentificados = new ArrayList<Usuario>();
    }

    public boolean autentificarUsuario( Usuario usuario,  ArrayList<Object> objectsPorAutentificar){

	boolean autentificado = false;

	for(int x = 0; x < objectsPorAutentificar.size(); x++){
	    
	    Usuario us = (Usuario) objectsPorAutentificar.get(x);
	    usuariosAutentificados.add(us);
	    
	    if(usuario.getNombreUsuario().equalsIgnoreCase(usuariosAutentificados.get(x).getNombreUsuario()) && usuario.getClave().equalsIgnoreCase( usuariosAutentificados.get(x).getClave() )){ //Si el usuario esta registrado, autentificar
		this.usuario = usuariosAutentificados.get(x);
		autentificado = true;
		break;
	    } 
	}
	return autentificado;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

}
