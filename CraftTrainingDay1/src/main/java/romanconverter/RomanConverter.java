package romanconverter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RomanConverter {
	
	private HashMap<Integer, String> romanNumerals = new HashMap<>();
	
	public RomanConverter() {
		romanNumerals.put(1, "I");
		romanNumerals.put(5, "V");
		romanNumerals.put(10, "X");
		romanNumerals.put(50, "L");
		romanNumerals.put(100, "C");
		romanNumerals.put(500, "D");
		romanNumerals.put(1000, "M");
	}

	public String convert(int number) {
		StringBuilder romanNumber = new StringBuilder();
		if(number >= 1000) {
			do {
				number = getRomanDigitFromNumber(number, 1000, romanNumber);
			} while(number >= 1000);
		}
		if(number >= 500) {
			number = getRomanDigitFromNumber(number, 500, romanNumber);
		}
		if(number >= 100) {
			do {
				number = getRomanDigitFromNumber(number, 100, romanNumber);
			} while(number >= 100);
		}
		if(number >= 50) {
			number = getRomanDigitFromNumber(number, 50, romanNumber);
		}
		if(number >= 10) {
			do {
				number = getRomanDigitFromNumber(number, 10, romanNumber);
			} while(number >= 10);
		}
		if(number >= 5) {
			number = getRomanDigitFromNumber(number, 5, romanNumber);
		}
		if(number < 4 && number > 0) {
			do {
				number = getRomanDigitFromNumber(number, 1, romanNumber);
			} while(number > 0);
		}
		return romanNumber.toString();
	}
	
	private int getRomanDigitFromNumber(int number, int subtractor, StringBuilder romanNumber) {
		romanNumber.append(romanNumerals.get(subtractor));
		return number - subtractor;
	}
	
	/*private int getRomanDigitsToRepertFromNumber(int number, int subtractor, StringBuilder romanNumber) {
		if(number >= 100 || number >= 10 || number < 4) {
			do {
				number = getRomanDigitFromNumber(number, subtractor, romanNumber);
			} while(number >= subtractor && number > 0);
		} else {
			number = getRomanDigitFromNumber(number, subtractor, romanNumber);
		}
		return number;
	}*/
}
