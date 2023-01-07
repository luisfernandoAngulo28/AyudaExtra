package diseño;

import java.util.Properties;
import java.awt.Color;
import javax.swing.JFileChooser;
import java.io.File;     
import javax.swing.*;
import UpperEssential.UpperEssentialLookAndFeel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import proyecto.Agenda;
import proyecto.Herramienta;
import proyecto.Contacto;

public class FORM extends javax.swing.JFrame  {

    Agenda a=new Agenda();
    int i=0;
    DefaultTableModel modelo;
   
    public FORM() {        
        initComponents();
        cerrar();
//        getContentPane().setBackground(Color.cyan);
       // setExtendedState(MAXIMIZED_BOTH);
        setLocation(300, 50);      
        setSize(950, 650);
        modelo=new DefaultTableModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("P. APELLIDO");
        modelo.addColumn("NRO. TELEFONO");
        jTable1.setModel(modelo);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setFont(new java.awt.Font("Angsana New", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(255, 101, 130));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseño/icon1.jpg"))); // NOI18N
        jButton1.setText("New");
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 13, 130, 55);

        jLabel1.setBackground(new java.awt.Color(51, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("MI AGENDA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, -10, 250, 100);

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseño/icon2.jpg"))); // NOI18N
        jButton2.setText("Almacenar");
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 78, 145, 55);

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("NOMBRE:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 144, 109, 31);

        jTextField1.setName("textfield1"); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(239, 140, 221, 30);

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("PRIMER APELLIDO:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 181, 177, 31);

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("SEGUNDO APELLIDO:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 218, 191, 31);

        jLabel5.setFont(new java.awt.Font("Traditional Arabic", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("TELEFONO:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 263, 109, 24);

        jLabel6.setFont(new java.awt.Font("Traditional Arabic", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("GRUPO:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 411, 109, 24);

        jLabel7.setFont(new java.awt.Font("Traditional Arabic", 2, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("NUMERO:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(239, 263, 98, 24);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(240, 180, 221, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(240, 220, 221, 30);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(239, 296, 212, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MOVIL", "CASA", "TRABAJO", "FAX CASA", "FAX TRABAJO" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(10, 296, 164, 22);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AMIGOS", "FAMILIA", "TRABAJO", "VIP" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(10, 444, 164, 22);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "P. APELLIDO", "TELEFONO", "NUMERO"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(550, 20, 330, 510);

        jButton3.setText("GUARDAR AGENDA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(240, 370, 140, 40);

        jButton4.setText("RECUPERAR AGENDA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(390, 370, 140, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
               
    }//GEN-LAST:event_formWindowOpened
  
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        //NUEVA AGENDA
       jTextField1.setText(null);
       jTextField2.setText(null);
       jTextField3.setText(null);
       jTextField4.setText(null);
       a.vaciar_agenda();
       int cantidad_ele=jTable1.getRowCount();
        for(int i=0;i<cantidad_ele;i++){
            modelo.removeRow(0);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        //AGREGA CONTACTO A AGENDA
      if (jTextField4.getText().length()<9){
        Contacto c=new Contacto(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), Integer.parseInt(jTextField4.getText()), jComboBox1.getSelectedIndex(), jComboBox2.getSelectedIndex());
        a.insertar_contacto(c);
        
        String []dato=new String[3];
        dato[0] = a.getcontacto().getNombre();
        dato[1]=a.getcontacto().getApellido1();
        dato[2]=""+a.getcontacto().getnumero();
        modelo.addRow(dato);
      }else{
      JOptionPane.showMessageDialog(this, "NUMERO INCORRECTO, NO SE INGRESO EL CONTACTO");
      }// JOptionPane.showMessageDialog(null, "ERROR.. INTRODUZCA UN NUMERO","ADVERTENCIA",JOptionPane.INFORMATION_MESSAGE);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public void cerrar() { 
        //CERRAR
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    try {
                        confirmar();
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }           
         });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void confirmar()throws UnsupportedLookAndFeelException, IOException{
               
        int valor=JOptionPane.showConfirmDialog(this, "¿Desea guardar los datos?","Advertencia",JOptionPane.YES_NO_OPTION);
        if(valor==JOptionPane.YES_OPTION){
           
             String name=JOptionPane.showInputDialog(this, "Introduzca el nombre de la agenda");
             Herramienta.guardar(a, name);
             System.exit(0);
            
        }else{
            System.exit(0);
        
            
      }
    }
  
  
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       // ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Archivo.txt"));
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        //GUARDAR AGENDA
        
        String name=JOptionPane.showInputDialog(this, "Introduzca el nombre de la agenda");
        try {                      
            Herramienta.guardar(a, name);
           
        } catch (IOException ex) {
           
            Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     
        //RECUPERAR AGENDA
        File selectedFile = null;
        JFileChooser fileChooser = new JFileChooser();
       fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
       int result = fileChooser.showOpenDialog(this);
       if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();          
          
         }
          
        try {
            a.vaciar_agenda();
            a = Herramienta.recuperar(selectedFile, a);
            llenar_table(a);
        } catch (IOException ex) {
            Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FORM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
        //MOSTRAR DATOS DEL CONTACTO EN LA AGENDA
        int fila=jTable1.getSelectedRow();       
        jTextField1.setText(a.Obtener_Contacto(fila).getNombre());
        jTextField2.setText(a.Obtener_Contacto(fila).getApellido1());
        jTextField3.setText(a.Obtener_Contacto(fila).getApellido2());
        jTextField4.setText(""+a.Obtener_Contacto(fila).getnumero());
        
        jComboBox1.setSelectedIndex(a.Obtener_Contacto(fila).gettipo());
        jComboBox2.setSelectedIndex(a.Obtener_Contacto(fila).getgrupo());
             
    }//GEN-LAST:event_jTable1MouseClicked
 
    void llenar_table(Agenda p){
        
        String []v=new String[3];
        int cantidad_ele=jTable1.getRowCount();
        for(int i=0;i<cantidad_ele;i++){
            modelo.removeRow(0);
        }
        int j=0;
        while(j<p.getDim()+1){
            
            v[0]=p.Obtener_Contacto(j).getNombre();
            v[1]=p.Obtener_Contacto(j).getApellido1();
            v[2]=""+p.Obtener_Contacto(j).getnumero();
            modelo.addRow(v);
            
            j++;
        } 
       
    }
  
    public static void main(String args[]) throws UnsupportedLookAndFeelException, IOException {
      //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
      UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\BELTRAN\\Documents\\NetBeansProjects\\PROYECTO\\lib\\tema.theme"));
        
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORM().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
