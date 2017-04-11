package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FormPanel extends JPanel implements ActionListener{

	private JLabel nameLabel, dateLabel;
	private JLabel surnameLabel, peselLabel;
	private JLabel bloodLabel, urineLabel, ghbLabel;
	private JTextField nameField;
	private JTextField surnameField, peselField;
	private JTextField bloodField, urineField;
	private JButton saveBT,anulujBT;
	private JList pesel;
	private JComboBox insCombo;
	private JSpinner dateSpin;
	private JScrollPane scrollpane;
	private FormListener formListener;
	private PersonTableListener tablelistener;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
	private JButton saveExam;
	private JButton cancelExam;
	private JCheckBox ghbBox;
	private TablePanel usunBut;
	

   

	public FormPanel() {
		
		
		
		Dimension dim = getPreferredSize();
		dim.width = 360;
		setPreferredSize(dim);
		TablePanel table= new TablePanel();
		
		nameLabel = new JLabel("Imiê: ");
		surnameLabel = new JLabel("Nazwisko: ");
		peselLabel = new JLabel("Pesel: ");
		nameField = new JTextField(20);
		surnameField = new JTextField(20);
		peselField = new JTextField(20);
		insCombo = new JComboBox();
		saveBT = new JButton("Zapisz");
		anulujBT = new JButton("Anuluj");
		dateLabel = new JLabel();
		
		
		// badanie inicjalizujemy komponenty
		bloodLabel = new JLabel("Stê¿enie glukozy we krwi: ");
		urineLabel = new JLabel("Poziom cukru w moczu: ");
		ghbLabel =new JLabel("Obecnoœæ glikowanej hemoglobiny");
		
		bloodField = new JTextField(20);
		urineField = new JTextField(20);
		ghbBox = new JCheckBox();
		
		saveExam = new JButton("Zapisz");
		cancelExam = new JButton("Anuluj");
		
		//inicjalizacja gender
		maleRadio = new JRadioButton("mê¿czyzna");
		femaleRadio = new JRadioButton("kobieta");
		
		maleRadio.setActionCommand("mê¿czyzna");
		femaleRadio.setActionCommand("kobieta");
		
		genderGroup = new ButtonGroup();
		
		maleRadio.setSelected(true);
		
		//nie mozemy pisac narazie
		//nameField.setEnabled(false);
		//surnameField.setEnabled(false);
		//peselField.setEnabled(false);
		
		// Ustawiam gender radio przyciski
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);

		// Ustawiam combo box.
		DefaultComboBoxModel insModel = new DefaultComboBoxModel();
		insModel.addElement("NFZ");
		insModel.addElement("Prywatne");
		insModel.addElement("brak");
		insCombo.setModel(insModel);
		insCombo.setSelectedIndex(0);
		insCombo.setEditable(true);
			
		this.add(dateLabel);
		Date todaysDate = new Date();
		
		// ustawiam date spinner i daje mu dzieijsza date
		// po przycisku zmieniamy date
		
				
		dateSpin = new JSpinner(new SpinnerDateModel(todaysDate, null, null,
				   Calendar.DAY_OF_MONTH));
				
		// DateEditor dzieki niemu wyswietlamy date
				
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpin, "dd/MM/yy");
		dateSpin.setEditor(dateEditor);
				
		int peselChecker;
		
		//ograniczam wpisanie peselu do 12 cyfr
		peselField = new JTextField(" ",12);
		peselField.addKeyListener(new KeyAdapter() {
		        public void keyTyped(KeyEvent e) {
		            if (peselField.getText().length() == 12) {
		                e.consume();
		            }
		            
		        }
		    });	

        layoutComponents();
		
		
	}
	
	//czyszcze formularz
	public void cleanForm(){
		nameField.setText(" ");
		surnameField.setText(" ");
		peselField.setText(" ");
	}

	public void layoutComponents() {

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		Dimension dim = getPreferredSize();
		dim.width = 450;
		dim.height = 300;
		setPreferredSize(dim);
		
		// ////////// First row ///////////////////////////////////
		
		JPanel dataBorder = new JPanel(new GridLayout(0,2));
		dataBorder.setBorder(new TitledBorder("Dane pacjenta"));
		dataBorder.setPreferredSize(dim);		
		
		gc.gridy = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		dataBorder.add(nameLabel, gc);

		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		dataBorder.add(nameField, gc);

		// //////////Second row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		dataBorder.add(surnameLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		dataBorder.add(surnameField, gc);
		

		// //////////Third row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		dataBorder.add(new JLabel("Pesel: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		dataBorder.add(peselField, gc);

		// //////////Fourth row ///////////////////////////////////
		JPanel genderBorder = new JPanel(new GridLayout(1,2));
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		genderBorder.add(maleRadio, gc);

		// //////////Next row ///////////////////////////////////

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		dataBorder.add(new JLabel("P³eæ: "), gc);
		gc.gridx++;
		genderBorder.add(femaleRadio, gc);
		
		dataBorder.add(genderBorder);
		
		
		// //////////Next row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.05;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		dataBorder.add(new JLabel("Ubezpieczenie: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		dataBorder.add(insCombo, gc);
		
		

		// //////////Next row ///////////////////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		dataBorder.add(saveBT, gc);
		
		add(dataBorder);
		
		gc.gridy++;

		gc.weightx = 0.5;
		gc.weighty = 1.0;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		dataBorder.add(anulujBT, gc);
		
		add(dataBorder);
		
		
		// //////////Next row ///////////////////////////////////
        // ramka Badanie
		JPanel Examborder = new JPanel(new GridLayout(0,2));
		
		Examborder.setBorder(new TitledBorder("Badanie"));
        Dimension dim2 = getPreferredSize();
		dim2.width = 450;
		dim2.height = 200;
		//setPreferredSize(dim2);
		Examborder.setPreferredSize(dim2);
		
		add(Examborder,gc);
		
		//////////////////////////////////////////////////////
		
		gc.gridy++;

		gc.weightx = 0.5;
		gc.weighty = 1.0;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		Examborder.add(new JLabel("Data: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		Examborder.add(dateSpin);
		add(Examborder,gc);

		
		////////////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		Examborder.add(bloodLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		Examborder.add(bloodField, gc);
		
		
		///////////////////////////////////////////////
		gc.gridy++;

		gc.weightx = 2;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		Examborder.add(urineLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		Examborder.add(urineField, gc);
		/////////////////////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		Examborder.add(ghbLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.PAGE_END;
		Examborder.add(ghbBox, gc);
		///////////////////////////////////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		Examborder.add(saveExam, gc);
		
		
		/////////////////////////////////////////
		gc.gridy++;

		gc.weightx = 0.5;
		gc.weighty = 1.0;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		Examborder.add(cancelExam, gc);
		
		
		
	}
	
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
		saveBT.addActionListener(this);
		anulujBT.addActionListener(this);
	}

		    
	@Override
	public void actionPerformed(ActionEvent evt) {
		
			if (evt.getSource() == saveBT)
	    	{
				String name = nameField.getText();
				String surname = surnameField.getText();
				String pesel = peselField.getText();
				String insCat = (String) insCombo.getSelectedItem();
				String gender  = genderGroup.getSelection().getActionCommand();
			
				//przekazuje do FormEvent wszystkie dane wpisane do formularza				
				FormEvent ev = new FormEvent(this, name, gender, pesel, insCat, surname);
				
				System.out.println("Dziala");
				//wywoluje metode podajac jej parametry
				if (formListener != null) {
					formListener.formEventOccurred(ev);
					
				}
	    	}
			else if (evt.getSource() == anulujBT)
			{
				System.out.println("Dziala anuluj");
				cleanForm();
			}
			
			
		}
  // metoda do wlaczania pola tekstowego
	public void set() {
		
		nameField.setEnabled(false);
		System.out.println("Dziala enable");
	}
		
	}
	



