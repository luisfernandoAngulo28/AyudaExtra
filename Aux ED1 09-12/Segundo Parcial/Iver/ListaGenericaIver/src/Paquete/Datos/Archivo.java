/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author Cristhian
 */
public class Archivo {

    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
//para escribir
    FileWriter fichero = null;
    PrintWriter pw = null;
//ruta absoluta del archivo a manipular
    String ruta = "c:";
//*****---------objeto-----**********

    public String OpenFile(String ruta) {
        String t = "";
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero linea por linea
            String linea;
            while ((linea = br.readLine()) != null) {
                t = t + linea + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //System.out.println(t);
        return t;
        

    }

    public void SaveFile(String t, String ruta) {
        //se separa el texto cada salto de linea




       // String o=OpenFile(ruta);

        StringTokenizer st = new StringTokenizer(t);
        try {






            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            //se guarda linea por linea en el archivo
            while (st.hasMoreTokens()) {
                String line = st.nextToken();
            //    System.out.println(line);
                pw.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //segun la opcion muestra en pantalla una ventana de dialogo
    //para "abrir" o "guardar" un archivo
    public boolean Dialog(String Opcion, JTextArea tArea) {
        //esta variable se utiliza como una bandera de retorno
        //no es necesaria, solo sirve para tener un control
        boolean b = true;
        //ventana para "abrir un archivo", retorna FALSE si se abre
        if (Opcion.equals("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                ruta = fileChooser.getSelectedFile().getAbsolutePath();
                tArea.setText(OpenFile(ruta));
                b = false;
            }
        } //ventana para guardar un archivo
        else if (Opcion.equals("Save As")) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                ruta = fileChooser.getSelectedFile().getAbsolutePath();
                ruta = ruta + ".txt";
                SaveFile(tArea.getText(), ruta);
                b = false;
            }
        } //aqui no muestra ninguna ventana, guarda automaticamente el archivo
        //respecto a un archivi previamente abierto
        else if (Opcion.equals("Save")) {
            SaveFile(tArea.getText(), ruta);
            b = false;
        }
        return b;
    }
}
