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
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author amnassar
 */
public final class document extends javax.swing.JInternalFrame {

    /**
     * Creates new form book
     */
       Connection con ;
    PreparedStatement pst ;
    ResultSet rs;
     public String y ;
     String curr=null;
     String end=null;
    int day;
   int month;
   public String datee;
    String dayyy ;
    int year;
    String fulldatee;
    String nexttypee;
    String doctorname;
    String smokerr , pressurre,sugarr;
    public document(String x) {
        initComponents();
        con=DBConnect.connect();
     Calendar cal = new GregorianCalendar();
             doctorname=x;
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
 date1.setText(year+"-"+month+"-"+dayyy);
           datee=date1.getText().toString();
    TableCellRenderer rendererFromHeader = tdetails.getTableHeader().getDefaultRenderer();
JLabel headerLabel = (JLabel) rendererFromHeader;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tdetails.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
         dose();
         TableCellRenderer rendererFromHeader1 = tdetails1.getTableHeader().getDefaultRenderer();
JLabel headerLabel1 = (JLabel) rendererFromHeader1;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
        centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
        tdetails1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer1 );
         tdetails1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer1 );
         tdetails1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer1 );
      
         
            TableCellRenderer rendererFromHeader3 = tdetails3.getTableHeader().getDefaultRenderer();
JLabel headerLabel13 = (JLabel) rendererFromHeader3;
headerLabel13.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer3 = new DefaultTableCellRenderer();
        centerRenderer3.setHorizontalAlignment( JLabel.CENTER );
        tdetails3.getColumnModel().getColumn(0).setCellRenderer( centerRenderer3 );
         tdetails3.getColumnModel().getColumn(1).setCellRenderer( centerRenderer3 );
         tdetails3.getColumnModel().getColumn(2).setCellRenderer( centerRenderer3 );
         tdetails3.getColumnModel().getColumn(3).setCellRenderer( centerRenderer3 );
         
         
           TableCellRenderer rendererFromHeader12 = tdetails2.getTableHeader().getDefaultRenderer();
