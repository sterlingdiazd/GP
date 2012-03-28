package tableModels;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import enums.Usuarios;
import modelos.Administrador;

/**
 * Table Model for the Encontrados.
 * @author Sterling Diaz
 * @author sterlingdiazd@gmail.com
 * @version v1.0 Modulo de Administrador
 */
public class ModeloTablaEncontrados extends AbstractTableModel {
    
    private static final long serialVersionUID = 1L;
    private ArrayList<Object> allUsers = new ArrayList<Object>();

    String [] encabezados = {Usuarios.IDUSUARIO.getText(), Usuarios.NOMBRE.getText(),Usuarios.APELLIDO.getText(), 
	    Usuarios.NOMBREUSUARIOS.getText(), Usuarios.CLAVE.getText(), Usuarios.ROL.getText(), 
	    Usuarios.CEDULA.getText(), Usuarios.TELEFONOS.getText(), Usuarios.DIRECCION.getText()};
    
    public ModeloTablaEncontrados(ArrayList<Object> allUsers){
	super(); 
	this.allUsers = allUsers;
    }
    
    @Override
    public int getColumnCount() {
	return encabezados.length;
    }
    
    @Override
	public String getColumnName(int arg0) {		
		return encabezados[arg0];
	}

    @Override
    public int getRowCount() {
	
	return allUsers.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	String columna = "";
	Administrador user = (Administrador) allUsers.get(rowIndex);
	switch(columnIndex){
		case 0:	columna = String.valueOf( user.getIdUsuario() );
		break;
		case 1: columna = user.getNombre();
		break;
		case 2: columna = user.getApellido();
		break;
		case 3: columna = user.getNombreUsuario();
		break;
		case 4: columna = user.getClave();
		break;
		case 5: columna = user.getRol();
		break;
		case 6: columna = user.getCedula();
		break;
		case 7: columna = user.getTelefonos();
		break;
		case 8: columna = user.getDireccion();
		break;
	}
	return columna;
    }

}
