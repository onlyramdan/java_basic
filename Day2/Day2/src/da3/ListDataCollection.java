package da3;
import java.util.*;

public class ListDataCollection {
	
    public static void main(String[] args) {
	    List<String> listData = new ArrayList<String>();
	    List<Integer> listQty = new ArrayList<Integer>();
	    listData.add("ramdan");
	    listData.add("Ilham");
	    
	    listQty.add(1);
	    listQty.add(2);
	    
	    for(int i = 0; i< listData.size() ; i++) {
	    	System.out.println(listData.get(i));
	    }
	    
	    for(int i = 0; i< listQty.size() ; i++) {
	    	System.out.println(listQty.get(i));
	    }
	    
	    List<Item> item = new ArrayList<>();
	    
	    item.add(new Item("Apel", 1));
	    item.add(new Item("Jeruk", 2));
	    
	    for(Item items : item){
	    	System.out.println(items.getName());
	    	System.out.println(items.getQty());
	    }
	    
    }
}