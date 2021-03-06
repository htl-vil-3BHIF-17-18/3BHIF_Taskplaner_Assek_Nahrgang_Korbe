package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bll.Task;
import dal.OracleHelper;
import java.awt.Font;

public class TaskList extends JPanel implements MouseListener{

	private static final long serialVersionUID = -8459441481289917384L;
	ArrayList<Task> tasks = null;
	JList<Task> list = null;
	DefaultListModel<Task> dlm = null;
	JScrollPane scroll = null;
	private Task currentSelectedTask = null;
	private PopUpListener popUpListener = null;
	
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
		this.list.setFont( new Font("monospaced", Font.BOLD, 12) );
		this.scroll = new JScrollPane(list);
		this.dlm = new DefaultListModel<Task>();
		this.list.setModel(dlm);
		this.add(this.scroll, BorderLayout.CENTER); 
		this.list.addMouseListener(this);
		this.popUpListener = new PopUpListener(new PopUpMenu(this));
	}
	
	public void removeContent()
	{
		this.tasks.clear();
		this.dlm.clear();
	}
	
	public void addTask(Task t)
	{
		t.insertTask();
		this.tasks.add(t);
		this.dlm.addElement(t);
	}
	
	public void deleteTask()
	{	
		this.currentSelectedTask.deleteTask();
		this.tasks.remove(this.currentSelectedTask);
		this.dlm.removeElement(this.currentSelectedTask);
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
	
	
	
	public Task getSelectedTask()
	{
		return this.list.getSelectedValue(); 		 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.currentSelectedTask = getSelectedTask();
	}
	
	public Task getCurrentTask() {
		return this.currentSelectedTask;
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		popUpListener.mousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		popUpListener.mouseReleased(arg0);
	}
}
