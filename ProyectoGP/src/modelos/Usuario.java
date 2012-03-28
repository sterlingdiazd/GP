package modelos;

public class Usuario extends Persona {

    public String 	idUsuario;	// Cambiar el tipo de dato, en la db
    public String	nombreUsuario;
    public String 	clave;
    public String 	rol;
    
    public Usuario(String idUsuario, String nombre, String apellido, String nombreUsuario, String clave, String rol, String cedula,
	    String telefonos, String direccion) {
	super(nombre, apellido, cedula, telefonos, direccion);
	this.idUsuario = idUsuario;
	this.nombreUsuario = nombreUsuario;
	this.clave = clave;
	this.rol = rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    


}
