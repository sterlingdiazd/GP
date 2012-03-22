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
    
    private DatosConexion datosConexion;
    
    public ConexionSql(String database) {
	datosConexion = new DatosConexion("localhost", database, "root", "");
    }
    
    Connection conn = null;

    /**
     * Metodo que conecta la base de datos.
     */
    public void connect() {
	
	try {
	    Class.forName(datosConexion.getDriver()).newInstance();
	    conn = DriverManager.getConnection(datosConexion.getUrl(), datosConexion.getUser(), datosConexion.getPassword());
	} catch (NullPointerException e){ 
	    JOptionPane.showMessageDialog(null, "No se puso establecer conexion. Verifique si el servidor esta encendido.", "Error de Conexion", 1);
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Conexion", 1);
	} catch (InstantiationException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Conexion", 1);
	} catch (IllegalAccessException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Conexion", 1);
	} catch (ClassNotFoundException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Conexion", 1);
	}
	
    }
    
    public Connection getConexion(){
	return conn;
    }
    
    public void disconnect(){
    	conn = null;
    }
    
}
