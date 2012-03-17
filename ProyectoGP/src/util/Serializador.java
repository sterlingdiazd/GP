package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Serializador {

    ObjectOutputStream salida;
    ObjectInputStream entrada;
    
    public void escribirFlujoDeSalidaObjetos(Object objeto, String ruta){
	
	try {
	    ObjectOutputStream salida = new ObjectOutputStream( new FileOutputStream(ruta) );
	    salida.writeObject(objeto);
	    salida.close();
	} catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog(null, "Archivo no encontrado.", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	} catch (IOException e) {
	    JOptionPane.showMessageDialog(null, "Error al intentar escribir el archivo. Problema de serializacion.", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	}
	
    }
    
    public Object leerFlujoDeEntradaObjetos(String ruta){
	
	Object objecto = null;
	
	try {
	    
	    entrada = new ObjectInputStream(new FileInputStream(ruta));
	    objecto = entrada.readObject();
	    
	} catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog(null, "Archivo no encontrado.", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	} catch (IOException e) {
	    JOptionPane.showMessageDialog(null, "Error al intentar leer el archivo. Problema de serializacion.", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	} catch (ClassNotFoundException e) {
	    JOptionPane.showMessageDialog(null, "Clase no encontrado.", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	}
	
	return objecto;
	
    }
    
}
