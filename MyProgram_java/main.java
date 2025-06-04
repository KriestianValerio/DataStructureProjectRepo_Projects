package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String[] args) {
	// the program is ready for the interpreter:
       String[][] sample =  
           {{"x", "=", "9"},       // line 0
            {"y", "=", "5"},      // line 1
            {"x", "-=", "y"},      // line 2
            {"x", "*=", "3"},      // line 3
            {"x", "println"}};     // line 4
       
       MySecondProgram mp = new MySecondProgram(sample);
       System.out.println(mp.complete());         // false 
       System.out.println(mp.counter()); // 0 (always start w/ line 0)
       
       // run through program
       mp.execute();                          // line 0 sets x = 9
       // next command prints: currently x is 9
       System.out.println("currently x is " + mp.currentVal("x")); 
       mp.execute();                          // line 1 sets y = 5
       mp.execute();                          // line 2 sets x = 4
       mp.execute();                          // line 3 multiplies x value by 3: 12
       mp.execute();                          // line 4 prints x value, 12
       
       System.out.println(mp.complete());        // true (program is finished)
   }
   }
