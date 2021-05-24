 package AirlineReservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class Receipt extends AirlineType{	
	JFrame receiptFrame;
	JPanel receiptPanel;
	JButton confirm, cancelReceipt;
	JLabel name, age, travelType, airplaneType, travelDestination, printName, printAge, printTravelType,
			printAirplaneType,printTravelDestination, transactionNumber,perosaName,perosaqoute,perosathanks;
	
	
	
	void receiptMethod() {
		
		PassengerAll[TransactionCounting][0] = String.valueOf(OverAllTransaction);
	
		
		receiptFrame = new JFrame("RECEIPT FRAME");
		receiptFrame.setBounds(400,100,500,500);
		receiptFrame.setVisible(true);
		receiptFrame.setLayout(null);
		receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		receiptFrame.getContentPane().setBackground(Color.cyan);
		receiptFrame.setResizable(false);
		
		
		receiptPanel = new JPanel();
		receiptFrame.getContentPane().add(receiptPanel);
		receiptPanel.setLayout(null);
		receiptPanel.setBackground(Color.LIGHT_GRAY);
		receiptPanel.setBounds(17,15,450,430);
		
		perosaName = new JLabel("PEROSA");
		receiptPanel.add(perosaName);
		perosaName.setBounds(150,50,300,20);
		perosaName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		
		perosaqoute = new JLabel("YOUR SAFETY IS OUR PRIORITY");
		receiptPanel.add(perosaqoute);
		perosaqoute.setBounds(100,70,300,30);
		perosaqoute.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	
	
		name = new JLabel("NAME:");
		receiptPanel.add(name);
		name.setBounds(80,100,420,30);
				
		printName = new JLabel(" "+PassengerAll[TransactionCounting][1]);
		receiptPanel.add(printName);
		printName.setBounds(250,100,420,30);

		

		age = new JLabel("AGE:");
		receiptPanel.add(age);
		age.setBounds(80,120,420,30);
		
		
		printAge = new JLabel(""+ PassengerAll[TransactionCounting][2]);
		receiptPanel.add(printAge);
		printAge.setBounds(250,120,420,30);

		
		airplaneType = new JLabel("SEAT CLASS:");
		receiptPanel.add(airplaneType);
		airplaneType.setBounds(80,140,420,30);

		printAirplaneType= new JLabel(""+PassengerAll[TransactionCounting][3]);
		receiptPanel.add(printAirplaneType);
		printAirplaneType.setBounds(250,140,420,30);
		

		travelType = new JLabel("TRAVEL TYPE:");
		receiptPanel.add(travelType);
		travelType.setBounds(80,160,420,30);
		
		
		printTravelType = new JLabel(""+PassengerAll[TransactionCounting][4]);
		receiptPanel.add(printTravelType);
		printTravelType.setBounds(250,160,420,30);
		
	
		travelDestination = new JLabel("TRAVEL DESTINATION:");
		receiptPanel.add(travelDestination);
		travelDestination.setBounds(80,180,420,30);
	
		
		printTravelDestination = new JLabel(""+PassengerAll[TransactionCounting][5]);
		receiptPanel.add(printTravelDestination);
		printTravelDestination.setBounds(250,180,420,30);
		
	
		
		transactionNumber = new JLabel("Transaction Number"+ PassengerAll[TransactionCounting][0]); 
		receiptPanel.add(transactionNumber);
		transactionNumber.setBounds(150,200,400,100);
		
		
		perosathanks = new JLabel("THANK YOU FOR CHOOSING PEROSA AIRLINE");
		receiptPanel.add(perosathanks);
		perosathanks.setBounds(80,340,600,20);
		perosathanks.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
		
		confirm = new JButton("CLOSE");
		receiptPanel.add(confirm);
		confirm.setBounds(180,375,100,50);
		confirm.addActionListener(this);
		
	
        
        
        
        
		
		
	}
	public void actionPerformed(ActionEvent e) {
		AirlineType jonnyPassenger = new AirlineType();
        
		if(e.getSource()==confirm) {
			
		int bookAgain = JOptionPane.showConfirmDialog(null, "Do you Want to Book Another Ticket?");
		
		if(bookAgain == 0) {
			
			try {
				jonnyPassenger.AirlineType();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			receiptFrame.dispose();
			
		}
		else if (bookAgain==1) {
			System.exit(0);
		}
		
		}		
	}
}