/* Name: Jacob Schleith
 * COP 3330 - Summer 2011
 * Assignment title: Program #4: GUI-based Even driven Application
 * Date:	July 17, 2011
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeartRateZone extends JFrame
{
	//Sets constant variables for height and width both to 400
	static final int WINDOW_WIDTH = 400;
	static final int WINDOW_HEIGHT = 400;
	
	//set the variable for fields and buttons 
	private JTextField age, weight, heartRate, low1, low2, low3, low4, low5, hi1, hi2, hi3, hi4, hi5; 
	private JRadioButton male, female;
	private JButton calculate, again;
	
	//variables for calucations 
	int myAge, myWeight, myGender, mhr;
	
	//function HeartRateZone
	public HeartRateZone()
	{
		//creating new panel p1
		JPanel p1 = new JPanel();
		//setting p1 to a grid layout of 2 rows and 1 column 
		p1.setLayout(new GridLayout(2, 1, 0, 0));
		//adding labels to each row to be displayed 
		p1.add(new JLabel(" This program will calculate 5 aerobic training zones based upon the"));
		p1.add(new JLabel(" theoretical max heart rate for your age, weight and sex."));
		//adding panel p1 to the GUI
		add(p1);
		
		//creating new panel p2
		JPanel p2 = new JPanel();
		//setting p2 to a flow layout that is centered 
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		//adding the label to be displayed 
		p2.add(new JLabel("                                    Your Age "));
		//setting age = to input text
		p2.add(age = new JTextField(15));
		//adding panel p2 to the GUI
		add(p2);
		
		//creating new panel p3
		JPanel p3 = new JPanel();
		//setting p3 to a flow layout that is centered 
		p3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		//adding the label to be displayed 
		p3.add(new JLabel("                  Weight (in pounds) "));
		//setting weight = to input text
		p3.add(weight = new JTextField(15));
		//adding panel p3 to the GUI
		add(p3);
		
		//creating new panel p4
		JPanel p4 = new JPanel();
		//setting p4 to a flow layout that is centered
		p4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		//adding the label to be displayed 
		p4.add(new JLabel("                     Select your sex  "));
		//adding radio buttons male and female
		p4.add(male = new JRadioButton("Male    "));
		p4.add(female = new JRadioButton("Female"));
		//setting radio buttons to a group so that only one can be selected at a time.  
		ButtonGroup group = new ButtonGroup();
		group.add(male);
		group.add(female);
		//adding panel p4 to the GUI
		add(p4);
		
		//creating new panel p5
		JPanel p5 = new JPanel();
		//setting p5 to a flow layout that is left
		p5.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p5.add(new JLabel("--------------------------------------------------------------------------------------------------"));
		//adding panel p5 to the GUI
		add(p5);
		
		//creating new panel p6
		JPanel p6 = new JPanel();
		//setting p6 to a flow layout that is left
		p6.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p6.add(new JLabel("Theoretical Maximum Heart Rate"));
		p6.add(heartRate = new JTextField(18));
		//adding background color to text field heartRate
		heartRate.setBackground(Color.yellow);
		//Text field is not editable 
		heartRate.setEditable(false);
		//adding panel p6 to the GUI
		add(p6);
		
		//creating new panel p7
		JPanel p7 = new JPanel();
		//setting p5 to a flow layout that is center
		p7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		p7.add(new JLabel("  Zone 1: Low End"));
		p7.add(low1 = new JTextField(6));
		//adding background color to text field low1
		low1.setBackground(Color.green);
		p7.add(new JLabel("  Zone 1: High End"));
		p7.add(hi1 = new JTextField(6));
		//adding background color to text field hi1
		hi1.setBackground(Color.red);
		//adding panel p7 to the GUI
		add(p7);
		
		//creating new panel p8
		JPanel p8 = new JPanel();
		//setting p8 to a flow layout that is center
		p8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		p8.add(new JLabel("  Zone 2: Low End"));
		p8.add(low2 = new JTextField(6));
		//adding background color to text field low2
		low2.setBackground(Color.green);
		p8.add(new JLabel("  Zone 2: High End"));
		p8.add(hi2 = new JTextField(6));
		//adding background color to text field hi2
		hi2.setBackground(Color.red);
		//adding panel p8 to the GUI
		add(p8);
		
		//creating new panel p9
		JPanel p9 = new JPanel();
		//setting p9 to a flow layout that is center
		p9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		p9.add(new JLabel("  Zone 3: Low End"));
		p9.add(low3 = new JTextField(6));
		//adding background color to text field low3
		low3.setBackground(Color.green);
		p9.add(new JLabel("  Zone 3: High End"));
		p9.add(hi3 = new JTextField(6));
		//adding background color to text field hi3
		hi3.setBackground(Color.red);
		//adding panel p9 to the GUI
		add(p9);
		
		//creating new panel p10
		JPanel p10 = new JPanel();
		//setting p10 to a flow layout that is center
		p10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		p10.add(new JLabel("  Zone 4: Low End"));
		p10.add(low4 = new JTextField(6));
		//adding background color to text field low4
		low4.setBackground(Color.green);
		p10.add(new JLabel("  Zone 4: High End"));
		p10.add(hi4 = new JTextField(6));
		//adding background color to text field hi4
		hi4.setBackground(Color.red);
		//adding panel p10 to the GUI
		add(p10);
		
		//creating new panel p11
		JPanel p11 = new JPanel();
		//setting p11 to a flow layout that is center
		p11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		p11.add(new JLabel("  Zone 5: Low End"));
		p11.add(low5 = new JTextField(6));
		//adding background color to text field low5
		low5.setBackground(Color.green);
		p11.add(new JLabel("  Zone 5: High End"));
		p11.add(hi5 = new JTextField(6));
		//adding background color to text field hi5
		hi5.setBackground(Color.red);
		//adding panel p11 to the GUI
		add(p11);
		
		//creating new panel space
		JPanel space= new JPanel();
		//setting space to a flow layout that is center
		space.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		space.add(new JLabel("                                          "));
		//adding panel space to the GUI
		add(space);
		
		
		//creating new panel p12
		JPanel p12 = new JPanel();
		//setting p12 to a flow layout that is left
		p12.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p12.add(new JLabel("--------------------------------------------------------------------------------------------------"));
		//adding the panel p8 to the main GUI
		add(p12);
		
		//creating new panel p13
		JPanel p13 = new JPanel();
		//setting p13 to a flow layout that is center
		p13.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		p13.add(calculate = new JButton("Calculate Zones"));
		calculate.setBackground(Color.cyan);
		p13.add(again = new JButton("Run Again"));
		again.setBackground(Color.yellow);
		//adding the panel p9 to the main GUI
		add(p13);
		
		//creating an action listener for calculate button  
		calculate.addActionListener(new ActionListener() {
			
			//function for calculate button
			public void actionPerformed(ActionEvent e) 
			{
				
				myAge = Integer.parseInt(age.getText());  				//setting myAge for what's in the age field
				myWeight = Integer.parseInt(weight.getText());			//setting Myweight for what is in the weight text field
				myGender = 0;											//setting myGender to 0 if male is selected then it will be set to 4
				if(male.isSelected())
				{
					myGender = 4;
				}
				
				//set mhr(max hear rate) use the using forumula below 
				mhr = Math.round((float)(210 - (myAge / 2) - (.05 * myWeight) + myGender));
				
				//Setting the text for heart rate to displace the mhr
				heartRate.setText(Integer.toString(mhr));
				
				//Setting all the zones to disply the correct % of mhr for the low zones by recasting mhr as an int 
				low1.setText(Integer.toString((int)(mhr*.50)));
				low2.setText(Integer.toString((int)(mhr*.60)));
				low3.setText(Integer.toString((int)(mhr*.70)));
				low4.setText(Integer.toString((int)(mhr*.80)));
				low5.setText(Integer.toString((int)(mhr*.90)));
				
				//Setting all the zones to disply the correct % of mhr for the hi zones by recasting mhr as an int
				hi1.setText(Integer.toString((int)(mhr*.60)));
				hi2.setText(Integer.toString((int)(mhr*.70)));
				hi3.setText(Integer.toString((int)(mhr*.80)));
				hi4.setText(Integer.toString((int)(mhr*.90)));
				hi5.setText(Integer.toString((int)(mhr)));
				
			}
		});
		
		//creating an action listener for the again button which will create a new instance of the program
		again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//sets only insance of the program to invisible 
				setVisible(false);
				createNew();
			}
		});

	}
	
	//main method that creates the fuction createNew
	public static void main(String[] args) 
	{
		createNew();
	}
	
	public static void createNew()
	{
		HeartRateZone frame = new HeartRateZone();						//Creates the GUI 
		frame.setTitle("Heart Rate Training Zones Calculator");			//set the title of GUI window
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0,5));		//set layout style to flow layout
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);						//set the size of the GUI window
		frame.setResizable(false);										//will not all the person to resize GUI window
		frame.setVisible(true);											//sets GUI to visible

	}

}