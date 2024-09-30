package da3;

import java.util.*;

public class TestArrayList {
	
	public static void main(String[] args) {	
		List<String> listString = new ArrayList<>();
		
		/*
		 * add 
		 */	
		
		listString.add("Apel");
		listString.add("Jeruk");
		listString.add("Mangga");
		listString.add("Nanas");
		
		/*
		 * set
		 */
		
		listString.set(1, "Alpukat");
		
		/*
		 * remove
		 */
		
		listString.remove(3);
		
		/*
		 * clear
		 */
		listString.clear();
		
		/*
		 * read
		 */
		
		for(String buahs : listString) {
			System.out.println(buahs);
		}
		
	}

}
