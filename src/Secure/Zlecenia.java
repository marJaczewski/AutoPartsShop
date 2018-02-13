/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

 import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.util.*;
 import java.util.Date;
import java.util.List;
 import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import java.util.Date;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
 


/**
 *
 * @author Mariusz Jaczewski
 */
public class Zlecenia extends javax.swing.JFrame {

    int modelid;
    int wlascicielId;
    int autoId;
    
    ArrayList<ArrayList<CzescSerwisowa>> listaCzesciWszystkichCzynnosci = new ArrayList<ArrayList<CzescSerwisowa>>();
    
        int   idKlient, idZlecenia;
    int numer;
    //private Object reklamacja;
    //private Object reklamacja1;
   Reklamacja  reklamacja1=new Reklamacja();
    
    
    
    public void setWlascicielId(int wlaścicielId){
        this.wlascicielId=wlaścicielId;
     }
    
    public int getWlascicielId(){
        return this.wlascicielId;
            }
    
     public void setAutoId(int autoId){
        this.autoId=autoId;
     }
    
    public int getAutoId(){
        return this.autoId;
            }
    
               
    public void setModelid(int modelid){
        this.modelid = modelid;
    }
    
    
    public int getModelid(){
        return this.modelid;
    }
    
    
    public void setidKlient(int idKlient){
        this.idKlient =idKlient ;
    }
    
    
    public int getidKlient(){
        return this.idKlient;
    }
    
    public void setidZlecenia(int idZlecenia){
        this.idZlecenia =idZlecenia ;
    }
    
    
    public int getidZlecenia(){
        return this.idZlecenia;
    }
    
     public void setNumer(int numer){
        this.numer=numer ;
    }
    
    
    public int getNumer(){
        return this.numer;
    }
    /**
     * Creates new form Zlecenia
     */
    
    public void setDostepneCS(){
        
                
          DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
         System.err.println( "Model ID w Zlecenia "+modelid);
  
       
    
Connection conn=null;
conn = MysqlConnect.ConnectDB();
PreparedStatement ps=null;
ResultSet rset;



//zapytanie do wyjecia danych odnośnie czynnosci serwisowej + sumaryczny koszt czesci
 

String Sql3="select   `ID_DEFINICJACS`,  definicjacs.nazwa ,`kosztrobocizny`,`orientacyjnyczastrwania`, model.id_model  , sum(IFNULL( definicjaczesci.cena,0))as kosztczesci \n" +
"from model JOIN definicjacs_has_model\n" +
"on model.id_model=definicjacs_has_model.MODEL_id_model\n" +
"join definicjacs\n" +
"on definicjacs.ID_DEFINICJACS=definicjacs_has_model.DEFINICJACS_ID_DEFINICJACS\n" +
"left join definicjacs_has_definicjaczesci\n" +
"on definicjacs.ID_DEFINICJACS=definicjacs_has_definicjaczesci.DEFINICJACS_ID_DEFINICJACS\n" +
"left join definicjaczesci\n" +
"on definicjacs_has_definicjaczesci.DEFINICJACZESCI_id_definicjaczesci=definicjaczesci.id_definicjaczesci\n" +
"group by definicjacs.ID_DEFINICJACS\n" +
"\n" +
"having model.id_model="+modelid;


    try{
ps = conn.prepareStatement(Sql3);
rset=ps.executeQuery();



                while(rset.next()==true){
                  
                     //zapytanie do wyjecia sumy cześci zamiennych potrzebnych do wykonania danej czynnosci serwisowej
  
                                model.addRow(new Object[]{rset.getString("ID_DEFINICJACS"),rset.getString("nazwa"),rset.getString("kosztrobocizny"),rset.getString("kosztczesci"),rset.getString("orientacyjnyczastrwania") });
                
                }
}
catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}
   
        
        
    }
     
    
     public void setZleceniaWyk(){
        DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
         System.err.println( "Model ID w Zlecenia "+modelid);
       
        
         System.err.println( "numer rej "+numer);
         
         
 Connection conn1=null;
conn1 = MysqlConnect.ConnectDB();
PreparedStatement ps1=null;
ResultSet rset1;
String Sql4="select zlecenie.id_zlecenie, zlecenie.data_przyjecia, zlecenie.wartosc from zlecenie left join auto on id_auto=AUTO_id_auto where auto.id_auto="+numer;
      
    try{
ps1 = conn1.prepareStatement(Sql4);
rset1=ps1.executeQuery();



                while(rset1.next()==true){
                  
                     //zapytanie do wyjecia sumy cześci zamiennych potrzebnych do wykonania danej czynnosci serwisowej
  
                                model1.addRow(new Object[]{
                                    rset1.getString(1),
                                    rset1.getString(2),
                                    rset1.getString(3) });
                
                }
}
catch(Exception e){
 JOptionPane.showMessageDialog(null, e);
}  
    }
    
    
    
    
    public Zlecenia() {
         initComponents();
          this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //wstawianie dosteepnych czynnosci serwisowych do tabeli 
         //.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jButton9 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jButton9.setText("Wyswietl na konsoli");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id zlecnenia", "Data przyjecia", "Wartość"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Historia zleceń:");

        jButton5.setText("Zgłoś reklamację");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText(".");

        jButton3.setText("Anuluj");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText("Zatwierdź");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nazwa", "Koszt robocizny", "Koszt części", "Rozpoczęcie", "Zakończenie", "Dostępność części", "Id Stanowiska", "Id Mechanika"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Wybrane czynności serwisowe:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nazwa", "Koszt robocizny", "Koszt części", "Czas trwania"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Nazwa");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Cena");
            jTable2.getColumnModel().getColumn(4).setHeaderValue("Czas trwania");
        }

        jLabel3.setText("Czynności serwisowe dostępne dla wybranego modelu:");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id definficji części", "Nazwa", "Cena", "Dostępność", "Numer magazynowy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dostępność"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dostępność"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable7);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Preferowany czas zlecenia:");

        jButton8.setText("Usuń");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel6.setText("Mechanik:");

        jLabel7.setText("Wymagane stanowisko:");

        jLabel8.setText("Wymagane części:");

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ilość czynności", "Wartość części", "Wartość robocizny", "Marża części", "Marża robocizny", "Suma", "Zakończenie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable8);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel10.setText("Utwórz nowe zlecenie:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        jLabel9.setText("yyyy-mm-dd hh:mm:ss");

        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(213, 213, 213))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5))))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(27, 27, 27)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        boolean podwojnie=true;
        
       // dodawanie zleceń po kliknieciu
        JOptionPane pane = new JOptionPane();
       
          DefaultTableModel model=(DefaultTableModel) jTable4.getModel();
          DefaultTableModel model5=(DefaultTableModel) jTable5.getModel();
          DefaultTableModel modelMechanik=(DefaultTableModel) jTable6.getModel();
          DefaultTableModel modelStanowisko=(DefaultTableModel) jTable7.getModel();
         
          model5.setRowCount(0);
          modelMechanik.setRowCount(0);
          modelStanowisko.setRowCount(0);
          
        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
