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
	private DefaultListModel<Task> dlm;
	private DateFormat df= new SimpleDateFormat("dd.mm.yyyy");
	private boolean editflag = false;
	private Task task;
	
	public CreateDialog(DefaultListModel<Task> dlm) {
		this.dlm = dlm;
		initializeControls();
		this.pack();
		this.setVisible(true);
	}
	
	public CreateDialog(Task task) {
		this.dlm = dlm;
		this.task = task;
		editflag = true;
		initializeControls();
		this.pack();
		this.setVisible(true);
	}

	private void initializeControls() {
		this.setLayout(new GridLayout(5,2));
		bok.addActionListener(this);
		bcancel.addActionListener(this);
		this.add(lsubject);
		this.add(ltext);
		this.add(ldate);
		this.add(ltyp);
		this.add(tsubject);
		this.add(ttext);
		this.add(tdate);
		this.add(ttyp);
		this.add(bok);
		this.add(bcancel);
	}
	
	public Task getTask() {
		return task;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bok)) {
			try {
				if(editflag) {
					task.setSubject(tsubject.getText());
					task.setText(ttext.getText());
					task.setDatum(df.parse(tdate.getText()));
					task.setTyp(Task.getTypFromString(ttyp.getText()));
				}
				else {
					dlm.addElement(new Task(tsubject.getText(),ttext.getText(),df.parse(tdate.getText()),Task.getTypFromString(ttyp.getText())));
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
