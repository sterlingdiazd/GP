package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Serializador2 {

    public void escribir(Object object, String ruta){
	try {
	    FileOutputStream fos = new FileOutputStream(ruta);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(object);
	    oos.close();
	} catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog(null, "Error al intentar escribir archivo", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	} catch (IOException e) {
	    JOptionPane.showMessageDialog(null, "Error al intentar escribir archivo", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    public Object leer(){
	
	Object comentariosAnteriores = null;
	
	try {
	    FileInputStream fis = new FileInputStream("BitacoraDelBlog.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    comentariosAnteriores = ois.readObject().toString();
	    ois.close();
	} catch (IOException e) {
	    JOptionPane.showMessageDialog(null, "Error al intentar leer archivo", "Error de Escritura", JOptionPane.ERROR_MESSAGE);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	return comentariosAnteriores;
	
    }
    
}
