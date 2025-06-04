package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		BikeRentalStation station1 = new BikeRentalStation(5.0, 5); // 5.0 per hour
        station1.startRental("Alice", 101, 10.0); // 2-hour rental
        station1.startRental("Bob", 102, 2.5); // Insufficient payment
        station1.startRental("David", 103, 15.0); // 3-hour rental
        station1.displayRentals();
        station1.stopRental("Alice"); // Rental has ended for Alice 
        station1.displayRentals();
        
        System.out.println("=========================");
        BikeRentalStation station2 = new BikeRentalStation(10.0, 1); // 10.0 per hour
        station2.startRental("Carol", 101, 10.0); // 1-hour rental
        station2.startRental("Bob", 102, 20.0); // No bikes available
        station2.stopRental("Alice"); // No active rental for Alice
	}
}