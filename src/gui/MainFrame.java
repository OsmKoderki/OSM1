package gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame {

	private TablePanel tablePanel;
	private Controller controller;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private JSpinner dateSpin;

	public MainFrame() {
		
		super("Rejestracja wyników badañ");

		setLayout(new BorderLayout());
		
		
		tablePanel = new TablePanel();
		formPanel = new FormPanel();
		
		controller = new Controller();
		
		//wstawiam dane przez controllera-jego metode
		tablePanel.setData(controller.getPeople());
		
		
		tablePanel.setPersonTableListener(new PersonTableListener() {
			public void rowDeleted(int row) {
				controller.removePerson(row);
			}
		});
		
		setJMenuBar(createMenuBar());
		
		//odpalam formEvent occured i przekazuje dane do contorlera ktory dodaje 
		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				controller.addPerson(e);
				tablePanel.refresh();
				
			}
		});
		
		
			
		add(formPanel, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);

		setMinimumSize(new Dimension(700, 600));
		setSize(800, 610);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Aplikacja");
		JMenuItem exitItem = new JMenuItem("Zamknij");
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem();
		showFormItem.setSelected(true);
		menuBar.add(fileMenu);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_F4);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				ActionEvent.ALT_MASK));
		
		
		
		

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Czy na pewno chcesz wyjœc z aplikacji?",
						"Potwierdzenie wyjœcia", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		return menuBar;
	}

	
}
