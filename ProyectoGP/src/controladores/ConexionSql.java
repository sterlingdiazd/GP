package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/** 
 * Clase que crea una conexion para ser utilizada en cada consulta a la base de datos.
 * @author Sterling Diaz
 * @author sterlingdiazd@gmail.com 
 * @version 1.0 Modulo de Usuarios 
*/
public class ConexionSql {
    
    /** Guarda la ubicacion del driver */
    String driver = "com.mysql.jdbc.Driver";
    
    /** Establecer los datos de conexion */
    String server = "localhost";
    String database = "gestiondepacientes";
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://" + server + "/" + database ;
    
    Connection conn = null;

    /**
     * Metodo que conecta la base de datos.
     */
    public void connect() {
	
	try {
	    Class.forName(driver).newInstance();
	    conn = DriverManager.getConnection(url, user, password);
	   
	} catch (NullPointerException e){ 
	    JOptionPane.showMessageDialog(null, "No se puso establecer conexion. Verifique si el servidor esta encendido.", "Error de Conexion", 1);
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "No se puso establecer conexion. Verifique si el servidor esta encendido.", "Error de Conexion", 1);
	} catch (InstantiationException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	
    }
    
    public Connection obtenerConexion(){
	return conn;
    }
    
    public void disconnect(){
    	conn = null;
    }
    
}
