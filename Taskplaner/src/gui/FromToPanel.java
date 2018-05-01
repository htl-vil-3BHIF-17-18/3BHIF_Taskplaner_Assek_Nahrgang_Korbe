package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import bll.Task;

public class FromToPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 7476815113182438805L;
	private JLabel lbFrom = null;
	private JLabel lbTo = null;
	private JFormattedTextField ftfFrom = null;
	private JFormattedTextField ftfTo = null;
	private JButton btnOK = null;
	private TaskList tasklist;
	private ArrayList<Task> tasks = null;
	private SimpleDateFormat formatter = null;
	
	public FromToPanel(TaskList tl) {
		super();
		this.tasklist = tl;
		this.initializeControls();
		this.setPreferredSize(new Dimension(200, 36));
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
	}

	private void initializeControls() {
		// TODO Auto-generated method stub
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		this.formatter =  new SimpleDateFormat("yyyy-MM-dd");
		this.tasks = new ArrayList<Task>();
		
		this.lbFrom = new JLabel("Tasks From:");
		this.lbTo = new JLabel("To:");
		
		this.ftfFrom = new JFormattedTextField(formatter);
		this.ftfTo = new JFormattedTextField(formatter);
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
	
	public void checkDate()	 {
		Date dateFrom = null;
		Date dateTo = null;
		try {
			dateFrom = this.formatter.parse(getDateFromAsString());
			dateTo = this.formatter.parse(getDateToAsString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(dateFrom);
		System.out.println(dateTo);
		//this.tasklist.removeContent();
		getCorrectTasks();
		
		//this.tasklist.fillList(getCorrectTasks());
		System.out.println("From: "+ this.ftfFrom.getText());
		System.out.println("To: "+this.ftfTo.getText());
	}
	
	public ArrayList<Task> getCorrectTasks()
	{
		this.tasks = this.tasklist.getTasks();
		for(Task t : this.tasklist.getTasks())
		{
			System.out.println(t.getDatum());
		}
		return null;
	}
	
	public String getDateFromAsString()
	{
		String rgw = "";
		System.out.println(this.ftfFrom.getText().substring(6, 10) + "-" + this.ftfFrom.getText().substring(3, 5) + "-" + this.ftfFrom.getText().substring(0, 2));
		rgw = this.ftfFrom.getText().substring(6, 10) + "-" + this.ftfFrom.getText().substring(3, 5) + "-" + this.ftfFrom.getText().substring(0, 2);
		return rgw;
	}
	
	public String getDateToAsString()
	{
		String rgw = "";
		System.out.println(this.ftfTo.getText().substring(6, 10) + "-" + this.ftfTo.getText().substring(3, 5) + "-" + this.ftfTo.getText().substring(0, 2));
		rgw = this.ftfTo.getText().substring(6, 10) + "-" + this.ftfTo.getText().substring(3, 5) + "-" + this.ftfTo.getText().substring(0, 2);
		return rgw;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOK))
		{
			this.checkDate();
		}
	}
}