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
		
		this.formatter =  new SimpleDateFormat("dd.MM.yyyy");
		this.tasks = new ArrayList<Task>();
		
		this.lbFrom = new JLabel("Tasks From:");
		this.lbTo = new JLabel("To:");
		
		this.ftfFrom = new JFormattedTextField(formatter);
		this.ftfTo = new JFormattedTextField(formatter);
		this.btnOK = new JButton("OK");
		
		try {
			MaskFormatter dateMask = new MaskFormatter("##.##.####");
			dateMask.install(this.ftfFrom);
			dateMask.install(this.ftfTo);
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
			dateFrom = this.formatter.parse(this.ftfFrom.getText());
			dateTo = this.formatter.parse(this.ftfTo.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.tasklist.fillList(getCorrectTasks(dateFrom,dateTo));
	}
	
	public ArrayList<Task> getCorrectTasks(Date dateFrom, Date dateTo)
	{
		//ArrayList<Task> tasksHelp = this.tasklist.getTasks();
		ArrayList<Task> tasksHelp = new ArrayList<Task>();
		tasksHelp.addAll(this.tasklist.getTasks());
		this.tasklist.removeContent();
		
		
		for(Task t : tasksHelp)
		{
			if(t.getDatum().after(dateFrom) && t.getDatum().before(dateTo))
			{
				this.tasks.add(t);
				System.out.println(t.getDatum());
			}
	
		}
		return this.tasks;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOK))
		{
			this.checkDate();
		}
	}
}