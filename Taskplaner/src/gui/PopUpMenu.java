package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenu extends JPopupMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214145130534271171L;
	
	private JMenuItem add = null;	
	private JMenuItem del = null;
	private JMenuItem edit = null;
	
	public PopUpMenu() {
		super();
		this.initializeContols();
		this.setVisible(true);
	}
	
	private void initializeContols() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
	}
}