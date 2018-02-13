/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;
import javax.swing.*;
/**
 *
 * @author Mariusz Jaczewski
 */
public class pobieranieWartosci {
    
    public int idModelConnection;
    
    
     int przebieg;
        int rocznik;
        
        String marka;
        String model;
         int id_wlasciciel;
         int id_model;
         int id_zlecenia;
        
        int  pobierzId_wlasciciel( JTable jTable1  ){
        //wyłuskanie id właścieciela
        
        int wlascicielZaznaczony=jTable1.getSelectedRow();
        id_wlasciciel = Integer.parseInt( jTable1.getValueAt(wlascicielZaznaczony, 0).toString()) ;
                System.out.println( id_wlasciciel );
        
                return id_wlasciciel;
        }
        
        int  pobierzId_model(  JTable jTable4 ){
                 
         int modelZaznaczony=jTable4.getSelectedRow();
         
         // JOptionPane.showMessageDialog(null,"Błąd- zaznacz model!!!","Brak dostepu",JOptionPane.ERROR_MESSAGE);
         
         
         id_model = Integer.parseInt( jTable4.getValueAt(modelZaznaczony, 0).toString()) ;
               System.out.println( id_model );
         
          
         
         return id_model;
}
        int  pobierzId_cz(  JTable jTable2 ){
                 
         
         
         // JOptionPane.showMessageDialog(null,"Błąd- zaznacz model!!!","Brak dostepu",JOptionPane.ERROR_MESSAGE);
         
         for (int i=jTable2.getRowCount()-1;i>=0;i-- ){
             
         
         id_zlecenia = Integer.parseInt( jTable2.getValueAt(i, 0).toString()) ;}
               System.out.println( id_zlecenia );

         return id_zlecenia;
}
        
        
        
        
        
        
        
        
            int  pobierzRocznik(  JTable jTable6 ){
                 
         int rocznikZaznaczony=jTable6.getSelectedRow();
         
         
         
         
          rocznik = Integer.parseInt( jTable6.getValueAt(rocznikZaznaczony, 0).toString()) ;
        // rocznik =  jTable6.getValueAt(rocznikZaznaczony, 0)  ;
               System.out.println( rocznik );
         
          
         
         return rocznik;
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        int pobierzPrzebieg( JTextField jTextField7){
        
        przebieg=Integer.parseInt(jTextField7.getText());
        return przebieg;
        }
        
        
        
       // rocznik= Integer.parseInt(jTextField11.getText());
        
        
        String pobierzModel( JTable jTable4 ){
            
            int modelZaznaczony=jTable4.getSelectedRow();
          model=   jTable4.getValueAt(modelZaznaczony, 2).toString();
          return model;
        }
        String pobierzMarka( JTable jTable4 ){
         int modelZaznaczony=jTable4.getSelectedRow();
          marka=   jTable4.getValueAt(modelZaznaczony, 1).toString(); 
        return marka;
    
        
        }
    
    
}
