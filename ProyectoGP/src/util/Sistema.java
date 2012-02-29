package util;
import vistas.VistaPrincipal;

public class Sistema {
    
    private static LookAndFeel look;
    
    public static void main(String[] args) {
	/*
	PerfilAdministrador pa = new PerfilAdministrador();
	pa.setLocationRelativeTo(null);
	pa.setVisible(true);
	*/

	/**
	 * Este es el bloque que correra el programa, el codigo anterior, es para ir directamente a la ventana de mi interes
	*/
	//Look and feel
	look = new LookAndFeel();
	//look.setLookAndFeel();
	new VistaPrincipal();
	
	
	/*
	VistaInicioSesion vi = new VistaInicioSesion();
	vi.setVisible(true);
	vi.setLocationRelativeTo(null);
	*/
	
    }
    
}
