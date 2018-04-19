package gui;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2616959112461490363L;
	private String identifier;
	
	private MenuBar mB = null;

	public MainFrame(String identifier) throws HeadlessException {
		super();
		this.identifier = identifier;
		this.setMinimumSize(new Dimension(1300, 900));
		this.setPreferredSize(new Dimension(1300, 700));
		this.initializeControls();
		this.pack();
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
		this.mB = new MenuBar();
		this.setJMenuBar(mB);
	}
}