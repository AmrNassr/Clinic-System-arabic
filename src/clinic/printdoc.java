/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.awt.ComponentOrientation;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author amnassar
 */

public class printdoc extends javax.swing.JFrame {
  Connection con ;  
     public  String LL=null;
    PreparedStatement pst ;
    Home h ;
    ResultSet rs;
    String dayyy;
    
    public printdoc() {
        initComponents();
        con=DBConnect.connect();
        patientss();
        AutoCompleteDecorator.decorate(cmtype);
        
        AutoCompleteDecorator.decorate(cmtype1);
 Calendar cal = new GregorianCalendar();
                int monthh=cal.get(Calendar.MONTH)+1;
                int yearr = cal.get(Calendar.YEAR);
                int dayy =cal.get(Calendar.DAY_OF_MONTH);
             dayyy=String.valueOf(dayy);
 if(dayy == 1 || dayy == 2 || dayy == 3 || dayy == 4
         || dayy == 5 || dayy == 6 || dayy == 7 || dayy == 8 || dayy == 9 )
 {
      dayyy=String.valueOf(dayy);
     dayyy="0"+dayyy;
 }
          
             

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancle = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cmtype1 = new javax.swing.JComboBox();
        save = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cmtype = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(530, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(530, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(530, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancle.setBackground(new java.awt.Color(98, 113, 146));
        cancle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        cancle.setForeground(new java.awt.Color(255, 255, 255));
        cancle.setText("اغلاق");
        cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleActionPerformed(evt);
            }
        });
        jPanel1.add(cancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("المريض");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 130, -1));

        cmtype1.setEditable(true);
        cmtype1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmtype1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmtype1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmtype1ActionPerformed(evt);
            }
        });
        jPanel1.add(cmtype1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 260, 30));

        save.setBackground(new java.awt.Color(98, 113, 146));
        save.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("طباعة الروشته");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("رقم الروشتة");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 130, 30));

        cmtype.setEditable(true);
        cmtype.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel1.add(cmtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/64586a0ad51dc03.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(530, 550));
        jLabel1.setMinimumSize(new java.awt.Dimension(530, 550));
        jLabel1.setPreferredSize(new java.awt.Dimension(530, 550));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 260));

        s1.setBackground(new java.awt.Color(255, 255, 255));
        s1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s1.setForeground(new java.awt.Color(255, 255, 255));
        s1.setText("/");
        jPanel1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 10, -1));

        s2.setBackground(new java.awt.Color(255, 255, 255));
        s2.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        s2.setForeground(new java.awt.Color(255, 255, 255));
        s2.setText("/");
        jPanel1.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 10, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(474, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_cancleActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
 
        
       
     InputStream in=null;
      try {
          
          in = this.getClass().getResourceAsStream("/reports/documentreport.jasper");
          String reportpath= "D:\\clinic\\msrofat.jasper";
    Map<String,Object> para = new HashMap<String,Object>();
            para.put("serial",cmtype.getSelectedItem().toString() );
           

            JasperPrint j = JasperFillManager.fillReport(in, para,con);
            JasperViewer.viewReport(j,false);
      }
     catch (JRException ex) {
        } finally {
        } 

         
        
    }//GEN-LAST:event_saveActionPerformed

    private void cmtype1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmtype1ActionPerformed
         Object obj = evt.getSource();
       if(obj==cmtype1)
       {
             try {
                  String sqll="SELECT serial  FROM clinic.documents ";
                  
                  pst=(PreparedStatement) con.prepareStatement(sqll);
                  
                  rs=pst.executeQuery();
                  
                  while(rs.next()){
                      
                      String name = rs.getString("serial");
                      
                      cmtype.removeItem(name);
                      
                      
                  }
              } catch (SQLException ex) {
                  Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
              }
              try {
                  String sqll="SELECT serial  FROM clinic.documents where  name='"+cmtype1.getSelectedItem().toString()+"' ORDER BY id DESC";
                  
                  pst=(PreparedStatement) con.prepareStatement(sqll);
                  
                  rs=pst.executeQuery();
                  
                  while(rs.next()){
                      
                      String name = rs.getString("serial");
                      
                      cmtype.addItem(name);
                      
                      
                  }
              } catch (SQLException ex) {
                  Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
              }
                  
       
       }
    }//GEN-LAST:event_cmtype1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancle;
    private javax.swing.JComboBox cmtype;
    private javax.swing.JComboBox cmtype1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

public void patientss()
   {
        try {
             String sql="SELECT * FROM clinic.patient";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmtype1.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }
}
