package menjacnica.TblModel;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.GUI.Kurs;

public class TblModel extends AbstractTableModel{
	
	private LinkedList<Kurs> kursevi;
	
	
	
	public TblModel(LinkedList<Kurs> kursevi) {
		super();
		this.kursevi = kursevi;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		if(kursevi==null)
			return 0;
		return kursevi.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		switch(kolona){
		case 0: return kursevi.get(red).getSifra();
		case 1: return kursevi.get(red).getNaziv();
		case 2: return kursevi.get(red).getProdajni();
		case 3: return kursevi.get(red).getKupovni();
		case 4: return kursevi.get(red).getSrednji();
		case 5: return kursevi.get(red).getSkraceniNaziv();
		default:return null;
	}
}
	public String getColumnName(int column) {
        switch(column){
            case 0: return "Broj indeksa";
            case 1: return "Ime";
            case 2: return "Prezime";
            case 3: return "Datum rodjenja";
            case 4: return "Mesto rodjenja";
            default: return "N/A";
        }
    }

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void obrisiKurs(int red) {
        kursevi.remove(red);
        fireTableDataChanged();
    }
	public void refresh() {
		 fireTableDataChanged();
	}
	
}
