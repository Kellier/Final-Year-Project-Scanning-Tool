/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanning_tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author corma
 */
public class SqlTest extends JFrame 
{   
    File selectFile = null;
    
    Scanner scan;
    
    String weak = new String("Statement stm = conn.createStatement();");
    
    int lineno = 1;

    /**
     * Creates new form SqlTest
     */
    public SqlTest() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        filebutton = new javax.swing.JButton();
        filefield = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("             Test for SQL Injection Vulnerabilities");
        jScrollPane1.setViewportView(jTextArea1);

        filebutton.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        filebutton.setText("Select File");
        filebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filebuttonActionPerformed(evt);
            }
        });

        filefield.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        filefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filefieldActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        output.setColumns(20);
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("\t\tOuput:");
        jScrollPane4.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filebutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filefield, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane4)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filebutton)
                    .addComponent(filefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filebuttonActionPerformed
        try {
            JFileChooser file = new JFileChooser();
            
            int result = file.showOpenDialog(file);
            
            file.setCurrentDirectory(new File("."));
            
            if(result == JFileChooser.APPROVE_OPTION)
            {
                selectFile = file.getSelectedFile();
            }

            filefield.setText(selectFile.getName());
            
            scan = new Scanner(selectFile);
            
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                if (line.trim().replaceAll("\\s+", " ").equalsIgnoreCase(weak.trim().replaceAll("\\s+", " ")))
                {
                    output.setText("line " + lineno + " : " + line + "\n\tRecommend using PreparedStatment()");
                }
                else
                {
                    lineno++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SqlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filebuttonActionPerformed

    
    private void filefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filefieldActionPerformed
       
    }//GEN-LAST:event_filefieldActionPerformed

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
            java.util.logging.Logger.getLogger(SqlTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SqlTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SqlTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SqlTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SqlTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton filebutton;
    private javax.swing.JTextField filefield;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea output;
    // End of variables declaration//GEN-END:variables
}
