package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FromToPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476815113182438805L;
	private JLabel lbFrom = null;
	private JLabel lbTo = null;
	private JFormattedTextField ftfFrom = null;
	private JFormattedTextField ftfTo = null;
	private JButton btnOK = null;
	
	public FromToPanel() {
		super();
		this.initializeControls();
		this.setPreferredSize(new Dimension(200, 36));
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		this.lbFrom = new JLabel("From:");
		this.lbTo = new JLabel("To:");
		
		this.ftfFrom = new JFormattedTextField(new Date());
		this.ftfTo = new JFormattedTextField(new Date());
		this.btnOK = new JButton("OK");
		
		this.add(lbFrom);
		this.add(ftfFrom);
		this.add(lbTo);
		this.add(ftfTo);
		this.add(btnOK);
	}
}