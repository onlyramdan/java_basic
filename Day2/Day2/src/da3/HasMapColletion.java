package da3;

import java.util.*;
public class HasMapColletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> dataMap = new HashMap<>();
		
		dataMap.put(1, "Alpukat");
		dataMap.put(2, "Jeruk");
		dataMap.put(3, "Nanas");
		dataMap.put(4, "Apel");
		
		for (Map.Entry<Integer, String> entry : dataMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
		
		for (Integer key : dataMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + dataMap.get(key));
        }
		
		for (String value : dataMap.values()) {
            System.out.println("Value: " + value);
        }
	}

}
