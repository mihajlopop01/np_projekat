/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import controller.UIController;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Termin;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo Popovic
 */
public class OcenjivanjeSalonaTableModel extends AbstractTableModel {
    
    private List<OpstiDomenskiObjekat> termini;

    public OcenjivanjeSalonaTableModel(List<OpstiDomenskiObjekat> termini) {
        this.termini = termini;
        
    }
   
    @Override
    public int getRowCount() {
       if(termini == null) {
           return 0;
       } return termini.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Termin t = (Termin) termini.get(rowIndex);
         switch (columnIndex) {
            case 0:
                return t.getVreme();
                
            case 1:
                return t.getDatum();
            case 2:
                return t.getFrizer();
                
             case 3:
                return vratiImeSalona(t);
                    
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns={"Vreme", "Datum", "Frizer", "Salon"};
        return columns[column];
    }

    private Object vratiImeSalona(Termin t) {
        try {
            Salon s = new Salon(t.getSalon().getPib(),3);
            
            System.out.println("Salon s: "+s.getPib() + " "+ s.getWhereType());
            Salon salon = (Salon) UIController.getInstance().getOneSalon(s);
            return salon.getIme();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
    
}
