package modelos;

public abstract class Usuario {
    
    private String 	IdEmpleado;
    private String	Nombre;
    private String	Apellido;
    private String	NombreUsuario;
    private String 	Clave;
    private String	Cedula;
    private String	Telefonos;
    private String	Direccion;
    
    public Usuario(String idUsuario, String nombre, String apellido,
	    String nombreUsuario, String clave, String cedula,
	    String telefonos, String direccion) {
	super();
	IdUsuario = idUsuario;
	Nombre = nombre;
	Apellido = apellido;
	NombreUsuario = nombreUsuario;
	Clave = clave;
	Cedula = cedula;
	Telefonos = telefonos;
	Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(String telefonos) {
        Telefonos = telefonos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }   
    
}
