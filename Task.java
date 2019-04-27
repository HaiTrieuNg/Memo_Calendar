package CS151_FinalProject;


import javax.swing.*;
import java.util.ArrayList;

public class Task {

	private DefaultListModel listModel;
	
	/**
	 * Constructor
	 */
	public Task()
	{
		listModel = new DefaultListModel();
	}
	
	/**
	 * Constructor
	 * @param list
	 */
	public Task(  DefaultListModel list)
	{
		listModel = list;
	}
	
	/**
	 * get size of task list
	 * @return size
	 */
	public int getSize()
	{
		return listModel.getSize();
	}
	
	public  ArrayList<Object> getTaskList()
	{
		ArrayList<Object> o= new ArrayList<Object>();
		for (int i=0;i<listModel.size();i++)
		{
			o.add(listModel.getElementAt(i));
		}
		return o;
	}
	
	/**
	 * get the list model
	 * @return listModel
	 */
	public  DefaultListModel getTask()
	{
		
		return listModel;
	}
	
	/**
	 * Add a task in task list
	 * @param s a task
	 */
	public void add (Object t)
	{
		listModel.addElement(t);
	}
	

	/**
	 * Add a task at specific index (used for Edit button)
	 * @param s
	 * @param index
	 */
	public void addAt(Object s, int index)
	{
		listModel.add(index, s);
	}
	
	/**
	 * Remove a task
	 * @param i ask o be removed
	 */
	public void remove(int i)
	{
		listModel.remove(i);
	}
	
	public String toString()
	{
		return listModel.toString();
	}

}
