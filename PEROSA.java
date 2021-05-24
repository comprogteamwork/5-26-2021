package AirlineReservation;

import java.io.FileNotFoundException;

public class PEROSA{

        public static void main(String[] args){
        	
			
			AirlineType jonnyPassenger = new AirlineType();
            try {
				jonnyPassenger.AirlineType();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}




 }
 