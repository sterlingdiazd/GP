package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.Administrador;
import enums.Usuarios;

public class ControladorUsuario implements Mantenimientos {

    private Administrador usuario;
    private ArrayList<Object> allUsers;
    private ConexionSql conexion;
    private Connection con;
    private Statement stm;

    public ControladorUsuario() {
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

	usuario = (Administrador) o;
	String query = "INSERT INTO `usuario` ( `"+Usuarios.IDUSUARIO.getText()+"`, `"+Usuarios.NOMBRE.getText()+"`, " +
		" `"+Usuarios.APELLIDO.getText()+"`,  `"+Usuarios.NOMBREUSUARIOS.getText()+"`, `"+Usuarios.CLAVE.getText()+"`," +
		" `"+Usuarios.ROL.getText()+"`,  `"+Usuarios.CEDULA.getText()+"`,  `"+Usuarios.TELEFONOS.getText()+"`, " +
		" `"+Usuarios.DIRECCION.getText()+"` ) " +
		" VALUES ( '0', '"+usuario.getNombre()+"', '"+usuario.getApellido()+"','"+usuario.getNombreUsuario()+"'," +
		" '"+usuario.getClave()+"','"+usuario.getRol()+"', '"+usuario.getCedula()+"'," +
		" '"+usuario.getTelefonos()+"', '"+usuario.getDireccion()+"');";
	try {
	    stm.executeUpdate(query);	    
	} catch (SQLException e) {
	    JOptionPane.showMessageDialog(null, "El servidor no esta encendido.", "Error de Conexion", 1, new ImageIcon(ConexionHeredada.class.getResource("/images/information.png")));
	}

    }

    @Override
    public void modificar(Object o) {

	usuario = (Administrador) o;
	String query = "UPDATE `gestiondepacientes`.`usuario`" +
		"SET `Nombre` = '"+usuario.getNombre()+"'," +
		"  `Apellido` = '"+usuario.getApellido()+"' ," +
		"  `NombreUsuario` = '"+usuario.getNombreUsuario()+"' ," +
		"  `Clave` = '"+usuario.getClave()+"' ," +
		"  `Rol` = '"+usuario.getRol()+"' ," +
		"  `Cedula` = '"+usuario.getCedula()+"' ," +
		"  `Telefonos` = '"+usuario.getTelefonos()+"' ," +
		"  `Direccion` = '"+usuario.getDireccion()+"' " +
		"WHERE `IdUsuario` = "+usuario.getIdUsuario()+" ;";	
	try {
	    stm.executeUpdate(query);

	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "No se ha podido modificar el usuario.", "Modificar Administrador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorUsuario.class.getResource("/imagenes/information.png")));
	}
    }

    @Override
    public void eliminar(Object o) {

	usuario = (Administrador) o;
	String query = "DELETE FROM `gestiondepacientes`.`usuario` " +
		"WHERE `IdUsuario` = "+usuario.getIdUsuario()+"; ";

	try {
	    stm.executeUpdate(query);
	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "No se ha podido modificar el usuario.", "Modificar Administrador", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorUsuario.class.getResource("/imagenes/information.png")));
	}

    }

    @Override
    public ArrayList<Object> buscarTodo() {

	allUsers = new ArrayList<Object>();
	try {	    
	    String query = "SELECT  `"+Usuarios.IDUSUARIO.getText()+"`,  `"+Usuarios.NOMBRE.getText()+"`,  `"+Usuarios.APELLIDO.getText()+"`,  `"+Usuarios.NOMBREUSUARIOS.getText()+"`,  " +
		    "`"+Usuarios.CLAVE.getText()+"`, `"+Usuarios.ROL.getText()+"`,  `"+Usuarios.CEDULA.getText()+"`,  `"+Usuarios.TELEFONOS.getText()+"`,  `"+Usuarios.DIRECCION.getText()+"`" +
		    " FROM `usuario` ";
	    ResultSet rs = stm.executeQuery(query);
	    while(rs.next()){
		allUsers.add( new Administrador(  rs.getString(Usuarios.IDUSUARIO.getText()), rs.getString(Usuarios.NOMBRE.getText()), rs.getString(Usuarios.APELLIDO.getText()), rs.getString(Usuarios.NOMBREUSUARIOS.getText()),
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

		allUsers.add( new Administrador(  rs.getString(Usuarios.IDUSUARIO.getText()), rs.getString(Usuarios.NOMBRE.getText()), rs.getString(Usuarios.APELLIDO.getText()), rs.getString(Usuarios.NOMBREUSUARIOS.getText()),
			rs.getString(Usuarios.CLAVE.getText()), rs.getString(Usuarios.ROL.getText()), rs.getString(Usuarios.CEDULA.getText()), rs.getString(Usuarios.TELEFONOS.getText()),rs.getString(Usuarios.DIRECCION.getText()) ) );
	    }	  		
	} catch (Exception e){
	    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar buscar este usuario. Verifique el nombre de usuario proporcionado", "Error de nombre de usuario", JOptionPane.ERROR_MESSAGE);
	}

	return allUsers;
    }

    @Override
    public ArrayList<Object> buscarPorNombreUsuarioYClave(Object o) {
	usuario = (Administrador) o;
	allUsers = new ArrayList<Object>();
	try {	   
	    String query = "SELECT  `"+Usuarios.IDUSUARIO.getText()+"`,  `"+Usuarios.NOMBRE.getText()+"`,  `"+Usuarios.APELLIDO.getText()+"`,  `"+Usuarios.NOMBREUSUARIOS.getText()+"`,  " +
		    "`"+Usuarios.CLAVE.getText()+"`, `"+Usuarios.ROL.getText()+"`,  `"+Usuarios.CEDULA.getText()+"`,  `"+Usuarios.TELEFONOS.getText()+"`,  `"+Usuarios.DIRECCION.getText()+"`" +
		    " FROM `usuario` " +  " WHERE " +	  		
		    "`"+Usuarios.NOMBREUSUARIOS.getText()+"` = '"+usuario.getNombreUsuario()+"' AND " +
		    "`"+Usuarios.CLAVE.getText()+"` = '"+usuario.getClave()+" ' ";

	    ResultSet rs = stm.executeQuery(query);

	    while(rs.next()){

		allUsers.add( new Administrador(  rs.getString(Usuarios.IDUSUARIO.getText()), rs.getString(Usuarios.NOMBRE.getText()), rs.getString(Usuarios.APELLIDO.getText()), rs.getString(Usuarios.NOMBREUSUARIOS.getText()),
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
