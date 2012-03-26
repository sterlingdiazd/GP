package entidades;

public abstract class Persona {

    public String nombre;
    public String apellido;
    public String cedula;
    public String telefonos;
    public String direccion;
    
    public Persona(String nombre, String apellido, String cedula,
	    String telefonos, String direccion) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.cedula = cedula;
	this.telefonos = telefonos;
	this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    
    
}
