package enums;

public enum EnumPadecimiento {

    IDPADECIMIENTO("IdPadecimiento"),
    NOMBREPADECIMIENTO("NombrePadecimiento");
    
    private String text;
    
    EnumPadecimiento(String text){
	this.text = text;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
