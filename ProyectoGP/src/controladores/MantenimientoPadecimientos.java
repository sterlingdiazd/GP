package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelos.Padecimiento;
import enums.EnumPadecimiento;
import enums.Usuarios;
/*
public class MantenimientoPadecimientos implements Mantenimientos {

    private Padecimiento padecimiento;
    private ArrayList<Object> allUsers;
    private ConexionSql conexion;
    private Connection con;
    private Statement stm;

    public MantenimientoPadecimientos() {
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

    @Override
    public void agregar(Object o) {


	try {
	    padecimiento = (Padecimiento) o;
	    String query = "INSERT INTO `padecimientos` ( `"+ EnumPadecimiento.NOMBREPADECIMIENTO.getText()+"` ) " +
		    " VALUES ( '0', '"+padecimiento.getNombrePadecimiento() +"');";
	    stm.executeUpdate(query);	
	    System.out.println(query);
	    
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "El servidor no esta encendido.", "Error de Conexion", 1, new ImageIcon(ConexionHeredada.class.getResource("/images/information.png")));
	}

    }

    @Override
    public void modificar(Object o) {

	padecimiento = (Padecimiento) o;
	String query = "UPDATE `gestiondepacientes`.`padecimientos`" +
		"SET `Nombre` = '"+padecimiento.getNombrePadecimiento()+"' " +
		"WHERE `IdPadecimiento` = "+padecimiento.getIdPadecimiento()+" ;";	
	try {
	    stm.executeUpdate(query);
	    System.out.println(query);
	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "No se ha podido modificar el usuario.", "Modificar Administrador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorUsuario.class.getResource("/imagenes/information.png")));
	}
    }

    @Override
    public void eliminar(Object o) {

	padecimiento = (Padecimiento) o;
	String query = "DELETE FROM `gestiondepacientes`.`padecimientos` " +
		"WHERE `IdPadecimiento` = "+padecimiento.getIdPadecimiento()+"; ";

	try {
	    stm.executeUpdate(query);
	    System.out.println(query);
	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "No se ha podido modificar el usuario.", "Modificar Administrador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorUsuario.class.getResource("/imagenes/information.png")));
	}

    }
    /*
    @Override
    public ArrayList<Object> buscarTodo() {

	allUsers = new ArrayList<Object>();
	try {	    
	    String query = "SELECT  `"+Usuarios.IDUSUARIO.getText()+"`,  `"+Usuarios.NOMBRE.getText()+"`,  `"+Usuarios.APELLIDO.getText()+"`,  `"+Usuarios.NOMBREUSUARIOS.getText()+"`,  " +
		    "`"+Usuarios.CLAVE.getText()+"`, `"+Usuarios.ROL.getText()+"`,  `"+Usuarios.CEDULA.getText()+"`,  `"+Usuarios.TELEFONOS.getText()+"`,  `"+Usuarios.DIRECCION.getText()+"`" +
		    " FROM `usuario` ";
	    ResultSet rs = stm.executeQuery(query);
	    while(rs.next()){
		allUsers.add( new Padecimiento(  rs.getString(Usuarios.IDUSUARIO.getText()), rs.getString(Usuarios.NOMBRE.getText()), rs.getString(Usuarios.APELLIDO.getText()), rs.getString(Usuarios.NOMBREUSUARIOS.getText()),
			rs.getString(Usuarios.CLAVE.getText()), rs.getString(Usuarios.ROL.getText()), rs.getString(Usuarios.CEDULA.getText()), rs.getString(Usuarios.TELEFONOS.getText()),rs.getString(Usuarios.DIRECCION.getText()) ) );
	    }	  		
	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar buscar este usuario. Verifique el nombre de usuario proporcionado", "Error de nombre de usuario", JOptionPane.ERROR_MESSAGE);
	}

	return allUsers;
    }

    @Override
    public ArrayList<Object> buscarPorAtributo(Object o) {
	String nombreUsuario = (String) o;
	allUsers = new ArrayList<Object>();
	try {	    

	    String query = "SELECT  `"+Usuarios.IDUSUARIO.getText()+"`,  `"+Usuarios.NOMBRE.getText()+"`,  `"+Usuarios.APELLIDO.getText()+"`,  `"+Usuarios.NOMBREUSUARIOS.getText()+"`,  " +
		    "`"+Usuarios.CLAVE.getText()+"`, `"+Usuarios.ROL.getText()+"`,  `"+Usuarios.CEDULA.getText()+"`,  `"+Usuarios.TELEFONOS.getText()+"`,  `"+Usuarios.DIRECCION.getText()+"`" +
		    " FROM `usuario` " +  " WHERE " +	  		
		    "`"+Usuarios.NOMBREUSUARIOS.getText()+"` like '%" + nombreUsuario + "%' ";

	    ResultSet rs = stm.executeQuery(query);

	    while(rs.next()){

		allUsers.add( new Padecimiento(  rs.getString(Usuarios.IDUSUARIO.getText()), rs.getString(Usuarios.NOMBRE.getText()), rs.getString(Usuarios.APELLIDO.getText()), rs.getString(Usuarios.NOMBREUSUARIOS.getText()),
			rs.getString(Usuarios.CLAVE.getText()), rs.getString(Usuarios.ROL.getText()), rs.getString(Usuarios.CEDULA.getText()), rs.getString(Usuarios.TELEFONOS.getText()),rs.getString(Usuarios.DIRECCION.getText()) ) );
	    }	  		
	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar buscar este usuario. Verifique el nombre de usuario proporcionado", "Error de nombre de usuario", JOptionPane.ERROR_MESSAGE);
	}

	return allUsers;
    }

    @Override
    public ArrayList<Object> buscarPorNombreUsuarioYClave(Object o) {
	padecimiento = (Padecimiento) o;
	allUsers = new ArrayList<Object>();
	try {	   
	    String query = "SELECT  `"+Usuarios.IDUSUARIO.getText()+"`,  `"+Usuarios.NOMBRE.getText()+"`,  `"+Usuarios.APELLIDO.getText()+"`,  `"+Usuarios.NOMBREUSUARIOS.getText()+"`,  " +
		    "`"+Usuarios.CLAVE.getText()+"`, `"+Usuarios.ROL.getText()+"`,  `"+Usuarios.CEDULA.getText()+"`,  `"+Usuarios.TELEFONOS.getText()+"`,  `"+Usuarios.DIRECCION.getText()+"`" +
		    " FROM `usuario` " +  " WHERE " +	  		
		    "`"+Usuarios.NOMBREUSUARIOS.getText()+"` = '"+padecimiento.getNombreUsuario()+"' AND " +
		    "`"+Usuarios.CLAVE.getText()+"` = '"+padecimiento.getClave()+" ' ";

	    ResultSet rs = stm.executeQuery(query);

	    while(rs.next()){

		allUsers.add( new Padecimiento(  rs.getString(Usuarios.IDUSUARIO.getText()), rs.getString(Usuarios.NOMBRE.getText()), rs.getString(Usuarios.APELLIDO.getText()), rs.getString(Usuarios.NOMBREUSUARIOS.getText()),
			rs.getString(Usuarios.CLAVE.getText()), rs.getString(Usuarios.ROL.getText()), rs.getString(Usuarios.CEDULA.getText()), rs.getString(Usuarios.TELEFONOS.getText()),rs.getString(Usuarios.DIRECCION.getText()) ) );
	    }	  		
	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar buscar este usuario. Verifique el nombre de usuario proporcionado", "Error de nombre de usuario", JOptionPane.ERROR_MESSAGE);
	}

	return allUsers;
    }

    public ArrayList<Object> getAllUsers() {
	return allUsers;
    }

    public void setAllUsers(ArrayList<Object> allUsers) {
	this.allUsers = allUsers;
    }
	
}
*/

