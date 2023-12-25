package com.galaxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SolveQuestion {
	public static boolean findInstoreMap(String str, Map<Character, Map.Entry<String, Float>> storeMap) {
		for (Map.Entry<Character, Map.Entry<String, Float>> entry : storeMap.entrySet()) {
			String associatedString = entry.getValue().getKey();
			if (str.equals(associatedString)) {
				return true;
			}
		}
		return false;
	}

	public static float solveNormalQuestion(List<String> command, Map<Character, Map.Entry<String, Float>> storeMap) {
		String romanString = "";
		float multiFactor = 1;
		List<String> temp = new ArrayList<>();
		for (String str : command) {
			for (Map.Entry<Character, Map.Entry<String, Float>> entry : storeMap.entrySet()) {
				char entryKey = entry.getKey();
				String associatedString = entry.getValue().getKey();
				Float associatedValue = entry.getValue().getValue();

				if (str.equals(associatedString) && Character.isDigit(entryKey) == false) {
					romanString += entryKey;
					temp.add(associatedString);
				} else if (str.equals(associatedString) && Character.isDigit(entryKey)) {
					multiFactor = associatedValue;
				}
			}
		}

		if (CommonFunc.validationOfRomanNumerals(romanString)) {
			int ans = CommonFunc.romanToInt(romanString);
			for (String str : temp) {
				System.out.print(str + " ");
			}
			System.out.println(" is " + ans * multiFactor + " Credits");
			return ans * multiFactor;

		} else {
			System.out.println("Requested number is in invalid format");
			return -1;
		}
	}

	public static float solveComparisionQuestion(List<String> command,
			Map<Character, Map.Entry<String, Float>> storeMap) {
		String romanString = "";
		float multiFactor = 1;
		List<String> temp = new ArrayList<>();
		for (String str : command) {
			for (Map.Entry<Character, Map.Entry<String, Float>> entry : storeMap.entrySet()) {
				char entryKey = entry.getKey();
				String associatedString = entry.getValue().getKey();
				Float associatedValue = entry.getValue().getValue();

				if (str.equals(associatedString) && Character.isDigit(entryKey) == false) {
					romanString += entryKey;
					temp.add(associatedString);
				} else if (str.equals(associatedString) && Character.isDigit(entryKey)) {
					multiFactor = associatedValue;
				}
			}
		}
		temp.add(romanString);
		if (CommonFunc.validationOfRomanNumerals(romanString)) {
			int ans = CommonFunc.romanToInt(romanString);
			return ans * multiFactor;

		} else if (romanString.length() == 0) {
			return multiFactor;
		}
		return multiFactor;
	}

	public static void solveContainMoreLessLargerSmaller(List<String> commands,
			Map<Character, Map.Entry<String, Float>> storeMap, Map<String, Integer> checkUniqeKey) {

		List<String> left = new ArrayList<>();
		List<String> right = new ArrayList<>();
		boolean flag = false;
		String middleString = "";
		for (String str : commands) {
			if (checkUniqeKey.containsKey(str)) {
				middleString = str;
				flag = true;
			} else if (findInstoreMap(str, storeMap)) {

				if (flag == false) {
					left.add(str);
				} else {
					right.add(str);
				}
			}
		}
		if (left.size() == 0 && right.size() == 0) {
			System.out.println("I have no idea what you are talking about");
			return;
		}
		String str1 = "has less Credits than";
		String str2 = "has more Credits than";
		String str3 = "is larger than";
		String str4 = "is smaller than";
		if (str1.contains(middleString) == true) {
			middleString = str1;
		}
		if (str2.contains(middleString) == true) {
			middleString = str2;
		}
		if (str3.contains(middleString) == true) {
			middleString = str3;
		}
		if (str4.contains(middleString) == true) {
			middleString = str4;
		}

		float leftInt = SolveQuestion.solveComparisionQuestion(left, storeMap);
		float rightInt = SolveQuestion.solveComparisionQuestion(right, storeMap);

		if (leftInt == -1) {
			System.out.println("Getting leftInt -1");
			return;
		}
		if (rightInt == -1) {
			System.out.println("Getting rightINT -1");
			return;
		}
		if (leftInt < rightInt) {
//			System.out.print(middleString);
			if(middleString.contains("more")== true || middleString.contains("larger")==true) {
				if(middleString.contains("more")==true) {
					middleString=middleString.replace("more", "less");
				}else {
					middleString=middleString.replace("larger", "smaller");
				}
			}
			for (String t : left) {
				System.out.print(t + " ");
			}

			System.out.print(middleString);

			for (String t : right) {
				System.out.print(" " + t);
			}

			System.out.println();

		} else {
//			System.out.println(middleString);
//			middleString=swapFunction(middleString);
			if(middleString.contains("less") || middleString.contains("smaller")) {
				if(middleString.contains("less")) {
					middleString=middleString.replace("less", "more");
				}else {
					middleString=middleString.replace("smaller", "larger");
				}
			}
			
			for (String t : left) {
				System.out.print(t+" ");
			}
			
			System.out.print(middleString);
			
			for (String t : right) {
				System.out.print(" "+t);
			}
			System.out.println();
		}
	}

}
