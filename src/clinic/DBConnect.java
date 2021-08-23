/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author amnassar
 */
public class DBConnect {
    
     public static Connection connect() 
     {
         Connection con=null;
	try {
            
		Class.forName("com.mysql.jdbc.Driver");
		 con=(Connection)DriverManager.getConnection ("jdbc:mysql://localhost/clinic", "root", "root");
                 
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
        }
	return con; 
	}
    //root1692000
    
}
