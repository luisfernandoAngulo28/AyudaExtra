/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FPParcialDemo.java
 *
 * Created on 04-05-2012, 05:17:27 PM
 */
package Presentacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import Negocio.PilaPrioridad;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roly
 */
public class FPParcialDemo extends javax.swing.JFrame {

    private int nroFil, nroCol;
    PilaPrioridad pila;

    /** Creates new form FPParcialDemo */
    public FPParcialDemo() {
        initComponents();
        Object[][] data = new Object[0][0];
        Object[] columnName = new Object[0];
        DefaultTableModel dftm = new DefaultTableModel(data, columnName);
        jTable1.setModel(dftm);
        jTable1.setEnabled(false);
    }

    public int getNroCol() {
        return nroCol;
    }

    public void setNroCol(int nroCol) {
        this.nroCol = nroCol;
    }

    public int getNroFil() {
        return nroFil;
    }

    public void setNroFil(int nroFil) {
        this.nroFil = nroFil;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                ""
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Crear Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mostrar Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Mostrar en Texto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                ""
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jButton4.setText("Cargar Datos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //setNroFil(Integer.parseInt(jTextField1.getText().trim()));
            setNroFil(Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de Elementos")));
            setNroCol(2);
            Object[][] data = new Object[getNroFil()][2];
            Object[] columnName = new Object[2];
            columnName[0] = "Valor";
            columnName[1] = "Prioridad";
            DefaultTableModel dftm = new DefaultTableModel(data, columnName);
            jTable1.setModel(dftm);
            jTable1.setEnabled(true);
            pila = new PilaPrioridad(getNroFil());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dato Incorrecto::Verifique Por favor");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Object data1[][] = new Object[getNroFil()][getNroCol()];
            Object ColumnName1[] = new Object[2];
            ColumnName1[0] = "Valor";
            ColumnName1[1] = "Prioridad";
            DefaultTableModel dftm1 = new DefaultTableModel(data1, ColumnName1);
            jTable2.setModel(dftm1);
            jTable2.setEnabled(true);
            int k = 1;
            for (int i = getNroFil() - 1; i >= 0; i--) {
                int n = pila.getDato(k);
                if (n != 0) {
                    int n1 = n;
                    n1 = n1 & 63;
                    n = n >>> 6;
                    n = n & 15;
                    if (jTable2.getValueAt(i, 0) == null && jTable2.getValueAt(i, 1) == null) {
                        jTable2.setValueAt(n1, i, 0);
                        jTable2.setValueAt(n, i, 1);
                    }
                }
                k++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            jTextPane1.setText(pila.Mostrar());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            for (int i = 0; i < getNroFil(); i++) {
                if ((jTable1.getValueAt(i, 0) != null) && (jTable1.getValueAt(i, 1) != null)) {
                    int valor = Integer.parseInt((String) jTable1.getValueAt(i, 0));
                    int priori = Integer.parseInt((String) jTable1.getValueAt(i, 1));
                    pila.pushDato(valor, priori);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FPParcialDemo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
