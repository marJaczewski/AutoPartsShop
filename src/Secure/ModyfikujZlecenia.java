/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

 
public class ModyfikujZlecenia extends javax.swing.JFrame {

    
    private void close() {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    int modelid,zlecenieid;
    
    
    public void setModeid(int modelid){
        this.modelid = modelid;
    }
    
    
    public int getModelid(){
        return this.modelid;
    }
    
    public void setZlecenieid(int zlecenieid){
        this.zlecenieid=zlecenieid;
    }
    public int getZlecenieid(){
        return this.zlecenieid;
    }
   public void setDostepneCS(){
        
                
          DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
         System.err.println( "Model ID w Zlecenia "+modelid);
  
       
    
Connection conn=null;
conn = MysqlConnect.ConnectDB();
PreparedStatement ps=null;
ResultSet rset;


model.setRowCount(0);

//zapytanie do wyjecia danych odnośnie czynnosci serwisowej + sumaryczny koszt czesci
 

String Sql3="  SELECT czynnoscserwisowa.id_czynnoscserwisowa , definicjacs.nazwa, czynnoscserwisowa.data_rozpoczecia, czynnoscserwisowa.data_zakonczenia, czynnoscserwisowa.MECHANIK_id_mechanik, czynnoscserwisowa.STANOWISKO_id_stanowisko\n" +
"  from czynnoscserwisowa \n" +
"  join zlecenie ON zlecenie.id_zlecenie=czynnoscserwisowa.ZLECENIE_id_zlecenie \n" +
"  join definicjacs ON definicjacs.ID_DEFINICJACS=czynnoscserwisowa.DEFINICJACS_ID_DEFINICJACS\n" +
"  where zlecenie.id_zlecenie=  "+zlecenieid;


    try{
ps = conn.prepareStatement(Sql3);
rset=ps.executeQuery();



                while(rset.next()==true){
                  
                     //zapytanie do wyjecia sumy cześci zamiennych potrzebnych do wykonania danej czynnosci serwisowej
  
                                model.addRow(new Object[]{
                                    rset.getString(1),
                                    rset.getString(2),
                                    rset.getString(3),
                                    rset.getString(4),
                                    rset.getString(5),
                                    rset.getString(6)
                                });
                
                }
}
catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}
   
        
        
    }
    public void AktualneCS(){
        
                
          DefaultTableModel model2=(DefaultTableModel) jTable2.getModel();
         System.err.println( "Model ID w Zlecenia "+modelid);
         System.err.println("Id modelu ze zlecen :"+zlecenieid);
  
       
    
Connection conn=null;
conn = MysqlConnect.ConnectDB();
PreparedStatement ps=null;
ResultSet rset;



//zapytanie do wyjecia danych odnośnie czynnosci serwisowej + sumaryczny koszt czesci
 

String Sql3="select   `ID_DEFINICJACS`,  definicjacs.nazwa ,`kosztrobocizny`,`orientacyjnyczastrwania`, model.id_model  , sum(definicjaczesci.cena)as kosztczesci\n" +
"from zlecenie JOIN czynnoscserwisowa\n" +
"on zlecenie.id_zlecenie=czynnoscserwisowa.ZLECENIE_id_zlecenie\n" +
"join definicjacs\n" +
"on czynnoscserwisowa.DEFINICJACS_ID_DEFINICJACS=definicjacs.ID_DEFINICJACS\n" +
"join definicjacs_has_model\n" +
"on definicjacs.ID_DEFINICJACS=definicjacs_has_model.DEFINICJACS_ID_DEFINICJACS\n" +
"join model\n" +
"on definicjacs_has_model.MODEL_id_model=model.id_model\n" +
"join model_has_definicjaczesci\n" +
"on model.id_model=model_has_definicjaczesci.MODEL_id_model\n" +
"join definicjaczesci\n" +     
"on model_has_definicjaczesci.DEFINICJACZESCI_id_definicjaczesci=definicjaczesci.id_definicjaczesci\n" +
"where zlecenie.id_zlecenie="+zlecenieid + " and model.id_model="+modelid+
"\n"+
"group by definicjacs.ID_DEFINICJACS\n";


    try{
ps = conn.prepareStatement(Sql3);
rset=ps.executeQuery();



                while(rset.next()==true){
                  
                     //zapytanie do wyjecia sumy cześci zamiennych potrzebnych do wykonania danej czynnosci serwisowej
  
                                model2.addRow(new Object[]{rset.getString("ID_DEFINICJACS"),rset.getString("nazwa"),rset.getString("kosztrobocizny"),rset.getString("kosztczesci"),rset.getString("orientacyjnyczastrwania") });
                
                }
}
catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}
   
        
        
    }
    public ModyfikujZlecenia() {
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

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Wyszukaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nazwa", "Data rozpoczęcia", "Data zakończenia", "Id Mechanik", "Id Stanowisko"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nazwa", "Koszt roboczy", "Koszt części", "Czas trwania", "Dostępność mechaników", "Dostępność stanowisk", "Dostępność części"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("Zatwierdź");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Anuluj");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Zakończ czynność");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(68, 68, 68)
                .addComponent(jButton3)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
  
   model.setRowCount(0);
  
        String word;
        word=jTextField1.getText();
        
        System.out.println(word);
            
Connection conn=null;

conn = MysqlConnect.ConnectDB();
PreparedStatement ps=null;
ResultSet rset;

