package modelos;

public class Medico {
	
		int CodEmpleado;
		String nombre;
		String apellido;
		String telefono;
		String direccion;
		String cedula;
		String especialidad;
		
		public Medico() {
			super();
			
		}

		public Medico(int codEmpleado, String nombre, String apellido,
				String telefono, String direccion, String cedula,
				String especialidad) {
			super();
			CodEmpleado = codEmpleado;
			this.nombre = nombre;
			this.apellido = apellido;
			this.telefono = telefono;
			this.direccion = direccion;
			this.cedula = cedula;
			this.especialidad = especialidad;
		}

		public int getCodEmpleado() {
			return CodEmpleado;
		}

		public void setCodEmpleado(int codEmpleado) {
			CodEmpleado = codEmpleado;
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

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public String getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(String especialidad) {
			this.especialidad = especialidad;
		}
		
    
}
