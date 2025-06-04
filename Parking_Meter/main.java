package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		ParkingMeter meter1 = new ParkingMeter(1.5, "adminABC");
		
		meter1.startSession("CS1234", 3.0); // for 2.0 hours
		meter1.showSession();
		
		System.out.println("Is session valid?" + meter1.isSessionValid());
		
        meter1.stopSession("CS1235"); //carPlate is incorrect.
		meter1.stopSession("CS1234");
		meter1.showSession();	
        
        System.out.println("*******************");
        ParkingMeter meter2 = new ParkingMeter(3.0, "adminABC");
        meter2.changeRate("adminBCD", 3.0); //admin password is incorrect.
		meter2.changeRate("adminABC", 3.0);

        meter2.startSession("CS5678", 3.0); //for 1.0 hour
        meter2.showSession();
        System.out.println("Is session valid?" + meter2.isSessionValid());

        System.out.println("*******************");
        ParkingMeter meter3 = new ParkingMeter(2.0, "adminABC");
        meter3.showSession();
        System.out.println("Is session valid?" + meter3.isSessionValid());
	}
}
