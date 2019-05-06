import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* TRIAL NOT YET WORKING */
class TaskMaker extends JFrame implements ActionListener {
	String taskname;	
	int index;
	String name;
	
	JTextField starthrfield = new JTextField();
	JTextField startminfield = new JTextField();
	JTextField endhrfield = new JTextField();
	JTextField endminfield = new JTextField();
	
	JButton savebtn = new JButton();
	
	JLabel start = new JLabel();
	JLabel end = new JLabel();
	
	JPanel main = new JPanel();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	TaskMaker(int index, String name) {
		this.index = index;
		this.name = name;
		setLayout(new FlowLayout());
		start.setText("Start Time");
		starthrfield.setText("12");
		startminfield.setText("00");
		endhrfield.setText("1");
		endminfield.setText("12");
		end.setText("End Time");
		savebtn.setText("Save");		
		
		main.setLayout(new FlowLayout());
		
		main.add(starthrfield);
		main.add(startminfield);
		main.add(endhrfield);
		main.add(endminfield);
		
		main.add(start);
		main.add(end);
		
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				starthr  = Integer.parseInt(starthrfield.getText());
				startmin  = Integer.parseInt(startminfield.getText());
				endhr  = Integer.parseInt(endhrfield.getText());
			}
		});
	}
	
	public int starthr;
	public int startmin;
	public int endhr;
	public int endmin;
}

