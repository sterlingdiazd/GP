package entidades;

public class Medico extends Usuario {

    String especialidad;

    public Medico(String nombre, String apellido, String cedula,
	    String telefonos, String direccion, String idUsuario,
	    String nombreUsuario, String clave, String rol) {
	super(nombre, apellido, cedula, telefonos, direccion, idUsuario, nombreUsuario,
		clave, rol);
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    
    
    

   


}