JLabel headerLabel12 = (JLabel) rendererFromHeader12;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer12 = new DefaultTableCellRenderer();
        centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
        tdetails2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer12 );
         tdetails2.getColumnModel().getColumn(1).setCellRenderer( centerRenderer12);
         tdetails2.getColumnModel().getColumn(2).setCellRenderer( centerRenderer12 );
         tdetails2.getColumnModel().getColumn(3).setCellRenderer( centerRenderer12 );
         
         
         date1.setText(year+"-"+month+"-"+dayyy);
           datee=date1.getText().toString();
             TimeZone tz = TimeZone.getTimeZone("GMT+02");
             Calendar c = Calendar.getInstance(tz);
             String time = String.format("%02d" , c.get(Calendar.HOUR_OF_DAY))+":"+
                     String.format("%02d" , c.get(Calendar.MINUTE));
              fulldatee=datee+" "+time;
        doctors();
        cmdoctor.setSelectedItem("doctorname");
       // clear();
        patientss();
        Document_serial();
         Medicines();
         analyz();
         operations();
         comboxfromcombo2();
          
      AutoCompleteDecorator.decorate(cmdoctor);
      AutoCompleteDecorator.decorate(cmpatient1);
      AutoCompleteDecorator.decorate(cmpatient);
      AutoCompleteDecorator.decorate(cmMedicines);
      pphone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      dob.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      pserial.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      comment.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);   
      name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      serial1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      serial2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
       
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
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        done2 = new javax.swing.JButton();
        nextdaytype = new javax.swing.JCheckBox();
        done1 = new javax.swing.JButton();
        weight = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cmpatient = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sugar = new javax.swing.JCheckBox();
        txtpressure = new javax.swing.JTextField();
        txtsugar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pressure = new javax.swing.JCheckBox();
        smoker = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        comment = new javax.swing.JTextArea();
        dob = new javax.swing.JTextField();
        serial = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nextdaydata = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        done4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nextday = new javax.swing.JTextField();
        done3 = new javax.swing.JButton();
        save1 = new javax.swing.JButton();
        cancle1 = new javax.swing.JButton();
        pphone = new javax.swing.JTextField();
        pserial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        done = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        serialid = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmdoctor = new javax.swing.JComboBox();
        date = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdetails = new javax.swing.JTable();
        cmpatient1 = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        number = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        cmMedicines = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        date2 = new javax.swing.JLabel();
        aid1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        oid1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        oprice = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cmoperations = new javax.swing.JComboBox();
        add2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tdetails2 = new javax.swing.JTable();
        delete2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        cmAnalyze = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        tdetails1 = new javax.swing.JTable();
        delete1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        aid = new javax.swing.JLabel();
        oid = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdetails3 = new javax.swing.JTable();
        total = new javax.swing.JTextField();
        serial3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        serial2 = new javax.swing.JTextField();
        number1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        available = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        delete3 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        serial1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        save2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        serialid1 = new javax.swing.JLabel();
        date3 = new javax.swing.JLabel();
        number2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();

        jLabel16.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/71847608-close-up-of-handshake-on-city-background-with-abstract-sunlight-partnership-concept-double-exposure.jpg"))); // NOI18N

        setMaximumSize(new java.awt.Dimension(980, 690));
        setMinimumSize(new java.awt.Dimension(980, 690));
        setPreferredSize(new java.awt.Dimension(980, 690));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel10.setPreferredSize(new java.awt.Dimension(964, 690));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        done2.setBackground(new java.awt.Color(138, 203, 195));
        done2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        done2.setText("التشخيصات السابقة");
        done2.setEnabled(false);
        done2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done2ActionPerformed(evt);
            }
        });
        jPanel10.add(done2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, 30));

        nextdaytype.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nextdaytype.setText("كشف ؟");
        jPanel10.add(nextdaytype, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 90, 30));

        done1.setBackground(new java.awt.Color(138, 203, 195));
        done1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        done1.setText("التاريخ المرضي");
        done1.setEnabled(false);
        done1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done1ActionPerformed(evt);
            }
        });
        jPanel10.add(done1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, 30));

        weight.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        weight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 60, 30));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel22.setText("الوزن");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 240, 50, 30));

        cmpatient.setEditable(true);
        cmpatient.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cmpatient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmpatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmpatientMouseClicked(evt);
            }
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
        cmpatient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmpatientKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmpatientKeyReleased(evt);
            }
        });
        jPanel10.add(cmpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 180, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel14.setText("الضغط ؟");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 70, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel15.setText("مدخن ؟");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 60, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel12.setText("تاريخ الميلاد");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, 100, 30));

        sugar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sugar.setText("نعم ؟");
        sugar.setEnabled(false);
        jPanel10.add(sugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 50, 30));

        txtpressure.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtpressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpressure.setText("/");
        jPanel10.add(txtpressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 70, 30));

        txtsugar.setEditable(false);
        txtsugar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtsugar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsugarActionPerformed(evt);
            }
        });
        jPanel10.add(txtsugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 60, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel13.setText("السكري ؟");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 80, 30));

        pressure.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pressure.setText("نعم ؟");
        pressure.setEnabled(false);
        pressure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressureActionPerformed(evt);
            }
        });
        jPanel10.add(pressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 50, 30));

        smoker.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        smoker.setText("نعم ؟");
        smoker.setEnabled(false);
        jPanel10.add(smoker, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 50, 30));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel23.setText("التشخيص");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, 90, 30));

        comment.setColumns(20);
        comment.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        comment.setRows(5);
        jScrollPane4.setViewportView(comment);

        jPanel10.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 370, 70));

        dob.setEditable(false);
        dob.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 180, 30));

        serial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        serial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        serial.setText("jLabel1");
        jPanel10.add(serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 50));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel8.setText("اسم المريض");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 100, 30));

        nextdaydata.setDateFormatString("yyyy-MM-dd");
        nextdaydata.setEnabled(false);
        nextdaydata.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel10.add(nextdaydata, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 190, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel17.setText("الزيارة القادمة");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 100, 30));

        done4.setBackground(new java.awt.Color(138, 203, 195));
        done4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        done4.setText("التحاليل السابقة");
        done4.setEnabled(false);
        done4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done4ActionPerformed(evt);
            }
        });
        jPanel10.add(done4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel10.setText("رقم الهاتف");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 80, 30));

        nextday.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nextday.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nextday.setText("0");
        nextday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nextdayMouseReleased(evt);
            }
        });
        nextday.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nextdayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nextdayKeyTyped(evt);
            }
        });
        jPanel10.add(nextday, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 60, 30));

        done3.setBackground(new java.awt.Color(138, 203, 195));
        done3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        done3.setText("نتائج التحاليل");
        done3.setEnabled(false);
        done3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done3ActionPerformed(evt);
            }
        });
        jPanel10.add(done3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 120, 30));

        save1.setBackground(new java.awt.Color(138, 203, 195));
        save1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        save1.setText("حفظ و طباعة");
        save1.setEnabled(false);
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });
        jPanel10.add(save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 170, 40));

        cancle1.setBackground(new java.awt.Color(138, 203, 195));
        cancle1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        cancle1.setText("مسح الروشتة");
        cancle1.setEnabled(false);
        cancle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancle1ActionPerformed(evt);
            }
        });
        jPanel10.add(cancle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 170, 40));

        pphone.setEditable(false);
        pphone.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pphone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(pphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 180, 30));

        pserial.setEditable(false);
        pserial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pserial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(pserial, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 120, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel9.setText("كود المريض");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 90, 30));

        done.setBackground(new java.awt.Color(138, 203, 195));
        done.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        done.setText("اضافة ادوية و تحاليل");
        done.setEnabled(false);
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        jPanel10.add(done, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 190, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 690));

        serialid.setText("jLabel1");
        jPanel10.add(serialid, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Doctor Name");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 120, -1));

        cmdoctor.setEditable(true);
        cmdoctor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cmdoctor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmdoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmdoctorMouseReleased(evt);
            }
        });
        jPanel10.add(cmdoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 650, 230, 30));

        date.setText("jLabel1");
        jPanel10.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jTabbedPane1.addTab("التشخيص", jPanel10);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel12.setName("Medicines "); // NOI18N
        jPanel12.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails.setBackground(new java.awt.Color(138, 203, 195));
        tdetails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "اسم الدواء", "عدد العلب", "الجرعة"
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
        jScrollPane2.setViewportView(tdetails);
        if (tdetails.getColumnModel().getColumnCount() > 0) {
            tdetails.getColumnModel().getColumn(0).setMinWidth(1);
            tdetails.getColumnModel().getColumn(0).setPreferredWidth(1);
            tdetails.getColumnModel().getColumn(0).setMaxWidth(1);
            tdetails.getColumnModel().getColumn(2).setMinWidth(100);
            tdetails.getColumnModel().getColumn(2).setPreferredWidth(100);
            tdetails.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 650, 200));

        cmpatient1.setEditable(true);
        cmpatient1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cmpatient1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
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
        jPanel12.add(cmpatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 250, 30));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel27.setText("الجرعة");
        jPanel12.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 90, 30));

        add.setBackground(new java.awt.Color(138, 203, 195));
        add.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add.setText("اضافة");
        add.setEnabled(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel12.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 90, 40));

        number.setEditable(false);
        number.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        number.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number.setText("1");
        jPanel12.add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 60, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel20.setText("اسم الدواء");
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 110, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel18.setText("عدد العلب");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 80, 30));

        delete.setBackground(new java.awt.Color(138, 203, 195));
        delete.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        delete.setText("مسح الدواء");
        delete.setEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel12.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 170, 40));

        cmMedicines.setEditable(true);
        cmMedicines.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cmMedicines.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmMedicines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmMedicinesMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmMedicinesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmMedicinesMouseReleased(evt);
            }
        });
        cmMedicines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmMedicinesActionPerformed(evt);
            }
        });
        jPanel12.add(cmMedicines, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 370, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel12.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 660));

        date2.setText("jLabel1");
        jPanel12.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        aid1.setText("jLabel1");
        jPanel12.add(aid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 320));

        oid1.setText("jLabel1");
        jPanel12.add(oid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, -1, -1));

        jTabbedPane1.addTab("الادوية الطبية", jPanel12);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel11.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        oprice.setEditable(false);
        oprice.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        oprice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel11.add(oprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 60, 30));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setText("اسم العملية");
        jPanel11.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 70, 30));

        cmoperations.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cmoperations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmoperationsMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmoperationsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmoperationsMouseReleased(evt);
            }
        });
        jPanel11.add(cmoperations, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 190, 30));

        add2.setBackground(new java.awt.Color(138, 203, 195));
        add2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add2.setText("اضافة");
        add2.setEnabled(false);
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });
        jPanel11.add(add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 90, 40));

        tdetails2.setBackground(new java.awt.Color(138, 203, 195));
        tdetails2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "اسم العملية", "التاريخ", "السعر"
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
        jScrollPane7.setViewportView(tdetails2);
        if (tdetails2.getColumnModel().getColumnCount() > 0) {
            tdetails2.getColumnModel().getColumn(0).setMinWidth(1);
            tdetails2.getColumnModel().getColumn(0).setPreferredWidth(1);
            tdetails2.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        jPanel11.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 420, 210));

        delete2.setBackground(new java.awt.Color(138, 203, 195));
        delete2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        delete2.setText("مسح عملية");
        delete2.setEnabled(false);
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2ActionPerformed(evt);
            }
        });
        jPanel11.add(delete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 140, 40));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setText("اسم التحليل");
        jPanel11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 160, 30));

        add1.setBackground(new java.awt.Color(138, 203, 195));
        add1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add1.setText("اضافة");
        add1.setEnabled(false);
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel11.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 90, 40));

        cmAnalyze.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cmAnalyze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmAnalyzeMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmAnalyzeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmAnalyzeMouseReleased(evt);
            }
        });
        jPanel11.add(cmAnalyze, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 190, 30));

        tdetails1.setBackground(new java.awt.Color(138, 203, 195));
        tdetails1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails1.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "اسم التحليل", "التاريخ"
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
        jScrollPane5.setViewportView(tdetails1);
        if (tdetails1.getColumnModel().getColumnCount() > 0) {
            tdetails1.getColumnModel().getColumn(0).setMinWidth(1);
            tdetails1.getColumnModel().getColumn(0).setPreferredWidth(1);
            tdetails1.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        jPanel11.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 420, 210));

        delete1.setBackground(new java.awt.Color(138, 203, 195));
        delete1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        delete1.setText("مسح تحليل");
        delete1.setEnabled(false);
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        jPanel11.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 140, 40));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel11.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 640));

        date1.setText("jLabel1");
        jPanel11.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        aid.setText("jLabel1");
        jPanel11.add(aid, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        oid.setText("jLabel1");
        jPanel11.add(oid, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, -1, -1));

        jTabbedPane1.addTab("التحاليل و العمليات", jPanel11);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.setMinimumSize(new java.awt.Dimension(90, 34));
        jPanel13.setPreferredSize(new java.awt.Dimension(970, 690));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdetails3.setBackground(new java.awt.Color(138, 203, 195));
        tdetails3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tdetails3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "الاسم", "الكود", "العدد"
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
        jScrollPane1.setViewportView(tdetails3);
        if (tdetails3.getColumnModel().getColumnCount() > 0) {
            tdetails3.getColumnModel().getColumn(0).setMinWidth(1);
            tdetails3.getColumnModel().getColumn(0).setPreferredWidth(1);
            tdetails3.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        jPanel13.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 920, 200));

        total.setEditable(false);
        total.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setText("0");
        jPanel13.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 70, 30));

        serial3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        serial3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                serial3KeyPressed(evt);
            }
        });
        jPanel13.add(serial3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 210, 30));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel28.setText("المجموع");
        jPanel13.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 60, 30));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel29.setText("كود المنتج");
        jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 90, 30));

        serial2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        serial2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                serial2KeyPressed(evt);
            }
        });
        jPanel13.add(serial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 210, 30));

        number1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        number1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number1.setText("0");
        number1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                number1KeyReleased(evt);
            }
        });
        jPanel13.add(number1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 50, 30));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel31.setText("السعر");
        jPanel13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, 50, -1));

        price.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price.setText("0");
        jPanel13.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 50, 30));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel32.setText("العدد");
        jPanel13.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 40, 30));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel19.setText("المتاح");
        jPanel13.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, 50, 30));

        available.setEditable(false);
        available.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        available.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        available.setText("0");
        jPanel13.add(available, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 50, 30));

        name.setEditable(false);
        name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel13.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 210, 30));

        delete3.setBackground(new java.awt.Color(138, 203, 195));
        delete3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        delete3.setText("مسح المنتج");
        delete3.setEnabled(false);
        delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete3ActionPerformed(evt);
            }
        });
        jPanel13.add(delete3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 170, 40));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel33.setText("اسم المنتج");
        jPanel13.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 80, 30));

        serial1.setEditable(false);
        serial1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        serial1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                serial1KeyPressed(evt);
            }
        });
        jPanel13.add(serial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 210, 30));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Arial", 1, 21)); // NOI18N
        jLabel34.setText("كود المريض");
        jPanel13.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 100, 30));

        save2.setBackground(new java.awt.Color(138, 203, 195));
        save2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        save2.setText("حفظ");
        save2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2ActionPerformed(evt);
            }
        });
        jPanel13.add(save2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 100, 40));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel13.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        serialid1.setText("jLabel1");
        jPanel13.add(serialid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        date3.setText("jLabel1");
        jPanel13.add(date3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, -1, -1));

        number2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        number2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        number2.setText("0");
        number2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                number2KeyReleased(evt);
            }
        });
        jPanel13.add(number2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 70, 30));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel35.setText("Number");
        jPanel13.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, -1));

        jTabbedPane1.addTab("بيع منتج", jPanel13);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmpatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatientMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatientMouseEntered

    private void cmpatientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatientMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatientMousePressed

    private void cmpatientMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatientMouseReleased

    }//GEN-LAST:event_cmpatientMouseReleased

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       if(serialid.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر الدواء ");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.drugs WHERE id='"+serialid.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    serialid.setText("");
                    tablelord();
                } catch (SQLException ex) {

                }
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void tdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseClicked
        DefaultTableModel tmodel =(DefaultTableModel)tdetails.getModel();
        int selectrowindex=tdetails.getSelectedRow();
        serialid.setText(tmodel.getValueAt(selectrowindex, 0).toString());
    }//GEN-LAST:event_tdetailsMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String dose="-";
        try
        {
          dose=cmpatient1.getSelectedItem().toString();
        }
        catch(Exception e)
        {
        }
        try
        {
            
        int numberr = Integer.parseInt(number.getText());
        String Medic=cmMedicines.getSelectedItem().toString();
        String patientserial = pserial.getText();
        String docuumtserial = serial.getText();
        String doctor=cmdoctor.getSelectedItem().toString();
         
         String sqldaf="SELECT * FROM clinic.drugs where name='"+Medic+"' and date='"+datee+"' and p_serial='"+patientserial+"' and d_serial = '"+docuumtserial+"'";
             pst=(PreparedStatement) con.prepareStatement(sqldaf);
             rs=pst.executeQuery();
             if(rs.next()){ 
                  JOptionPane.showMessageDialog(rootPane, "الدواء تم اضافتة من قبل");
                           cmMedicines.setSelectedItem(" ");
                           cmMedicines.requestFocus();
             }
             else
             {
        String sql = "INSERT INTO clinic.drugs (typee,name,number,p_serial,d_serial,date,doctor) VALUES"
                            + " ('"+dose+"','"+Medic+"','"+numberr+"','"+patientserial+"','"+docuumtserial+"','"+datee+"','"+doctor+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
             String sqld="SELECT * FROM clinic.dose where name = '"+dose+"'";
             pst=(PreparedStatement) con.prepareStatement(sqld);
             rs=pst.executeQuery();
             if(rs.next()){
             }
             else
             {
                  String sqla = "INSERT INTO clinic.dose (name)"
                         + " VALUES('"+dose+"')";
                            pst = (PreparedStatement)con.prepareStatement(sqla);
                            pst.execute();
                            cmpatient1.addItem(dose);
             }
             String sqlda="SELECT * FROM clinic.drugslist where type='"+dose+"'"
                     + " and name = '"+Medic+"'";
             pst=(PreparedStatement) con.prepareStatement(sqlda);
             rs=pst.executeQuery();
             if(rs.next()){ 
             
             }
             else
             {
                  String sqlaz = "UPDATE clinic.drugslist SET type='"+dose+"'"
                         + " where  name='"+Medic+"' ";
                            pst=(PreparedStatement) con.prepareStatement(sqlaz);
                            pst.executeUpdate();
                
             }
             String sqldad="SELECT * FROM clinic.drugslist where name='"+cmMedicines.getSelectedItem().toString()+"'";
             pst=(PreparedStatement) con.prepareStatement(sqldad);
             rs=pst.executeQuery();
             if(rs.next()){ 
             
             }
             else
             {
                 String sqla = "INSERT INTO clinic.drugslist (name,type)"
                         + " VALUES('"+cmMedicines.getSelectedItem().toString()+"','"+dose+"')";
                            pst = (PreparedStatement)con.prepareStatement(sqla);
                            pst.execute();
                            cmMedicines.addItem(cmMedicines.getSelectedItem().toString());
                
             }
                            tablelord();
                             cmMedicines.setSelectedIndex(0);
                           cmpatient1.setSelectedIndex(0);
                           cmMedicines.requestFocus();
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane,ex);
                           
        }
    }//GEN-LAST:event_addActionPerformed

    private void cmMedicinesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmMedicinesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmMedicinesMouseEntered

    private void cmMedicinesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmMedicinesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmMedicinesMousePressed

    private void cmMedicinesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmMedicinesMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmMedicinesMouseReleased

    private void pressureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressureActionPerformed

    }//GEN-LAST:event_pressureActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
