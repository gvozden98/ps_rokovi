/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import komunikacija.Poruka;

/**
 *
 * @author Ognjen
 */
public class PorukaTableModel extends AbstractTableModel {

    String[] columns = {"Poruka od korisnika", "Datum i vreme", "Tekst poruke"};
    private List<Poruka> poruke;

    public PorukaTableModel() {
        poruke = new ArrayList<>();
    }

    public PorukaTableModel(List<Poruka> poruke) {
        this.poruke = poruke;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (poruke == null) {
            return 0;
        }
        return poruke.size();
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
        Poruka p = poruke.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                p.getKorisnikOd();
            case 1 ->
                p.getDatumVreme().toString();
            case 2 ->
                p.getTekstPoruke();
            default ->
                "N/A";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Poruka p = poruke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                p.setKorisnikOd((String) aValue);
                break;
            case 1:
                p.setDatumVreme((LocalDateTime) aValue);
                break;
            case 2:
                p.setTekstPoruke((String) aValue);
                break;
            default:
                throw new AssertionError();
        }
    }

    public List<Poruka> getPoruke() {
        return poruke;
    }

    public void setPoruke(List<Poruka> poruke) {
        this.poruke = poruke;
        fireTableDataChanged();
    }

    public void dodajPoruku(Poruka p) {
        poruke.add(p);
    }

}
