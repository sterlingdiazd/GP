package util;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class LookAndFeelFinder extends JFrame
{

    public LookAndFeelFinder()
    {
        javax.swing.UIManager.LookAndFeelInfo laf[] = UIManager.getInstalledLookAndFeels();
        for(int i = 0; i < laf.length; i++)
        {
            System.out.println((new StringBuilder("Class name: ")).append(laf[i].getClassName()).toString());
            System.out.println((new StringBuilder("Name: ")).append(laf[i].getName()).append("\n").toString());
        }

    }

    public static void main(String arguments[])
    {
        new LookAndFeelFinder();
    }

    private static final long serialVersionUID = 1L;
}