package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import bll.Task;

public class PopUpMenu extends JPopupMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214145130534271171L;
	
	private JMenuItem add = null;	
	private JMenuItem del = null;
	private JMenuItem edit = null;
	private TaskList tL = null;
	
	public PopUpMenu(TaskList tL) {
		super();
		this.tL = tL;
		this.initializeContols();
	}
	
	private void initializeContols() {
		this.add = new JMenuItem("Add Task");
		this.del = new JMenuItem("Delete Task");
		this.edit = new JMenuItem("Edit Task");
		
		this.add(add);
		this.addSeparator();
		this.add(del);
		this.addSeparator();
		this.add(edit);
	
		this.add.addActionListener(this);
		this.del.addActionListener(this);
		this.edit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(add)) {
			Task t = new Task();
			new CreateDialog(t);
			tL.addTask(t);
		}
		if(e.getSource().equals(del)) {
			tL.deleteTask();
		}
		if(e.getSource().equals(edit)) {
			new CreateDialog(tL.getCurrentTask());
		}
	}
}