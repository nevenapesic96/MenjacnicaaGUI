package menjacnica.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JTextField textFieldKupovni;
	private JTextField Prodajni;
	private JLabel lblIznos;
	private JComboBox<String> comboBox;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;
	private JTextField textFieldIznos;
	public ButtonGroup bg;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvrsiZamenuGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTextFieldKupovni());
		contentPane.add(getProdajni());
		contentPane.add(getLblIznos());
		contentPane.add(getComboBox());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
		contentPane.add(getTextFieldIznos());
		bg=new ButtonGroup();
		bg.add(getRdbtnKupovina());
		bg.add(getRdbtnProdaja());
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(25, 45, 85, 14);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(262, 45, 85, 14);
		}
		return lblProdajniKurs;
	}
	private JTextField getTextFieldKupovni() {
		if (textFieldKupovni == null) {
			textFieldKupovni = new JTextField();
			textFieldKupovni.setEditable(false);
			textFieldKupovni.setBounds(25, 70, 86, 20);
			textFieldKupovni.setColumns(10);
		}
		return textFieldKupovni;
	}
	private JTextField getProdajni() {
		if (Prodajni == null) {
			Prodajni = new JTextField();
			Prodajni.setEditable(false);
			Prodajni.setBounds(262, 70, 86, 20);
			Prodajni.setColumns(10);
		}
		return Prodajni;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(25, 120, 54, 14);
		}
		return lblIznos;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(171, 70, 54, 20);
			comboBox.addItem("EUR");
			comboBox.addItem("USD");
			comboBox.addItem("CHF");
		}
		return comboBox;
	}
	
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(262, 120, 109, 14);
		}
		return lblVrstaTransakcije;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setBounds(262, 141, 109, 23);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			rdbtnProdaja.setBounds(262, 167, 109, 23);
		}
		return rdbtnProdaja;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(10);
			slider.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					KontrolerGUI.upisiUIznos(slider.getValue());
					
				}
			});
			slider.setBounds(25, 192, 375, 45);
		}
		return slider;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!getRdbtnKupovina().isSelected() && !getRdbtnProdaja().isSelected())
						JOptionPane.showMessageDialog(null, "Niste izabrali transakciju! ");
					else{
						if(getRdbtnKupovina().isSelected())
					KontrolerGUI.izvrsiZamenuSlajder(comboBox.getSelectedItem().toString(),getTextFieldIznos().getText(),"Kupovina");
						else
							KontrolerGUI.izvrsiZamenuSlajder(comboBox.getSelectedItem().toString(),getTextFieldIznos().getText(),"Prodaja");
					}
				}
			});
			btnIzvrsiZamenu.setBounds(35, 237, 109, 23);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(262, 237, 109, 23);
		}
		return btnOdustani;
	}
	private JTextField getTextFieldIznos() {
		if (textFieldIznos == null) {
			textFieldIznos = new JTextField();
			textFieldIznos.setBounds(25, 145, 86, 20);
			textFieldIznos.setColumns(10);
		}
		return textFieldIznos;
	}
	public void upisiUTextField(String tekst){
		getTextFieldIznos().setText(tekst);
	}
	public void upisiUKupovni(String tekst){
		getTextFieldKupovni().setText(tekst);
	}
	public void upisiUProdajni(String tekst){
		getProdajni().setText(tekst);
	}
}
