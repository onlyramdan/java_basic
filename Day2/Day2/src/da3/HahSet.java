package da3;

import java.util.HashSet;

public class HahSet {

	public static void main(String[] args) {
		HashSet<String> hasSet = new HashSet<String>();
		
		hasSet.add("Budi");
		hasSet.add("Darma");
		hasSet.add("Darma");
		hasSet.add("Ucup");
		
		for(String str : hasSet) {
			System.out.println(str);
		}
	}
}
