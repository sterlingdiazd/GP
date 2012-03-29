package tableModels;

import controladores.ControladorAdministrador;
import controladores.ControladorGenerico;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import enums.EnumPadecimiento;
import enums.Usuarios;

import modelos.Administrador;

/**
 * Table Model for the Padecimiento Table.
 * @author Sterling Diaz
 * @author sterlingdiazd@gmail.com
 * @version v1.0 Modulo de Administrador
 */
public class ModeloDeTablaPadecimientos extends AbstractTableModel {
    
    private static final long serialVersionUID = 1L;
   
    private ControladorGenerico controlador;
    private ArrayList<Object> padecimientos = new ArrayList<Object>();

    String [] encabezados = {EnumPadecimiento.IDPADECIMIENTO.getText(), EnumPadecimiento.NOMBREPADECIMIENTO.getText()};
    
    public ModeloDeTablaPadecimientos(ArrayList<Object> padecimientos){
	super(); 
	this.padecimientos = padecimientos;
	controlador = new ControladorAdministrador();
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
	padecimientos = new ArrayList<Object>();
	padecimientos = controlador.buscarTodo();
	return padecimientos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	String columna = "";
	Administrador user = (Administrador) padecimientos.get(rowIndex);
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
