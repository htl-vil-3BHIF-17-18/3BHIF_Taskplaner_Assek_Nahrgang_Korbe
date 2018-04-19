package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SortPanel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4997140050621690744L;
	//fach, datum, schüler, typ
	private JButton sortSubject = null;
	private JButton sortDate = null;
	private JButton sortStudent = null;
	private JButton sortType = null;
			
	public SortPanel() {
		super();
		this.initializeControls();
		this.setPreferredSize(new Dimension(200, 200));
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		this.sortSubject = new JButton("Sort By Subject");
		this.sortDate = new JButton("Sort By Date");
		this.sortStudent = new JButton("Sort By Student");
		this.sortType = new JButton("Sort By Type");
		
		this.add(sortSubject);
		this.add(sortDate);
		this.add(sortStudent);
		this.add(sortType);
		
		this.sortSubject.addActionListener(this);
		this.sortDate.addActionListener(this);
		this.sortStudent.addActionListener(this);
		this.sortType.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}