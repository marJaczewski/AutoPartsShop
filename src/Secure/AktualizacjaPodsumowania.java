/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
 


/**
 *
 * @author Mariusz Jaczewski
 */
public class AktualizacjaPodsumowania {
    
    int iloscCzynnosci;
    float wartoscCzesci;
    float wartoscRobocizny;
    float marzaCzesci;
    float marzaRobocizny;
    float suma;
    String zakonczenieCzynnosci;                
    
    void aktualizujPodsumowanie(JTable tabelaCzynnosci, JTable tabelaPodsumowanie, String marzaCzesci, String marzaRobocizny){
      long zakonczenieCzynnosciLong=0;  
      long temp=0; 
      String ostatniaData=null;
      Date data=null;
      
            DefaultTableModel model =( DefaultTableModel ) tabelaPodsumowanie.getModel();
             
            model.setRowCount(0);
        
        
        
        for(int i=0; i<tabelaCzynnosci.getRowCount(); i++){
            iloscCzynnosci++;
            wartoscCzesci+=Integer.parseInt(tabelaCzynnosci.getValueAt(i, 3).toString());
            wartoscRobocizny+=Integer.parseInt(tabelaCzynnosci.getValueAt(i, 2).toString());
            this.marzaRobocizny=Integer.parseInt(marzaRobocizny);
            this.marzaCzesci=Integer.parseInt(marzaCzesci);
            zakonczenieCzynnosci=tabelaCzynnosci.getValueAt(i, 5).toString();
             
        

SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
              data = formater.parse(zakonczenieCzynnosci);
            zakonczenieCzynnosciLong = data.getTime();
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
                    if(zakonczenieCzynnosciLong>temp){
                        temp=zakonczenieCzynnosciLong;

                    }
        
        
                    
                                ostatniaData = formater.format(temp);
                    
                    
                    
                    
        }
          suma=(wartoscCzesci*this.marzaCzesci) + (wartoscRobocizny*this.marzaRobocizny);  
            
          
          
          model.addRow(new Object[]{
              iloscCzynnosci,
              wartoscCzesci,
              wartoscRobocizny,
              this.marzaCzesci,
              this.marzaRobocizny,
              suma,
                ostatniaData             
             });
            
         
    }
   
}