tablelord();
     tablelord1();
     tablelord12();
     tablelord11();      
                        add.setEnabled(true);
                           delete.setEnabled(true);
                           done.setEnabled(false);
                           number.setEditable(true);
                           cmMedicines.setEditable(true);
                           add1.setEnabled(true);
                           add2.setEnabled(true);
                           delete1.setEnabled(true);
                           delete2.setEnabled(true);
                           delete3.setEnabled(true);
                           cmAnalyze.setEditable(true);
                           cmoperations.setEditable(true);
                           jTabbedPane1.setSelectedComponent(jPanel12);
                           cmMedicines.requestFocus();
      
    }//GEN-LAST:event_doneActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
           try {
               String name = cmAnalyze.getSelectedItem().toString();
               String patientserial = pserial.getText();
               String docuumtserial = serial.getText();
               String doctor=cmdoctor.getSelectedItem().toString();
               String sql = "INSERT INTO clinic.operation (name,type,p_serial,d_serial,date,doctor,fulldate) VALUES"
                       + " ('"+name+"','analyze','"+patientserial+"','"+docuumtserial+"','"+datee+"','"+doctor+"','"+fulldatee+"')";
               pst = (PreparedStatement)con.prepareStatement(sql);
               pst.execute();
               tablelord1();
           } catch (SQLException ex) {
               Logger.getLogger(document.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_add1ActionPerformed

    private void cmAnalyzeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmAnalyzeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmAnalyzeMouseEntered

    private void cmAnalyzeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmAnalyzeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmAnalyzeMousePressed

    private void cmAnalyzeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmAnalyzeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmAnalyzeMouseReleased

    private void tdetails1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetails1MouseClicked
         DefaultTableModel tmodel =(DefaultTableModel)tdetails1.getModel();
        int selectrowindex=tdetails1.getSelectedRow();
        aid.setText(tmodel.getValueAt(selectrowindex, 0).toString());
    }//GEN-LAST:event_tdetails1MouseClicked

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        if(aid.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر اسم التحليل");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.operation WHERE id='"+aid.getText()+"' and type = 'analyze'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    aid.setText("");
                    tablelord1();
                } catch (SQLException ex) {

                }
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_delete1ActionPerformed

    private void cmoperationsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmoperationsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmoperationsMouseEntered

    private void cmoperationsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmoperationsMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmoperationsMousePressed

    private void cmoperationsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmoperationsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmoperationsMouseReleased

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        try {
               String name = cmoperations.getSelectedItem().toString();
               String patientserial = pserial.getText();
               String docuumtserial = serial.getText();
               String doctor=cmdoctor.getSelectedItem().toString();
               String sql = "INSERT INTO clinic.operation (price,name,type,p_serial,d_serial,date,doctor,fulldate) VALUES"
                       + " ('"+oprice.getText()+"','"+name+"','Operations','"+patientserial+"','"+docuumtserial+"','"+datee+"','"+doctor+"','"+fulldatee+"')";
               pst = (PreparedStatement)con.prepareStatement(sql);
               pst.execute();
               tablelord12();
           } catch (SQLException ex) {
               Logger.getLogger(document.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_add2ActionPerformed

    private void tdetails2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetails2MouseClicked
         DefaultTableModel tmodel =(DefaultTableModel)tdetails2.getModel();
        int selectrowindex=tdetails2.getSelectedRow();
        oid.setText(tmodel.getValueAt(selectrowindex, 0).toString());
    }//GEN-LAST:event_tdetails2MouseClicked

    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
       if(oid.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر العملية");

        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sql = "DELETE FROM clinic.operation WHERE id='"+oid.getText()+"' and type = 'Operations'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    oid.setText("");
                    tablelord12();
                } catch (SQLException ex) {

                }
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_delete2ActionPerformed

    private void cmpatient1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MouseEntered

    private void cmpatient1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MousePressed

    private void cmpatient1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatient1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatient1MouseReleased

    private void cmdoctorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdoctorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdoctorMouseReleased

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        String name = cmpatient.getSelectedItem().toString();
        String pseriall=pserial.getText();
        String phone = pphone.getText();
        String doctor = cmdoctor.getSelectedItem().toString();
        String dobb=dob.getText();
        String remarkk=comment.getText();
        String weightt=weight.getText();
        String sugar1=txtsugar.getText();
        String pressure1 = txtpressure.getText();
        int nextdays=Integer.parseInt(nextday.getText());
         if(nextdaytype.isSelected())
                 {
                     nexttypee="Check";
                 }
                 else
                 {
                     nexttypee="consultation";
                 }
         String nextdatee=  ((JTextField)nextdaydata.getDateEditor().getUiComponent()).getText();
        try{
            String sql = "INSERT INTO clinic.documents (nextvisitdata,nextvisitdays,nextvisittype,name,p_serial,serial,"
                    + "doctor_name,date,fulldate,weight,sugar,pressure,remark) VALUES"
                            + " ('"+nextdatee+"','"+nextdays+"','"+nexttypee+"','"+name+"','"+pseriall+"',"
                    + "'"+serial.getText()+"','"+doctor+"','"+datee+"','"+fulldatee+"','"+weightt+"','"+sugar1+"',"
                              + "'"+pressure1+"','"+remarkk+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
                             String sqla = "UPDATE clinic.attendance SET finish='Yes'"
                                     + "where  name='"+name+"' "
                                     + "AND date='"+datee+"' AND doctor='"+doctorname+"'";
                            pst=(PreparedStatement) con.prepareStatement(sqla);
                            pst.executeUpdate();
                            System.out.print(serial.getText());
                            JOptionPane.showMessageDialog(this, "تتم الطباعه الان");
                            printDocument(serial.getText());
                            
                        
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null, e);
        }

      Document_serial();
     tablelord();
     tablelord1();
     tablelord12();
     tablelord11();
     cmpatient.removeItem(name);  
     
     clear();
     done.setEnabled(true);
     cmpatient.setSelectedItem(" ");
     
         if(1!=0)
         {
             cmpatient.removeAllItems();
             cmpatient.addItem(" ");
         }
         
     patientss();
     
     
     
     
    }//GEN-LAST:event_save1ActionPerformed

    private void cancle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancle1ActionPerformed
        try {
            String sqld="SELECT *  FROM clinic.sell where  d_serial='"+serial.getText()+"' and p_serial='"+pserial.getText()+"' and date='"+datee+"'";
             pst=(PreparedStatement) con.prepareStatement(sqld);
             rs=pst.executeQuery();
             if(rs.next()){
                JOptionPane.showMessageDialog(rootPane, "من فضلك قم بمسح عمليات البيع اولا");
                 
             }
             else
             {
               String sql = "DELETE FROM clinic.drugs WHERE d_serial='"+serial.getText()+"' and p_serial='"+pserial.getText()+"' and date='"+datee+"'";
               pst=(PreparedStatement) con.prepareStatement(sql);
               pst.execute();
                String sqll = "DELETE FROM clinic.documents WHERE serial='"+serial.getText()+"' and p_serial='"+pserial.getText()+"' and date='"+datee+"'";
               pst=(PreparedStatement) con.prepareStatement(sqll);
               pst.execute();
               String sqll1 = "DELETE FROM clinic.operation WHERE d_serial='"+serial.getText()+"' and p_serial='"+pserial.getText()+"' and date='"+datee+"'";
               pst=(PreparedStatement) con.prepareStatement(sqll1);
               pst.execute();
              
               
                JOptionPane.showMessageDialog(rootPane, "تم مسح الروشته بنجاح");
               clear();
                done.setEnabled(true);
               Document_serial();
               tablelord();
         if(1!=0)
         {
             cmpatient.removeAllItems();
             cmpatient.addItem(" ");
         }
         
     patientss();
             } 
           } catch (SQLException ex) {
               Logger.getLogger(document.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_cancle1ActionPerformed

    private void nextdayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextdayMouseReleased
         
    }//GEN-LAST:event_nextdayMouseReleased

    private void nextdayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nextdayKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nextdayKeyTyped

    private void nextdayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nextdayKeyReleased
 try {
             int x = Integer.parseInt(nextday.getText());
             System.out.print(datee);
               Date date1;
               date1 = new SimpleDateFormat("yyyy-M-dd").parse(datee);
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
               Calendar cal  = Calendar.getInstance();
               cal.setTime(date1);
               cal.add(Calendar.DATE, (x));
               String expDateString = sdf.format(cal.getTime());
               ((JTextField)nextdaydata.getDateEditor().getUiComponent()).setText(expDateString);
           } catch (ParseException ex) {
               Logger.getLogger(document.class.getName()).log(Level.SEVERE, null, ex);
           }        // TODO add your handling code here:
    }//GEN-LAST:event_nextdayKeyReleased

    private void tdetails3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetails3MouseClicked
        DefaultTableModel tmodel =(DefaultTableModel)tdetails3.getModel();
        //bid,name, price, publisher, book_type, b_code, date, category
        int selectrowindex=tdetails3.getSelectedRow();
        serialid1.setText(tmodel.getValueAt(selectrowindex, 0).toString());
        number2.setText(tmodel.getValueAt(selectrowindex, 3).toString());
        serial3.setText(tmodel.getValueAt(selectrowindex, 2).toString());
    }//GEN-LAST:event_tdetails3MouseClicked

    private void serial2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serial2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String sqls="SELECT serial FROM clinic.item where serial='"+serial2.getText()+"'";
                pst=(PreparedStatement) con.prepareStatement(sqls);
                rs=pst.executeQuery();
                if(rs.next()){
                    String sqlsa="SELECT * FROM clinic.item where serial='"+serial2.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sqlsa);
                    rs=pst.executeQuery();
                    if(rs.next()){
                        available.setText(rs.getString("total"));
                        name.setText(rs.getString("name"));
                        price.setText(rs.getString("price"));
                    }
                    number1.setText("0");
                    number1.requestFocus();
                }
                else
                {

                    JOptionPane.showMessageDialog(this, "المنتج غير موجود");
                }
            } catch (SQLException ex) {

            }

        }
    }//GEN-LAST:event_serial2KeyPressed

    private void number1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_number1KeyReleased

        int numberr = Integer.parseInt(number1.getText());
        int pricee = Integer.parseInt(price.getText());
        String totall = Integer.toString(numberr*pricee);
        total.setText(totall);
    }//GEN-LAST:event_number1KeyReleased

    private void serial1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serial1KeyPressed

    }//GEN-LAST:event_serial1KeyPressed

    private void save2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ActionPerformed
        try
        {
            TimeZone tz = TimeZone.getTimeZone("GMT+02");
            Calendar c = Calendar.getInstance(tz);
            String time = String.format("%02d" , c.get(Calendar.HOUR_OF_DAY))+":"+
            String.format("%02d" , c.get(Calendar.MINUTE));
            String fulldatee=datee+" "+time;
            String namee = name.getText();

            int pricee= Integer.parseInt(price.getText());
            int numberbuyed=Integer.parseInt(number1.getText());
            int  availablee= Integer.parseInt(available.getText());
            int totall=availablee-numberbuyed;
            if( availablee >= numberbuyed)
            {
                try {
                    String sql = "INSERT INTO clinic.sell (name,p_serial,d_serial,date,doctor,number,serial) VALUES"
                            + " ('"+namee+"','"+serial1.getText()+"','"+serial.getText()+"',"
                            + "'"+datee+"','"+doctorname+"','"+numberbuyed+"','"+serial2.getText()+"')";
                            pst = (PreparedStatement)con.prepareStatement(sql);
                            pst.execute();
        
                    String sqla = "UPDATE clinic.item SET total='"+totall+"' where name = '"+namee+"' and serial = '"+serial2.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sqla);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "item added Successfully");
                    tablelord11();
                    String sqll4 = "INSERT INTO clinic.logs (d_serial,personserial,type,serial,name,price,amount,date,fulldate,number) VALUES"
                    + " ('"+serial.getText()+"','"+serial1.getText()+"','sell','"+serial2.getText()+"','"+name.getText()+"',"
                    + "'"+pricee+"','"+total.getText()+"',"
                    + "'"+datee+"','"+fulldatee+"','"+number1.getText()+"')";
                    pst = (PreparedStatement)con.prepareStatement(sqll4);
                    pst.execute();
                    tablelord11();
                     serial2.setText("");
  name.setText("");
  available.setText("");
  price.setText("");
  number1.setText("");
  total.setText("");
                    serial2.requestFocus();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
            else
            {

                JOptionPane.showMessageDialog(this, "لاتملك عدد كافي من المنتج");
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_save2ActionPerformed

    private void delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete3ActionPerformed
       if(serialid1.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "من فضلك اختر المنتج");

        }
        else{
           
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "هل تريد حفظ العملية", "رسالة تاكيد ؟ ", dialogButton);
            if(dialogResult == 0) {
                try {
                    String sqla = "UPDATE clinic.item SET total=total+"+number2.getText()+" WHERE serial='"+serial3.getText()+"' ";
                            pst=(PreparedStatement) con.prepareStatement(sqla);
                            pst.executeUpdate();
                    String sql = "DELETE FROM clinic.sell WHERE id='"+serialid1.getText()+"'";
                    pst=(PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    String sqls = "DELETE FROM clinic.logs WHERE d_serial = '"+serial.getText()+"' and serial = '"+serial3.getText()+"' "
                            + "   and number = '"+number2.getText()+"' and personserial = '"+serial1.getText()+"'and date = '"+datee+"'";
                    pst=(PreparedStatement) con.prepareStatement(sqls);
                    pst.execute();
                    serialid1.setText("");
                    serial3.setText("");
                    tablelord11();
                    serial2.requestFocus();
                } catch (SQLException ex) {

                }
            }
            else
            {

                JOptionPane.showMessageDialog(this, " الغاء");
            }
        }
    }//GEN-LAST:event_delete3ActionPerformed

    private void number2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_number2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_number2KeyReleased

    private void serial3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serial3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_serial3KeyPressed

    private void cmpatientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmpatientKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatientKeyReleased

    private void cmpatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmpatientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatientMouseClicked

    private void cmpatientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmpatientKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpatientKeyPressed

    private void cmpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpatientActionPerformed
      try
      {
       Object obj = evt.getSource();
       if(obj==cmpatient)
       {
            if(cmpatient.getSelectedItem().toString().trim().isEmpty())
       {
       }
       else
               {
                    try {
             String sql="SELECT *  FROM clinic.patient where name='"+cmpatient.getSelectedItem().toString()+"'";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 cmdoctor.setSelectedItem(doctorname);
                 dob.setText(rs.getString("dob"));
                 pserial.setText(rs.getString("serial"));
                 serial1.setText(rs.getString("serial"));
                 weight.setText(rs.getString("weight"));
                 pphone.setText(rs.getString("phone"));
                 sugarr=rs.getString("sugar");
                 smokerr=rs.getString("smoker");
                 pressurre=rs.getString("pressure");
                 if(sugarr.equals("Yes"))
                 {
                     sugar.setSelected(true);
                     txtsugar.setEditable(true);
                 }
                 else
                 {
                     sugar.setSelected(false);
                 }
                  if(pressurre.equals("Yes"))
                 {
                     pressure.setSelected(true);
                 }
                 else
                 {
                     pressure.setSelected(false);
                 }
                  if(smokerr.equals("Yes"))
                 {
                     smoker.setSelected(true);
                 }
                 else
                 {
                     smoker.setSelected(false);
                 }
             }
            done1.setEnabled(true);
            done2.setEnabled(true);
            done3.setEnabled(true);
            done4.setEnabled(true);
            done.setEnabled(true);
            save1.setEnabled(true);
            cancle1.setEnabled(true);
         } catch (SQLException ex) {
             
         }

       }}
      }
      catch(Exception ex)
      {
          cmpatient.removeAllItems();

      }
    }//GEN-LAST:event_cmpatientActionPerformed

    private void cmMedicinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmMedicinesActionPerformed
         Object obj = evt.getSource();
       if(obj==cmMedicines)
       {
        try {
             String sql="SELECT *  FROM clinic.drugslist where name='"+cmMedicines.getSelectedItem().toString()+"'";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 
                 cmpatient1.setSelectedItem(rs.getString("type"));
                }
             else
             {
                 cmpatient1.setSelectedItem(" ");
             }
            

         } catch (SQLException ex) {
             
         }
       } 
    }//GEN-LAST:event_cmMedicinesActionPerformed

    private void done1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done1ActionPerformed
       if(pserial.getText().toString().trim().isEmpty())
               {
                    JOptionPane.showMessageDialog(this, "Please select Patient");
               }
       else
       {
           InputStream in=null;
      try {
          
          in = this.getClass().getResourceAsStream("/reports/cart.jasper");
    Map<String,Object> para = new HashMap<String,Object>();
            para.put("serial",pserial.getText());
           

            JasperPrint j = JasperFillManager.fillReport(in, para,con);
            JasperViewer.viewReport(j,false);
      }
     catch (JRException ex) {
        } finally {
        } 
       }
    }//GEN-LAST:event_done1ActionPerformed

    private void done2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done2ActionPerformed
         if(pserial.getText().toString().trim().isEmpty())
               {
                    JOptionPane.showMessageDialog(this, "Please select Patient");
               }
       else
       {InputStream in=null;
      try {
          
          in = this.getClass().getResourceAsStream("/reports/documents.jasper");
    Map<String,Object> para = new HashMap<String,Object>();
            para.put("serial",pserial.getText() );
           

            JasperPrint j = JasperFillManager.fillReport(in, para,con);
            JasperViewer.viewReport(j,false);
      }
     catch (JRException ex) {
        } finally {
        } 
       }
    }//GEN-LAST:event_done2ActionPerformed

    private void done3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done3ActionPerformed
       Results m = new Results(pserial.getText());
            m.setVisible(true);
    }//GEN-LAST:event_done3ActionPerformed

    private void done4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done4ActionPerformed
       if(pserial.getText().toString().trim().isEmpty())
               {
                    JOptionPane.showMessageDialog(this, "Please select Patient");
               }
       else
       {
           InputStream in=null;
      try {
          
          in = this.getClass().getResourceAsStream("/reports/drugs.jasper");
    Map<String,Object> para = new HashMap<String,Object>();
            para.put("serial",pserial.getText());
           

            JasperPrint j = JasperFillManager.fillReport(in, para,con);
            JasperViewer.viewReport(j,false);
      }
     catch (JRException ex) {
        } finally {
        } 
       }
    }//GEN-LAST:event_done4ActionPerformed

    private void txtsugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JLabel aid;
    private javax.swing.JLabel aid1;
    private javax.swing.JTextField available;
    private javax.swing.JButton cancle1;
    private javax.swing.JComboBox cmAnalyze;
    private javax.swing.JComboBox cmMedicines;
    private javax.swing.JComboBox cmdoctor;
    private javax.swing.JComboBox cmoperations;
    private javax.swing.JComboBox cmpatient;
    private javax.swing.JComboBox cmpatient1;
    private javax.swing.JTextArea comment;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JLabel date3;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JButton delete2;
    private javax.swing.JButton delete3;
    private javax.swing.JTextField dob;
    private javax.swing.JButton done;
    private javax.swing.JButton done1;
    private javax.swing.JButton done2;
    private javax.swing.JButton done3;
    private javax.swing.JButton done4;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nextday;
    private com.toedter.calendar.JDateChooser nextdaydata;
    private javax.swing.JCheckBox nextdaytype;
    private javax.swing.JTextField number;
    private javax.swing.JTextField number1;
    private javax.swing.JTextField number2;
    private javax.swing.JLabel oid;
    private javax.swing.JLabel oid1;
    private javax.swing.JTextField oprice;
    private javax.swing.JTextField pphone;
    private javax.swing.JCheckBox pressure;
    private javax.swing.JTextField price;
    private javax.swing.JTextField pserial;
    private javax.swing.JButton save1;
    private javax.swing.JButton save2;
    private javax.swing.JLabel serial;
    private javax.swing.JTextField serial1;
    private javax.swing.JTextField serial2;
    private javax.swing.JTextField serial3;
    private javax.swing.JLabel serialid;
    private javax.swing.JLabel serialid1;
    private javax.swing.JCheckBox smoker;
    private javax.swing.JCheckBox sugar;
    private javax.swing.JTable tdetails;
    private javax.swing.JTable tdetails1;
    private javax.swing.JTable tdetails2;
    private javax.swing.JTable tdetails3;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtpressure;
    private javax.swing.JTextField txtsugar;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
