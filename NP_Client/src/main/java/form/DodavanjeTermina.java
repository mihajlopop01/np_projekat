/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import controller.UIController;
import domen.Frizer;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Termin;
import domen.Usluga;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mihajlo Popovic
 */
public class DodavanjeTermina extends javax.swing.JDialog {

    /**
     * Creates new form DodavanjeTermina
     */
    private Salon salon;

    public DodavanjeTermina(VlasnikMainForm aThis, boolean par, Salon salon) {

        super(aThis, par);
        this.salon = salon;
        initComponents();
        populateTable();
        populateComboBox();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVreme = new javax.swing.JTextField();
        txtDatum = new javax.swing.JTextField();
        btnDodajTermin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbFrizer = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbUsluga = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Dodaj Termin");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Vreme");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Datum");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Frizer");

        btnDodajTermin.setText("Dodaj Termin");
        btnDodajTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajTerminActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vreme", "Datum", "Slobodan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Trenutni termini");

        jLabel6.setText("(YYYY-mm-dd)");

        jLabel7.setText("(hh:mm)");

        jLabel8.setText("Usluga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodajTermin, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbFrizer, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUsluga, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatum))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(187, 187, 187))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbUsluga, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFrizer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addComponent(btnDodajTermin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajTerminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajTerminActionPerformed
        // TODO add your handling code here:
        try {
            Termin termin = new Termin(this.salon);
            termin.setVreme(txtVreme.getText().trim());
            String dateStr = txtDatum.getText();
            System.out.println(dateStr);

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(dateStr);
                System.out.println(termin.getDatum(date));
                termin.setDatum(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            Usluga u = (Usluga)cbUsluga.getItemAt(0);
            String s = (String)u.getNaziv();
            
            switch(s) {
                case "sisanje":
                    termin.setUsluga(new Usluga(1));
                    break;
                    
                case "feniranje":
                    termin.setUsluga(new Usluga(2));    
                    break;
                    
                case "brijanje":
                    termin.setUsluga(new Usluga(3));
                    break;
                    
                case "farbanje":
                    termin.setUsluga(new Usluga(3));
                    break;
            
            }
            
            termin.setFrizer((String) cbFrizer.getSelectedItem());
            termin.setSlobodan(true);
            termin.setKorisnik(new Korisnik(1, "", "", "", ""));

            System.out.println("Termin za dodavanje: " + termin);
            if (proveriTermin(termin)) {
                OpstiDomenskiObjekat v = UIController.getInstance().zapamtiTermin(termin);
                JOptionPane.showMessageDialog(this, "Uspesno dodat termin!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Postoji termin u unetom vremenu");
                dispose();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDodajTerminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajTermin;
    private javax.swing.JComboBox<String> cbFrizer;
    private javax.swing.JComboBox<Object> cbUsluga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtVreme;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        try {
            Termin termin = new Termin();
            termin.setSalon(salon);
            List<OpstiDomenskiObjekat> slobodniTermini = UIController.getInstance().allTermini(termin);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (OpstiDomenskiObjekat odo : slobodniTermini) {
                Termin t = (Termin) odo;
                Object[] row = new Object[3];
                row[0] = t.getVreme();
                row[1] = t.getDatum();
                row[2] = t.isSlobodan();
                model.addRow(row);

            }

        } catch (Exception ex) {
            Logger.getLogger(DodavanjeTermina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean proveriTermin(Termin termin) {

        try {
            List<OpstiDomenskiObjekat> termini = UIController.getInstance().allTermini(termin);
            List<String> vremena = new ArrayList<>();
            for (OpstiDomenskiObjekat odo : termini) {
                Termin t = (Termin) odo;
                String vreme = t.getVreme();
                vremena.add(vreme);

            }
            if (vremena.contains(termin.getVreme())) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void populateComboBox() {
        Frizer frizer = new Frizer();
        frizer.setSalon(salon);
        try {
            List<OpstiDomenskiObjekat> listaFrizera = UIController.getInstance().vratiSveFrizere(frizer);
            if (listaFrizera.size() == 0 || listaFrizera == null) {
                cbFrizer.removeAllItems();
                cbFrizer.setModel(new DefaultComboBoxModel(listaFrizera.toArray()));
                cbFrizer.addItem("NEMA UBACENIH FRIZERA");

            } else {
                cbFrizer.removeAllItems();
                cbFrizer.setModel(new DefaultComboBoxModel());
                for (OpstiDomenskiObjekat odo: listaFrizera) {
                    Frizer f = (Frizer)odo;
                    cbFrizer.addItem(f.getIme());
                
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        List<Usluga> usluge = new ArrayList<>();
        usluge.add(new Usluga(1, "sisanje", "Sisanje klijenata"));
        usluge.add(new Usluga(2, "feniranje", "Feniranje kose"));
        usluge.add(new Usluga(3, "brijanje","brijanje brade"));
        usluge.add(new Usluga(4,"fabranje","farbanje kose"));
        
        
        cbUsluga.setModel(new DefaultComboBoxModel(usluge.toArray()));

    }
}
