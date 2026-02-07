/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dto.AngazovaniModeliDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ognjen
 */
public class ServerTableModel extends AbstractTableModel {

    String[] columns = {"Model", "Broj revija", "Ukupna zarada", "Ukupan broj sati"};

    private List<AngazovaniModeliDTO> angModeli;

    public ServerTableModel(List<AngazovaniModeliDTO> angModeli) {
        this.angModeli = angModeli;
    }

    public ServerTableModel() {
        this.angModeli = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (angModeli == null) {
            return 0;
        }
        return angModeli.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AngazovaniModeliDTO amdto = angModeli.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                amdto.getModel();
            case 1 ->
                amdto.getBrojRevija();
            case 2 ->
                amdto.getUkupnaZarada();
            case 3 ->
                amdto.getUkupanBrojSati();
            default ->
                "N/A";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        AngazovaniModeliDTO amdto = angModeli.get(rowIndex);
        switch (columnIndex) {
            case 0:
                amdto.setModel((String) aValue);
                break;
            case 1:
                amdto.setBrojRevija((int) aValue);
                break;
            case 2:
                amdto.setUkupanBrojSati((int) aValue);
                break;
            case 3:
                amdto.setUkupanBrojSati((int) aValue);
            default:
                throw new AssertionError();
        }
        fireTableDataChanged();

    }

    public List<AngazovaniModeliDTO> getAngModeli() {
        return angModeli;
    }

    public void setAngModeli(List<AngazovaniModeliDTO> angModeli) {
        this.angModeli = angModeli;
        fireTableDataChanged();
    }

}