public void valueChanged(ListSelectionEvent e) {
    
    if (!e.getValueIsAdjusting() && jTable2.getSelectedRow() != -1)
           // System.out.println("klik");
            System.out.println(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        }
    });
    int idDCS= Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString() );
          System.err.println("Zaznaczona def.czynnosc: "+idDCS);
      
        for(int i =0; i<model.getRowCount();i++){
            if(Integer.parseInt(jTable4.getValueAt(i, 0).toString())==idDCS){
                
                
        int reply = JOptionPane.showConfirmDialog(null, "Czy napewno chcesz dodać powtórnie tę samą czynność serwisową?", "Błąd", JOptionPane.YES_NO_OPTION);
                     if (reply == JOptionPane.YES_OPTION) {
                         podwojnie=true;
                        break;
                    }
                    else {
                       
                        podwojnie=false;
                          break;
                    }
        }
          
                 
                 
            }
            
         
        
        
        if(podwojnie==true){
      Connection conn=null;
      PreparedStatement ps=null;
      ResultSet rs;
      PreparedStatement ps4=null;
      ResultSet rs4=null;
      conn = MysqlConnect.ConnectDB();
      
      // wyjecie czesci do naprawy i konkretnych cześci
      String Sql="  SELECT DISTINCT definicjaczesci.id_definicjaczesci,  definicjaczesci.nazwa, definicjaczesci.cena,   egzeplarzczesci.CZYNNOSCSERWISOWA_id_czynnoscserwisowa  \n" +
"from definicjacs\n" +
"  JOIN definicjacs_has_definicjaczesci\n" +
"on definicjacs.ID_DEFINICJACS=definicjacs_has_definicjaczesci.DEFINICJACS_ID_DEFINICJACS\n" +
" JOIN definicjaczesci\n" +
"ON definicjacs_has_definicjaczesci.DEFINICJACZESCI_id_definicjaczesci=definicjaczesci.id_definicjaczesci\n" +
"join egzeplarzczesci\n" +
"on egzeplarzczesci.DEFINICJACZESCI_id_definicjaczesci=definicjaczesci.id_definicjaczesci\n" +
"\n" +
"where definicjacs.ID_DEFINICJACS=?";
    
      String Sql6="SELECT  egzeplarzczesci.id_egzeplarzczesc\n" +
"FROM egzeplarzczesci \n" +
"join definicjaczesci on egzeplarzczesci.DEFINICJACZESCI_id_definicjaczesci=definicjaczesci.id_definicjaczesci\n" +
"where egzeplarzczesci.CZYNNOSCSERWISOWA_id_czynnoscserwisowa IS NULL && egzeplarzczesci.DEFINICJACZESCI_id_definicjaczesci=?";
       ArrayList<CzescSerwisowa> listaCzesciPojedynczejCzynnosci = new ArrayList<CzescSerwisowa>();
         System.out.println("test przed wszystkie 1043");
      
            try {
                ps = conn.prepareStatement(Sql);
                String dostepnosc;
                int idEgzemplarzCzesci = 0;

                ps.setInt(1, idDCS);
                rs = ps.executeQuery();

                while (rs.next()) {
                      
                    if (rs.getString(4) == null) {
                        dostepnosc = "dostepny";
 System.out.println("dostepnosc po  while1: "+dostepnosc);
                        ps4 = conn.prepareStatement(Sql6);

                        ps4.setInt(1, rs.getInt(1));
                     
                        rs4 = ps4.executeQuery();

                        while (rs4.next()) {
                            
                            idEgzemplarzCzesci = rs4.getInt(1);
                        }
  
                        model5.addRow(new Object[]{
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            dostepnosc,
                            idEgzemplarzCzesci

                        });
                System.out.println("test przed if 768");           
if(idEgzemplarzCzesci!=0){
     System.out.println("test po if 770");
                        CzescSerwisowa kolejnaCzesc = new CzescSerwisowa();
                        kolejnaCzesc.idCzynnoscSerwisowa = idDCS;
                        kolejnaCzesc.idEgzeplarzCzesci = idEgzemplarzCzesci;

                        listaCzesciPojedynczejCzynnosci.add(kolejnaCzesc);}

                    } else {
                       
                        dostepnosc = "nie dostepny";

                        model5.addRow(new Object[]{
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            dostepnosc,
                            "brak"
                        });
                         
                    }

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }

      
      listaCzesciWszystkichCzynnosci.add(listaCzesciPojedynczejCzynnosci);
      
      // zajęcie wybranych wcześniej egzeplarzyCzesci 
      
      
      
     String Sql8=null;
     int idEgzeplarz=0;
      
       
      for(int i =0; i<model5.getRowCount();i++){
                            if(listaCzesciPojedynczejCzynnosci.isEmpty()==false){                                               //<-dosc istatny szczegół
                            idEgzeplarz=listaCzesciPojedynczejCzynnosci.get(i).idEgzeplarzCzesci;

          Sql8="UPDATE `egzeplarzczesci` SET  `CZYNNOSCSERWISOWA_id_czynnoscserwisowa`=  "+idDCS+"  \n" +
"WHERE egzeplarzczesci.id_egzeplarzczesc="+idEgzeplarz;
          
          try{
              Statement statem=conn.createStatement();
              statem.executeUpdate(Sql8);
              statem.close();
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, e);
              
          }
          
          }
      }
      
      
      
      
     // sprawdzenie dostepnosci mechanika
         //wyciagniecie, jaka specka mechanika jest potrzebna
        
      PreparedStatement ps2=null;
      ResultSet rs2;
      conn= MysqlConnect.ConnectDB();
      String Sql2=" select mechanik.id_mechanik , specjalizacjamechanika.id_specjalizacjamechanika\n" +
"from definicjacs\n" +
"JOIN specjalizacjamechanika on definicjacs.SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika=specjalizacjamechanika.id_specjalizacjamechanika\n" +
"join mechanik on mechanik.SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika=specjalizacjamechanika.id_specjalizacjamechanika\n" +
"where definicjacs.ID_DEFINICJACS=?";
      
      int ileMechanikow=0;
      
      try{
          ps2=conn.prepareStatement(Sql2);
        
            ps2.setInt(1,idDCS);
            rs2=ps2.executeQuery();
          String dostepnosc;
              
          
           while(rs2.next()){
              ileMechanikow++; 
               
             modelMechanik.addRow(new Object[]{
                 rs2.getString(1),
               
             }); 
           }
                
      }catch(Exception e){
      
      JOptionPane.showMessageDialog(null, e);
      }
     
     
     // wydobycie okresow zajetosci mechaników o odpowiedniej specjalnosci
    
     
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date teraz = new Date();
System.out.println(dateFormat.format(teraz)); 
     
     String terazString=dateFormat.format(teraz).toString();
 System.out.println("Teraz jest(string)"+terazString);     
      
PreparedStatement ps3 =null;
ResultSet rs3=null;
conn=MysqlConnect.ConnectDB();

//sprawdzenie czy zlecenie na teraz, czy na KONKTERNA date


String wymogCzasowy;
wymogCzasowy=jTextField2.getText();
if(wymogCzasowy.length()==0){
    wymogCzasowy=terazString;}
 //wymogCzasowy="2017-06-27 12:17:12";
System.out.println("Wybrana defincjaCS"+idDCS);  
System.out.println("Wymog czasowy"+wymogCzasowy); 
String Sql4="SELECT dostepnoscmechanika.id_dostepnoscmechanika,   dostepnoscmechanika.poczatek, dostepnoscmechanika.koniec, dostepnoscmechanika.id_mechanik ,ADDDATE( '"+wymogCzasowy+"', INTERVAL definicjacs.orientacyjnyczastrwania*60 MINUTE_SECOND) AS koniecnaprawy, definicjacs.orientacyjnyczastrwania   \n" +
"FROM definicjacs\n" +
"left JOIN specjalizacjamechanika on definicjacs.SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika=specjalizacjamechanika.id_specjalizacjamechanika\n" +
"left JOIN mechanik on mechanik.SPECJALIZACJAMECHANIKA_id_specjalizacjamechanika=specjalizacjamechanika.id_specjalizacjamechanika\n" +
"left JOIN dostepnoscmechanika on dostepnoscmechanika.id_mechanik=mechanik.id_mechanik\n" +
"where definicjacs.ID_DEFINICJACS=? && dostepnoscmechanika.koniec>  ADDDATE( '"+wymogCzasowy+"', INTERVAL definicjacs.orientacyjnyczastrwania*60 MINUTE_SECOND)         ORDER BY dostepnoscmechanika.koniec ASC  LIMIT 1";
//2017-06-22 18:23:40



  


int idDostepnosc=0;
String poczatek=null;
String koniec=null;
int idMechanik=0;
String koniecNaprawy=null;
long oczekiwanyCzasNaprawy=0;
// wybranie pierwszego najbardzeiej pasującego zlecenia

try{
    ps3=conn.prepareStatement(Sql4);
    ps3.setInt(1, idDCS);
     
    
     rs3=ps3.executeQuery();
 
    
    while(rs3.next()){
          idDostepnosc=rs3.getInt(1);
  poczatek=rs3.getString(2);
  koniec=rs3.getString(3);
  idMechanik=rs3.getInt(4);
  koniecNaprawy=rs3.getString(5);
  oczekiwanyCzasNaprawy=rs3.getInt(6);
 System.out.println("Id_Dostepnosc: "+idDostepnosc +" poczatek: "+ poczatek +" koniec: "+koniec+" IdMechanik: "+idMechanik+" koniecNaprawy: "+koniecNaprawy);
       
    }
    
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);}


