package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2616959112461490363L;
	private String identifier;
	
	private MenuBar mB = null;
	private SortPanel sP = null;
	private TaskList tL = null;

	public MainFrame(String identifier) throws HeadlessException {
		super();
		this.identifier = identifier;
		this.setMinimumSize(new Dimension(900, 450));
		this.setPreferredSize(new Dimension(900, 450));
		this.initializeControls();
		this.pack();
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		this.mB = new MenuBar();
		this.sP = new SortPanel();
		this.tL = new TaskList();
		this.setJMenuBar(mB);
		
		this.add(sP, BorderLayout.NORTH);
		this.add(tL, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}