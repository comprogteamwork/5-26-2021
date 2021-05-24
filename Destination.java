package AirlineReservation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Destination extends AirlineType {
	static int confirmationButton = 0;
	int isa;
	JFrame Destination;
	JButton buttonLocal, buttonInternational, nextPassengerDetails, cancelDestination;
	JComboBox comboBoxInternational, comboBoxLocal, defaultComboBox;
	JLabel chooseTravelType;
	JPanel DestinationPanel;

	public static String International[] = new String[6], Local[] = new String[4];
	
	int selectedValuesLocal, selectedValuesInternational, passengerFare;

	public void Destination() {
    	logoImage = new ImageIcon(new ImageIcon("src/AirlineReservation/pictures/blackperosa.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));


		Destination = new JFrame("DESTINATION FRAME");
		Destination.setBounds(400, 100, 500, 500);
		Destination.setVisible(true);
		Destination.setLayout(null);
		Destination.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Destination.getContentPane().setBackground(Color.CYAN);		
		Destination.setResizable(false);

		
		DestinationPanel = new JPanel();
		DestinationPanel.setLayout(null);
		Destination.getContentPane().add(DestinationPanel);
		DestinationPanel.setBackground(Color.LIGHT_GRAY);
		DestinationPanel.setBounds(17,15,450,430);
		
		
		dashline = new JLabel("-------------------------------------------------------------------------------------------------------------------");
		DestinationPanel.add(dashline);
        dashline.setBounds(0,80,600,30);
        
        airlinelabel = new JLabel(logoImage);
        DestinationPanel.add(airlinelabel);
		airlinelabel.setBounds(-50,-100,300,300);
		airlinelabel.setLayout(null);

		chooseTravelType = new JLabel("Where Would You Like To Go?");
		DestinationPanel.add(chooseTravelType);
		chooseTravelType.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		chooseTravelType.setBounds(90, 115, 300, 40);

		
		buttonLocal = new JButton("local");
		DestinationPanel.add(buttonLocal);
		buttonLocal.setBackground(Color .CYAN);
		buttonLocal.setBounds(160, 150, 120, 45);
		buttonLocal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		buttonLocal.addActionListener(this);
		
		
		buttonInternational = new JButton("International");
		DestinationPanel.add(buttonInternational);
		buttonInternational.setBounds(130, 200, 180, 45);
		buttonInternational.setBackground(Color .CYAN);
		buttonInternational.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		buttonInternational.addActionListener(this);

	
		String[] Default = { "      Choose Destination" };
		defaultComboBox = new JComboBox(Default);
		DestinationPanel.add(defaultComboBox);
		defaultComboBox.setBounds(115, 270, 220, 45);
		defaultComboBox.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		defaultComboBox.setBackground(Color.CYAN);

		Local[0] = "Manila to Batanes";
		Local[1] = "Batanes to Manila";
		Local[2] = "Manila to Palawan";
		Local[3] = "Palawan to Manila";

		comboBoxLocal = new JComboBox(Local);
		comboBoxLocal.setVisible(false);
		DestinationPanel.add(comboBoxLocal);
		comboBoxLocal.setBounds(115, 270, 220, 30);
		comboBoxLocal.setBackground(Color.CYAN);
		comboBoxLocal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		

		International[0] = "Manila to South Korea";
		International[1] = "South Korea to Manila";
		International[2] = "Manila toJapan";
		International[3] = "Japan to Manila";
		International[4] = "Manila to Vietnam";
		International[5] = "Vietnam to Manila";

		comboBoxInternational = new JComboBox(International);
		DestinationPanel.add(comboBoxInternational);
		comboBoxInternational.setVisible(false);
		comboBoxInternational.setBackground(Color.CYAN);
		comboBoxInternational.setBounds(115, 270, 220, 30);
		comboBoxInternational.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		

		nextPassengerDetails = new JButton("Proceed ");
		DestinationPanel.add(nextPassengerDetails);
		nextPassengerDetails.setBounds(100, 340, 120, 30);
		nextPassengerDetails.setBackground(Color.CYAN);
		nextPassengerDetails.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		nextPassengerDetails.addActionListener(this);

		cancelDestination = new JButton("Back");
		DestinationPanel.add(cancelDestination);
		cancelDestination.setBounds(250, 340, 120, 30);
		cancelDestination.setBackground(Color.CYAN);
		cancelDestination.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		cancelDestination.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == cancelDestination) {
				AirlineType jonnyPassenger = new AirlineType();
				OverAllTransaction = OverAllTransaction - 1;
				try {
					jonnyPassenger.AirlineType();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Destination.dispose();

			}

		if (e.getSource() == buttonLocal) {

			PassengerAll[TransactionCounting][4] = "Local";
			System.out.println(PassengerAll[TransactionCounting][4]);
			comboBoxLocal.setVisible(true);
			comboBoxInternational.setVisible(false);
			defaultComboBox.setVisible(false);
			confirmationButton = 1;
		} else if (e.getSource() == buttonInternational) {
			PassengerAll[TransactionCounting][4] = "International";
			System.out.println(PassengerAll[TransactionCounting][4]);
			comboBoxInternational.setVisible(true);
			comboBoxLocal.setVisible(false);
			defaultComboBox.setVisible(false);
			confirmationButton = 2;
		} else if (e.getSource() == nextPassengerDetails) {
			selectedValuesLocal = comboBoxLocal.getSelectedIndex();
			selectedValuesInternational = comboBoxInternational.getSelectedIndex();

			if (confirmationButton == 1) {
				// saving local destination data to two dimensional array
				if (selectedValuesLocal == 0) {
					PassengerAll[TransactionCounting][5] = Local[0];
					knowingDestination = 0;
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "8000";

							} else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "12500";

							} else if (knowingTypeofAirplane == 2) {

								PassengerAll[TransactionCounting][8] = "3500";
							}
							
				}else if (selectedValuesLocal == 1) {
					knowingDestination = 1;
					PassengerAll[TransactionCounting][5] = Local[1];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "9800";
		
							}else if (knowingTypeofAirplane == 1) {
									PassengerAll[TransactionCounting][8] = "12950";
			
							}else if (knowingTypeofAirplane == 2) {
			
									PassengerAll[TransactionCounting][8] = "3900";
							}
									System.out.println(Local[1]);

				}else if (selectedValuesLocal == 2) {
					knowingDestination = 2;
					PassengerAll[TransactionCounting][5] = Local[2];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "9100";
		
							} else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "10500";
		
							} else if (knowingTypeofAirplane == 2) {
		
								PassengerAll[TransactionCounting][8] = "3200";
							}
							System.out.println(Local[2]);

				}else if (selectedValuesLocal == 3) {
					knowingDestination = 3;
					PassengerAll[TransactionCounting][5] = Local[3];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "9850";
			
							} else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "10975";
			
							} else if (knowingTypeofAirplane == 2) {
			
								PassengerAll[TransactionCounting][8] = "3575";
							}
				}
					passenger passenger = new passenger();
					passenger.passengerDetails();
					Destination.dispose();
				
			
			}else if (confirmationButton == 2) {
				
					// Manila to South Korea
					if (selectedValuesInternational == 0) {
						knowingDestination = 4;
						PassengerAll[TransactionCounting][5] = International[0];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "27450";
			
							}else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "37390";
			
							}else if (knowingTypeofAirplane == 2) {
								PassengerAll[TransactionCounting][8] = "12055";
								
						
					//South Korea to Manila
					} else if (selectedValuesInternational == 1) {
						knowingDestination = 5;
						PassengerAll[TransactionCounting][5] = International[1];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "30890";
			
							}else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "39650";
			
							}else if (knowingTypeofAirplane == 2) {
								PassengerAll[TransactionCounting][8] = "13100";				
							}
								
						
					//Manila to Japan		
					} else if (selectedValuesInternational == 2) {
						knowingDestination = 6;
						PassengerAll[TransactionCounting][5] = International[2];
						
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "40450";
			
							}else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "45355";
			
							}else if (knowingTypeofAirplane == 2) {
								PassengerAll[TransactionCounting][8] = "27800";				
							}
					}	
					
					//Japan to Manila		
					} else if (selectedValuesInternational == 3) {
						knowingDestination = 7;
						PassengerAll[TransactionCounting][5] = International[3];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "43385";
			
							}else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "49780";
			
							}else if (knowingTypeofAirplane == 2) {
								PassengerAll[TransactionCounting][8] = "29400";				
							}
	
					//Manila to Vietnam		
					}else if (selectedValuesInternational == 4) {
						knowingDestination = 8;
						PassengerAll[TransactionCounting][5] = International[4];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "8505";
			
							}else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "12345";
			
							}else if (knowingTypeofAirplane == 2) {
								PassengerAll[TransactionCounting][8] = "3200";				
							}
							
					//Vietnam to Manila		
					}else if (selectedValuesInternational == 5) {	
						knowingDestination = 9;
						PassengerAll[TransactionCounting][5] = International[5];
							if (knowingTypeofAirplane == 0) {
								PassengerAll[TransactionCounting][8] = "14300";
			
							}else if (knowingTypeofAirplane == 1) {
								PassengerAll[TransactionCounting][8] = "16320";
			
							}else if (knowingTypeofAirplane == 2) {
								PassengerAll[TransactionCounting][8] = "4600";				
							}
							
						}
					passenger passenger = new passenger();
					passenger.passengerDetails();
					Destination.dispose();
				}
		}
			 else if(confirmationButton ==0) {
				JOptionPane.showMessageDialog(null, "Input Travel Destination", "No Travel Destination Accepted",JOptionPane.ERROR_MESSAGE);
			}
		
	
		
		
	}
}




