package menjacnica.GUI;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class KontrolerGUI {
	
	public static MenjacnicaGUI frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MenjacnicaGUI();
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
}
