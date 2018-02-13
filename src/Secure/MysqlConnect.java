/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import java.sql.*;
import javax.swing.*;



/**
 *
 * @author Mariusz Jaczewski
 */
public class MysqlConnect {
    Connection conn=null; //bez public
    Connection conn2=null;
 //   Connection costomerTable=null;
  public static Connection ConnectDB(){
      
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/warsztat","root","");
        //  JOptionPane.showMessageDialog(null, "połączono z baza danych");
          return conn;
                  
          
      }
      
  catch(Exception e){
JOptionPane.showMessageDialog(null, e);
return null;

}
    
  }  
    
}
