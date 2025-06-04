package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

/**********************************************
* Do not modify the client code****************
***********************************************/
public class Main {
	public static void main(String args[]) {
		    IntList list1 = new IntList();
			
			int size = (int)(Math.random()*10)+5;
			System.out.println(size);
			for(int i=0; i<size; i++) {
				list1.addLast((int)(Math.random()*10)); //add pseudo-random integers to the list
			}
					
			System.out.println("What do we have in our list?: ");
			System.out.println(list1); //what do we have in our list?
			
			int[] result = new int[size];
			result = list1.toArray();
            System.out.println("What do we have in the array?: ");
			for(int i=0; i<size; i++) {
				System.out.print(result[i]+" ");
			}
	}
}