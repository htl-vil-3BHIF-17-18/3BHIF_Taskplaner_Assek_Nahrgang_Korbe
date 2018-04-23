package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import bll.Task;

public class MenuBar extends JMenuBar implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7795971250872208275L;
	private JMenu menu = null;
	private JMenuBar menuBar = null;
	private JMenuItem add = null;
	private JMenuItem del = null;
	private JMenuItem edit = null;
	private JMenuItem exit = null;
	private TaskList tasklist = null;
	
	public MenuBar() {
		super();
		this.initializeControls();
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
		this.tasklist = new TaskList();
		
		this.menu = new JMenu("Start");
		this.menuBar = new JMenuBar();
		
		this.add = new JMenuItem("Add");
		this.del = new JMenuItem("Delete");
		this.edit = new JMenuItem("Edit");
		this.exit = new JMenuItem("Exit");

		this.menuBar.add(menu);
		this.menu.addSeparator();
		this.menu.add(add);
		this.menu.add(del);
		this.menu.add(edit);
		this.menu.addSeparator();
		this.menu.add(exit);
		
		this.add(menu);
		
		this.add.addActionListener(this);
		this.del.addActionListener(this);
		this.edit.addActionListener(this);
		this.exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(add)) {
			Task t =new Task();
			CreateDialog dialog = new CreateDialog(t);
			System.out.println(t);
			this.tasklist.addTask(t);
		}
		
		if(e.getSource().equals(del)) {
			
		}
		
		if(e.getSource().equals(edit)) {
			
		}

		if(e.getSource().equals(exit)) {
			System.exit(0);
		}
	}
}