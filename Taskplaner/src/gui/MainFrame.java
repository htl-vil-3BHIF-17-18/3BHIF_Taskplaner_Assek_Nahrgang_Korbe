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

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2616959112461490363L;
	private String identifier;
	
	private MenuBar mB = null;
	private SortPanel sP = null;
	private TaskList tL = null;
	private FromToPanel ftP = null;

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
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.tL = new TaskList();
		this.mB = new MenuBar(this.tL);
		this.ftP = new FromToPanel(this.tL);
		this.sP = new SortPanel(this.tL);
		this.setJMenuBar(mB);
		this.add(ftP, BorderLayout.SOUTH);
		this.add(sP, BorderLayout.NORTH);
		this.add(tL, BorderLayout.CENTER);
	}
}