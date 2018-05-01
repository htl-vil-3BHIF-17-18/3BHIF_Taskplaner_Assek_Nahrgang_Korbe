package gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenu extends JPopupMenu {

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
		
		this.add.setActionCommand("add_PopUp");
		this.del.setActionCommand("del_PopUp");
		this.edit.setActionCommand("edit_PopUp");
	}
}