/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.swing.table.AbstractTableModel;
import komunikacija.PrikazRadovaDTO;

/**
 *
 * @author Ognjen
 */
public class RadoviStatusiTableModel extends AbstractTableModel {

    List<PrikazRadovaDTO> radovi = new ArrayList<>();
    String[] columns = {"Profesor", "Student", "Broj Indeksa", "Godina upisa", "Status rada"};

    public RadoviStatusiTableModel(List<PrikazRadovaDTO> radovi) {
        this.radovi = radovi;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (radovi == null) {
            return 0;
        }
        return radovi.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PrikazRadovaDTO rad = radovi.get(rowIndex);
        return switch (columnIndex) {
            case 1 ->
                rad.getImeProfesora();
            case 2 ->
                rad.getImeStudenta();
            case 3 ->
                rad.getBrojIndeksa();
            case 4 ->
                rad.getGodinaUpisa();
            case 5 ->
                rad.getStatusRada();
            default ->
                null;
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PrikazRadovaDTO rad = radovi.get(rowIndex);
        switch (columnIndex) {
            case 1:
                rad.setImeProfesora((String) aValue);
                break;
            case 2:
                rad.setImeStudenta((String) aValue);
                break;
            case 3:
                rad.setBrojIndeksa((String) aValue);
                break;
            case 4:
                rad.setGodinaUpisa((Integer) aValue);
                break;
            case 5:
                rad.setStatusRada((String) aValue);
                break;
            default:
                throw new AssertionError("N/A");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

}
