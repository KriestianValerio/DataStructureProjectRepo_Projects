package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		System.out.println("Testing SinglyLinkedlist");
		SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>();

		int size = (int)(Math.random()*10)+2;
		for(int i=0; i<size; i++) {
			s.addFirst((int)(Math.random()*100)); //add pseudo-random integers to the list
		}
		System.out.println("What do we have in our list?: ");
		System.out.println(s); //what do we have in our list?
		
		System.out.println("\nWe removed "+s.removeLast());//#3. removeLast()
		System.out.println("After removing a tail of the list: ");
        System.out.println(s); 
        		
		
		System.out.println("Enter any integer between 0 and 2^31-1: ");
        Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		System.out.println("Do we have this number in our list?: (using recursive search) "+ num);
		boolean result1 = s.contains_rc(num); // #4. recursive search
		if(result1) {
			System.out.println(num+"  is in our list.");
			System.out.println("How many times does "+num+" appear?: "+s.count(num)); //#6. count()
		}		
		else	           
			System.out.println(num+" is not in our list.");
        
        System.out.println("***Reversely print the linked list***");
        s.reverseDisplay(); 
        // #5. reversely print the linked list, using recursion (without modifying the original linked list)
        
	}
}
