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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import bll.Task;
import bll.TaskTypEnum;

public class CreateDialog extends JDialog implements ActionListener{
	private static final long serialVersionUID = 7152982713464622095L;
	private JLabel lsubject = new JLabel("Subject");
	private JLabel ltext = new JLabel("Text");
	private JLabel ldate = new JLabel("Date");
	private JLabel ltyp = new JLabel("Typ");
	private JTextField tsubject = new JTextField();
	private JTextField ttext = new JTextField();
	private JTextField tdate = new JTextField();
	private JTextField ttyp = new JTextField();
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
		this.add(lsubject);
		this.add(tsubject);
		this.add(ltext);
		this.add(ttext);
		this.add(ldate);
		this.add(tdate);
		this.add(ltyp);
		this.add(ttyp);
		this.add(bok);
		this.add(bcancel);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bok)) {
			try {
				task.setSubject(tsubject.getText());
				task.setText(ttext.getText());
				task.setDatum(df.parse(tdate.getText()));
				task.setTyp(Task.getTypFromString(ttyp.getText()));
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
