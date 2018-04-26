package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import bll.Task;

public class SortPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 4997140050621690744L;
	private JButton sortSubject = null;
	private JButton sortDate = null;
	//private JButton sortStudent = null;
	private JButton sortType = null;
	private TaskList tl;
	
	public SortPanel(TaskList tl) {
		super();
		this.tl = tl;
		this.initializeControls();
		this.setPreferredSize(new Dimension(200, 36));
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
	}

	private void initializeControls() {
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		this.sortSubject = new JButton("Sort By Subject");
		this.sortDate = new JButton("Sort By Date");
		//this.sortStudent = new JButton("Sort By Student");
		this.sortType = new JButton("Sort By Type");
		
		this.add(sortSubject);
		this.add(sortDate);
		//this.add(sortStudent);
		this.add(sortType);
		this.sortSubject.addActionListener(this);
		this.sortDate.addActionListener(this);
		//this.sortStudent.addActionListener(this);
		this.sortType.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(sortSubject)) {
			tl.dlm.clear();
			tl.tasks.sort((Task t1,Task t2)-> t1.getSubject().compareTo(t2.getSubject()));
			for(Task t: tl.tasks) {
				tl.dlm.addElement(t);
			}
		}
		if(e.getSource().equals(sortDate)) {
			tl.dlm.clear();
			tl.tasks.sort((Task t1, Task t2)-> t1.getDatum().compareTo(t2.getDatum()));
			for(Task t: tl.tasks) {
				tl.dlm.addElement(t);
			}
		}
		if(e.getSource().equals(sortType)) {
			tl.dlm.clear();
			tl.tasks.sort((Task t1, Task t2)-> t1.getTyp().compareTo(t2.getTyp()));
			for(Task t: tl.tasks) {
				tl.dlm.addElement(t);
			}
		}
	}
}