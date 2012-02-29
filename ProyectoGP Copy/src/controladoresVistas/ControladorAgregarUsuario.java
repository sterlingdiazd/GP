package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelos.Usuario;
import vistas.AgregarUsuario;
import vistas.EditarUsuario;
import vistas.PerfilAdministrador;
import controladores.ControladorInicioSesion;
import controladores.ControladorUsuario;

public class ControladorAgregarUsuario implements ActionListener {

    private AgregarUsuario au;
    private ControladorUsuario controladorUsuario = new ControladorUsuario();
    private Usuario usuario;
    
    public ControladorAgregarUsuario(AgregarUsuario au){
	this.au = au;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(au.getBtnAgregar())){
	    //Hay que cambiar la clave por un passwordfield
	    usuario = new Usuario(  0, au.getTxtUsuario().getText(), au.getTxtClave().getText(), au.getTxtCedula().getText(),
		    au.getTxtDireccion().getText(), au.gettxtCargo().getText(), au.getComboBoxPerfil().getSelectedItem().toString(),
		    au.getTxtCasa().getText(), au.getTxtOficina().getText(), au.getTxtCelular().getText(), au.getTxtBbpin().getText(),
		    au.getTxtFacebook().getText(), au.getTxtSkype().getText(), au.getTxtGmail().getText(), au.getTxtHotmail().getText(), au.getTxtLinkedin().getText()  );
	    controladorUsuario.agregar(usuario);
	    ControladorInicioSesion cis = new ControladorInicioSesion();
	    boolean seInserto = cis.autentificarUsuario(usuario.getNombreUsuario(), usuario.getClave());
	    if(seInserto){
		JOptionPane.showMessageDialog(au, "Usuario \"" +usuario.getNombreUsuario() + "\"  agregado satisfactoriamente. ", "Usuario Agregado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ControladorAgregarUsuario.class.getResource("/imagenes/information_mini.png")));
		au.dispose();
		
	    } 	else {
		JOptionPane.showMessageDialog(au, "No se inserto. ", "Error", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PerfilAdministrador.class.getResource("/imagenes/information.png")));
	    }
	
	} 
	if(e.getSource().equals(au.getBtnCancelar())){
	    au.dispose();
	}
	
    }
    /**
     * Metodo para comprobar si se inserto, enviarlo al administrador de perfil, luego que se inserte, y entonces volver a ponerlo visible.
     */
    //public boolean 
    
    
    
    
}
