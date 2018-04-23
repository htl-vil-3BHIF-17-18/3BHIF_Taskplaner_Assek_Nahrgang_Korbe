package gui;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bll.OracleHelper;
import bll.Task;

public class TaskList extends JPanel{

	private static final long serialVersionUID = -8459441481289917384L;
	ArrayList<Task> tasks = null;
	JList<Task> list = null;
	DefaultListModel<Task> dlm = null;
	JScrollPane scroll = null;
	
	public TaskList()
	{	
		this.initializeControls();
		this.setVisible(true);
	}

	private void initializeControls() 
	{	
		this.setLayout(new BorderLayout()); 
		tasks = new ArrayList<Task>();
		this.list = new JList<Task>();
		this.scroll = new JScrollPane(list);
		this.dlm = new DefaultListModel<Task>();
		this.list.setModel(dlm);
		this.add(this.scroll, BorderLayout.CENTER); 
		this.fillList(OracleHelper.getListFromDB());
	}
	
	public void addTask(Task t)
	{
		this.tasks.add(t);
		this.dlm.addElement(t);
	}
	
	public ArrayList<Task> getTasks()
	{
		return this.tasks;
	}

	public void fillList(ArrayList<Task> tList)
	{
		for(Task t : tList)
		{
			addTask(t);
		}
	}
	
	public void deleteTask(Task t)
	{
		this.tasks.remove(t);
		this.dlm.removeElement(t);
	}
	
	
	
	
}