public void tablelord()
    {
        try {
            String sqll = "SELECT * FROM clinic.drugs where p_serial='"+pserial.getText()+"' AND d_serial='"+serial.getText()+"' AND date='"+datee+"' order by id";
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
                       rs.getString("number"),
                       rs.getString("typee"),
                       
                      
                        
                        
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
public void tablelord1()
    {
        try {
            String sqll = "SELECT * FROM clinic.operation where type = 'analyze' AND p_serial='"+pserial.getText()+"' AND d_serial='"+serial.getText()+"' AND date='"+datee+"' order by id";
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
                       rs.getString("date"),
                       
                      
                        
                        
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
public void tablelord12()
    {
        try {
            String sqll = "SELECT * FROM clinic.operation where type = 'Operations' AND p_serial='"+pserial.getText()+"' AND d_serial='"+serial.getText()+"' AND date='"+datee+"' order by id";
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
                       rs.getString("date"),
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
 pserial.setText("");
 cmdoctor.setSelectedIndex(0);
 pphone.setText("");
 dob.setText("");
 serialid.setText("");
 txtsugar.setEditable(false);
 txtsugar.setText("");
 txtpressure.setText("/");
 weight.setText("");
 sugar.setSelected(false);
 pressure.setSelected(false);
 smoker.setSelected(false);
 comment.setText("");
 number.setText("1");
 cmMedicines.setSelectedIndex(0);
 done.setEnabled(true);
 add.setEnabled(false);
 delete.setEnabled(false);
  add1.setEnabled(false);
 add2.setEnabled(false);
 delete1.setEnabled(false);
 delete2.setEnabled(false);
 delete3.setEnabled(false);
 cmAnalyze.setEditable(false);
 cmAnalyze.setSelectedIndex(0);
 cmoperations.setSelectedIndex(0);
 cmoperations.setEditable(false);
 number.setEditable(false);
 nextday.setText("0");
  ((JTextField)nextdaydata.getDateEditor().getUiComponent()).setText("");
  serial2.setText("");
  name.setText("");
  available.setText("");
  price.setText("");
  number1.setText("");
  total.setText("");
  done1.setEnabled(false);
            done2.setEnabled(false);
            done3.setEnabled(false);
            done4.setEnabled(false);
 
 }
     
              public void comboxfromcombo()
      {
        
          
                   cmMedicines.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                JComboBox cmsupplier = (JComboBox) event.getSource();

                Object item = event.getItem();
                     try {
             String sql="SELECT *  FROM clinic.drugslist where name='"+cmMedicines.getSelectedItem().toString()+"'";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 
                 cmpatient1.setSelectedItem(rs.getString("type"));
                }
            

         } catch (SQLException ex) {
             
         } }
        });
       
      }
     public void comboxfromcombo2()
      {
        
          
                   cmoperations.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                JComboBox cmsupplier = (JComboBox) event.getSource();

                Object item = event.getItem();
                     try {
             String sql="SELECT *  FROM clinic.operationslist where name='"+cmoperations.getSelectedItem().toString()+"'";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 
                 oprice.setText(rs.getString("price"));
                }
            

         } catch (SQLException ex) {
             
         } }
        });
       
      }

     public void Document_serial(){

         try {
             String sql = "SELECT serial FROM clinic.documents where id=(select max(id)FROM clinic.documents )";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             if(rs.next()){
                 String rnno=rs.getString("serial");
                 int co=rnno.length();
                 String txt=rnno.substring(0,3);
                 String num = rnno.substring(3,co);
                 int n = Integer.parseInt(num);
                 n++;
                 String snum=Integer.toString(n);
                 String ftxt=txt+snum;
                 serial.setText(ftxt);
             }
             else
             {
                 serial.setText("DN-1001");
             }
         } catch (SQLException ex) {
            
         }
     }
     public void doctors()
   {
        try {
             String sql="SELECT name  FROM clinic.doctors ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmdoctor.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }
public void patientss()
   {
        try {
             String sql="SELECT * FROM clinic.attendance where date = '"+datee+"'and "
                     + "doctor='"+doctorname+"'and mark = 'Yes' and paid = 'Yes' and finish='No' order by id";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmpatient.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }
              
      public void Medicines()
   {
       
        try {
             String sql="SELECT name  FROM clinic.drugslist order by name ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmMedicines.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }   
 public void operations()
   {
        try {
             String sql="SELECT name  FROM clinic.operationslist ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmoperations.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
         }
   }   
  public void analyz()
   {
        try {
             String sql="SELECT name  FROM clinic.analyzeslist ";
             pst=(PreparedStatement) con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
                String namee = rs.getString("name");
                
                cmAnalyze.addItem(namee);
  
             }

         } catch (SQLException ex) {
             
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
       public void tablelord11()
{
    try {
           String sqll = "SELECT * FROM clinic.sell where p_serial='"+pserial.getText()+"' AND d_serial='"+serial.getText()+"' AND date='"+datee+"' order by id";
              pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tdetails3.getModel(); 
                model.setRowCount(0);
              int k = 0;
                while (rs.next())
                {
                    Object row[] = {
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("serial"),
                        rs.getString("number"),
                      };
                    model.addRow(row);
                    k++;
                }
                for(int i = k ;i<11;i++)
                {
                 Object rowData[] = {
                       "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                       };
                model.addRow(rowData);
                } 
        }
        catch (SQLException ex) {
            
        }
}
    public void printDocument(String x )
    {
            
       
     InputStream in=null;
      try {
          
          in = this.getClass().getResourceAsStream("/reports/documentreport.jasper");
    Map<String,Object> para = new HashMap<String,Object>();
            para.put("serial",x );
           

            JasperPrint j = JasperFillManager.fillReport(in, para,con);
            JasperViewer.viewReport(j,false);
      }
     catch (JRException ex) {
        } finally {
        } 

         
        
}
}
