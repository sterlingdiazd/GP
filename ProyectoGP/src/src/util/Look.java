package util;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.birosoft.liquid.LiquidLookAndFeel;

	
public class Look {

    public void setLookAndFeel(){

	try {// RECORDAR IMPORTAR LA LIBERIA QUE ESTA EN ESTE PROYECTO
		UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		LiquidLookAndFeel.setLiquidDecorations(true, "mac");
	}
	catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "No se ha podido establecer el skin", "Error de Look And Feel", 1, new ImageIcon(Look.class.getResource("/images/information.png")));
	}
    }
}
