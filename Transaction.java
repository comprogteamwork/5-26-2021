package AirlineReservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends AirlineType{
	
	JFrame transactionFrame;
	JPanel TransactionPanel;
	JButton Payment, PaymentCancel;
	JTextField inputPayment;
	
	JLabel transactionProcessingFeeLabel, taxfee, fare, baggage, insurance, totalPayment, 
	airlineType,travelType, passengerDestination, passengerName, passengerAge,
	printName, printAge, printAirlineType, printTravelType, printDestination, 
	printProcessingFee, printTax, printFare, printBaggageFee, printInsuranceFee ,
	printTotalPayment, totalPassenger, printTotalPassenger, child, adult, senior,
	childDisplay, adultDisplay, seniorDisplay,childshowPayment, adultshowPayment,
	seniorshowPayment,confirmPayment;
	
	double overAllPayment,seniorTotalPayment,seniorDiscount,userPaymentInput,passengersChange;
	int childTotalPayment,adultTotalPayment,passengerPayment,deductTotalPassengerCount;
	String gettingUserPayment;

	
	
	
	
	
	void falseHiding() {		
		
		 if(passenger.childCount==0 ) {
			 
				child.setVisible(false);
				childshowPayment.setVisible(false);
				childDisplay.setVisible(false);
				if(passenger.seniorCount==0) {
					senior.setVisible(false);
					seniorshowPayment.setVisible(false);
					seniorDisplay.setVisible(false);
					
				}else if(passenger.adultCount==0) {
					adult.setVisible(false);
					adultshowPayment.setVisible(false);
					adultDisplay.setVisible(false);
				
				}
			
			}else if(passenger.adultCount==0) {
				
				adult.setVisible(false);
				adultshowPayment.setVisible(false);
				adultDisplay.setVisible(false);
			
			}else if(passenger.seniorCount==0){
				
				senior.setVisible(false);
				seniorshowPayment.setVisible(false);
				seniorDisplay.setVisible(false);
				
								
			}
						
		 
	}
		
	void finalComputation() {
		passenger passenger = new passenger();
		passengerPayment = 	Integer.parseInt(PassengerAll[TransactionCounting][6])+Integer.parseInt(PassengerAll[TransactionCounting][7])+
				Integer.parseInt(PassengerAll[TransactionCounting][8])+Integer.parseInt(PassengerAll[TransactionCounting][9])+
				Integer.parseInt(PassengerAll[TransactionCounting][10]);
		
		
		childTotalPayment = passengerPayment * passenger.childCount;
		System.out.println("child total fare"+ childTotalPayment);
		
		adultTotalPayment = passengerPayment * passenger.adultCount;
		System.out.println("adult total fare"+ adultTotalPayment);
		
		seniorDiscount = Integer.parseInt(PassengerAll[TransactionCounting][8])*.20;
		seniorTotalPayment = (passengerPayment  * passenger.seniorCount -seniorDiscount)-Integer.parseInt(PassengerAll[TransactionCounting][7]  );
		System.out.println("senior total fare"+ seniorTotalPayment);
		
		
		 if(passenger.childCount==0) {
			 overAllPayment =adultTotalPayment+seniorTotalPayment;
				System.out.println("child=0");
			
			/*	child.setVisible(false);
				childshowPayment.setVisible(false);
				childDisplay.setVisible(false);
				*/
			}else if(passenger.adultCount==0) {
				overAllPayment =childTotalPayment+seniorTotalPayment;
				
			/*	System.out.println("adult=0");
				adult.setVisible(false);
				adultshowPayment.setVisible(false);
				adultDisplay.setVisible(false);
			*/	
			}else if(passenger.seniorCount==0){
				overAllPayment =childTotalPayment+adultTotalPayment;
				System.out.println("senior=0");
		/*		senior.setVisible(false);
				seniorshowPayment.setVisible(false);
				seniorDisplay.setVisible(false);
		*/		
				
				
					
			} else {
				overAllPayment =childTotalPayment+adultTotalPayment+seniorTotalPayment;
				System.out.println("over all payment" + overAllPayment)	;
				
			
			} 
		 
	}
	
	void Transaction() {
		finalComputation();
	
		transactionFrame = new JFrame("TRANSACTION FRAME");
		transactionFrame.setBounds(400,100,500,500);
		transactionFrame.setVisible(true);
		transactionFrame.setLayout(null);
    	transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	transactionFrame.getContentPane().setBackground(Color.LIGHT_GRAY);;
    	transactionFrame.setResizable(false);
    	
    	
        TransactionPanel = new JPanel();
        
        transactionFrame.getContentPane().add(TransactionPanel);
        TransactionPanel.setLayout(null);
        TransactionPanel.setBackground(Color.GRAY);
        TransactionPanel.setBounds(17,15,450,430);
        
        
        passengerName = new JLabel("Name:");
        TransactionPanel.add(passengerName);
        passengerName.setBounds(30,0,120,30);
        
        
        printName = new JLabel("     "+ PassengerAll[TransactionCounting][1]);
        TransactionPanel.add(printName);
        printName.setBounds(150,0,120,30);
        
        passengerAge = new JLabel("Age:");
        TransactionPanel.add(passengerAge);
        passengerAge.setBounds(30,20,120,30);
        
        printAge = new JLabel("     "+ PassengerAll[TransactionCounting][2]);
        TransactionPanel.add(printAge);
        printAge.setBounds(150,20,120,30);
        
        airlineType = new JLabel("Airline Type" );
        TransactionPanel.add(airlineType);
        airlineType.setBounds(30,40,120,30);
        
        printAirlineType = new JLabel("     "+ PassengerAll[TransactionCounting][3]);
        TransactionPanel.add(printAirlineType);
        printAirlineType.setBounds(150,40,120,30);
        
        travelType = new JLabel("Travel Type" );
        TransactionPanel.add(travelType);
        travelType.setBounds(30,60,120,30);
        
        printTravelType = new JLabel("     "+ PassengerAll[TransactionCounting][4]);
        TransactionPanel.add(printTravelType);
        printTravelType.setBounds(150,60,120,30);
        
        passengerDestination = new JLabel("Destination" );
        TransactionPanel.add(passengerDestination);
        passengerDestination.setBounds(30,80,120,30);
        
        printDestination = new JLabel("     "+ PassengerAll[TransactionCounting][5]);
        TransactionPanel.add(printDestination);
        printDestination.setBounds(150,80,120,30);  
        
        transactionProcessingFeeLabel = new JLabel("transaction Fee:  " );
        TransactionPanel.add(transactionProcessingFeeLabel);
        transactionProcessingFeeLabel.setBounds(30,100,420,30);
        
        printProcessingFee = new JLabel("     "+ PassengerAll[TransactionCounting][6]);
        TransactionPanel.add(printProcessingFee);
        printProcessingFee.setBounds(150,100,120,30);
        
        
        taxfee = new JLabel("transaction Tax:  " );
        TransactionPanel.add(taxfee);
        taxfee.setBounds(30,120,420,30);
        
        printTax = new JLabel("     "+ PassengerAll[TransactionCounting][7]);
        TransactionPanel.add(printTax);
        printTax.setBounds(150,120,120,30);
        
        
        fare = new JLabel("Fare:  ");
        TransactionPanel.add(fare);
        fare.setBounds(30,140,420,30);
        
        printFare = new JLabel("     "+ PassengerAll[TransactionCounting][8]);
        TransactionPanel.add(printFare);
        printFare.setBounds(150,140,120,30);
        
        baggage = new JLabel("baggage Fee:  " );
        TransactionPanel.add(baggage);
        baggage.setBounds(30,160,420,30);
        
        printBaggageFee = new JLabel("     "+ PassengerAll[TransactionCounting][9]);
        TransactionPanel.add(printBaggageFee);
        printBaggageFee.setBounds(150,160,120,30);
        
        insurance = new JLabel("insurance Fee:  ");
        TransactionPanel.add(insurance);
        insurance.setBounds(30,180,420,30);
        insurance.setVisible(false);
        
        printInsuranceFee = new JLabel("     " + PassengerAll[TransactionCounting][10]);
        TransactionPanel.add(printInsuranceFee);
        printInsuranceFee.setBounds(150,180,120,30);
        printInsuranceFee.setVisible(false);
        
        
        totalPassenger = new JLabel("Total Passenger:");
        TransactionPanel.add(totalPassenger);
        totalPassenger.setBounds(30,200,420,30);
        
        printTotalPassenger = new JLabel("     "+ PassengerAll[TransactionCounting][12]);
        TransactionPanel.add(printTotalPassenger);
        printTotalPassenger.setBounds(150,200,120,30);
     
        child = new JLabel("Child:");
        TransactionPanel.add(child);
        child.setBounds(30,220,120,30);
   //    child.setVisible(false);
       
        
        childshowPayment = new JLabel("                "+ childTotalPayment);
        TransactionPanel.add(childshowPayment);
        childshowPayment.setBounds(200,220,120,30);
    //    childshowPayment.setVisible(false);
        
        adult = new JLabel("Adult:");
        TransactionPanel.add(adult);
        adult.setBounds(30,240,120,30);
    //    adult.setVisible(false);
          
        adultshowPayment = new JLabel("                "+adultTotalPayment);
        TransactionPanel.add(adultshowPayment);
        adultshowPayment.setBounds(200,240,120,30);
    //    adultshowPayment.setVisible(false);
        
        senior = new JLabel("Senior:");
        TransactionPanel.add(senior);
        senior.setBounds(30,260,120,30);
     //   senior.setVisible(false);
        
        
        seniorshowPayment = new JLabel("                "+ seniorTotalPayment);
        TransactionPanel.add(seniorshowPayment);
        seniorshowPayment.setBounds(200,260,120,30);
     //   seniorshowPayment.setVisible(false);
        
        
      passenger getpassenger = new passenger();
        
        childDisplay = new JLabel("     "+getpassenger.childCount);
        TransactionPanel.add(childDisplay);
        childDisplay.setBounds(150,220,120,30);
       
        
        adultDisplay = new JLabel("     "+getpassenger.adultCount);
        TransactionPanel.add(adultDisplay);
        adultDisplay.setBounds(150,240,120,30);
        
        seniorDisplay = new JLabel("     "+getpassenger.seniorCount);
        TransactionPanel.add(seniorDisplay);
        seniorDisplay.setBounds(150,260,120,30);
        
        totalPayment = new JLabel("Amount Payable:  ");
        TransactionPanel.add(totalPayment);
        totalPayment.setBounds(30,280,420,30);
        
        printTotalPayment = new JLabel(""+ overAllPayment);
        TransactionPanel.add(printTotalPayment);
        printTotalPayment.setBounds(245,280,120,30);
        
        confirmPayment = new JLabel("PLEASE ENTER THE AMOUNT TO PAY");
        TransactionPanel.add(confirmPayment);
        confirmPayment.setBounds(120,310,420,40);
        
   
        inputPayment = new JTextField();
        TransactionPanel.add(inputPayment);
        inputPayment.setBounds(160,345,100,30);
        inputPayment.addActionListener(this);
        
          
        Payment = new JButton("Pay");
        TransactionPanel.add(Payment);
        Payment.setBounds(160,380,100,40);
        Payment.addActionListener(this);
      
    	falseHiding();
	}  
        @Override
    	public void actionPerformed(ActionEvent e) {
        	if(e.getSource()==Payment) {
        	Receipt Receipt = new Receipt();
        	Transaction Transaction = new Transaction();
   
        	gettingUserPayment = inputPayment.getText();
        	userPaymentInput = Double.parseDouble(gettingUserPayment);
        	
	        	
	        	if(userPaymentInput > overAllPayment) {
	        		passengersChange = userPaymentInput - overAllPayment;
	        	 	Receipt.receiptMethod();
	        	 	transactionFrame.dispose();
	        	 	
	        	}else if(userPaymentInput < overAllPayment) {
	        	userPaymentInput = 0;
	        	JOptionPane.showMessageDialog(null, "AMOUNT SHOULD BE GREATER THAN " +overAllPayment, "INVALID INPUT",JOptionPane.ERROR_MESSAGE);
	        	
	        	Transaction.Transaction();
	    		Transaction.insurance.setVisible(true);
	    		transactionFrame.dispose();  
	        	}
        	 
        	 	
	        }	
	}
}

