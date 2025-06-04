package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
        StackNode.main(null); //invoke a unit test of QueueNode
        //Test your implementation of Stack Iterator (#4)
        System.out.println("****************************");
        
	   Roster list = new Roster();
       list.add("Alice", "20221001");
       list.add("Bob", "20217834");
       list.add("Carol", "20231559");
       list.add("Daniel", "20201334");
       list.add("Chris", "20217997");
       System.out.println("Print all students in roster:");
       list.display();
       System.out.println("*****************************");
       
       list.update("Carol", "20221559");
       list.remove("Chris");
       System.out.println("Bob " + list.search("Bob"));
       System.out.println("Chris " + list.search("Chris"));
       System.out.println("*****************************");
       
       System.out.println("Updated roster:");
       list.display();
	}
}
