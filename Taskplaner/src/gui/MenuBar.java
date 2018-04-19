package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7795971250872208275L;
	private JMenu menu = null;
	private JMenuBar menuBar = null;
	JMenuItem add = null;
	JMenuItem del = null;
	JMenuItem edit = null;
	JMenuItem exit = null;
	
	public MenuBar() {
		super();
		this.initializeControls();
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
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