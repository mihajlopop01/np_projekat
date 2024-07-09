/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import domen.OpstiDomenskiObjekat;
import domen.Termin;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo Popovic
 */
public class IzmenaTerminaTableModel extends AbstractTableModel{

    private List<OpstiDomenskiObjekat> termini;

    public IzmenaTerminaTableModel(List<OpstiDomenskiObjekat> termini) {
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
        return 3;
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
                    
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns={"Vreme", "Datum", "Frizer"};
        return columns[column];
    }
    
}

