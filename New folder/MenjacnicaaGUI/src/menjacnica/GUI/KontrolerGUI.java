package menjacnica.GUI;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.TblModel.TblModel;

public class KontrolerGUI {
	
	public static MenjacnicaGUI frame;
	public static DodajKursGUI dodajKursProzor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MenjacnicaGUI();
					dodajKursProzor=new DodajKursGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ucitajFajl(){
		JFileChooser chooser = new JFileChooser();
	    int returnVal = chooser.showOpenDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       frame.upisiUTextPolje("Ucitan fajl: "+chooser.getSelectedFile().getAbsolutePath());
	}
	}
	public static void sacuvanFajl(){
		JFileChooser chooser = new JFileChooser();
	    int returnVal = chooser.showSaveDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       frame.upisiUTextPolje("Sacuvan fajl: "+chooser.getSelectedFile().getAbsolutePath());
	}
	}
	public static void zatvoriAplikaciju(){
		int odgovor=JOptionPane.showConfirmDialog(frame, "Da li se sigurni da hocete da izadjete? ");
		if(odgovor==JOptionPane.YES_OPTION)
			System.exit(0);
	}
	public static void podaciOAutoru(){
		JOptionPane.showMessageDialog(frame, "Autor: Nevena Pešiæ", "Podaci o autoru",JOptionPane.PLAIN_MESSAGE);
	}
	public static void dodajKursUTekstPolje(String Sifra,String Naziv,String Prodajni,String Kupovni,String Srednji,String SkraceniNaziv){
		String kurs="Sifra: "+Sifra+"Prodajni kurs: "+Prodajni+"Kupovni kurs: "+Kupovni+"Srednji kurs: "+Srednji+"Skraceni naziv: "+SkraceniNaziv;
		frame.upisiUTextPolje(kurs);
	}
	public static void dodajKursUTabelu(String Sifra,String Naziv,String Prodajni,String Kupovni,String Srednji,String SkraceniNaziv){
		Kurs kurs=new Kurs(Sifra, Naziv, Prodajni, Kupovni, Srednji, SkraceniNaziv);
		MenjacnicaGUI.kursevi.add(kurs);
		frame.napraviTabelu();
	}
	public static void prikaziProzorDodajKurs() {
		dodajKursProzor.setVisible(true);
	}
}
