package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
    /*****************************************************
    ****Do not modify the code in this main method********
    ******************************************************/
		Scanner input = new Scanner(System.in);
		String pwd = input.nextLine();
		
		if(pwd.length()>15) {
			System.out.println("The length: "+pwd.length());
		}
		else {
			System.out.println("The length: "+pwd.length());
			System.out.println("The number of digits: "+Password.numDigits(pwd));
			System.out.println("The number of alphabets: "+Password.numLetters(pwd));
			System.out.println("The number of symbols: "+Password.numSymbols(pwd));
			System.out.println("Strength of your password: "+Password.Strength(pwd));
		}
	}
}
