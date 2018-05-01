package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class FromToPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 7476815113182438805L;
	private JLabel lbFrom = null;
	private JLabel lbTo = null;
	private JFormattedTextField ftfFrom = null;
	private JFormattedTextField ftfTo = null;
	private JButton btnOK = null;
	private TaskList tl;
	private DateFormat df= null;
	
	public FromToPanel(TaskList tl) {
		super();
		this.tl = tl;
		this.initializeControls();
		this.setPreferredSize(new Dimension(200, 36));
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		this.df = new SimpleDateFormat("dd.mm.yyyy");
		
		this.lbFrom = new JLabel("Tasks From:");
		this.lbTo = new JLabel("To:");
		
		this.ftfFrom = new JFormattedTextField(df);
		this.ftfTo = new JFormattedTextField(df);
		this.btnOK = new JButton("OK");
		
		try {
			MaskFormatter dateMask = new MaskFormatter("##.##.####");
			dateMask.install(ftfFrom);
			dateMask.install(ftfTo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.add(lbFrom);
		this.add(ftfFrom);
		ftfFrom.setColumns(7);
		this.add(lbTo);
		this.add(ftfTo);
		ftfTo.setColumns(7);
		this.add(btnOK);
		this.btnOK.addActionListener(this);
	}
	
	public void checkDate()
	{	
		try {
			Date dateFrom = this.df.parse(this.ftfFrom.getText());
			Date dateTo = this.df.parse(this.ftfTo.getText());
			System.out.println("From: "+ dateFrom);
			System.out.println("To: "+dateTo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOK))
		{
			this.checkDate();
		}
	}
}