package enums;

public enum Usuarios {

    IDUSUARIO("IdUsuario"),
    NOMBRE("Nombre"),
    APELLIDO("Apellido"),
    NOMBREUSUARIOS("NombreUsuario"),
    CLAVE("Clave"),
    ROL("Rol"),
    CEDULA("Cedula"),
    TELEFONOS("Telefonos"),
    DIRECCION("Direccion");
    
    private String text;
    
    Usuarios(String text){
	this.text = text;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
