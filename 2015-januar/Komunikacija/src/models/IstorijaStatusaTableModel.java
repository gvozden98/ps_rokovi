/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import domen.IstorijaStatusaRada;
import domen.StatusRada;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ognjen
 */
public class IstorijaStatusaTableModel extends AbstractTableModel {

    private List<IstorijaStatusaRada> svaIstorijaStatusaRada;

    String[] columns = {"RB", "Status rada", "Datum"};

    public IstorijaStatusaTableModel() {
        this.svaIstorijaStatusaRada = new LinkedList<>();
    }

    @Override
    public int getRowCount() {
        if (svaIstorijaStatusaRada == null) {
            return 0;
        }
        return svaIstorijaStatusaRada.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        IstorijaStatusaRada isr = svaIstorijaStatusaRada.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                isr.getRb();
            case 1 ->
                isr.getStatusRada().getNazivStatusa();
            case 2 ->
                isr.getDatum().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            default ->
                null;
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        IstorijaStatusaRada isr = svaIstorijaStatusaRada.get(rowIndex);

        switch (columnIndex) {
            case 0:
                isr.setRb((Integer) aValue);
                break;
            case 1:
                isr.setStatusRada((StatusRada) aValue);
                break;
            case 2:
                isr.setDatum((LocalDateTime) aValue);
                break;
            default:
                throw new AssertionError();
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void dodajUListu(IstorijaStatusaRada isr) {
        if (isr == null) {
            return;
        }

        isr.setRb(svaIstorijaStatusaRada.size() + 1);
        int row = svaIstorijaStatusaRada.size();
        svaIstorijaStatusaRada.add(isr);
        fireTableRowsInserted(row, row);
    }

    public void obrisiRedIstorijeStatusaRada(int rowIndex) {
        svaIstorijaStatusaRada.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public List<IstorijaStatusaRada> getSvaIstorijaStatusaRada() {
        return svaIstorijaStatusaRada;
    }

}
