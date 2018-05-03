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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import bll.Task;
import dal.OracleHelper;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class FromToPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 7476815113182438805L;
	private JLabel lbFrom = null;
	private JLabel lbTo = null;
	private JButton btnOK = null;
	private TaskList tasklist;
	private ArrayList<Task> tasks = null;
	private SimpleDateFormat formatter = null;
	private UtilDateModel modelfrom = new UtilDateModel();
	private UtilDateModel modelto = new UtilDateModel();
	private JDatePanelImpl datePanelfrom = new JDatePanelImpl(modelfrom);
	private JDatePickerImpl datePickerfrom = new JDatePickerImpl(datePanelfrom);
	private JDatePanelImpl datePanelto = new JDatePanelImpl(modelto);
	private JDatePickerImpl datePickerto = new JDatePickerImpl(datePanelto);
	
	public FromToPanel(TaskList tl) {
		super();
		this.tasklist = tl;
		this.initializeControls();
		this.setPreferredSize(new Dimension(200, 36));
		this.setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
	}

	private void initializeControls() {
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		this.formatter =  new SimpleDateFormat("dd.MM.yyyy");
		this.tasks = new ArrayList<Task>();
		
		this.lbFrom = new JLabel("Tasks From:");
		this.lbTo = new JLabel("To:");
		this.btnOK = new JButton("OK");
		this.add(lbFrom);
		this.add(datePickerfrom);
		this.add(lbTo);
		this.add(datePickerto);
		this.add(btnOK);
		this.btnOK.addActionListener(this);
	}
	
	public void checkDate()	 {
		Date dateFrom = (Date) this.datePickerfrom.getModel().getValue();
		Date dateTo = (Date) this.datePickerto.getModel().getValue();
		this.tasklist.fillList(getCorrectTasks(dateFrom,dateTo));
	}
	
	public ArrayList<Task> getCorrectTasks(Date dateFrom, Date dateTo)
	{
		if(dateFrom == null || dateTo == null) {
			JOptionPane.showMessageDialog(null, "Please enter values in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
		} else {
			ArrayList<Task> tasksHelp = new ArrayList<Task>();
			tasksHelp.addAll(this.tasklist.getTasks());
			this.tasklist.removeContent();
			addDays(dateFrom,-1);
		
			for(Task t : tasksHelp)
			{
				if(t.getDatum().after(dateFrom) && t.getDatum().before(dateTo))
				{
					this.tasks.add(t);
					System.out.println(t.getDatum());
				}
			}
		}
		return this.tasks;
	}
	
	public static void addDays(Date d, int days)
	{
	    d.setTime( d.getTime() + (long)days*1000*60*60*24 );
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOK))
		{
			this.checkDate();
		}
	}
}