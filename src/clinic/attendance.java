/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.awt.ComponentOrientation;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
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
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author amnassar
 */
public final class attendance extends javax.swing.JInternalFrame {

    /**
     * Creates new form book
     */
       Connection con ;
    PreparedStatement pst ;
    ResultSet rs;
     public String y ;
        int day;
   int month;
   public String datee;
   public String check;
    String dayyy ;
    int year;
    String fulldatee;
    int numbernotpaid;
    
   
    public attendance() {
        initComponents();
        con=DBConnect.connect();
         doctors();
        ButtonGroup G = new ButtonGroup();
        G.add(rconsu);
        G.add(rcheck);
        ButtonGroup G1 = new ButtonGroup();
        G1.add(rconsu1);
        G1.add(rcheck1);
        ButtonGroup G11 = new ButtonGroup();
        G11.add(rconsu2);
        G11.add(rcheck2);
        rcheck1.setSelected(true);
       TableCellRenderer rendererFromHeader = tdetails.getTableHeader().getDefaultRenderer();
JLabel headerLabel = (JLabel) rendererFromHeader;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tdetails.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
          /*cmdoctor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
          cmdoctor1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
          cmpatient.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
          cmpatient1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
          cmday.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
          cmpatient2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);*/
          next.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
         Calendar cal = new GregorianCalendar();
             AutoCompleteDecorator.decorate(cmpatient);
                int month=cal.get(Calendar.MONTH)+1;
             int year = cal.get(Calendar.YEAR);
                 int dayy =cal.get(Calendar.DAY_OF_MONTH);
             dayyy=String.valueOf(dayy);
 if(dayy == 1 || dayy == 2 || dayy == 3 || dayy == 4
         || dayy == 5 || dayy == 6 || dayy == 7 || dayy == 8 || dayy == 9 )
 {
      dayyy=String.valueOf(dayy);
     dayyy="0"+dayyy;
 }
 AutoCompleteDecorator.decorate(cmpatient);
 AutoCompleteDecorator.decorate(cmpatient2);
        date1.setText(year+"-"+month+"-"+dayyy);
           datee=date1.getText().toString();
           System.out.print(datee);
            TimeZone tz = TimeZone.getTimeZone("GMT+02");
             Calendar c = Calendar.getInstance(tz);
             String time = String.format("%02d" , c.get(Calendar.HOUR_OF_DAY))+":"+
                     String.format("%02d" , c.get(Calendar.MINUTE));
              fulldatee=datee+" "+time;
            ((JTextField)cmday.getDateEditor().getUiComponent()).setText(datee); 
        clear();
        
       
        cmdoctorr();
          getpatientnumber();
          cmday.getDateEditor().addPropertyChangeListener(new java.beans.PropertyChangeListener(){
    public void propertyChange(java.beans.PropertyChangeEvent evt){
        
    }
});
 
       
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        price1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        rconsu2 = new javax.swing.JRadioButton();
        rcheck2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        next = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nextnumber = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmpatient2 = new javax.swing.JComboBox();
        cmpatient = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        add2 = new javax.swing.JButton();
        rconsu = new javax.swing.JRadioButton();
        rcheck = new javax.swing.JRadioButton();
        cmdoctor = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdetails = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        serialid = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        maxnumber = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pnumber = new javax.swing.JTextField();
        cmday = new com.toedter.calendar.JDateChooser();
        rconsu1 = new javax.swing.JRadioButton();
        rcheck1 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        add3 = new javax.swing.JButton();
        cmpatient1 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        cmdoctor1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        serialid1 = new javax.swing.JLabel();
        date2 = new javax.swing.JLabel();
        maxnumber1 = new javax.swing.JLabel();
        date3 = new javax.swing.JLabel();

        jLabel16.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/71847608-close-up-of-handshake-on-city-background-with-abstract-sunlight-partnership-concept-double-exposure.jpg"))); // NOI18N

        setMaximumSize(new java.awt.Dimension(980, 690));
        setMinimumSize(new java.awt.Dimension(980, 690));
        setPreferredSize(new java.awt.Dimension(980, 690));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel10.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        price1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        price1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                price1ActionPerformed(evt);
            }
        });
        price1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                price1KeyReleased(evt);
            }
        });
        jPanel10.add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 60, 30));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setText("المدفوع");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 60, 30));

        rconsu2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        rconsu2.setText("استشارة");
        jPanel10.add(rconsu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 70, 30));

        rcheck2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        rcheck2.setText("كشف");
        jPanel10.add(rcheck2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("اسم المريض (بالحضور)");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 150, 30));

        add1.setBackground(new java.awt.Color(138, 203, 195));
        add1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        add1.setText("دخول");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel10.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 140, 40));

        add.setBackground(new java.awt.Color(138, 203, 195));
        add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add.setText("تسجيل (بالحضور)");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel10.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 130, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setText("المريض التالي");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 150, 40));

        next.setEditable(false);
        next.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        next.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 270, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("المدفوع");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 60, 30));

        price.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceKeyReleased(evt);
            }
        });
        jPanel10.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 60, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("رقم المريض");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, 30));

        nextnumber.setEditable(false);
        nextnumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nextnumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(nextnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setText("اسم المريض (بالحجز)");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 140, 30));

        cmpatient2.setEditable(true);
        cmpatient2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cmpatient2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmpatient2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmpatient2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmpatient2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmpatient2MouseReleased(evt);
            }
        });
        cmpatient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpatient2ActionPerformed(evt);
            }
        });
        jPanel10.add(cmpatient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 150, 30));

        cmpatient.setEditable(true);
        cmpatient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cmpatient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmpatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmpatientMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmpatientMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmpatientMouseReleased(evt);
            }
        });
        cmpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpatientActionPerformed(evt);
            }
        });
        jPanel10.add(cmpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 150, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel11.setText("اسم الطبيب");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 120, 30));

        add2.setBackground(new java.awt.Color(138, 203, 195));
        add2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add2.setText("تسجيل (بالحجز)");
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });
        jPanel10.add(add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 130, 30));

        rconsu.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        rconsu.setText("استشارة");
        jPanel10.add(rconsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 70, 30));

        rcheck.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        rcheck.setText("كشف");
        jPanel10.add(rcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, 30));

        cmdoctor.setEditable(true);
        cmdoctor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cmdoctor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cmdoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmdoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmdoctorMouseReleased(evt);
            }
        });
        cmdoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdoctorActionPerformed(evt);
            }
        });
        jPanel10.add(cmdoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 220, 30));

        tdetails.setBackground(new java.awt.Color(138, 203, 195));
        tdetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "اسم المريض", "اسم الطبيب", "رقم الدخول", "المدفوع", "التاريخ"
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

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 920, 230));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid.setText("jLabel1");
        jPanel10.add(serialid, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date.setText("jLabel1");
        jPanel10.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        maxnumber.setText("jLabel1");
        maxnumber.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(maxnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 80, 30));

        date1.setText("jLabel1");
        jPanel10.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, -1, -1));

        jTabbedPane1.addTab("نسجيل الحضور و الدفع", jPanel10);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel11.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel11.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("رقم المريض القادم");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, 30));

        pnumber.setEditable(false);
        pnumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pnumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(pnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 70, 30));

        cmday.setDateFormatString("yyyy-M-dd");
        cmday.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdayMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmdayMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmdayMouseReleased(evt);
            }
        });
        jPanel11.add(cmday, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 200, 30));

        rconsu1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        rconsu1.setText("استشارة");
        jPanel11.add(rconsu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, -1, 30));

        rcheck1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        rcheck1.setText("كشف");
        jPanel11.add(rcheck1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel14.setText("التاريخ");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 100, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("اسم المريض");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 120, 30));

        add3.setBackground(new java.awt.Color(138, 203, 195));
        add3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        add3.setText("تسجيل");
        add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add3ActionPerformed(evt);
            }
        });
        jPanel11.add(add3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 100, 50));

        cmpatient1.setEditable(true);
        cmpatient1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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
        cmpatient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpatient1ActionPerformed(evt);
            }
        });
        jPanel11.add(cmpatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 200, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel18.setText("اسم الطبيب");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 150, 30));

        cmdoctor1.setEditable(true);
        cmdoctor1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cmdoctor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmdoctor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmdoctor1MouseReleased(evt);
            }
        });
        cmdoctor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdoctor1ActionPerformed(evt);
            }
        });
        jPanel11.add(cmdoctor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 200, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel11.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid1.setText("jLabel1");
        jPanel11.add(serialid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date2.setText("jLabel1");
        jPanel11.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        maxnumber1.setText("jLabel1");
        maxnumber1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel11.add(maxnumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 80, 30));

        date3.setText("jLabel1");
        jPanel11.add(date3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, -1, -1));

        jTabbedPane1.addTab("الحجز", jPanel11);

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

        jTabbedPane1.getAccessibleContext().setAccessibleName("الحج");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        try {
            String sql1 = "UPDATE clinic.attendance SET mark='Yes',enterfulldate='"+fulldatee+"' WHERE id='"+serialid.getText()+"' and name = '"+next.getText()+"' and date = '"+datee+"'";
            pst=(PreparedStatement) con.prepareStatement(sql1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "تم تسجيل دخول المريض للطبيب");
            tablelord(cmdoctor.getSelectedItem().toString());
            number(cmdoctor.getSelectedItem().toString());
            maxnumber(cmdoctor.getSelectedItem().toString());
            clear();
            
        } catch (SQLException ex) {
            Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       if(!cmpatient.getSelectedItem().toString().trim().isEmpty() || !price.getText().trim().isEmpty())
               {
                   try
        {
            String check =null;
            if(rcheck.isSelected())
            {
                check="check";
            }
            else
            {
                check="consultation";
            }
            int maxnumberr = Integer.parseInt(maxnumber.getText())+1;
            int pricee = Integer.parseInt(price.getText());
            String namee = cmpatient.getSelectedItem().toString();
            String doctor=cmdoctor.getSelectedItem().toString();
            String sqll = "SELECT * FROM clinic.attendance where name='"+namee+"' and date = '"+datee+"' and doctor ='"+doctor+"'";
            pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            if (rs.next())
            {
                JOptionPane.showMessageDialog(rootPane, "تم التسجيل من قبل");
            }
            else
            {
                String sql = "INSERT INTO clinic.attendance (name,number,doctor,fulldate,date,amount,mark,paid,checkk) VALUES"
                + " ('"+namee+"','"+maxnumberr+"','"+doctor+"','"+fulldatee+"','"+datee+"','"+pricee+"','No','Yes','"+check+"')";
                pst = (PreparedStatement)con.prepareStatement(sql);
                pst.execute();
                String sql1 = "INSERT INTO clinic.logs (name,type,fulldate,date,amount) VALUES"
                + " ('"+namee+"','"+check+"','"+fulldatee+"','"+datee+"','"+pricee+"')";
                pst = (PreparedStatement)con.prepareStatement(sql1);
                pst.execute();
                tablelord(cmdoctor.getSelectedItem().toString());
                number(cmdoctor.getSelectedItem().toString());                
                maxnumber(cmdoctor.getSelectedItem().toString());
                JOptionPane.showMessageDialog(rootPane, "تم التسجيل بنجاح ورقم المريض  : "+maxnumberr);
                cmpatient.setSelectedItem(" ");
                System.out.print(namee);
                cmpatient.removeItem(namee);
            }
        }
        catch(Exception ex)
        {
                 JOptionPane.showMessageDialog(rootPane, ex);
        }
               }
       else
       {
           JOptionPane.showMessageDialog(rootPane, "من فضلك اكمل البيانات");
       }
    }//GEN-LAST:event_addActionPerformed

    private void cmpatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatientMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatientMouseEntered

    private void cmpatientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatientMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatientMousePressed

    private void cmpatientMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatientMouseReleased

    }//GEN-LAST:event_cmpatientMouseReleased

    private void cmdoctorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdoctorMouseReleased
        
    }//GEN-LAST:event_cmdoctorMouseReleased

    private void tdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseClicked
        DefaultTableModel tmodel =(DefaultTableModel)tdetails.getModel();
        //bid,name, price, publisher, book_type, b_code, date, category
        int selectrowindex=tdetails.getSelectedRow();
        serialid.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        next.setText(tmodel.getValueAt(selectrowindex, 1).toString());

    }//GEN-LAST:event_tdetailsMouseClicked

    private void add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add3ActionPerformed

        if(cmpatient1.getSelectedItem().toString().trim().isEmpty() || cmdoctor1.getSelectedItem().toString().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر الطبيب و المريض");
        }
        else
        {
        String cmdayy=((JTextField)cmday.getDateEditor().getUiComponent()).getText();
        TimeZone tz = TimeZone.getTimeZone("GMT+02");
             Calendar c = Calendar.getInstance(tz);
             String time = String.format("%02d" , c.get(Calendar.HOUR_OF_DAY))+":"+
                     String.format("%02d" , c.get(Calendar.MINUTE));
              fulldatee=cmdayy+" "+time;
       
        try
        {
            String check =null;
            if(rconsu1.isSelected())
            {
                check="consultation";
            }
            else
            {
                check="check";
            }
            int maxnumberr = Integer.parseInt(pnumber.getText());
            String namee = cmpatient1.getSelectedItem().toString();
            String doctor=cmdoctor1.getSelectedItem().toString();
            String sqll = "SELECT * FROM clinic.attendance where name='"+namee+"' and doctor ='"+doctor+"' and date = '"+cmdayy+"'";
            pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            if (rs.next())
            {
                JOptionPane.showMessageDialog(rootPane, "تم الحجز للمريض من قبل");
            }
            else
            {
                String sql = "INSERT INTO clinic.attendance (name,number,doctor,fulldate,date,amount,mark,paid,checkk) VALUES"
                + " ('"+namee+"','"+maxnumberr+"','"+doctor+"','"+fulldatee+"','"+cmdayy+"','0','No','No','"+check+"')";
                pst = (PreparedStatement)con.prepareStatement(sql);
                pst.execute();
               tablelord(cmdoctor.getSelectedItem().toString());
                number(cmdoctor.getSelectedItem().toString());
                maxnumber(cmdoctor.getSelectedItem().toString());
                cmpatient2.setSelectedIndex(0);
                JOptionPane.showMessageDialog(rootPane, "تم التسجيل بنجاح ورقم المريض   : "+maxnumberr);
                cmpatient1.removeItem(namee);
                pnumber();
                if(doctor.equals(cmdoctor.getSelectedItem().toString()))
                {
                    cmpatient2.addItem(namee);
                    pnumber();
                    cmpatient1.setSelectedIndex(0);
                }
            }
        }
        catch(Exception ex)
        {

        }
        }
    }//GEN-LAST:event_add3ActionPerformed

    private void cmpatient1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MouseEntered

    private void cmpatient1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MousePressed

    private void cmpatient1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MouseReleased

    private void cmdoctor1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdoctor1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdoctor1MouseReleased

    private void cmdayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdayMouseReleased
        
    }//GEN-LAST:event_cmdayMouseReleased

    private void cmdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdayMouseClicked
       
    }//GEN-LAST:event_cmdayMouseClicked

    private void cmdayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdayMousePressed
         
    }//GEN-LAST:event_cmdayMousePressed

    private void cmdayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdayMouseEntered
     
    }//GEN-LAST:event_cmdayMouseEntered

    private void cmpatient2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient2MouseEntered

    private void cmpatient2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient2MousePressed

    private void cmpatient2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient2MouseReleased

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
         String number;
        try{                                     
           String sql="SELECT *  FROM clinic.attendance where name ='"+cmpatient2.getSelectedItem().toString()+"' "
                    + "and date='"+datee+"' and doctor='"+cmdoctor.getSelectedItem().toString()+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                check=rs.getString("checkk");
                number=rs.getString("number");
            }
            try{
                int pricee = Integer.parseInt(price1.getText());
                String patientt = cmpatient2.getSelectedItem().toString();
                if(!patientt.trim().isEmpty())
                {
                    
                    try {
                        String sql1 = "UPDATE clinic.attendance SET paid='Yes',amount='"+pricee+"'"
                                + "WHERE  date = '"+datee+"' and doctor='"+cmdoctor.getSelectedItem().toString()+"' and name = '"+patientt+"'";
                        pst=(PreparedStatement) con.prepareStatement(sql1);
                        pst.executeUpdate();
                        String sql11 = "INSERT INTO clinic.logs (name,type,fulldate,date,amount) VALUES"
                                + " ('"+patientt+"','"+check+"','"+fulldatee+"','"+datee+"','"+pricee+"')";
                        pst = (PreparedStatement)con.prepareStatement(sql11);
                        pst.execute();
                        JOptionPane.showMessageDialog(rootPane, "تم تاكيد الحجز بالدفع ");
                        price1.setText("");
                        cmpatient2.removeItem(patientt);
                           number(cmdoctor.getSelectedItem().toString());
                           tablelord(cmdoctor.getSelectedItem().toString());
                           maxnumber(cmdoctor.getSelectedItem().toString());
                    } catch (SQLException ex) {
                        Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
                    }}
                else
                {
                    JOptionPane.showMessageDialog(rootPane, "من فضلك اختر المريض المراد تسجيلة");
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, "المبلغ المدفوع غير صحيح");
            }
        }
        catch(SQLException ex)
        {
               Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null,ex);
        }
    }//GEN-LAST:event_add2ActionPerformed

    private void cmpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpatientActionPerformed
