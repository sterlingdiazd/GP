package entidades;

public class Asistente extends Usuario {
	
	public String idAsistente;
	public String nombreUsuario;
	

	public Asistente( String idUsuario, String nombreUsuario, String clave, String rol, String idAsistente, 
			        	String nombre, String apellido, String telefonos, String direccion, String cedula)
	{
		super(idUsuario, nombre, apellido, nombreUsuario,  clave,  rol,  cedula, telefonos,  direccion);
		this.idAsistente = idAsistente;
		this.nombre = nombre;
		this.apellido = apellido;
	}
		public String getIdAsistente() {
			return idAsistente;
		}

		public void setIdAsistente(String idAsistente) {
			this.idAsistente = idAsistente;
		}	
		
		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}

}