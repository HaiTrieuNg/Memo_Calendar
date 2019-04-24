package CS151_FinalProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.UIManager.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarFrame extends JFrame  implements ItemListener
{

	 private JPanel p1,firstP, mainp,today,dayofweek, ALL;
	 private JLabel monthLabel;
	 int monthindex;
	 private JPanel DayPanels[]= new JPanel[42]; 
	 private JButton DayButtons[][][]= new JButton[31][12][51];  
	 private JLabel sun;
	 private JLabel mon;
	 private JLabel tue;
	 private JLabel wed;
	 private JLabel thu;
	 private JLabel fri;
	 private JLabel sat;
	 private String weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	 private String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	 private TaskFrame T[][][] = new TaskFrame[31][12][51];
	 public JTextField yeart;
	  
	 CalendarFrame()
	{
		super();
		
		mainp= new JPanel();//for days
		mainp.setLayout(new GridLayout(6, 7,1,1));
		
		sun = new JLabel(" Sun");
		mon = new JLabel("Mon");
	    tue = new JLabel("Tue");
	    wed = new JLabel("Wed");
	    thu = new JLabel("Thu");
	    fri = new JLabel("Fri");
	    sat = new JLabel("Sat ");
	    
	    
		dayofweek = new JPanel();

	    dayofweek.add(sun);
	    dayofweek.add(mon);
	    dayofweek.add(tue);
	    dayofweek. add(wed);
	    dayofweek.add(thu);
	    dayofweek.add(fri);
	    dayofweek.add(sat);
	    dayofweek.setBackground(Color.LIGHT_GRAY);
	    dayofweek.setLayout(new GridLayout(1,7,25,25));
	    dayofweek.setPreferredSize(new Dimension(340,25));
	      
	      
		for (int x=0;x<42;x++)
		{
			DayPanels[x]= new JPanel();
			DayPanels[x].setBackground(Color.WHITE);
			DayPanels[x].setLayout(new GridLayout(1,1));
			
			mainp.add(DayPanels[x]);
	     }
		
	
		  
	     ArrayList<Integer> y= new ArrayList<>();
	   	 for(int i=2000;i<=2050;i++)
	   	 {
	   	     y.add(i);
	   	 }
	   	   
	   	 SpinnerListModel yModel = new SpinnerListModel(y);
	   	 JSpinner spinner = new JSpinner(yModel);

	   	 Calendar td=  GregorianCalendar.getInstance(); // for only the current time
		 Calendar cal =  GregorianCalendar.getInstance(); //to change date
		  
		setTitle("Calendar");
		this.setLocation(100,100);
		
		p1 = new JPanel();
		
		int chosenmonth=cal.get(Calendar.MONTH)+1;
		  
		monthindex= chosenmonth-1;
	    monthLabel = new JLabel("                   "+months[monthindex]+"                   ");
	     
	    int l;
	      
	    for (l=0; l<cal.get(Calendar.YEAR)-2000; l++)
	    {
	    	spinner.setValue(yModel.getNextValue()); // set the current year to be initial value of year spinner
	    	 
	    }
	      
		  
			
			
		//change listener for spinner
		ChangeListener listener = new ChangeListener() {
		    public void stateChanged(ChangeEvent e2)
		    {
		     cal.set((Integer)spinner.getValue(), monthindex, 1);
		      for (int x=0;x<42;x++)
	    	  {
	    		 DayPanels[x].removeAll();
	    		 DayPanels[x].updateUI();
	    	   }
	    		         
		      int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;
			  for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); ++i)
			  {
			  	int o= i;
			  	T[i][monthindex][(Integer)spinner.getValue()-2000]= new TaskFrame( "Day: "+ weekdays[offset%7]+ months[monthindex]+", "+(i+1)+" "+yModel.getValue());
				T[i][monthindex][(Integer)spinner.getValue()-2000].setVisible(false);
				T[i][monthindex][(Integer)spinner.getValue()-2000].setLocation(500,100);
			  	DayButtons[i][monthindex][(Integer)spinner.getValue()-2000]= new JButton();
			    DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setText(Integer.toString(i+1));
			    if (td.get(Calendar.DATE) == i+1 && td.get(Calendar.YEAR) == (int)spinner.getValue() && td.get(Calendar.MONTH) == monthindex)
	 			{DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setForeground(Color.RED);}
				DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setBorderPainted(false);
				DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setFocusPainted(false);
				DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setContentAreaFilled(false);
				
				DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].addActionListener(e1 -> {
					T[o][monthindex][(Integer)yModel.getValue()-2000].setVisible(true);
				 });
				
				T[o][monthindex][(Integer)yModel.getValue()-2000].setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				DayPanels[offset].add( DayButtons[i][monthindex][(Integer)yModel.getValue()-2000]);
			  	++offset;       
			  }
		          
		   }
		};
		   	   
		spinner.addChangeListener(listener);
		
	      
	      
	    //Buttons  
	
	    JButton PrevBtn = new JButton ("<");
	    PrevBtn.addActionListener(e -> 
	    {
	    	if (monthindex==0)
	    	{
	    		spinner.setValue(yModel.getPreviousValue());
	    		monthindex= 12;
	    	}
	    		  
	    	for (int x=0;x<42;x++)
	    	{
	    		DayPanels[x].removeAll();
	    		DayPanels[x].updateUI();
	    	}
	    		
	    	monthindex--;
	    	monthLabel.setText("                   "+months[monthindex]+"                   ");
	    		  
	    	cal.set((Integer)spinner.getValue(), monthindex, 1);//year, month,day
	  		    
	  		int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;
	  		for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); ++i)
	  		{
	  		 int o= i;
	  		 T[i][monthindex][(Integer)spinner.getValue()-2000]= new TaskFrame("Day: "+ weekdays[offset%7]+ " "+ months[monthindex]+", "+(i+1)+" "+yModel.getValue());
			 T[i][monthindex][(Integer)spinner.getValue()-2000].setVisible(false);
			 T[i][monthindex][(Integer)spinner.getValue()-2000].setLocation(500,100);
				
	  		 DayButtons[i][monthindex][(Integer)spinner.getValue()-2000]= new JButton();
	  	     DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setText(Integer.toString(i+1));
	  	    if (td.get(Calendar.DATE) == i+1 && td.get(Calendar.YEAR) == (int)spinner.getValue() && td.get(Calendar.MONTH) == monthindex)
	  	 	{DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setForeground(Color.RED);}
			 DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setBorderPainted(false);
			 DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setFocusPainted(false);
			 DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setContentAreaFilled(false);
			 DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].addActionListener(e1 -> {
			 T[o][monthindex][(Integer)spinner.getValue()-2000].setVisible(true);
			 });
			 
			  T[o][monthindex][(Integer)spinner.getValue()-2000].setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			  DayPanels[offset].add( DayButtons[i][monthindex][(Integer)spinner.getValue()-2000]);
	  		  ++offset;       
	  		 }
	    });
	      
	      
	      
	      
	   
	    JButton NextBtn = new JButton (">");
	    NextBtn.addActionListener(e -> 
	    {
	    	  
	    	if(monthindex==11)
	    	{
	    		spinner.setValue(yModel.getNextValue());
	    		monthindex=-1;
	    	}
	    		  
	    	for (int x=0;x<42;x++)
	    	{
	    		DayPanels[x].removeAll();
	    		DayPanels[x].updateUI();
	    	}
	    	
	    	monthindex++;
	    	monthLabel.setText("                   "+months[monthindex]+"                   ");
	    	
	    	cal.set((Integer)spinner.getValue(), monthindex, 1);//year, month,day
	  		int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;
	  		for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); ++i)
	  		{
	  			int o= i;
	  			T[i][monthindex][(Integer)spinner.getValue()-2000]= new TaskFrame("Day: "+ weekdays[offset%7]+" "+months[monthindex]+", "+(i+1)+" "+yModel.getValue());
				T[i][monthindex][(Integer)spinner.getValue()-2000].setVisible(false);
				T[i][monthindex][(Integer)spinner.getValue()-2000].setLocation(500,100);
	  			
	  			DayButtons[i][monthindex][(Integer)spinner.getValue()-2000]= new JButton();
	  			DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setText(Integer.toString(i+1));
	  			if (td.get(Calendar.DATE) == i+1 && td.get(Calendar.YEAR) == (int)spinner.getValue() && td.get(Calendar.MONTH) == monthindex)
	 			{DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setForeground(Color.RED);}
	  			DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setBorderPainted(false);
	  			DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setFocusPainted(false);
	  			DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].setContentAreaFilled(false);
	  			DayButtons[i][monthindex][(Integer)spinner.getValue()-2000].addActionListener(e1 ->
	  			{
	  				T[o][monthindex][(Integer)spinner.getValue()-2000].setVisible(true);
				 });
	  			
	  			T[o][monthindex][(Integer)spinner.getValue()-2000].setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	  			DayPanels[offset].add(DayButtons[i][monthindex][(Integer)spinner.getValue()-2000]);
	  		    ++offset;        
	  		 }
	  	});
	    
	      PrevBtn.setBounds(10, 25, 50, 25);
	      NextBtn.setBounds(260, 25, 50, 25);
	   
	      
	      
	     
	      
	      //INITIAL FRAME
	    cal.set((Integer)yModel.getValue(), monthindex, 1);//year, month,day
		int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;
		  
		for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); ++i)
		{   
			int o= i;
			T[i][monthindex][(Integer)yModel.getValue()-2000]= new TaskFrame("Day: "+ weekdays[offset%7]+" "+months[monthindex]+", "+(i+1)+" "+yModel.getValue());
 			T[i][monthindex][(Integer)yModel.getValue()-2000].setVisible(false);
			T[i][monthindex][(Integer)yModel.getValue()-2000].setLocation(500,100);
 			
 		    DayButtons[i][monthindex][(Integer)yModel.getValue()-2000]= new JButton();
 		    DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setText(Integer.toString(i+1));
 		   if (td.get(Calendar.DATE) == i+1 && td.get(Calendar.YEAR) == (int)spinner.getValue() && td.get(Calendar.MONTH) == monthindex)
 			{DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setForeground(Color.RED);}
 			DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setBorderPainted(false);
 			DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setFocusPainted(false);
 			DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].setContentAreaFilled(false);
 			DayButtons[i][monthindex][(Integer)yModel.getValue()-2000].addActionListener(e1 ->
 			{
 				T[o][monthindex][(Integer)yModel.getValue()-2000].setVisible(true);
			 });
 			
 			T[o][monthindex][(Integer)yModel.getValue()-2000].setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
 		    DayPanels[offset].add( DayButtons[i][monthindex][(Integer)yModel.getValue()-2000]);
		    ++offset;
		           
		 }

		
		
	   p1.setBackground(new Color(172,191, 233));
	   p1.add(spinner);
	   Container c=getContentPane();
	   c.setLayout(new FlowLayout());
	        
	   firstP=new JPanel();
	   firstP.setBackground(new Color(172,191, 233));
	   firstP.add(PrevBtn);
	   firstP.add(monthLabel);
	   firstP.add(p1);
	   firstP.add(NextBtn);
	   firstP.setPreferredSize(new Dimension(340, 35));
		
		
		 
		today= new JPanel ();
		JLabel  todayl= new JLabel ("Today:  "+  months[td.get(Calendar.MONTH)]+" "+  td.get(Calendar.DATE)+", "+  td.get(Calendar.YEAR));
		today.add(todayl);
		today.setBackground(new Color (240,248,255));
		today.setLayout(new FlowLayout(FlowLayout.LEFT));

	        
	     ALL= new JPanel();
	     ALL.setSize(380,300);
	     ALL.add(firstP);// buttons
	     ALL.add(dayofweek);//sun mon
	     ALL.add(mainp);//1 2 3
	     ALL.add(today);
	     ALL.setLayout(new BoxLayout(ALL,BoxLayout.Y_AXIS));
	     
	     
	     add(ALL);
		 setSize(370,293);
		 setResizable(false);
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		CalendarFrame fr = new CalendarFrame();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