String Sql3= "select   `ID_DEFINICJACS`,  definicjacs.nazwa ,`kosztrobocizny`,`orientacyjnyczastrwania`, model.id_model  , sum(definicjaczesci.cena)as kosztczesci\n" +
"from model JOIN definicjacs_has_model\n" +
"on model.id_model=definicjacs_has_model.MODEL_id_model\n" +
"join definicjacs\n" +
"on definicjacs.ID_DEFINICJACS=definicjacs_has_model.DEFINICJACS_ID_DEFINICJACS\n" +
"join definicjacs_has_definicjaczesci\n" +
"on definicjacs.ID_DEFINICJACS=definicjacs_has_definicjaczesci.DEFINICJACS_ID_DEFINICJACS\n" +
"join definicjaczesci\n" +
"on definicjacs_has_definicjaczesci.DEFINICJACZESCI_id_definicjaczesci=definicjaczesci.id_definicjaczesci\n" +
"group by definicjacs.ID_DEFINICJACS\n" +
"\n" +
"having model.id_model="+modelid;

        
    try{
ps = conn.prepareStatement(Sql3);
rset=ps.executeQuery();

                while(rset.next()==true){
                             Pattern pattern = Pattern.compile(word);
                             Matcher matcherId = pattern.matcher(rset.getString("ID_DEFINICJACS"));
                             Matcher matcherName = pattern.matcher(rset.getString("nazwa"));
                             Matcher matcherKosztR = pattern.matcher(rset.getString("kosztrobocizny"));
                             Matcher matcherKosztCz = pattern.matcher(rset.getString("kosztczesci"));
                             Matcher matcherCzas = pattern.matcher(rset.getString("orientacyjnyczastrwania"));
                             
                             
                            if( matcherId.find()||matcherName.find()||matcherKosztR.find()||matcherKosztCz.find()||matcherCzas.find()){ //zwraca true lub false
                           model.addRow(new Object[]{rset.getString("ID_DEFINICJACS"),rset.getString("nazwa"),rset.getString("kosztrobocizny"),rset.getString("kosztczesci"), rset.getString("orientacyjnyczastrwania") });
                }  }
}
catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}
     
        
        
        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
         
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
public void valueChanged(ListSelectionEvent e) {
    
    if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1)
           // System.out.println("klik");
            System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        }
    });
        
        model.addRow(new Object[]{
        
            jTable1.getValueAt(jTable1.getSelectedRow(), 0),
            jTable1.getValueAt(jTable1.getSelectedRow(), 1),
            jTable1.getValueAt(jTable1.getSelectedRow(), 2),
            jTable1.getValueAt(jTable1.getSelectedRow(), 3),
            jTable1.getValueAt(jTable1.getSelectedRow(), 4)
        
        });    
        
        ((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getSelectedRow() );
        
        
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
         
        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
public void valueChanged(ListSelectionEvent e) {
    
    if (!e.getValueIsAdjusting() && jTable2.getSelectedRow() != -1)
           // System.out.println("klik");
            System.out.println(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        }
    });
        
        model.addRow(new Object[]{
        
            jTable2.getValueAt(jTable2.getSelectedRow(), 0),
            jTable2.getValueAt(jTable2.getSelectedRow(), 1),
            jTable2.getValueAt(jTable2.getSelectedRow(), 2),
            jTable2.getValueAt(jTable2.getSelectedRow(), 3),
            jTable2.getValueAt(jTable2.getSelectedRow(), 4)
        
        });    
        
        ((DefaultTableModel)jTable2.getModel()).removeRow(jTable2.getSelectedRow() );
        
        
         
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
        DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
        for(int i=model.getRowCount()-1;i>=0;i--)
{
    model.removeRow(i);
}
        for(int i=model1.getRowCount()-1;i>=0;i--)
{
    model1.removeRow(i);
}
        close();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
      //pobieranieWartosci pobieraniewartosci;
        //pobieraniewartosci = new pobieranieWartosci();
        for (int i=jTable2.getRowCount()-1;i>=0;i-- ){
             
         
         int id_cz = Integer.parseInt( jTable2.getValueAt(i, 0).toString()) ;
        //int id_cz=pobieraniewartosci.pobierzId_cz(jTable2);System.err.println( id_cz);
        
            Connection conn=null;
            conn = MysqlConnect.ConnectDB();
            String Sql7="INSERT INTO `czynnoscserwisowa` (`data_rozpoczecia`,`data_zakonczenia`,`ZLECENIE_id_zlecenie`,`DEFINICJACS_ID_DEFINICJACS`,`MECHANIK_id_mechanik`,`STANOWISKO_id_stanowisko`) VALUES (0,0,"+zlecenieid+","+id_cz+",1,1)" ;

         try{

            Statement smt = conn.createStatement();
            smt.executeUpdate(Sql7);
            smt.close();


            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     if(jTable1.getSelectedRow()!=-1){
        
        DefaultTableModel modelTab1 = (DefaultTableModel)jTable1.getModel();
        
        int czynnoscDoZakonczenia=0;
        
        czynnoscDoZakonczenia=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        
        Connection conn=null;
        conn=MysqlConnect.ConnectDB();
        String Sql1= "UPDATE `czynnoscserwisowa` SET\n" +
" `data_zakonczenia`=NOW()\n" +
"WHERE czynnoscserwisowa.id_czynnoscserwisowa="+czynnoscDoZakonczenia;
        
        try{
            Statement smt=conn.createStatement();
            smt.executeUpdate(Sql1);
            smt.close();
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
     }  
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ModyfikujZlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModyfikujZlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModyfikujZlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModyfikujZlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModyfikujZlecenia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
