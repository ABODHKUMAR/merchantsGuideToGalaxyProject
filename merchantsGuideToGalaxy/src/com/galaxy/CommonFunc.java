package com.galaxy;

import java.util.List;
import java.util.Map;

public class CommonFunc {

	public static boolean validationOfRomanNumerals(String str) {

		String pattern = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

		if (str.isEmpty()) {
			return false;
		}

		if (str.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNumeric(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}

		boolean hasDecimalPoint = false;

		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				if (c == '.' && !hasDecimalPoint) {
					hasDecimalPoint = true;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public static int romanToInt(String s) {
		int ans = 0, num = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			}
			if (4 * num < ans)
				ans -= num;
			else
				ans += num;
		}
		return ans;
	}

	public static int checkQuestionMark(List<String> command) {
		int len = command.size();
		int lastIndex = len - 1;
		String temp = command.get(lastIndex);
		if (temp.equals("?")) {
			return 1;
		}
		return 0;
	}

	public static int checkValidQuestion(List<String> command, Map<Character, Map.Entry<String, Float>> storeMap) {
		int flag = 0;
		for (String s : command) {
			for (Map.Entry<Character, Map.Entry<String, Float>> entry : storeMap.entrySet()) {
				String associatedString = entry.getValue().getKey();
				if (s.equals(associatedString)) {
					flag = 1;
				}

			}
		}

		return flag;

	}

}
