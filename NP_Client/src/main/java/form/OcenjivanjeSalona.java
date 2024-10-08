/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import controller.UIController;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Termin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import table_model.OcenjivanjeSalonaTableModel;

/**
 *
 * @author Mihajlo Popovic
 */
public class OcenjivanjeSalona extends javax.swing.JFrame {

    /**
     * Creates new form OcenjivanjeSalona
     */
    
    private Korisnik korisnik;
    private List<OpstiDomenskiObjekat> aktivniTermini = new ArrayList<>();
    private Termin t;
    private List<Termin> termini;
    
    public OcenjivanjeSalona(Korisnik korisnik) {
        
        initComponents();
        pnlOcena.setVisible(false);
        txtOcena.setVisible(false);
        lblOcena.setVisible(false);
        btnOceni.setVisible(false);
        this.korisnik = korisnik;
        Termin termin = new Termin();
        termin.setKorisnik(this.korisnik);
        try {
            List<OpstiDomenskiObjekat> sviTermini = UIController.getInstance().allTermini1(termin);
            for (OpstiDomenskiObjekat odo : sviTermini) {
                Termin t = (Termin) odo;
                if(t.getDatum().before(new Date())) {
                aktivniTermini.add(t);
                termini.add(t);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        populateTable(aktivniTermini);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSalon = new javax.swing.JButton();
        pnlOcena = new javax.swing.JPanel();
        lblOcena = new javax.swing.JLabel();
        txtOcena = new javax.swing.JTextField();
        btnOceni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Vasi zavrseni termini");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnSalon.setText("Oceni Salon");
        btnSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalonActionPerformed(evt);
            }
        });

        pnlOcena.setBorder(javax.swing.BorderFactory.createTitledBorder("Ocena"));

        lblOcena.setText("Ocena:");

        btnOceni.setText("Oceni");
        btnOceni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOceniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOcenaLayout = new javax.swing.GroupLayout(pnlOcena);
        pnlOcena.setLayout(pnlOcenaLayout);
        pnlOcenaLayout.setHorizontalGroup(
            pnlOcenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOcenaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblOcena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(txtOcena, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOcenaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOceni)
                .addContainerGap())
        );
        pnlOcenaLayout.setVerticalGroup(
            pnlOcenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOcenaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlOcenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOcena)
                    .addComponent(txtOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnOceni)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalon)
                                .addGap(45, 45, 45)
                                .addComponent(pnlOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(pnlOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalon)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalonActionPerformed
        // TODO add your handling code here:
        pnlOcena.setVisible(true);
        lblOcena.setVisible(true);
        txtOcena.setVisible(true);
        btnOceni.setVisible(true);
        Termin termin = new Termin();
        int row = jTable1.getSelectedRow();
        termin.setVreme((String) jTable1.getValueAt(row, 0));
        termin.setDatum((Date) jTable1.getValueAt(row, 1));
        termin.setFrizer((String) jTable1.getValueAt(row, 2));
        t = vratiTermin(aktivniTermini, termin);
        try {
            Termin selektovani = (Termin) UIController.getInstance().getOneTermin(t);
            System.out.println("Selektovani termin ocenjivanje salona: "+ selektovani.toString());
            //new IzmenaTerminaDialog(this, true, selektovani).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_btnSalonActionPerformed

    private void btnOceniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOceniActionPerformed
        // TODO add your handling code here:
        int ocena = Integer.parseInt(txtOcena.getText());
        t.setOcena(ocena);
        t.setWhereType(2);
        try {
            Termin termin = (Termin) UIController.getInstance().updateTermin(t);
            JOptionPane.showMessageDialog(this, "Uspesno ocenjen salon!");
            new KorisnikMainForm(korisnik).setVisible(true);
            dispose();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnOceniActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOceni;
    private javax.swing.JButton btnSalon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblOcena;
    private javax.swing.JPanel pnlOcena;
    private javax.swing.JTextField txtOcena;
    // End of variables declaration//GEN-END:variables

    private void populateTable(List<OpstiDomenskiObjekat> aktivniTermini1) {
        TableModel model = new OcenjivanjeSalonaTableModel(aktivniTermini);
        jTable1.setModel(model);
        
    }
    private Termin vratiTermin(List<OpstiDomenskiObjekat> aktivniTermini, Termin termin) {
        Termin t = null;
        for (OpstiDomenskiObjekat odo : aktivniTermini) {
            t = (Termin) odo;
            if (t.getVreme().equals(termin.getVreme()) && t.getDatum().equals(termin.getDatum())
                    && t.getFrizer().equals(termin.getFrizer())) {
                return t;
                //this.termin.setSalon(t.getSalon());
            }

        }
        return null;

    }
}
