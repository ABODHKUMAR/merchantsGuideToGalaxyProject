package com.galaxy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.regex.*;


public class Trade {
	
	private static Map<Character, Map.Entry<String, Float>> storeMap = new HashMap<>();
	private static Map<String, Integer> checkUniqeKey = GalacticMaps.getCheckUniqeKey();
	private static Map<Character, Float> generalMap = GalacticMaps.generalMap();
   												
   

	public static void main(String[] args) {

		
		 
		try {
			FileInputStream fstream = new FileInputStream("InputFile");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
			List<List<String>> inputList = new ArrayList<>();
			String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                List<String> command = new ArrayList<>();
                for (String token : tokens) {
                    command.add(token);
                }
                inputList.add(command);
            }
            // Printing of input 
            System.out.println("Start Printing Input");
//            for (List<String> innerList : inputList) {
//                for (String element : innerList) {
//                    System.out.print(element + " ");
//                }
//                System.out.println(); 
//            }
//            System.out.println("End Printing Input");
            
            /* Parsing of */
            Character countCharacter='1';
            for (int i = 0; i < inputList.size(); i++) {
//            	System.out.println("Question no "+(i+1));
                List<String> temp = inputList.get(i);
                int checkQuestionMark = CommonFunc.checkQuestionMark(temp);
                if (checkQuestionMark == 0) {
                    if (temp.size() == 3) {
                    	StoreInMap.storeInStoreMap(temp,generalMap,storeMap);
                    } else if (temp.size() > 3) {
                    	StoreInMap.calculateAndStoreInStoreMap(temp,countCharacter,storeMap);
                        countCharacter++;
                    }
                    
                } else if (checkQuestionMark == 1) {
                    
                	if(CommonFunc.checkValidQuestion(temp,storeMap)== 1) {
                		if(TypeQuestion.isNormalQuestion(temp)== true){
                		  SolveQuestion.solveNormalQuestion(temp,storeMap);
                		}else if(TypeQuestion.isNormalQuestion(temp)==false){
//                			System.out.print("containMoreLessLargerSmaller ");
                			SolveQuestion.solveContainMoreLessLargerSmaller(temp,storeMap,checkUniqeKey);
                				
                			
                		} else {
                			
                			InvalidHandler.Invalide();
                		}
                	}else {
                		InvalidHandler.Invalide();
                	}
                	}else{
                		InvalidHandler.Invalide();
                	}
                	
                }
//          Store Map is Completely filled
//            System.out.println();
//            for (Map.Entry<Character, Map.Entry<String, Float>> entry : storeMap.entrySet()) {
//                char key = entry.getKey();
//                String item = entry.getValue().getKey();
//                float value = entry.getValue().getValue();
//
//                System.out.println("Key: " + key + ", Item: " + item + ", Value: " + value);
//            }
//            System.out.println();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}