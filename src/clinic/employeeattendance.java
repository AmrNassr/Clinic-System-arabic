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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author amnassar
 */
public final class employeeattendance extends javax.swing.JInternalFrame {

    /**
     * Creates new form book
     */
     Connection con ;
     PreparedStatement pst ;
     ResultSet rs;
     public String y ;
     public String datee;
     public  Calendar cal;
     String dayyy ;
    
   
    public employeeattendance( )throws IOException {
        initComponents();
        con=DBConnect.connect();
          TableCellRenderer rendererFromHeader = tdetails.getTableHeader().getDefaultRenderer();
JLabel headerLabel = (JLabel) rendererFromHeader;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tdetails.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
         tdetails.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
          cal = new GregorianCalendar();
             
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
          clear();
        tablelord();
        serial.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      phone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
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
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdetails = new javax.swing.JTable();
        save3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        serial = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        serialid = new javax.swing.JLabel();

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
                "الكود", "اسم الموظف", "التاريخ", "التاريخ التفصيلي"
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
            tdetails.getColumnModel().getColumn(0).setMinWidth(100);
            tdetails.getColumnModel().getColumn(0).setPreferredWidth(100);
            tdetails.getColumnModel().getColumn(0).setMaxWidth(100);
            tdetails.getColumnModel().getColumn(2).setMinWidth(300);
            tdetails.getColumnModel().getColumn(2).setPreferredWidth(300);
            tdetails.getColumnModel().getColumn(2).setMaxWidth(300);
            tdetails.getColumnModel().getColumn(3).setMinWidth(200);
            tdetails.getColumnModel().getColumn(3).setPreferredWidth(200);
            tdetails.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 920, 300));

        save3.setBackground(new java.awt.Color(138, 203, 195));
        save3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        save3.setText("تفريغ");
        save3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save3ActionPerformed(evt);
            }
        });
        jPanel10.add(save3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 120, 50));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setText("الهاتف");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 60, 30));

        phone.setEditable(false);
        phone.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel10.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 210, 30));

        name.setEditable(false);
        name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel10.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 210, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setText("الاسم");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 100, 30));

        serial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        serial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                serialKeyPressed(evt);
            }
        });
        jPanel10.add(serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 140, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel18.setText("كود الموظف");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 100, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nYwGq3.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 2));
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 720));

        date1.setText("jLabel1");
        jPanel10.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 140, 50));

        serialid.setText("jLabel1");
        jPanel10.add(serialid, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdetailsMouseClicked
        DefaultTableModel tmodel =(DefaultTableModel)tdetails.getModel();
        //bid,name, price, publisher, book_type, b_code, date, category
        int selectrowindex=tdetails.getSelectedRow();
       
       
        
       

    }//GEN-LAST:event_tdetailsMouseClicked

    private void serialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serialKeyPressed
        

        String seriall = serial.getText();
        String namee = name.getText();
     
      TimeZone tz = TimeZone.getTimeZone("GMT+02");
             Calendar c = Calendar.getInstance(tz);
             String time = String.format("%02d" , c.get(Calendar.HOUR_OF_DAY))+":"+
                     String.format("%02d" , c.get(Calendar.MINUTE));
             String fulldatee=datee+" "+time;
             String fulldateee=datee+" "+time;
        String frommm = null;
        String tooo=null;
        String salary = null;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
           try {
                String sqlss="SELECT name,hour FROM clinic.employee where serial='"+serial.getText()+"'";
             pst=(PreparedStatement) con.prepareStatement(sqlss);
             rs=pst.executeQuery();
             if(rs.next()){
                 namee=rs.getString("name");
                 salary=rs.getString("hour");
             }
                 String fromm=null;
                 Date min,max ;
                 DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm");
                 String sqls="SELECT * FROM clinic.empployeeattendance where serial='"+serial.getText()+"' AND date='"+datee+"'";
             pst=(PreparedStatement) con.prepareStatement(sqls);
             rs=pst.executeQuery();
             if(rs.next()){
                 fromm=rs.getString("fulldate");
                 min=sdf.parse(fromm);
                 max=sdf.parse(fulldatee);
                 double diff = max.getTime() - min.getTime();
                 double diffminute = (double) ((diff / (60 * 60 * 1000))%1)*60;
                 double diffhours = (double) (diff / (60 * 60 * 1000));
                 int minute = (int)diffminute;
                 int hour = (int)diffhours;
                 System.out.print(hour +" : "+ minute);
                 String sqla = "UPDATE clinic.empployeeattendance SET fulldateleave = '"+fulldatee+"'"
                         + ",hours='"+hour+"',minute='"+minute+"'"
                         + " WHERE  serial='"+serial.getText()+"' AND date='"+datee+"'";
                             pst=(PreparedStatement) con.prepareStatement(sqla);
                             pst.executeUpdate();
                             JOptionPane.showMessageDialog(this, " تم تسجيل الخروج بنجاح : "+namee);
             }
             else
             {
                  String sqlz = "INSERT INTO clinic.empployeeattendance (name,serial,date,fulldate,fulldateleave,hourr) VALUES"
                        + " ('"+namee+"','"+seriall+"','"+datee+"','"+fulldatee+"','"+fulldatee+"','"+salary+"')";
                        pst = (PreparedStatement)con.prepareStatement(sqlz );
                        pst.execute();
                           JOptionPane.showMessageDialog(this,  " تم تسجيل الدخول بنجاح : "+namee);
                           clear();
                           tablelord();
             }
               
         } 
            catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, ex);
         }  catch (ParseException ex) {
                Logger.getLogger(employeeattendance.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }
       
    }//GEN-LAST:event_serialKeyPressed

    private void save3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save3ActionPerformed
        clear();
        tablelord();
    }//GEN-LAST:event_save3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JButton save3;
    private javax.swing.JTextField serial;
    private javax.swing.JLabel serialid;
    private javax.swing.JTable tdetails;
    // End of variables declaration//GEN-END:variables
public void tablelord()
    {
        try {
            String sqll = "SELECT * FROM clinic.empployeeattendance where date = '"+datee+"' ORDER BY id DESC";
              pst=(PreparedStatement) con.prepareStatement(sqll);
            rs=pst.executeQuery();
            DefaultTableModel model =(DefaultTableModel)tdetails.getModel(); 
                model.setRowCount(0);
              int x = 1;
                while (rs.next())
                {
                    Object row[] = {
                       rs.getString("serial"),
                       rs.getString("name"),
                       rs.getString("date"),
                       rs.getString("fulldate")
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
    phone.setText("");
    serial.setText("");
    
}
    
}
