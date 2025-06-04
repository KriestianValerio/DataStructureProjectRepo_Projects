package elice;

public class Password {
	
	//return the number of symbols in a given password
	//Symbols are neither alphabets or digits.
	public static int numSymbols(String pwd) {
		//implement here.
        int symbols = 0;
        for (int i=0; i<pwd.length(); i++) {
            char charac = pwd.charAt(i);

            if (!Character.isLetterOrDigit(charac)) {
                symbols++;
            }
        }
        return symbols;
	}
	
    //return the number of alphabets
	public static int numLetters(String pwd) {
		//implement here.
        int letters = 0;
        for (int i=0; i<pwd.length(); i++) {
            char charac = pwd.charAt(i);

            if (Character.isLetter(charac)) {
                letters++;
            }
        }
        return letters;
	
	}
	
    //return the number of digits (0 - 9)
	public static int numDigits(String pwd) {
		//implement here.
        int digits = 0;
        for (int i=0; i<pwd.length(); i++) {
            char charac = pwd.charAt(i);

            if (Character.isDigit(charac)) {
                digits++;
            }
        }
        return digits;
	}
    
    //Find HW1 instructions (PDF file)
	public static String Strength(String pwd) {
		//implement here.
        int passlength = pwd.length();

        int numofsymbol = numSymbols(pwd);
        int numofletter = numLetters(pwd);
        int numofdigits = numDigits(pwd);

        if (passlength >= 8 && numofdigits >= 1 && numofletter >= 1 && numofsymbol >= 1) {
            return "strong";
        }
        else if ((passlength >= 5 && passlength < 8 && numofsymbol >= 1) || (passlength>=8 && (numofdigits == 0 || numofletter == 0 || numofsymbol == 0 ))) {
            return "medium";
        }
        else if ((passlength >= 5 && passlength < 8 && numofsymbol == 0) || passlength < 5) {
            return "weak";
        }
        else {
            return "weak";
        }

       
        
    }
}
