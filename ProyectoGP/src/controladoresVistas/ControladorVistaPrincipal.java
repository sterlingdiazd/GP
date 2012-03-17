package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vistas.VistaInicioSesion;
import vistas.VistaPrincipal;

public class ControladorVistaPrincipal implements ActionListener, MouseListener{

    private VistaPrincipal vp;
    /*
    private EditarUsuario editarUsuario;
    private AgregarUsuario agregarUsuario;
    //private ControladorUsuario controladorUsuario;
    */
    
    public ControladorVistaPrincipal(VistaPrincipal vp){
	this.vp = vp;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
	
	if(e.getSource().equals(vp.getMntmIniciarSesion())){
	    VistaInicioSesion vi = new VistaInicioSesion(vp);
	    vi.setLocationRelativeTo(vp);
	    vi.setVisible(true);
	    
	}
	
	if(e.getSource().equals(vp.getMntmSalir())){
	    System.exit(0); 
	}
    }


    @Override
    public void mouseClicked(MouseEvent arg0) {
	
    }


    @Override
    public void mouseEntered(MouseEvent arg0) {
	
    }


    @Override
    public void mouseExited(MouseEvent arg0) {
	
    }


    @Override
    public void mousePressed(MouseEvent e) {
	if(e.getSource().equals(vp.getPanel())){
	    VistaInicioSesion vi = new VistaInicioSesion(vp);
	    vi.setLocationRelativeTo(vp);
	    vi.setVisible(true);
	}
	
    }


    @Override
    public void mouseReleased(MouseEvent arg0) {
	
    }
}
