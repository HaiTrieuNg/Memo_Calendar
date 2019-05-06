//package CS151_FinalProject;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class TaskFrame extends JFrame implements ActionListener 
{
	String month;
	int d;
	int year;
	JList list;
	JButton AddBtn, DeleteBtn, EditBtn, ExportBtn;
	JTextField textfield;
	Task tasks ;
	int ret;
	JLabel Day;
	public String dayofFrame;
	TaskFrame(String day, int d, String month, int year)
	{
		dayofFrame=day;
		setTitle("Tasks");
		
		this.month= month;
		this.year= year;
		this.d= d;
		Container c = getContentPane();
		setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		JPanel all = new JPanel();
		all.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		
		JPanel p0 = new JPanel();
		 Day = new JLabel(dayofFrame);
		 
		p0.add(Day);
		p0.setLayout(new FlowLayout(FlowLayout.LEFT));//display day in the left
		all.add(p0);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		tasks = new Task();
		
		list = new JList (tasks.getTask());
		
		list.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		
		 
		JScrollPane js = new JScrollPane(list);
	
		js.setPreferredSize(new Dimension(24,100));
		all.add(js);
		
		//Creating Text Field
		JPanel text = new JPanel();
		textfield = new JTextField(24);  
		text.add(textfield);
		all.add(text);
		
		//Creating Buttons
		AddBtn = new JButton("Add");
		AddBtn.addActionListener(this);
		DeleteBtn = new JButton("Delete");
		DeleteBtn.addActionListener(this);
		DeleteBtn.setActionCommand("Delete");
		EditBtn = new JButton("Edit");
		EditBtn.addActionListener(this);
		EditBtn.setActionCommand("Edit");
		ExportBtn = new JButton("Export");
		ExportBtn.addActionListener(this);
		ExportBtn.setActionCommand("Export");
		
		JPanel buttonPane = new JPanel();
		buttonPane.add(AddBtn);
		buttonPane.add(DeleteBtn);
		buttonPane.add(EditBtn);
		buttonPane.add(ExportBtn);
		add(all);
		all.add(buttonPane);
		
		setSize(300,250);
		//setVisible(true);
		}
		
		public void actionPerformed(ActionEvent ae)
		{
		if ("Edit".equals(ae.getActionCommand()))
		{
			if (tasks.getTask().getSize()>0)
			{
				String select = textfield.getText();
				Object obj = select;
				ret = list.getSelectedIndex();
				tasks.remove(ret);
				tasks.addAt(select, ret);
			}
			
		
		}
		
		else if("Delete".equals(ae.getActionCommand()))
		{
			
			if (tasks.getTask().getSize()>0)
			{
				ret = list.getSelectedIndex();
				tasks.remove(ret);
			}
		}
		
		else if ("Add".equals(ae.getActionCommand()))
		{
		
			String select = textfield.getText();
			
			JTextField textField= new JTextField(select,10);
			
			Object obj = select;
			tasks.add(obj);
		
		}
		
		else if ("Export".equals(ae.getActionCommand()))
		{ 
			String s= month+"_"+year;
			

				try ( PrintWriter out = new PrintWriter(new FileWriter(s+".txt", true))) 
				{
					out.println("Date "+ d+": "+tasks.toString());
			    } 
				catch (IOException e3) 
				{
			        System.err.println("Error occurred");
			        e3.printStackTrace();
			    }
			
		}
	}

	
	public static void main(String[] args) 
	{
		TaskFrame tf = new TaskFrame("", 1,"January", 2019);
		tf.setVisible(true);
	}
	
	
}
