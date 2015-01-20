/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Core.C_ComponentFrame;
import Clases.Core.C_File;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lvaleriano
 */
public class F_Modify_Files_EDI extends javax.swing.JFrame{

    C_ComponentFrame Obj_ComponentFrame = new C_ComponentFrame();
    /**
     * Creates new form F_Modify_Files_EDI
     */
    public F_Modify_Files_EDI() {
        initComponents();
        Obj_ComponentFrame.setEnableJPanelComponentsWithCheckBox(pnlReferencia, chbReferencia);
        Obj_ComponentFrame.setEnableJPanelComponentsWithCheckBox(pnlUNBUNZ, chbUNBUNZ);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        pnlReferencia = new javax.swing.JPanel();
        txtReferencia = new javax.swing.JTextField();
        lblReferencia = new javax.swing.JLabel();
        chbTDT20 = new javax.swing.JCheckBox();
        chbRFFVON = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        chbReferencia = new javax.swing.JCheckBox();
        pnlUNBUNZ = new javax.swing.JPanel();
        lblUNBUNZ = new javax.swing.JLabel();
        txtUNBUNZ = new javax.swing.JTextField();
        chbUNBUNZ = new javax.swing.JCheckBox();
        btnSelectEDI = new javax.swing.JButton();
        lblPathEDI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlReferencia.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Referencia"));

        lblReferencia.setText("Texto de referencia :");

        chbTDT20.setText("TDT+20");

        chbRFFVON.setText("RFF+VON");

        javax.swing.GroupLayout pnlReferenciaLayout = new javax.swing.GroupLayout(pnlReferencia);
        pnlReferencia.setLayout(pnlReferenciaLayout);
        pnlReferenciaLayout.setHorizontalGroup(
            pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReferenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReferencia)
                    .addComponent(chbTDT20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbRFFVON)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlReferenciaLayout.setVerticalGroup(
            pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReferenciaLayout.createSequentialGroup()
                .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(pnlReferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbTDT20)
                    .addComponent(chbRFFVON)))
        );

        jButton1.setText("Modificar EDI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chbReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbReferenciaActionPerformed(evt);
            }
        });

        pnlUNBUNZ.setBorder(javax.swing.BorderFactory.createTitledBorder("Sumar unidad a minuto y segundo a UNB-UNZ"));

        lblUNBUNZ.setText("Unidad Sumada :");

        txtUNBUNZ.setText("1");
        txtUNBUNZ.setToolTipText("");

        javax.swing.GroupLayout pnlUNBUNZLayout = new javax.swing.GroupLayout(pnlUNBUNZ);
        pnlUNBUNZ.setLayout(pnlUNBUNZLayout);
        pnlUNBUNZLayout.setHorizontalGroup(
            pnlUNBUNZLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUNBUNZLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUNBUNZ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUNBUNZ, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlUNBUNZLayout.setVerticalGroup(
            pnlUNBUNZLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUNBUNZLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblUNBUNZ)
                .addComponent(txtUNBUNZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        chbUNBUNZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbUNBUNZActionPerformed(evt);
            }
        });

        btnSelectEDI.setText("Seleccionar EDI");
        btnSelectEDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectEDIActionPerformed(evt);
            }
        });

        lblPathEDI.setForeground(new java.awt.Color(0, 0, 255));
        lblPathEDI.setText("No ha seleccionado archivo EDI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnSelectEDI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPathEDI))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbReferencia, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chbUNBUNZ, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlUNBUNZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectEDI)
                    .addComponent(lblPathEDI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlUNBUNZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(chbUNBUNZ)
                        .addGap(27, 27, 27)
                        .addComponent(chbReferencia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbReferenciaActionPerformed
        Obj_ComponentFrame.setEnableJPanelComponentsWithCheckBox(pnlReferencia, chbReferencia);
    }//GEN-LAST:event_chbReferenciaActionPerformed

    private void chbUNBUNZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbUNBUNZActionPerformed
        Obj_ComponentFrame.setEnableJPanelComponentsWithCheckBox(pnlUNBUNZ, chbUNBUNZ);
    }//GEN-LAST:event_chbUNBUNZActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String FilePath = "";
        try {
            C_File O_File= new C_File();
            O_File.ReturnObjectOfArchiveReadyToRead(null);
        } catch (Exception e) {
        }
        if(chbUNBUNZ.isSelected()){
            //String milisecond = GetTextFromOneCharterToAnother(Linea,"'",1,"+",1,false);
            //GetTextFromOneCharterToAnother(Linea,"+",1,":",1,false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSelectEDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectEDIActionPerformed
        // TODO add your handling code here:
        
        JFileChooser chosser = new JFileChooser();
        int returnVal = chosser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File myFile = chosser.getSelectedFile();
            String FilePath = myFile.getPath();
            lblPathEDI.setText(FilePath);
            
            //Declaramos fr y fw
            FileReader fr = null;
            FileWriter fw = null;
            //Instanciamos el objeto O_FILE
            C_File O_File = new C_File();
            
            try {
                fr = O_File.ReturnObjectOfArchiveReadyToRead(FilePath);
                BufferedReader br = new BufferedReader(fr);
                String Resultado="";
                String Linea="";
                boolean Print=false;
                fw = O_File.ReturnCreatedObjectOfArchiveToWrite(O_File.GetTextFromOneCharterToAnother(FilePath,"", 1, ".", 1, true)+"_RESULT.txt");
                PrintWriter pw = new PrintWriter(fw);
                //Leemos la primera linea
                if((Linea = br.readLine())!=null){
                    if(chbUNBUNZ.isSelected()){
                        String seconds = O_File.AddToInteger(O_File.GetTextFromOneCharterToAnother(Linea,"'",1,"+",1,false),1);
                        String minutes = O_File.AddNMinutesDWPC(O_File.GetTextFromOneCharterToAnother(Linea,"+",1,":",1,false),Integer.parseInt(txtUNBUNZ.getText()));
                        Linea = Linea.replace(O_File.GetTextFromOneCharterToAnother(Linea,"'",1,"+",1,false), seconds);
                        Linea = Linea.replace(O_File.GetTextFromOneCharterToAnother(Linea,"+",1,":",1,false), minutes);
                    }
                    pw.println(Linea);
                }
                while((Linea=br.readLine())!=null){
                    if(O_File.TextStartWith(Linea,"UNH")){
                        Resultado="";
                        Print=false;
                    }
                    if(O_File.TextStartWith(Linea,"TDT+20")){ 
                        if(chbReferencia.isSelected() && chbTDT20.isSelected()){
                            Linea = O_File.DelimitedReplaceCaractersInText(Linea,"TDT+20+","+",txtReferencia.getText());
                        }
                        /*if(TextEndWith(Linea, VesselName)){
                            Print=true;
                        }*/
                    }
                    if(O_File.TextStartWith(Linea,"RFF+VON")){
                        if(chbReferencia.isSelected() && chbRFFVON.isSelected()){
                            Linea = O_File.DelimitedReplaceCaractersInText(Linea,"RFF+VON:","'",txtReferencia.getText());
                        }
                    }
                    if(O_File.TextStartWith(Linea,"UNT")){
                        Resultado+=Linea+";";
                        if(Print){
                            O_File.MultilaneWriteArchive(pw, Resultado, ';');
                        }
                    }
                    else{
                        Resultado+=Linea+";";
                    }
                    if(O_File.TextStartWith(Linea,"UNZ")){
                        pw.println(Linea);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(F_Modify_Files_EDI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSelectEDIActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_Modify_Files_EDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Modify_Files_EDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Modify_Files_EDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Modify_Files_EDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Modify_Files_EDI().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectEDI;
    private javax.swing.JCheckBox chbRFFVON;
    private javax.swing.JCheckBox chbReferencia;
    private javax.swing.JCheckBox chbTDT20;
    private javax.swing.JCheckBox chbUNBUNZ;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel lblPathEDI;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblUNBUNZ;
    private javax.swing.JPanel pnlReferencia;
    private javax.swing.JPanel pnlUNBUNZ;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtUNBUNZ;
    // End of variables declaration//GEN-END:variables
}