package controladores;

import java.util.ArrayList;

public interface Mantenimientos {

    public void agregar(Object o);
    public void modificar(Object o);
    public void eliminar(Object o);
    public ArrayList<Object> buscarTodo();
    public ArrayList<Object> buscarPorParametro(Object o);
    
}
