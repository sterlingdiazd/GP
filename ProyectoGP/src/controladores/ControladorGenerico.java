package controladores;

import java.util.ArrayList;

public abstract class ControladorGenerico {

    protected Mantenimientos mantenimiento;
   
    public void agregar(Object o){
	mantenimiento.agregar(o);
    }
    
    public void modificar(Object o){
	mantenimiento.modificar(o);
    }
    
    public void eliminar(Object o){
	mantenimiento.eliminar(o);
    }
    
    public ArrayList<Object> buscarTodo(){
	return mantenimiento.buscarTodo();
    }
    
    public ArrayList<Object> buscarPorNombreUsuarioYClave(Object o){
	return mantenimiento.buscarPorNombreUsuarioYClave(o);
    }
    
    public ArrayList<Object> buscarPorAtributoPrincipal(Object o){
	return mantenimiento.buscarPorAtributo(o);
    }
    
    public Mantenimientos getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimientos mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    
}
