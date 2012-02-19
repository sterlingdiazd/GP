package enums;

public enum Roles {

    ADMINISTRADOR("Administrador"),
    MEDICO("Medico"),
    ASISTENTE("Asistente");
    
    private String text;
    
    Roles(String text){
	this.text = text;
    }
    
    public String getText(){
	return text;
    }
    
    public void setText(String text) {
	this.text = text;
    }
}