//trzeba sprawdzić czy trafilismy w srodek okresu dostepnosci czy nie
long wymogCzasowyLong=0;
long poczatekLong=0;
   
      
     



Date d=null ;
 Date d2=null;
 
 
 System.out.println("Teraz jest(string)"+terazString);     
 
try {
    d = dateFormat.parse(wymogCzasowy);
     wymogCzasowyLong = d.getTime();
      d2 = dateFormat.parse(poczatek);
     poczatekLong = d2.getTime(); 
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

long poczatekNowejDostepnosci=poczatekLong+oczekiwanyCzasNaprawy*1000*60;////ok
 
 Date poczatekNowejDostepnosciDate = new Date(poczatekNowejDostepnosci );//* 1000
 String poczatekNowejDostepnosciString =dateFormat.format(poczatekNowejDostepnosciDate ).toString();
 String wymogCzasowyString =dateFormat.format(d).toString();
String poczatek2=dateFormat.format(d2).toString();
 
     

  System.out.println("WymogCzasowy: "+wymogCzasowyString);
        System.out.println("Znaleziony poczatek okresu dostepnosci "+poczatek2);
 System.out.println("Znaleziony poczatek okresu Nowej dostepnosci "+poczatekNowejDostepnosciString);
boolean wSrodkuOkresuDostepnosci=true;


if(wymogCzasowyLong>poczatekLong){
wSrodkuOkresuDostepnosci=true;}
else{wSrodkuOkresuDostepnosci=false;}


//modyfikacja zakresu dostepnosci:1.usuniecie i wstawienie dwoch nowych przedziłów
 
conn=MysqlConnect.ConnectDB();
try{
    Statement smt=conn.createStatement();
    
    
    if(wSrodkuOkresuDostepnosci==true){
        System.out.println("Wewnatrz okresu dost.");
        smt.executeUpdate("DELETE FROM `dostepnoscmechanika` WHERE dostepnoscmechanika.id_dostepnoscmechanika="+idDostepnosc);
     smt.executeUpdate("INSERT INTO `dostepnoscmechanika`(`poczatek`, `koniec`, `id_mechanik`) VALUES ('"+ poczatek +"','"+wymogCzasowy+"',"+idMechanik+ " ) ");      
  smt.executeUpdate("INSERT INTO `dostepnoscmechanika`(`poczatek`, `koniec`, `id_mechanik`) VALUES ('"+ koniecNaprawy+"','"+koniec+"',"+idMechanik+ " ) ");      
  
  System.out.println("******************************** " );
   System.out.println("Usuwam rekord dostepnosci: "+ idDostepnosc+"Wstawiam rekord: poczatek: "+poczatek+" , koniec: "+wymogCzasowy +"idMechanika: "+idMechanik);
   System.out.println( "Wstawiam rekord: poczatek: "+koniecNaprawy+" , koniec: "+koniec+ "idMechanika: "+idMechanik);
      System.out.println("******************************** " );
    }
    else{
          System.out.println("Poza okresem dost.");
      smt.executeUpdate("DELETE FROM `dostepnoscmechanika` WHERE dostepnoscmechanika.id_dostepnoscmechanika="+idDostepnosc);
       smt.executeUpdate("INSERT INTO `dostepnoscmechanika`(`poczatek`, `koniec`, `id_mechanik`) VALUES ('"+ poczatekNowejDostepnosciString+"','"+koniec+"',"+idMechanik+ " ) ");  
      
    System.out.println("******************************** " );   
  System.out.println("Usuwam rekord dostepnosci: "+ idDostepnosc+"Wstawiam rekord: poczatek: "+poczatekNowejDostepnosciString+" , koniec: "+koniec +"idMechanika: "+idMechanik);
    System.out.println("******************************** " ); 
    }
          smt.close();
     
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    
}
 
// wstawienie do tabeli z wybranymi czynnościami serwisowymi  czau rozpoczesia i zakończenia
            String rozpoczecie = null;
            String zakonczenie = null;

            if (wSrodkuOkresuDostepnosci == true) {
                rozpoczecie = wymogCzasowy;
                zakonczenie = koniecNaprawy;
            } else {
                rozpoczecie = poczatek;
                zakonczenie = poczatekNowejDostepnosciString;
            }

            int iloscNiedostepnych = 0;
            String dostepneCzesci = null;
            String dostepneStanowisko = Integer.toString(idMechanik);

            modelStanowisko.addRow(new Object[]{
                dostepneStanowisko,
                "Dostępne"

            });
 
            for (int i = 0; i < jTable5.getRowCount(); i++) {
                if (jTable5.getValueAt(i, 3).toString() != "dostepny") {
                    iloscNiedostepnych++;
                }
            }

          
            
            if (iloscNiedostepnych == 0) {
                dostepneCzesci = "Wszystkie dostepne";
            } else {
                dostepneCzesci = "Brak " + iloscNiedostepnych + " egzemplarzy";
            }

            model.addRow(new Object[]{
                jTable2.getValueAt(jTable2.getSelectedRow(), 0),
                jTable2.getValueAt(jTable2.getSelectedRow(), 1),
                jTable2.getValueAt(jTable2.getSelectedRow(), 2),
                jTable2.getValueAt(jTable2.getSelectedRow(), 3),
                //  jTable2.getValueAt(jTable2.getSelectedRow(), 4)
                rozpoczecie,
                zakonczenie,
                dostepneCzesci,
                jTable7.getValueAt(0, 0),
                idMechanik

            });

        }

      AktualizacjaPodsumowania aktualizator = new AktualizacjaPodsumowania();
      aktualizator.aktualizujPodsumowanie(jTable4, jTable8, "1", "2");





 
   
        
       
        
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        
         JOptionPane pane = new JOptionPane();
        
        
                    
                if (model.getRowCount()==0) { 
                   
                JOptionPane.showMessageDialog(null , "Wybierz czynności serwisowe!" );
                 }
                    else{
                                    int reply = JOptionPane.showConfirmDialog(null, "Czy napewno chcesz dodać nowe zlecenie?", "Ostrzeżenie!", JOptionPane.YES_NO_OPTION);
                    
                                    if (reply == JOptionPane.YES_OPTION) {
                               
                                 
                                        
                         
                                   int maxZlecenieId=0;
                         
                         //znlaezienie zlecenia  o największym id w bazie
                                        Connection conn=null;
                                        PreparedStatement ps=null;
                                        ResultSet rs;
                                         conn=MysqlConnect.ConnectDB();
                                        
                                        String Sql="SELECT    MAX(zlecenie.id_zlecenie)   FROM `zlecenie` WHERE 1";
                                         
                                       
                                        try{
                                            ps=conn.prepareStatement(Sql);
                                            rs=ps.executeQuery();
                                            
                                            while(rs.next()){
                                            maxZlecenieId=rs.getInt(1);
                                             System.out.println("(1112)maxZlecenieId"+maxZlecenieId );
                                            }
                                        }catch(Exception e){
                                            JOptionPane.showMessageDialog(null, e);
                                        }

                         //wstawienie nowego zlecenia o id = maxZlecenieId+1
                         int noweZlecenieId=maxZlecenieId+1;
                         float wartosc = Float.parseFloat(jTable8.getValueAt(0, 5).toString());
                         float marza=0;   
                         System.out.println("(1129)Wartosc: "+wartosc);
                        
                        //_________________________________________________________________________________________________diagnoza do zmiany_______________________________                
                                         
                                         String Sql2="INSERT INTO `zlecenie`\n" +
                                                        "(`data_przyjecia`, `data_zakonczenia`, `wartosc`, `marza`,\n" +
                                                        " `id_zlecenie`, `REKLAMACJA_id_reklamacja`, `AUTO_id_auto`,\n" +
                                                        " `DIAGNOZA_id_diagnoza`, `WLASCICIEL_id_wlasciciel`) \n" +
                                                        " VALUES \n" +
                                                        "(NOW(), null,"+wartosc+","+marza+","+ noweZlecenieId+", null,"+this.getAutoId()+", null  ,"+this.getWlascicielId()+"  )";
                                         System.out.println(Sql2);
                                         
                                         Connection conn2=null;
                                         conn2=MysqlConnect.ConnectDB();
                                         
                                         try{
                                             Statement smt=conn.createStatement();
                                             smt.executeUpdate(Sql2);
                                             smt.close();
                                             }catch(Exception e){
                                                 JOptionPane.showMessageDialog(null, e);
                                                 
                                             }

                        // wstawienei wybranych definicji czynnosci serwisowych
                        
                                       // DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                                            String Sql3=null;
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                        for(int i =0; i<model.getRowCount();i++){
                                            
                                            Sql3="INSERT INTO `czynnoscserwisowa`( "+
                                                    "`data_rozpoczecia`, `data_zakonczenia`, `ZLECENIE_id_zlecenie`,\n" +
                                                    "`DEFINICJACS_ID_DEFINICJACS`, `MECHANIK_id_mechanik`, `STANOWISKO_id_stanowisko`)\n" +
                                                    "VALUES\n" +
                                                    "(NOW(), null,"+noweZlecenieId +","+jTable4.getValueAt(i, 0)+","+jTable4.getValueAt(i,8)+ ","+jTable4.getValueAt(i, 7)+" )";
                                            try{
                                                Statement smt2=conn2.createStatement();
                                                smt2.executeUpdate(Sql3);
                                                
                                            }catch(Exception e){
                                                JOptionPane.showMessageDialog(null, e);
                                              }  
                                            } 

                                            this.dispose();
                                    
                                        }  
                                      
                         
                   
                   }
                   
                     
         
                          
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
     DefaultTableModel model4=(DefaultTableModel) jTable4.getModel();    
        
    if(model4.getRowCount()==0){
   
    DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
    model1.setRowCount(0);
    
    DefaultTableModel model2=(DefaultTableModel) jTable2.getModel();
    model2.setRowCount(0);
     
    
    DefaultTableModel model5=(DefaultTableModel) jTable5.getModel();
    model5.setRowCount(0);
    
    DefaultTableModel model6=(DefaultTableModel) jTable6.getModel();
    model6.setRowCount(0);
    
    DefaultTableModel model7=(DefaultTableModel) jTable7.getModel();
    model7.setRowCount(0);
    
    this.dispose();
    }
    else{
    JOptionPane.showMessageDialog(rootPane, "Najpierw usuń wybrane czynności serwisowe"  );
        
        
    }
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(jTable1.getSelectedRow()!=-1){
          int idZlecenia=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
          System.err.println("Id zlecenia :"+idZlecenia);
           
         
         reklamacja1.setVisible(true);
         reklamacja1.setidZlecenia(idZlecenia);
         reklamacja1.wpiszDane();
         
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
//Usuwanie czynności serwisowych 
 if(jTable4.getSelectedRow()!=-1){
           DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
         
        jTable4.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
public void valueChanged(ListSelectionEvent e) {
    
    if (!e.getValueIsAdjusting() && jTable4.getSelectedRow() != -1)
           // System.out.println("klik");
            System.out.println(jTable4.getValueAt(jTable4.getSelectedRow(), 0).toString());
        }
    });
             
        
        
        
        
        String poczatekPierwszej=null;
        String koniecPierwszej=null;
        int idPierwszej=0;
        
        String poczatekDrugiej=null;
        String koniecDrugiej=null;
        int idDrugiej=0;
        String wartoscPoczatku=jTable4.getValueAt(jTable4.getSelectedRow(),4).toString();
        System.out.println("1040Wartosc poczatku: "+wartoscPoczatku);
        
       String wartoscKonca=jTable4.getValueAt(jTable4.getSelectedRow(),5).toString();
        System.out.println("1043Wartosc konca: "+wartoscKonca);
       
         String wartoscIdMechanika=jTable4.getValueAt(jTable4.getSelectedRow(),8).toString();
        System.out.println(wartoscIdMechanika);
        
        System.out.println("1048SELECT `id_dostepnoscmechanika`, `poczatek`, `koniec`   FROM `dostepnoscmechanika` WHERE koniec = '"+wartoscPoczatku+" ' && id_mechanik="+wartoscIdMechanika);
       
        //wartoscKonca="2017-06-27 16:00:00";              //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
         boolean znaleziony1= false;
         boolean znaleziony2= false;
        
        
        Connection conn4=null;
        PreparedStatement ps=null;
        ResultSet rs;
        conn4 =MysqlConnect.ConnectDB();
        String Sql="SELECT `id_dostepnoscmechanika`, `poczatek`, `koniec`   FROM `dostepnoscmechanika` WHERE koniec = '"+wartoscPoczatku+" ' && id_mechanik="+wartoscIdMechanika;
         
        try{
            ps=conn4.prepareStatement(Sql);
             
            rs=ps.executeQuery();
         
            while(rs.next())
            {
                 idPierwszej=rs.getInt(1);
                  poczatekPierwszej=rs.getString(2);
                  koniecPierwszej=rs.getString(3);
                 System.out.println("IdPierwszej:"+idPierwszej);
                 System.out.println("PoczatekPierwszej:"+poczatekPierwszej);
                 System.out.println("KoniecPierwszej:"+koniecPierwszej);
 znaleziony1= true;
                 
           }   
        }catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
            System.out.println("Nie znaleziono 1 ");
           
        }
        
     
           PreparedStatement ps2=null;
        ResultSet rs2;
        conn4 =MysqlConnect.ConnectDB();
        System.out.println("1083SELECT `id_dostepnoscmechanika`, `poczatek`, `koniec`   FROM `dostepnoscmechanika` WHERE poczatek = '"+wartoscKonca+"' && id_mechanik="+wartoscIdMechanika);
       
        String Sql2="SELECT `id_dostepnoscmechanika`, `poczatek`, `koniec`   FROM `dostepnoscmechanika` WHERE poczatek = '"+wartoscKonca+"' && id_mechanik="+wartoscIdMechanika;
         
        try{
            ps2=conn4.prepareStatement(Sql2);
            
            
          //  ps2.setInt(1,Integer.parseInt(jTable4.getValueAt(jTable6.getSelectedRow(), 8 ).toString()));
            rs2=ps2.executeQuery();
         
            while(rs2.next()){
                  idDrugiej=rs2.getInt(1);
                  poczatekDrugiej=rs2.getString(2);
                  koniecDrugiej=rs2.getString(3);
                 System.out.println("IdDrugiej:"+idDrugiej);
                 System.out.println("PoczatekDrugiej:"+poczatekDrugiej);
                 System.out.println("KoniecDrugiej:"+koniecDrugiej);
 
              znaleziony2= true;     
                  
           }   
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
            System.out.println("Nie znaleziono 2 ");
           
        }
        
        /* */
        System.out.println("(1107)Znaleziono Pierwsza:poczatek: "+poczatekPierwszej+"koniec"+koniecPierwszej+" o id: "+idPierwszej);
        System.out.println("(1108)Znaleziono Druga:poczatek: "+poczatekDrugiej+"koniec"+koniecDrugiej+" o id: "+idDrugiej); 
        
   System.out.println("Znaleziony1: "+znaleziony1);
   System.out.println("Znaleziony2: "+znaleziony2);
        
       conn4=MysqlConnect.ConnectDB();
