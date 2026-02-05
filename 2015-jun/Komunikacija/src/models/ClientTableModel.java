/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import domen.Angazovanje;
import domen.Model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ognjen
 */
public class ClientTableModel extends AbstractTableModel {

    private List<Angazovanje> angazovanja;

    String[] columns = {"Ime i prezime modela", "Broj sati", "Zarada", "Komentar"};

    public ClientTableModel(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

    public ClientTableModel() {
        angazovanja = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (angazovanja == null) {
            return 0;
        }
        return angazovanja.size();
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
        Angazovanje a = angazovanja.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                a.getModel().toString();
            case 1 ->
                a.getBrojSati();
            case 2 ->
                a.getZarada();
            case 3 ->
                a.getKomentar();
            default ->
                "N/A";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Angazovanje a = angazovanja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                a.setModel((Model) aValue);
                break;
            case 1:
                a.setBrojSati((int) aValue);
                break;
            case 2:
                a.setZarada((int) aValue);
                break;
            case 3:
                a.setKomentar((String) aValue);
                break;
        }
        fireTableDataChanged();
    }

    public List<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
        fireTableDataChanged();
    }

    public void addAngazovanje(Angazovanje a) {
        this.angazovanja.add(a);
        fireTableDataChanged();
    }

    public void removeAngazovanjeAtIndex(int index) {
        this.angazovanja.remove(index);
        fireTableDataChanged();
    }

}
