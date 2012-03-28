package modelos;

import java.util.Date;

import javax.swing.ImageIcon;

public class Paciente extends Persona {

    private Date fechaNacimiento;
    private boolean esFumador;
    private Alergias alergias;
    private ImageIcon foto;
    
    public Paciente(String nombre, String apellido, String cedula,
	    String telefonos, String direccion, Date fechaNacimiento,
	    boolean esFumador, Alergias alergias, ImageIcon foto) {
	super(nombre, apellido, cedula, telefonos, direccion);
	this.fechaNacimiento = fechaNacimiento;
	this.esFumador = esFumador;
	this.alergias = alergias;
	this.foto = foto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    public Alergias getAlergias() {
        return alergias;
    }

    public void setAlergias(Alergias alergias) {
        this.alergias = alergias;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
    
}
