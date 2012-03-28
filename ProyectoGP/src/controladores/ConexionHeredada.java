package controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ConexionHeredada {
    public ConexionSql conexion;
    public Connection con;
    public Statement stm;

    public ConexionHeredada(){
	try {
	    conexion = new ConexionSql("gestiondepacientes");
	    conexion.connect();
	    con = conexion.getConexion();
	    stm = con.createStatement();
	    conexion.disconnect();
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "El servidor no esta encendido.", "Error de Conexion", 1, new ImageIcon(ConexionHeredada.class.getResource("/images/information.png")));
	}
	
    }
}