package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.html.HTMLDocument.Iterator;

import bll.Task;
import bll.TaskSubjectEnum;
import bll.TaskTypEnum;

public class CreateDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 7152982713464622095L;
	private JLabel lsubject = new JLabel("Subject");
	private JLabel ltext = new JLabel("Text");
	private JLabel ldate = new JLabel("Date");
	private JLabel ltyp = new JLabel("Typ");
	private JTextField ttext = new JTextField();
	
	private String[] types = new String[] { "Hausuebung", "Schularbeit", "GLF", "Pruefung", "MAK" };
    private JComboBox<String> typList = new JComboBox<>(types);
	
    private String[] typessub = new String[] { "AM","E","D","POS","GGP","NVS","TINF","BSPK","NW","BWM1","BWM2","DBI","RK","SOPK" };
    private JComboBox<String> subList = new JComboBox<>(typessub);
    
	private JTextField tdate = new JTextField();
	private JButton bok = new JButton("OK");
	private JButton bcancel = new JButton("Cancel");
	private DateFormat df= new SimpleDateFormat("dd.mm.yyyy");
	private Task task;
	
	public CreateDialog(Task task) {
		this.task = task;
		initializeControls();
		this.pack();
		this.setVisible(true);
	}
	
	private void initializeControls() {
		this.setLayout(new GridLayout(5,2));
		bok.addActionListener(this);
		bcancel.addActionListener(this);
		
		subList.setSelectedItem(task.getSubject().toString());
		ttext.setText(task.getText());
		tdate.setText(new SimpleDateFormat("DD.MM.YYYY").format(task.getDatum()));
		typList.setSelectedItem(task.getTyp().toString());
		
		this.add(lsubject);
		this.add(subList);
		this.add(ltext);
		this.add(ttext);
		this.add(ldate);
		this.add(tdate);
		this.add(ltyp);
		this.add(typList);
		this.add(bok);
		this.add(bcancel);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bok)) {
			try {
				task.setSubject(Task.getSubjectFromString((String)subList.getSelectedItem()));
				task.setText(ttext.getText());
				task.setDatum(df.parse(tdate.getText()));
				task.setTyp(Task.getTypFromString((String)typList.getSelectedItem()));
				
				if(this.ttext.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a value in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			finally {
				this.setVisible(false);
				this.dispose();
			}
		}
		if(e.getSource().equals(bcancel)) {
			this.setVisible(false);
			this.dispose();
		}
	}
}