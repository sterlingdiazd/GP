package modelos;

public class Administrador extends Usuario {

    public Administrador(String idUsuario, String nombre, String apellido,
	    String nombreUsuario, String clave, String rol, String cedula,
	    String telefonos, String direccion) {
	super(idUsuario, nombre, apellido, nombreUsuario, clave, rol, cedula,
		telefonos, direccion);
    }

}
