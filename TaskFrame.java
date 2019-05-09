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
	private JComboBox cb1;
	private JComboBox cb2;
	private JComboBox cb3;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		Color skyBlue = new Color(235,250,250);
		list.setBackground(skyBlue);
		list.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		
		JScrollPane js = new JScrollPane(list);
	
		js.setPreferredSize(new Dimension(300,400));
		js.getViewport().setBackground(Color.gray);
		all.add(js);
	      
	    // Put the combo boxes for Time into the panel.
	      
	    String Hr[]={"0","1","2","3","4","5","6","7","8","9","10","11","12"};        
	    String Min[]={":00",":15",":30",":45"};        
	    String AMPM[]={"am","pm"};   
	    cb1=new JComboBox(Hr);    
	    cb2=new JComboBox(Min);    
	    cb3=new JComboBox(AMPM);    
	    JPanel time = new JPanel();
		time.setLayout(new FlowLayout(FlowLayout.LEFT));
		time.add(new JLabel("Time"));
	    time.add(cb1);
	    time.add(cb2);
	    time.add(cb3);
	    all.add(time);
		
		//Creating Text Field for Task.

	    JPanel task = new JPanel();
		task.setLayout(new FlowLayout(FlowLayout.LEFT));
		task.add(new JLabel("Task"));
		textfield = new JTextField(20); 
		task.add(textfield);
		all.add(task);

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
		
		setSize(300,500);
		setVisible(false);
		
		}
		
		public void actionPerformed(ActionEvent ae)
		{
		if ("Edit".equals(ae.getActionCommand()))
		{
			if (tasks.getTask().getSize()>0)
			{
				String select = cb1.getSelectedItem().toString()+cb2.getSelectedItem().toString()+cb3.getSelectedItem().toString()+" - "+textfield.getText();
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
		
			String select = cb1.getSelectedItem().toString()+cb2.getSelectedItem().toString()+cb3.getSelectedItem().toString()
					+" - "+textfield.getText();
			
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