try{
    Statement smt2=conn4.createStatement();    
        if(znaleziony1==true&&znaleziony2==true){
           smt2.executeUpdate("DELETE FROM `dostepnoscmechanika` WHERE dostepnoscmechanika.id_dostepnoscmechanika="+idPierwszej);
           smt2.executeUpdate("DELETE FROM `dostepnoscmechanika` WHERE dostepnoscmechanika.id_dostepnoscmechanika="+idDrugiej);
           smt2.executeUpdate("INSERT INTO `dostepnoscmechanika`(`poczatek`, `koniec`, `id_mechanik`) VALUES ('"+ poczatekPierwszej +"','"+koniecDrugiej+"',"+wartoscIdMechanika+ " ) "); 
       System.out.println("_______________________________ " );
       System.out.println( "1Wstawiam rekord: poczatek: "+poczatekPierwszej+" , koniec: "+koniecDrugiej+ "idMechanika: "+wartoscIdMechanika);
       System.out.println("_____________________________" );
        
        }
        else if(znaleziony1==false&&znaleziony2==false){
           smt2.executeUpdate("INSERT INTO `dostepnoscmechanika`(`poczatek`, `koniec`, `id_mechanik`) VALUES ('"+ wartoscPoczatku+"','"+wartoscKonca+"',"+wartoscIdMechanika+ " ) ");  
        System.out.println("_______________________________ " );
        System.out.println( "2Wstawiam rekord: poczatek: "+wartoscPoczatku+" , koniec: "+wartoscKonca+ "idMechanika: "+wartoscIdMechanika);
        System.out.println("_____________________________" );
        
        }    
          else if(znaleziony1==false&&znaleziony2==true)  {  
           smt2.executeUpdate("DELETE FROM `dostepnoscmechanika` WHERE dostepnoscmechanika.id_dostepnoscmechanika="+idDrugiej);
           smt2.executeUpdate("INSERT INTO `dostepnoscmechanika`(`poczatek`, `koniec`, `id_mechanik`) VALUES ('"+ wartoscPoczatku +"','"+koniecDrugiej+"',"+wartoscIdMechanika+ " ) ");      
        System.out.println("_______________________________ " );
        System.out.println( "3Wstawiam rekord: poczatek: "+wartoscPoczatku+" , koniec: "+koniecDrugiej+ "idMechanika: "+wartoscIdMechanika);
        System.out.println("_____________________________" );
               
          }
        else if(znaleziony1==true&&znaleziony2==false)  {  
          // smt2.executeUpdate("DELETE FROM `dostepnoscmechanika` WHERE dostepnoscmechanika.id_dostepnoscmechanika="+idPierwszej);
          // smt2.executeUpdate("INSERT INTO `dostepnoscmechanika`(`poczatek`, `koniec`, `id_mechanik`) VALUES ('"+ poczatekPierwszej +"','"+wartoscKonca+"',"+wartoscIdMechanika+ " ) ");      
        System.out.println("_______________________________ " );
        System.out.println( "4Wstawiam rekord: poczatek: "+poczatekPierwszej+" , koniec: "+wartoscKonca+ "idMechanika: "+wartoscIdMechanika);
        System.out.println("_____________________________" );
              
            
        }
          smt2.close();
     
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    
}
            
            
        
        







 
 //  null-owanie pola id_czynnoscSerwisowa egzemplarzyCzesci, z których rezygnyjemy
 
 String Sql8=null;
     int idEgzeplarz;
      Connection conn5=null;
    DefaultTableModel modelTab4=(DefaultTableModel) jTable4.getModel();
       int wierszDoUsuniecia=jTable4.getSelectedRow(); 
       System.out.println("Zaznaczony wiersz: "+wierszDoUsuniecia);
     //   System.out.println("Ilosc elem glownej"+listaCzesciWszystkichCzynnosci.size());
      
         
        
          System.out.println("test"); 
   conn5=MysqlConnect.ConnectDB(); 
  
   for(int i =0; i<listaCzesciWszystkichCzynnosci.size();i++){
      for(int j =0; j<listaCzesciWszystkichCzynnosci.get(0).size();j++){  
            
          if(i==wierszDoUsuniecia)  {
          try{
           idEgzeplarz=listaCzesciWszystkichCzynnosci.get(i).get(j).idEgzeplarzCzesci;
        Sql8="UPDATE `egzeplarzczesci` SET  `CZYNNOSCSERWISOWA_id_czynnoscserwisowa`=NULL   WHERE egzeplarzczesci.id_egzeplarzczesc="+idEgzeplarz;

                        try{
                            Statement statem=conn5.createStatement() ;
                            statem.executeUpdate(Sql8);
                            statem.close();
                        }catch(Exception e){
                            System.out.println("test blad1");
                            System.out.println("idEgzeplarz: "+idEgzeplarz);
                            JOptionPane.showMessageDialog(null, e); }
          }catch(Exception e){
          System.out.println("test blad2");
          }
          }}}
          
          
     
 
       listaCzesciWszystkichCzynnosci.remove(wierszDoUsuniecia);
      
      
 ((DefaultTableModel)jTable4.getModel()).removeRow(jTable4.getSelectedRow() );
         }
 
  AktualizacjaPodsumowania aktualizator=new AktualizacjaPodsumowania();
 aktualizator.aktualizujPodsumowanie(jTable4, jTable8, "1", "2");
 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
 String wartosc=jTable4.getValueAt(jTable4.getSelectedRow(),4).toString();
        System.out.println(wartosc);
        
        
        
 //System.out.println("SELECT `id_dostepnoscmechanika`, `poczatek`, `koniec`   FROM `dostepnoscmechanika` WHERE koniec = '"+jTable4.getValueAt(jTable6.getSelectedRow(), 4 ).toString()+" ' && id_mechanik="+Integer.parseInt(jTable4.getValueAt(jTable6.getSelectedRow(), 8 ).toString()));
      





        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable8MouseClicked

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
            java.util.logging.Logger.getLogger(Zlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zlecenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zlecenia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
