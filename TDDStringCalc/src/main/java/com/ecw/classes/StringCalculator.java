package com.ecw.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	private static final String REPLACEMENT_DELIMITER = "<<CUSTOM>>";
	
	public int add(String numbers) {
		int result = 0;
		try {
			if(numbers != null && !numbers.isEmpty()) {
				List<Integer> numbersList = extractInputNumbers(numbers);
				result = numbersList.stream().mapToInt(i -> i.intValue()).sum();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private List<Integer> extractInputNumbers(String numbers) {
		List<Integer> list = new ArrayList<>();
		
		if(numbers.startsWith("//")) {
			numbers = numbers.replace("//", "");
			int deliIndex = numbers.indexOf("\n");
			String custDeli = numbers.substring(0, deliIndex);
			numbers = numbers.substring(deliIndex  + 1);
			numbers = numbers.replaceAll("["+custDeli+"]", REPLACEMENT_DELIMITER);
		}
		
		numbers = numbers.replaceAll("\\n", REPLACEMENT_DELIMITER);
		numbers = numbers.replaceAll(",", REPLACEMENT_DELIMITER);
		
		String[] splitter = numbers.split(REPLACEMENT_DELIMITER);
		if(splitter != null && splitter.length > 0) {
			String strNum = null;
			for (int i = 0; i < splitter.length; i++) {
				strNum = splitter[i];
				System.out.println(strNum);
				if(strNum != null && !strNum.isEmpty()) {
					list.add(Integer.parseInt(strNum));
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(new StringCalculator().add("1,2"));
	}

	private String[] extractCustomDelimiters(String numbers) {
		Pattern pattern = Pattern.compile("(.*?)\\n");
		
		//\[(.*?)\]
		
		Matcher matcher = pattern.matcher(numbers);
		int n = matcher.groupCount();

		String[] deliArr = pattern.split(numbers);
		System.out.println("Custom DELI >> " + deliArr.toString());
		return deliArr;
	}	
}
