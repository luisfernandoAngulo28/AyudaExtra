package Panaderia;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        String [] looks = {"Java","Nimbus","Windows","Acryl","Aero","Aluminium",
                           "Fast","Graphite","Hifi","Luna","Mcwin","Mint","Noire",
                           "Smart","Synthetica","Sistema"};

        String [] newLook = {"javax.swing.plaf.metal.MetalLookAndFeel",
                                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel",
                                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
                                "com.jtattoo.plaf.acryl.AcrylLookAndFeel",
                                "com.jtattoo.plaf.aero.AeroLookAndFeel",
                                "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel",
                                "com.jtattoo.plaf.fast.FastLookAndFeel",
                                "com.jtattoo.plaf.graphite.GraphiteLookAndFeel",
                                "com.jtattoo.plaf.hifi.HiFiLookAndFeel",
                                "com.jtattoo.plaf.luna.LunaLookAndFeel",
                                "com.jtattoo.plaf.mcwin.McWinLookAndFeel",
                                "com.jtattoo.plaf.mint.MintLookAndFeel",
                                "com.jtattoo.plaf.noire.NoireLookAndFeel",
                                "com.jtattoo.plaf.smart.SmartLookAndFeel",
                                "de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel",
                                 UIManager.getSystemLookAndFeelClassName()};

	String resp =(String)JOptionPane.showInputDialog(null, "Elija una interfaz", "Look & Feel",
							JOptionPane.QUESTION_MESSAGE,null, looks, looks[0]);
       
        try{
            for(int i=0; i<looks.length; i++){
                if(resp.equals(looks[i])){
                    UIManager.setLookAndFeel(newLook[i]);
                }
            }
        }
        catch(Exception ex){
            ex.fillInStackTrace();
        }
        JFramePanaderia ventana = new JFramePanaderia();
        ventana.setVisible(true);
    }
    
}
