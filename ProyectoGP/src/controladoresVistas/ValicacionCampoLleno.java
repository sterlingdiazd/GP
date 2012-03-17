package controladoresVistas;

import javax.swing.text.JTextComponent;

public class ValicacionCampoLleno {

    public boolean validacionCampoLleno(JTextComponent comp) {
	
	boolean tieneContenido = false;
	if(comp.getText().length() != 0 ) {
	    tieneContenido =  true;
	} else {
	    return tieneContenido;
	}
	return tieneContenido;
    }

}
