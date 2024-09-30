package da3;

public class Item {
	private String name;
	private Integer qty;
	
	public Item(String name, Integer qty) {
		this.name = name;
		this.qty = qty;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
}