/*        Object obj = evt.getSource();
       if(obj==cmpatient)
       {
            try {
                String sql="SELECT *  FROM clinic.documents where name='"+cmpatient.getSelectedItem().toString()+"' order by id DESC";
                pst=(PreparedStatement) con.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                    if(rs.getString("nextvisittype").equals("consultation")){
                    rconsu.setSelected(true);
                    }
                    else
                    {
                        rcheck.setSelected(true);
                    }
                }
                else
                {
                        rcheck.setSelected(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
            }
            price.requestFocus();
       
       }*/
    }//GEN-LAST:event_cmpatientActionPerformed

    private void price1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_price1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price1ActionPerformed

    private void cmpatient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpatient2ActionPerformed
/*        Object obj = evt.getSource();
       if(obj==cmpatient2)
       {
            try {
                String sql="SELECT *  FROM clinic.attendance where name='"+cmpatient2.getSelectedItem().toString()+"' order by id DESC";
                pst=(PreparedStatement) con.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                    if(rs.getString("checkk").equals("consultation")){
                    rconsu2.setSelected(true);
                    }
                    else
                    {
                        rcheck2.setSelected(true);
                    }
                }
                else
                {
                        rcheck.setSelected(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
            }
              price1.requestFocus();
       }*/
    }//GEN-LAST:event_cmpatient2ActionPerformed

    private void cmdoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdoctorActionPerformed
          Object obj = evt.getSource();
       if(obj==cmdoctor)
       {   
            try {
                  String sqll="SELECT name  FROM clinic.patient ";
                  
                  pst=(PreparedStatement) con.prepareStatement(sqll);
                  
                  rs=pst.executeQuery();
                  
                  while(rs.next()){
                      
                      String name = rs.getString("name");
                      
                      cmpatient.removeItem(name);
                      
                      
                  }
                } catch (SQLException ex) {
                  Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
              }
           patientss();
              try {
                  String sqll="SELECT name  FROM clinic.attendance where  paid='No'";
                  
                  pst=(PreparedStatement) con.prepareStatement(sqll);
                  
                  rs=pst.executeQuery();
                  
                  while(rs.next()){
                      
                      String name = rs.getString("name");
                      
                      cmpatient2.removeItem(name);
                      
                      
                  }
                  bookedpatientss(cmdoctor.getSelectedItem().toString());
              } catch (SQLException ex) {
                  Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
              }
                  }
    }//GEN-LAST:event_cmdoctorActionPerformed

    private void cmpatient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpatient1ActionPerformed
         Object obj = evt.getSource();
       if(obj==cmpatient1)
       {
            try {
                String sql="SELECT *  FROM clinic.documents where doctor_name='"+cmdoctor1.getSelectedItem().toString()+"' and name='"+cmpatient1.getSelectedItem().toString()+"' order by id DESC";
                pst=(PreparedStatement) con.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                    if(rs.getString("nextvisittype").equals("consultation")){
                    rconsu1.setSelected(true);
                    }
                    else
                    {
                        rcheck1.setSelected(true);
                    }
                }
                else
                {
                        rcheck1.setSelected(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       }
    }//GEN-LAST:event_cmpatient1ActionPerformed

    private void cmdoctor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdoctor1ActionPerformed
         Object obj = evt.getSource();
       if(obj==cmdoctor1)
       { 
            try {
                  String sqll="SELECT name  FROM clinic.patient ";
                  
                  pst=(PreparedStatement) con.prepareStatement(sqll);
                  
                  rs=pst.executeQuery();
                  
                  while(rs.next()){
                      
                      String name = rs.getString("name");
                      
                      cmpatient1.removeItem(name);
                      
                      
                  }
                  } catch (SQLException ex) {
                  Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
              }
           patientssx(cmdoctor1.getSelectedItem().toString());
           pnumber();
       }
    }//GEN-LAST:event_cmdoctor1ActionPerformed

    private void priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyReleased
       
    }//GEN-LAST:event_priceKeyReleased

    private void price1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_price1KeyReleased
        
    }//GEN-LAST:event_price1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JButton add3;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser cmday;
    private javax.swing.JComboBox cmdoctor;
    private javax.swing.JComboBox cmdoctor1;
    private javax.swing.JComboBox cmpatient;
    private javax.swing.JComboBox cmpatient1;
    private javax.swing.JComboBox cmpatient2;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JLabel date3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel maxnumber;
    private javax.swing.JLabel maxnumber1;
    private javax.swing.JTextField next;
    private javax.swing.JTextField nextnumber;
    private javax.swing.JTextField pnumber;
    private javax.swing.JTextField price;
    private javax.swing.JTextField price1;
    private javax.swing.JRadioButton rcheck;
    private javax.swing.JRadioButton rcheck1;
    private javax.swing.JRadioButton rcheck2;
    private javax.swing.JRadioButton rconsu;
    private javax.swing.JRadioButton rconsu1;
    private javax.swing.JRadioButton rconsu2;
    private javax.swing.JLabel serialid;
    private javax.swing.JLabel serialid1;
    private javax.swing.JTable tdetails;
    // End of variables declaration//GEN-END:variables

   public void tablelord(String xdoctor )
    {
        try {
            String sqll = "SELECT * FROM clinic.attendance where mark='No' and paid='Yes' and date='"+datee+"' and doctor='"+xdoctor+"'";
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
                       rs.getString("doctor"),
                       rs.getString("number"),
                       rs.getString("amount"),
                       rs.getString("fulldate")
                       
                      
                        
                        
                                };
                    model.addRow(row);
                    x++;
                    
                }
                if(x>=16)
                {
                }
                else
                {
                for(int z = x ;z<16;z++)
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
         price.setText("");
    }
    
     public void doctors()
   {
        try {
             String sql="SELECT name  FROM clinic.doctors order by id";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmdoctor.addItem(namee);
                cmdoctor1.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }
public void patientss()
   {
        try {
             String sql="SELECT name  FROM clinic.patient where name NOT IN "
                     + "(select name from clinic.attendance where paid='No' and date ='"+datee+"' "
                     + "and doctor='"+cmdoctor.getSelectedItem().toString()+"')and name not in "
                     + "(select name from clinic.attendance where date ='"+datee+"' and doctor='"+cmdoctor.getSelectedItem().toString()+"')";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmpatient.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }
public void patientssx(String doctor)
   {
       try {
            String cmdayy=((JTextField)cmday.getDateEditor().getUiComponent()).getText();
             String sql="SELECT name  FROM clinic.patient where name NOT IN "
                     + "(select name from clinic.attendance where date = '"+cmdayy+"' and doctor = '"+doctor+"')";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                cmpatient1.addItem(namee);
                     }

         } catch (SQLException ex) {
             
         }
   }
     
     public void number(String xdoctor)
   {
        try {
             String sql="SELECT * FROM clinic.attendance where date='"+datee+"' and mark ='No' and paid='Yes' and doctor='"+xdoctor+"' order by id ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                nextnumber.setText(rs.getString("number"));
                next.setText(rs.getString("name"));
                serialid.setText(rs.getString("id"));
                 }
             else
             {
                 nextnumber.setText("0");
             }

         } catch (SQLException ex) {
             
         }
   }
     public void maxnumber(String xdoctor)
   {
        try {
             String sql="SELECT * FROM clinic.attendance where date='"+datee+"' and doctor='"+xdoctor+"'  order by id DESC";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                maxnumber.setText(rs.getString("number"));
                 }
              else
             {
                 maxnumber.setText("0");
                
             }

         } catch (SQLException ex) {
             
         }
   }
     public void pnumber()
   {
       
       String cmdayy=((JTextField)cmday.getDateEditor().getUiComponent()).getText();
        try {
             
             String sql="SELECT number FROM clinic.attendance where date='"+cmdayy+"' and doctor='"+cmdoctor1.getSelectedItem().toString()+"'  order by id DESC";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 numbernotpaid = Integer.parseInt(rs.getString("number"))+1;
                 pnumber.setText(Integer.toString(numbernotpaid));
                 }
              else
             {
                 pnumber.setText("1");
                
             }

         } catch (SQLException ex) {
             
         }
   }
     public void bookedpatientss(String xdoctor)
   {
        try {
             String sql="SELECT name  FROM clinic.attendance where  doctor='"+xdoctor+"' and date='"+datee+"' and paid='No' ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmpatient2.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }
     public void cmdoctorr()
      {
        
          serialid.setText("");
                   cmdoctor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                JComboBox cmsupplier = (JComboBox) event.getSource();

                Object item = event.getItem();
                     try {
             String sql="SELECT *  FROM clinic.doctors where name ='"+cmdoctor.getSelectedItem().toString()+"'";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 
                  number(cmdoctor.getSelectedItem().toString());
                tablelord(cmdoctor.getSelectedItem().toString());
          maxnumber(cmdoctor.getSelectedItem().toString());
          
                }
             } catch (SQLException ex) {
             
         } }
        });
       
      }
     
      public void getpatientnumber()
      {
        
                   cmdoctor1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                JComboBox cmsupplier = (JComboBox) event.getSource();

                Object item = event.getItem();
                     try {
             String sql="SELECT *  FROM clinic.doctors where name ='"+cmdoctor1.getSelectedItem().toString()+"'";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 pnumber();
                }
             } catch (SQLException ex) {
             
         } }
        });
       
      }
}
