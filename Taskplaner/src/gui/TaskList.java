package gui;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bll.Task;
import dal.OracleHelper;

public class TaskList extends JPanel implements MouseListener{

	private static final long serialVersionUID = -8459441481289917384L;
	ArrayList<Task> tasks = null;
	JList<Task> list = null;
	DefaultListModel<Task> dlm = null;
	JScrollPane scroll = null;
	private static Task currentSelectedTask = null;
	
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
		this.list.addMouseListener(this);
		
	}
	
	public void addTask(Task t)
	{
		this.tasks.add(t);
		this.dlm.addElement(t);
		OracleHelper.addTaskToDB(t);
	}
	
	public ArrayList<Task> getTasks()
	{
		return this.tasks;
	}

	public void fillList(ArrayList<Task> tList)
	{
		for(Task t : tList)
		{
			this.tasks.add(t);
			this.dlm.addElement(t);
		}
	}
	
	public void deleteTask()
	{	
		System.out.println(TaskList.currentSelectedTask);
		this.tasks.remove(TaskList.currentSelectedTask);
		this.dlm.removeElement(TaskList.currentSelectedTask);
		OracleHelper.deleteTaskAtDB(TaskList.currentSelectedTask);
	}
	
	public Task getSelectedTask()
	{
		return this.list.getSelectedValue(); 		 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(getSelectedTask());
		TaskList.currentSelectedTask = getSelectedTask();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
