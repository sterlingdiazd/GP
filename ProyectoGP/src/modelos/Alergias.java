package modelos;

public class Alergias {

    private int idAlergia;
    private String nombreAlergia;
    
    public Alergias(int idAlergia, String nombreAlergia) {
	super();
	this.idAlergia = idAlergia;
	this.nombreAlergia = nombreAlergia;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    public String getNombreAlergia() {
        return nombreAlergia;
    }

    public void setNombreAlergia(String nombreAlergia) {
        this.nombreAlergia = nombreAlergia;
    }
    
    
}
