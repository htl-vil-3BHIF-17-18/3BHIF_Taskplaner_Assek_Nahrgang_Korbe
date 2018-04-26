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
import dal.OracleHelper;

public class MenuBar extends JMenuBar implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7795971250872208275L;
	private JMenu menu = null;
	private JMenuBar menuBar = null;
	private JMenuItem connect = null;
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
		
		this.connect = new JMenuItem("Connect");
		this.add = new JMenuItem("Add");
		this.del = new JMenuItem("Delete");
		this.edit = new JMenuItem("Edit");
		this.exit = new JMenuItem("Exit");

		this.menuBar.add(menu);
		this.menu.addSeparator();
		this.menu.add(connect);
		this.menu.add(add);
		this.menu.add(del);
		this.menu.add(edit);
		this.menu.addSeparator();
		this.menu.add(exit);
		
		this.add(menu);
		
		this.connect.addActionListener(this);
		this.add.addActionListener(this);
		this.del.addActionListener(this);
		this.edit.addActionListener(this);
		this.exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(connect)) {
			//this.tasklist.fillList(OracleHelper.getListFromDB());
		}
		
		if(e.getSource().equals(add)) {
			Task t =new Task();
			CreateDialog dialog = new CreateDialog(t);
			System.out.println(t);
			this.tasklist.addTask(t);
		}
		
		if(e.getSource().equals(del)) {
			this.tasklist.deleteTask();
		}
		
		if(e.getSource().equals(edit)) {
			Task t = TaskList.getCurrentTask();
			Task t_old= new Task(t.getSubject(),t.getText(),t.getDatum(),t.getTyp());
			CreateDialog dialog = new CreateDialog(t);
			OracleHelper.updateTaskInDB(t_old, t);
			
		}
		if(e.getSource().equals(exit)) {
			System.exit(0);
		}
	}
}