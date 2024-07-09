/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_model;

import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Termin;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mihajlo Popovic
 */
public class PrikazSalonaTableModel extends AbstractTableModel {
    
    private List<OpstiDomenskiObjekat> saloni;

    public PrikazSalonaTableModel(List<OpstiDomenskiObjekat> saloni) {
        this.saloni = saloni;
    }
   
    @Override
    public int getRowCount() {
       if(saloni == null) {
           return 0;
       } return saloni.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Salon salon = (Salon)saloni.get(rowIndex);
         switch (columnIndex) {
            case 0:
                return salon.getIme();
            case 1:
                return salon.getMesto();
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns={"Naziv", "Mesto"};
        return columns[column];
    }
    
}
