package com.galaxy;

import java.util.List;

public class TypeQuestion {

	public static boolean isNormalQuestion(List<String> command) {
		String inputString = "";
		for (String str : command) {
			inputString += str;
		}

		if (inputString.contains("hasless") || inputString.contains("hasmore") || inputString.contains("largerthan")
				|| inputString.contains("smallerthan")) {
			return false;
		}

		return true;
	}

}
