package com.galaxy;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StoreInMap {
	public static void storeInStoreMap(List<String> command, Map<Character, Float> generalMap,
		Map<Character, Map.Entry<String, Float>> storeMap) {
		String key = command.get(0);
		String value = command.get(2);
		Float intValue = generalMap.get(value.charAt(0));
		char ch = value.charAt(0);
		storeMap.put(ch, new AbstractMap.SimpleEntry<>(key, intValue));
	}

	public static void calculateAndStoreInStoreMap(List<String> command, char countCharacter,
			Map<Character, Map.Entry<String, Float>> storeMap) {
		Float total = 0f;
		String newString = "";
		List<String> temp = new ArrayList<>();

		for (String token : command) {
			if ("is".equals(token) || "Credits".equals(token)) {
				continue;
			} else if (CommonFunc.isNumeric(token)) {
				total = Float.parseFloat(token);
			} else {
				for (Entry<Character, Entry<String, Float>> entry : storeMap.entrySet()) {
					String associatedString = entry.getValue().getKey();

					if (associatedString.equals(token)) {
						temp.add(token);
					} else {
						newString = token;
					}
				}
			}
		}

		String roman = "";

		for (String value : temp) {
			for (Map.Entry<Character, Map.Entry<String, Float>> entry : storeMap.entrySet()) {
				char entryKey = entry.getKey();
				String associatedString = entry.getValue().getKey();

				if (value.equals(associatedString)) {
					roman = roman + entryKey;
				}
			}
		}

		int remain = CommonFunc.romanToInt(roman);

		// Check if 'newString' is not empty before performing the division
		if (!newString.isEmpty()) {
			float result = total / remain;
			storeMap.put(countCharacter, new AbstractMap.SimpleEntry<String, Float>(newString, result));

		}

		for (Map.Entry<Character, Map.Entry<String, Float>> entry : storeMap.entrySet()) {
			char entryKey = entry.getKey();
			String associatedString = entry.getValue().getKey();
			Float associatedValue = entry.getValue().getValue();
			//System.out.println(associatedValue);

		}

	}
}
