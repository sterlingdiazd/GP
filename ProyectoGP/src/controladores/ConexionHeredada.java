package controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionHeredada {
    public ConexionSql conexion;
    public Connection con;
    public Statement stm;
    
    public ConexionHeredada(){
	try {
	    conexion = new ConexionSql();
	    conexion.connect();
	    con = conexion.obtenerConexion();
	    stm = con.createStatement();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	conexion.disconnect();
    }
}