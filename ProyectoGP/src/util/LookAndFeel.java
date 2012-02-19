package util;

import javax.swing.*;

public class LookAndFeel {

    public LookAndFeel() {
	super();
	setLookAndFeel();
    }

    public void setLookAndFeel(){            
        try {
            UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
            //SwingUtilities.updateComponentTreeUI(this); 
        } catch (Exception e){
            System.out.print("No se ha podido establecer el scheme: " + e.getMessage() );
            e.getStackTrace();
        }            
    } 
}
