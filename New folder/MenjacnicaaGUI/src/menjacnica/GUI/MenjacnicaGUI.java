package menjacnica.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import menjacnica.TblModel.TblModel;

import java.awt.ComponentOrientation;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPanel centralniPanel;
	private JPanel desniPanel;
	private JPanel donjiPanel;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private static JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;
	public static LinkedList<Kurs> kursevi=new LinkedList<>();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        KontrolerGUI.zatvoriAplikaciju();
		    }
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NEVEN\\Desktop\\New folder\\MenjacnicaaGUI\\materijal\\\u043F\u0440\u0435\u0443\u0437\u0438\u043C\u0430\u045A\u0435.jpg"));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getCentralniPanel(), BorderLayout.CENTER);
		contentPane.add(getDesniPanel(), BorderLayout.EAST);
		contentPane.add(getDonjiPanel(), BorderLayout.SOUTH);
		
		TblModel model=new TblModel(kursevi);
		table.setModel(model);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					KontrolerGUI.ucitajFajl();
				}
			});
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KontrolerGUI.sacuvanFajl();
				}
			});
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KontrolerGUI.zatvoriAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KontrolerGUI.podaciOAutoru();
				}
			});
		}
		return mntmAbout;
	}
	private JPanel getCentralniPanel() {
		if (centralniPanel == null) {
			centralniPanel = new JPanel();
			centralniPanel.setLayout(new BorderLayout(0, 0));
			centralniPanel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return centralniPanel;
	}
	private JPanel getDesniPanel() {
		if (desniPanel == null) {
			desniPanel = new JPanel();
			desniPanel.setLayout(new MigLayout("", "[]", "[][][][]"));
			desniPanel.add(getBtnDodajKurs(), "cell 0 1,growx");
			desniPanel.add(getBtnIzbrisiKurs(), "cell 0 2,growx");
			desniPanel.add(getBtnIzvrsiZamenu(), "cell 0 3,growx");
		}
		return desniPanel;
	}
	private JPanel getDonjiPanel() {
		if (donjiPanel == null) {
			donjiPanel = new JPanel();
			donjiPanel.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEFT, TitledBorder.TOP, null, null));
			donjiPanel.setPreferredSize(new Dimension(10, 60));
			donjiPanel.setLayout(new BorderLayout(0, 0));
			donjiPanel.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return donjiPanel;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KontrolerGUI.prikaziProzorDodajKurs();
				}
			});
		}
		return btnDodajKurs;
	}
	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi kurs");
			btnIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int red=table.getSelectedRow();
					KontrolerGUI.izbrisiKurs(red);
				}
			});
		}
		return btnIzbrisiKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		}
		return btnIzvrsiZamenu;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			addPopup(scrollPane, getPopupMenu());
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextPane());
		}
		return scrollPane_1;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
		}
		return textPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u0160ifra", "Skra\u0107eni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					true, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		}
		return table;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIzbrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KontrolerGUI.prikaziProzorDodajKurs();
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Izbrisi kurs");
		}
		return mntmIzbrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		}
		return mntmIzvrsiZamenu;
	}
	public void upisiUTextPolje(String tekst){
		if(textPane.getText().equals("")) textPane.setText(tekst);
		else textPane.setText(textPane.getText()+"\n"+tekst);
	}
	public JTable vratiTabelu() {
		return getTable();
	}
	public static void napraviTabelu(){
		TblModel model=new TblModel(kursevi);
		table.setModel(model);
	}
}
