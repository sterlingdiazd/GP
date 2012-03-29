package modelos;

public class Padecimiento {

    private int idPadecimiento;
    private String nombrePadecimiento;
    
    public Padecimiento(int idPadecimiento, String nombrePadecimiento) {
	super();
	this.idPadecimiento = idPadecimiento;
	this.nombrePadecimiento = nombrePadecimiento;
    }

    public int getIdPadecimiento() {
        return idPadecimiento;
    }

    public void setIdPadecimiento(int idPadecimiento) {
        this.idPadecimiento = idPadecimiento;
    }

    public String getNombrePadecimiento() {
        return nombrePadecimiento;
    }

    public void setNombrePadecimiento(String nombrePadecimiento) {
        this.nombrePadecimiento = nombrePadecimiento;
    }
    
    
}
