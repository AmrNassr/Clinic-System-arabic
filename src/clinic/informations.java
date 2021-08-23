/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author amnassar
 */
public final class informations extends javax.swing.JInternalFrame {

    /**
     * Creates new form book
     */
       Connection con ;
    PreparedStatement pst ;
    ResultSet rs;
     public String y ;
     String type;
     int day;
   int month;
    int year;
    
   
    public informations(String x ) {
        initComponents();
        con=DBConnect.connect();
        tablelorddruglist();
        tablelordoperationlist();
         tablelordanalyzeslistlist();
         tablelorddoctorlist();
         tablelorddose();
         types();
        clear();
        
          type=x;
          if(type.equals("admin"))
          {
              delete.setEnabled(true);
              delete1.setEnabled(true);
              delete2.setEnabled(true);
              delete3.setEnabled(true);
              delete4.setEnabled(true);
          }
            TableCellRenderer rendererFromHeader = tdetails.getTableHeader().getDefaultRenderer();
JLabel headerLabel = (JLabel) rendererFromHeader;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tdetails.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
         
         // TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
         
         TableCellRenderer rendererFromHeader4 = tdetails4.getTableHeader().getDefaultRenderer();
JLabel headerLabel4 = (JLabel) rendererFromHeader4;
headerLabel4.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer4 = new DefaultTableCellRenderer();
        centerRenderer4.setHorizontalAlignment( JLabel.CENTER );
        tdetails4.getColumnModel().getColumn(0).setCellRenderer( centerRenderer4 );
         tdetails4.getColumnModel().getColumn(1).setCellRenderer( centerRenderer4 );
         
         // TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
          TableCellRenderer rendererFromHeadero = tdetails1.getTableHeader().getDefaultRenderer();
JLabel headerLabelo = (JLabel) rendererFromHeadero;
headerLabelo.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderero = new DefaultTableCellRenderer();
        centerRenderero.setHorizontalAlignment( JLabel.CENTER );
        tdetails1.getColumnModel().getColumn(0).setCellRenderer( centerRenderero );
         tdetails1.getColumnModel().getColumn(1).setCellRenderer( centerRenderero );
         
         // TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
          TableCellRenderer rendererFromHeaderr = tdetails2.getTableHeader().getDefaultRenderer();
JLabel headerLabel1 = (JLabel) rendererFromHeaderr;
headerLabel1.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRendererr = new DefaultTableCellRenderer();
        centerRendererr.setHorizontalAlignment( JLabel.CENTER );
        tdetails2.getColumnModel().getColumn(0).setCellRenderer( centerRendererr );
         tdetails2.getColumnModel().getColumn(1).setCellRenderer( centerRendererr );
         tdetails2.getColumnModel().getColumn(2).setCellRenderer( centerRendererr );
         
          // TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
          TableCellRenderer rendererFromHeaderrd = tdetails3.getTableHeader().getDefaultRenderer();
JLabel headerLabel1d = (JLabel) rendererFromHeaderrd;
headerLabel1d.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRendererrd = new DefaultTableCellRenderer();
        centerRendererrd.setHorizontalAlignment( JLabel.CENTER );
        tdetails3.getColumnModel().getColumn(0).setCellRenderer( centerRendererrd );
         tdetails3.getColumnModel().getColumn(1).setCellRenderer( centerRendererrd );
         tdetails3.getColumnModel().getColumn(2).setCellRenderer( centerRendererrd );
         dose();
          Calendar cal = new GregorianCalendar();
                 day = cal.get(Calendar.DAY_OF_MONTH);
                 month=cal.get(Calendar.MONTH)+1;
                 year = cal.get(Calendar.YEAR);
               date.setText(year+":"+month+":"+day);
               
               lname1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
               name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
               oname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                dname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
               user.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
               pass.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tdetails4 = new javax.swing.JTable();
        autoserial4 = new javax.swing.JLabel();
        delete4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lname1 = new javax.swing.JTextField();
        save4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        serialid4 = new javax.swing.JLabel();
        date4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdetails = new javax.swing.JTable();
        autoserial = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmpatient1 = new javax.swing.JComboBox();
        delete = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        serialid = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tdetails2 = new javax.swing.JTable();
        price = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        autoserial2 = new javax.swing.JLabel();
        delete2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        oname = new javax.swing.JTextField();
        save1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        serialid2 = new javax.swing.JLabel();
        date2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdetails1 = new javax.swing.JTable();
        autoserial1 = new javax.swing.JLabel();
        delete1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        save2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        serialid1 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tdetails3 = new javax.swing.JTable();
        cmtype = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        autoserial3 = new javax.swing.JLabel();
        delete3 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        dname = new javax.swing.JTextField();
        save3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        serialid3 = new javax.swing.JLabel();
        date3 = new javax.swing.JLabel();

        jLabel16.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/71847608-close-up-of-handshake-on-city-background-with-abstract-sunlight-partnership-concept-double-exposure.jpg"))); // NOI18N

        setMaximumSize(new java.awt.Dimension(980, 690));
        setMinimumSize(new java.awt.Dimension(980, 690));
        setPreferredSize(new java.awt.Dimension(980, 690));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel14.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails4.setBackground(new java.awt.Color(138, 203, 195));
        tdetails4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "الرقم", "الجرعة"
            }
        ));
        tdetails4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tdetails4.setRowHeight(25);
        tdetails4.setRowMargin(2);
        tdetails4.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tdetails4.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tdetails4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdetails4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tdetails4);
        if (tdetails4.getColumnModel().getColumnCount() > 0) {
            tdetails4.getColumnModel().getColumn(0).setMinWidth(150);
            tdetails4.getColumnModel().getColumn(0).setPreferredWidth(150);
            tdetails4.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        jPanel14.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 920, 280));

        autoserial4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        autoserial4.setForeground(new java.awt.Color(255, 255, 255));
        autoserial4.setText("لإثسف");
        jPanel14.add(autoserial4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 170, 60));

        delete4.setBackground(new java.awt.Color(138, 203, 195));
        delete4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        delete4.setText("مسح");
        delete4.setEnabled(false);
        delete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete4ActionPerformed(evt);
            }
        });
        jPanel14.add(delete4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 110, 40));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel15.setText("اسم الجرعة");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 140, 30));

        lname1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel14.add(lname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 230, 30));

        save4.setBackground(new java.awt.Color(138, 203, 195));
        save4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save4.setText("اضافة");
        save4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save4ActionPerformed(evt);
            }
        });
        jPanel14.add(save4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 100, 40));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid4.setText("jLabel1");
        jPanel14.add(serialid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date4.setText("jLabel1");
        jPanel14.add(date4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        jTabbedPane1.addTab("الجرعات", jPanel14);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel10.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails.setBackground(new java.awt.Color(138, 203, 195));
        tdetails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Serial", "اسم الدواء", "الجرعة"
            }
        ));
        tdetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tdetails.setRowHeight(25);
        tdetails.setRowMargin(2);
        tdetails.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tdetails.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tdetails);
        if (tdetails.getColumnModel().getColumnCount() > 0) {
            tdetails.getColumnModel().getColumn(0).setMinWidth(1);
            tdetails.getColumnModel().getColumn(0).setPreferredWidth(1);
            tdetails.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 920, 280));

        autoserial.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        autoserial.setForeground(new java.awt.Color(255, 255, 255));
        autoserial.setText("لإثسف");
        jPanel10.add(autoserial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 60));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel27.setText("الجرعة");
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 90, 30));

        cmpatient1.setEditable(true);
        cmpatient1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cmpatient1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmpatient1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmpatient1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmpatient1MouseReleased(evt);
            }
        });
        jPanel10.add(cmpatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 230, 30));

        delete.setBackground(new java.awt.Color(138, 203, 195));
        delete.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        delete.setText("مسح");
        delete.setEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel10.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 110, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("اسم الدواء");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 160, 30));

        name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel10.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 230, 30));

        save.setBackground(new java.awt.Color(138, 203, 195));
        save.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save.setText("حفظ");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel10.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 110, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid.setText("jLabel1");
        jPanel10.add(serialid, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, 120));

        date.setText("jLabel1");
        jPanel10.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        jTabbedPane1.addTab("الادوية الطبية", jPanel10);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.setEnabled(false);
        jPanel12.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel12.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails2.setBackground(new java.awt.Color(138, 203, 195));
        tdetails2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "الكود", "اسم العملية", "السعر"
            }
        ));
        tdetails2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tdetails2.setRowHeight(25);
        tdetails2.setRowMargin(2);
        tdetails2.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tdetails2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tdetails2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdetails2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tdetails2);
        if (tdetails2.getColumnModel().getColumnCount() > 0) {
            tdetails2.getColumnModel().getColumn(0).setMinWidth(150);
            tdetails2.getColumnModel().getColumn(0).setPreferredWidth(150);
            tdetails2.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 920, 280));

        price.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price.setText("0");
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel12.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 70, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel20.setText("سعر العملية");
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 130, 30));

        autoserial2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        autoserial2.setForeground(new java.awt.Color(255, 255, 255));
        autoserial2.setText("لإثسف");
        jPanel12.add(autoserial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 170, 60));

        delete2.setBackground(new java.awt.Color(138, 203, 195));
        delete2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        delete2.setText("مسح");
        delete2.setEnabled(false);
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2ActionPerformed(evt);
            }
        });
        jPanel12.add(delete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 120, 40));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setText("اسم العملية");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 130, 30));

        oname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel12.add(oname, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 230, 30));

        save1.setBackground(new java.awt.Color(138, 203, 195));
        save1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save1.setText("حفظ");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });
        jPanel12.add(save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 110, 40));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid2.setText("jLabel1");
        jPanel12.add(serialid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date2.setText("jLabel1");
        jPanel12.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        jTabbedPane1.addTab("العمليات", jPanel12);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel11.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails1.setBackground(new java.awt.Color(138, 203, 195));
        tdetails1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "الكود", "اسم التحليل - الاشعة"
            }
        ));
        tdetails1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tdetails1.setRowHeight(25);
        tdetails1.setRowMargin(2);
        tdetails1.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tdetails1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tdetails1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdetails1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tdetails1);
        if (tdetails1.getColumnModel().getColumnCount() > 0) {
            tdetails1.getColumnModel().getColumn(0).setMinWidth(150);
            tdetails1.getColumnModel().getColumn(0).setPreferredWidth(150);
            tdetails1.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        jPanel11.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 920, 280));

        autoserial1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        autoserial1.setForeground(new java.awt.Color(255, 255, 255));
        autoserial1.setText("لإثسف");
        jPanel11.add(autoserial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 170, 60));

        delete1.setBackground(new java.awt.Color(138, 203, 195));
        delete1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        delete1.setText("مسح");
        delete1.setEnabled(false);
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        jPanel11.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 110, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel14.setText("اسم التحليل - الاشعة");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 190, 30));

        lname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel11.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 240, 30));

        save2.setBackground(new java.awt.Color(138, 203, 195));
        save2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save2.setText("حفظ");
        save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2ActionPerformed(evt);
            }
        });
        jPanel11.add(save2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 110, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel11.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid1.setText("jLabel1");
        jPanel11.add(serialid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date1.setText("jLabel1");
        jPanel11.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        jTabbedPane1.addTab("التحاليل و الاشعة", jPanel11);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel13.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails3.setBackground(new java.awt.Color(138, 203, 195));
        tdetails3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "الكود", "اسم الطبيب", "التخصص الطبي"
            }
        ));
        tdetails3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tdetails3.setRowHeight(25);
        tdetails3.setRowMargin(2);
        tdetails3.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tdetails3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tdetails3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdetails3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tdetails3);
        if (tdetails3.getColumnModel().getColumnCount() > 0) {
            tdetails3.getColumnModel().getColumn(0).setMinWidth(150);
            tdetails3.getColumnModel().getColumn(0).setPreferredWidth(150);
            tdetails3.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        jPanel13.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 920, 230));

        cmtype.setEditable(true);
        cmtype.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cmtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel13.add(cmtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 230, 30));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setText("كلمة السر");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 120, 30));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setText("اسم المستخدم");
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 110, 30));

        user.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel13.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 230, 30));

        pass.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel13.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 230, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setText("التخصص الطبي");
        jPanel13.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 110, 30));

        autoserial3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        autoserial3.setForeground(new java.awt.Color(255, 255, 255));
        autoserial3.setText("لإثسف");
        jPanel13.add(autoserial3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 170, 60));

        delete3.setBackground(new java.awt.Color(138, 203, 195));
        delete3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        delete3.setText("مسح");
        delete3.setEnabled(false);
        delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete3ActionPerformed(evt);
            }
        });
        jPanel13.add(delete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 140, 40));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setText("اسم الطبيب");
        jPanel13.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 110, 30));

        dname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel13.add(dname, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 230, 30));

        save3.setBackground(new java.awt.Color(138, 203, 195));
        save3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save3.setText("حفظ");
        save3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save3ActionPerformed(evt);
            }
        });
        jPanel13.add(save3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 150, 40));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel13.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid3.setText("jLabel1");
        jPanel13.add(serialid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date3.setText("jLabel1");
        jPanel13.add(date3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        jTabbedPane1.addTab("الاطباء", jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseClicked
        DefaultTableModel tmodel =(DefaultTableModel)tdetails.getModel();
        int selectrowindex=tdetails.getSelectedRow();
        serialid.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        name.setText(tmodel.getValueAt(selectrowindex, 1).toString());
        cmpatient1.setSelectedItem(tmodel.getValueAt(selectrowindex, 2).toString());
      

    }//GEN-LAST:event_tdetailsMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         if(serialid.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر الدواء المراد ازالتة");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.drugslist WHERE id='"+serialid.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(rootPane, " تم ازالة الدواء بنجاح");
                    tablelorddruglist();
                    clear();
                } catch (SQLException ex) {

                }
                clear();
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try
        {
            String type = cmpatient1.getSelectedItem().toString();
            String namee = name.getText();
            if(serialid.getText().trim().isEmpty())
            {

                
                if( name.getText().trim().isEmpty() )
                {
                    JOptionPane.showMessageDialog(this, " من فضلك ادخل اسم الدواء ");
                }
                else
                {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
                    if(dialogResult == 0) {
                        try{
                            String sql = "INSERT INTO clinic.drugslist (name,type) VALUES"
                            + " ('"+namee+"','"+type+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "تم اضافة الدواء بنجاح");
                             clear();
                            tablelorddruglist();
                            name.requestFocus();

                        }
                        catch(Exception e ){
                            JOptionPane.showMessageDialog(null,"الدواء موجود مسبقا");
                        }

                    }
                    else
                    {JOptionPane.showMessageDialog(this, "الغاء");

                    }
                }
            }
            else
            {
                 String sqla = "UPDATE clinic.drugslist SET name='"+namee+"',type='"+type+"' where id = '"+serialid.getText()+"'";
                  pst=(PreparedStatement) con.prepareStatement(sqla);
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(this, "تم تعديل الدواء بنجاح");
                  tablelorddruglist(); 
                  clear();
                  name.requestFocus();
            }
            
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_saveActionPerformed

    private void tdetails2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetails2MouseClicked
         DefaultTableModel tmodel =(DefaultTableModel)tdetails2.getModel();
        int selectrowindex=tdetails2.getSelectedRow();
        serialid2.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        oname.setText(tmodel.getValueAt(selectrowindex, 1).toString());
        price.setText(tmodel.getValueAt(selectrowindex, 2).toString());
    }//GEN-LAST:event_tdetails2MouseClicked

    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
         if(serialid2.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر العملية المراد ازالتها");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.operationslist WHERE id='"+serialid2.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(rootPane, "تم مسح العملية بنجاح");
                    clear();
                            tablelordoperationlist();
                            oname.requestFocus();
                } catch (SQLException ex) {

                }
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_delete2ActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
 try
        {
             int pricee = Integer.parseInt(price.getText());
             String namee = oname.getText();
            if(serialid2.getText().trim().isEmpty())
            {
               if( oname.getText().trim().isEmpty() )
                {
                    JOptionPane.showMessageDialog(this, " من فضلك ادخل اسم العملية");
                }
                else
                {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
                    if(dialogResult == 0) {
                        try{
                           
                            String sql = "INSERT INTO clinic.operationslist (name,price) VALUES"
                            + " ('"+namee+"','"+pricee+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "تم اضافة العملية بنجاح");
                             clear();
                            tablelordoperationlist();
                            oname.requestFocus();

                        }
                        catch(Exception e ){
                            JOptionPane.showMessageDialog(null,"اسم العملية موجود من قبل");
                        }

                    }
                    else
                    {JOptionPane.showMessageDialog(this, "الغاء");

                    }
                }
            }
            else
            {
                
                 String sqla = "UPDATE clinic.operationslist SET name='"+namee+"',price='"+pricee+"' where id = '"+serialid2.getText()+"'";
                  pst=(PreparedStatement) con.prepareStatement(sqla);
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(this, "تم تعديل العملية بنجاح");
                  clear();
                            tablelordoperationlist();
                            oname.requestFocus();
            }
            
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(this, " من فضلك قم بادخال سعر صحيح");
        }        
    }//GEN-LAST:event_save1ActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void tdetails1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetails1MouseClicked
      DefaultTableModel tmodel =(DefaultTableModel)tdetails1.getModel();
        int selectrowindex=tdetails1.getSelectedRow();
        serialid1.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        lname.setText(tmodel.getValueAt(selectrowindex, 1).toString());
    }//GEN-LAST:event_tdetails1MouseClicked

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        if(serialid1.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر التحليل - الاشعة المراد ازالته");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.analyzeslist WHERE id='"+serialid1.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(rootPane, " تمت الازالة بنجاح");
                    tablelordanalyzeslistlist();
                    clear();
                } catch (SQLException ex) {

                }
                clear();
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_delete1ActionPerformed

    private void save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ActionPerformed
        try
        {
            String namee = lname.getText();
            if(serialid1.getText().trim().isEmpty())
            {

                
                if( lname.getText().trim().isEmpty() )
                {
                    JOptionPane.showMessageDialog(this, " من فضلك ادخل اسم التحليل - الاشعة");
                }
                else
                {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
                    if(dialogResult == 0) {
                        try{
                            String sql = "INSERT INTO clinic.analyzeslist (name) VALUES"
                            + " ('"+namee+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "تمت الاضافة بنجاح");
                             clear();
                            tablelordanalyzeslistlist();

                        }
                        catch(Exception e ){
                            JOptionPane.showMessageDialog(null,"التحليل - الاشعة موجود من قبل");
                        }

                    }
                    else
                    {JOptionPane.showMessageDialog(this, "الغاء");

                    }
                }
            }
            else
            {
                 String sqla = "UPDATE clinic.analyzeslist SET name='"+namee+"' where id = '"+serialid1.getText()+"'";
                  pst=(PreparedStatement) con.prepareStatement(sqla);
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(this, "تم تعديل التحليل - الاشعة بنجاح");
                  tablelordanalyzeslistlist();
                  clear();
                  lname.requestFocus();
            }
            
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_save2ActionPerformed

    private void tdetails3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetails3MouseClicked
         DefaultTableModel tmodel =(DefaultTableModel)tdetails3.getModel();
        int selectrowindex=tdetails3.getSelectedRow();
        serialid3.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        dname.setText(tmodel.getValueAt(selectrowindex, 1).toString());
        cmtype.setSelectedItem(tmodel.getValueAt(selectrowindex, 2).toString());
    }//GEN-LAST:event_tdetails3MouseClicked

    private void delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete3ActionPerformed
        if(serialid3.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر الطبيب المراد ازالتة");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.doctors WHERE id='"+serialid3.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(rootPane, " تمت الازالة بنجاح");
                    tablelorddoctorlist();
                    clear();
                    dname.requestFocus();
                } catch (SQLException ex) {

                }
                clear();
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_delete3ActionPerformed

    private void save3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save3ActionPerformed
        try
        {
            String namee = dname.getText();
            if(serialid3.getText().trim().isEmpty())
            {

                
                if( dname.getText().trim().isEmpty() || cmtype.getSelectedItem().toString().trim().isEmpty() )
                {
                    JOptionPane.showMessageDialog(this, " من فضلك ادخل اسم الطبيب و التخصص");
                }
                else
                {
                    if(user.getText().trim().isEmpty() ||pass.getText().trim().isEmpty() )
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك ادخل اسم المستخدم وكلمة السر ");
        }
        else
        {

            try{
                String sql = "INSERT INTO clinic.users (username, password, type,name) VALUES"
                + " ('"+user.getText()+"','"+pass.getText()+"','Doctor','"+dname.getText()+"')";
                pst = (PreparedStatement)con.prepareStatement(sql);
                pst.execute();
            }
            catch(Exception e ){
                JOptionPane.showMessageDialog(null,"Eror : "+e);
            }

        }
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
                    if(dialogResult == 0) {
                        try{
                            String sql = "INSERT INTO clinic.doctors (name,type) VALUES"
                            + " ('"+namee+"','"+cmtype.getSelectedItem().toString()+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "تم اضافة الطبيب بنجاح");
                             clear();
                            tablelorddoctorlist();
                             dname.requestFocus();

                        }
                        catch(Exception e ){
                            JOptionPane.showMessageDialog(null,"اسم الطبيب موجود من قبل");
                        }

                    }
                    else
                    {JOptionPane.showMessageDialog(this, "الغاء");

                    }
                }
            }
            else
            {
                 String sqla = "UPDATE clinic.doctors SET name='"+namee+"' where id = '"+serialid3.getText()+"'";
                  pst=(PreparedStatement) con.prepareStatement(sqla);
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(this, "تم تعديل الطبيب بنجاح");
                  tablelorddoctorlist();
                  clear();
                   dname.requestFocus();
            }
            
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_save3ActionPerformed

    private void cmpatient1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MouseEntered

    private void cmpatient1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MousePressed

    private void cmpatient1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MouseReleased

    private void tdetails4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetails4MouseClicked
       DefaultTableModel tmodel =(DefaultTableModel)tdetails4.getModel();
        int selectrowindex=tdetails4.getSelectedRow();
        serialid4.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        lname1.setText(tmodel.getValueAt(selectrowindex, 1).toString());
    }//GEN-LAST:event_tdetails4MouseClicked

    private void delete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete4ActionPerformed
       if(serialid4.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر الجرعة المراد ازالتها");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.dose WHERE id='"+serialid4.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(rootPane, " تم مسح الجرعة بنجاح");
                    tablelorddose();
                    clear();
                } catch (SQLException ex) {

                }
                clear();
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_delete4ActionPerformed

    private void save4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save4ActionPerformed
                try
        {
            String namee = lname1.getText();
            if(serialid4.getText().trim().isEmpty())
            {

                
                if( lname1.getText().trim().isEmpty() )
                {
                    JOptionPane.showMessageDialog(this, " من فضلك ادخل اسم الجرعة ");
                }
                else
                {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
                    if(dialogResult == 0) {
                        try{
                            String sql = "INSERT INTO clinic.dose (name) VALUES"
                            + " ('"+namee+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "تم اضافة الجرعة بنجاح");
                             clear();
                            tablelorddose();
                            cmpatient1.addItem(namee);

                        }
                        catch(Exception e ){
                            JOptionPane.showMessageDialog(null,"الجرعة موجودة من قبل ");
                        }

                    }
                    else
                    {JOptionPane.showMessageDialog(this, "الغاء");

                    }
                }
            }
            else
            {
                 String sqla = "UPDATE clinic.dose SET name='"+namee+"' where id = '"+serialid4.getText()+"'";
                  pst=(PreparedStatement) con.prepareStatement(sqla);
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(this, "تم عديل الجرعة بنجاح");
                  tablelorddose();
                  clear();
                  lname1.requestFocus();
            }
            
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(this, " -- ");
        }
    }//GEN-LAST:event_save4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autoserial;
    private javax.swing.JLabel autoserial1;
    private javax.swing.JLabel autoserial2;
    private javax.swing.JLabel autoserial3;
    private javax.swing.JLabel autoserial4;
    private javax.swing.JComboBox cmpatient1;
    private javax.swing.JComboBox cmtype;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JLabel date3;
    private javax.swing.JLabel date4;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JButton delete3;
    private javax.swing.JButton delete4;
    private javax.swing.JTextField dname;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lname1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField oname;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField price;
    private javax.swing.JButton save;
    private javax.swing.JButton save1;
    private javax.swing.JButton save2;
    private javax.swing.JButton save3;
    private javax.swing.JButton save4;
    private javax.swing.JLabel serialid;
    private javax.swing.JLabel serialid1;
    private javax.swing.JLabel serialid2;
    private javax.swing.JLabel serialid3;
    private javax.swing.JLabel serialid4;
    private javax.swing.JTable tdetails;
    private javax.swing.JTable tdetails1;
    private javax.swing.JTable tdetails2;
    private javax.swing.JTable tdetails3;
    private javax.swing.JTable tdetails4;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
 public void tablelorddoctorlist()
    {
        try {
            String sqll = "SELECT id,name,type FROM clinic.doctors";
              pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tdetails3.getModel(); 
                model.setRowCount(0);
              int x = 1;
                while (rs.next())
                {
                    Object row[] = {
                       rs.getString("id"),
                       rs.getString("name"),
                       rs.getString("type"),
                       
                      
                        
                        
                                };
                    model.addRow(row);
                    x++;
                    
                }
                if(x>=11)
                {
                }
                else
                {
                for(int z = x ;z<13;z++)
                {
                 Object rowData[] = {
                       "", "", "","","",
                       };
                model.addRow(rowData);
                }
        }
        }
        catch (SQLException ex) {
            
        }
    }
   public void tablelorddruglist()
    {
        try {
            String sqll = "SELECT id,name,type FROM clinic.drugslist";
              pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tdetails.getModel(); 
                model.setRowCount(0);
              int x = 1;
                while (rs.next())
                {
                    Object row[] = {
                       rs.getString("id"),
                       rs.getString("name"),
                       rs.getString("type"),
                       
                      
                        
                        
                                };
                    model.addRow(row);
                    x++;
                    
                }
                if(x>=11)
                {
                }
                else
                {
                for(int z = x ;z<13;z++)
                {
                 Object rowData[] = {
                       "", "", "","","",
                       };
                model.addRow(rowData);
                }
        }
        }
        catch (SQLException ex) {
            
        }
    }
   public void tablelordanalyzeslistlist()
    {
        try {
            String sqll = "SELECT id,name FROM clinic.analyzeslist";
              pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tdetails1.getModel(); 
                model.setRowCount(0);
              int x = 1;
                while (rs.next())
                {
                    Object row[] = {
                       rs.getString("id"),
                       rs.getString("name"),
                       
                      
                        
                        
                                };
                    model.addRow(row);
                    x++;
                    
                }
                if(x>=11)
                {
                }
                else
                {
                for(int z = x ;z<13;z++)
                {
                 Object rowData[] = {
                       "", "", "","","",
                       };
                model.addRow(rowData);
                }
        }
        }
        catch (SQLException ex) {
            
        }
    }
   public void tablelorddose()
    {
        try {
            String sqll = "SELECT id,name FROM clinic.dose";
              pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tdetails4.getModel(); 
                model.setRowCount(0);
              int x = 1;
                while (rs.next())
                {
                    Object row[] = {
                       rs.getString("id"),
                       rs.getString("name"),
                       
                      
                        
                        
                                };
                    model.addRow(row);
                    x++;
                    
                }
                if(x>=11)
                {
                }
                else
                {
                for(int z = x ;z<13;z++)
                {
                 Object rowData[] = {
                       "", "", "","","",
                       };
                model.addRow(rowData);
                }
        }
        }
        catch (SQLException ex) {
            
        }
    }
    public void tablelordoperationlist()
    {
        try {
            String sqll = "SELECT id,price,name FROM clinic.operationslist";
              pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tdetails2.getModel(); 
                model.setRowCount(0);
              int x = 1;
                while (rs.next())
                {
                    Object row[] = {
                       rs.getString("id"),
                       rs.getString("name"),
                       rs.getString("price"),
                       
                      
                        
                        
                                };
                    model.addRow(row);
                    x++;
                    
                }
                if(x>=11)
                {
                }
                else
                {
                for(int z = x ;z<13;z++)
                {
                 Object rowData[] = {
                       "", "", "","","",
                       };
                model.addRow(rowData);
                }
        }
        }
        catch (SQLException ex) {
            
        }
    }
     public void clear()
 {
 name.setText("");  
 serialid.setText("");
 lname.setText(""); 
lname1.setText("");  
 serialid1.setText("");
 oname.setText("");  
 serialid2.setText("");
 serialid3.setText("");
 serialid4.setText("");
 price.setText("0");  
 dname.setText(""); 
 user.setText(""); 
 pass.setText(""); 
 cmtype.setSelectedIndex(0);

 
 }
     public void types()
   {
        try {
             String sql="SELECT name  FROM clinic.doctor_types order by name ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String name = rs.getString("name");
                
                cmtype.addItem(name);
  
             }

         } catch (SQLException ex) {
             
         }
   }
     private void setEnableRec(Component container, boolean enable){
    container.setEnabled(enable);

    try {
        Component[] components= ((Container) container).getComponents();
        for (int i = 0; i < components.length; i++) {
            setEnableRec(components[i], enable);
        }
    } catch (ClassCastException e) {

    }
}
     public void dose()
   {
        try {
             String sql="SELECT name  FROM clinic.dose ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmpatient1.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }   
       
}
