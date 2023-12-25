// GalacticMaps.java
package com.galaxy;

import java.util.HashMap;
import java.util.Map;

public class GalacticMaps {
	private static Map<String, Integer> checkUniqeKey = new HashMap<>();
	public static Map<Character, Float> generalMap = new HashMap<>();

	static {
		// Initialize generalMap
		generalMap.put('I', (float) 1);
		generalMap.put('V', (float) 5);
		generalMap.put('X', (float) 10);
		generalMap.put('L', (float) 50);
		generalMap.put('C', (float) 100);
		generalMap.put('D', (float) 500);
		generalMap.put('M', (float) 1000);
	}
	static {
		// Initialize checkUniqeKey
		checkUniqeKey.put("more", 1);
		checkUniqeKey.put("less", 1);
		checkUniqeKey.put("smaller", 1);
		checkUniqeKey.put("larger", 1);
	}

	public static Map<String, Integer> getCheckUniqeKey() {
		return checkUniqeKey;
	}

	public static Map<Character, Float> generalMap() {
		return generalMap;
	}
}
