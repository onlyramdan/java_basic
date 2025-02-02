package com.lawencon.BookStore;
import java.util.List;
import java.util.ArrayList;

public class App {
	private final List<Item> cart = new ArrayList<>();
	private int total_price = 0;
	History history = new History();
	
	public static void main(String[] args) {
		final App app = new App();
		app.startApp();
	}
	
	private void startApp() {
		int option;
		System.out.println("==== Main Menu ====");
		System.out.println("1. List Book");
		System.out.println("2. Cart");
		System.out.println("3. History");
		System.out.println("4. Exit");
		System.out.print("Input Menu : ");
		
		option = ScannerUtil.scanInt();
		switch(option) {
			case 1:
				showBooks();
			case 2:
				cartBook();
			case 3:
				historyBook();
			case 4:
				exit();
			default:
				System.out.println("Input Not Valid!");
				startApp();
		}
	}
	
	private void showBooks() {
		int bookNumber = 1;
		System.out.println("==== List of Books ====");
		for(Book books: Book.values()) {
			System.out.print(bookNumber +"."+ books.getName() + " ");
			System.out.println(books.getPrice());
			bookNumber++;
		}
		buy();
	}
	
	private void buy() {
		
		Book[] books = Book.values();
		
		System.out.print("Select Book : ");
		
		int optionBook = ScannerUtil.scanInt();
		if ( !(optionBook > 0 && optionBook < 5)) {
			System.out.println("Book Not Found");
			showBooks();
		}
		
		System.out.print("Quantity : ");
		int quantity = ScannerUtil.scanInt();
		
		System.out.println("==== Buy Book ====");
		
		String name = books[optionBook - 1].getName();
		System.out.print("Name : " + name + "\t");
		
		int totalPrice = books[optionBook - 1].getPrice() * quantity;
		System.out.println("Total Price : Rp. " + totalPrice);
		
		System.out.println("1. Buy");
		System.out.println("2. Cancel");
		System.out.print("Input : ");
		int option = ScannerUtil.scanInt();
		switch(option) {
		case 1:
			if( cart.size() == 0) {
				Item item = new Item(name, quantity, totalPrice);
				cart.add(item);	
			} else {
				boolean find = false;
				for(int i = 0; i< cart.size(); i++) {
					if(cart.get(i).getItemName() == name){
						int newQty = cart.get(i).getItemQty()+ quantity;
						int newPrice = cart.get(i).getItemTotalPrice() + totalPrice;
						Item item = new Item(name, newQty, newPrice);
						cart.set(i, item);
						find = true;
						break;
					} 
				}
				if(!find){
					Item item = new Item(name, quantity, totalPrice);
					cart.add(item);	
				}
			}
			System.out.println("=== Succes Buying Books ===");
			System.out.println("Do you want buy a Book agin ?");
			System.out.println("1. Yes ");
			System.out.println("2. No");
			System.out.print("Input : ");
			option = ScannerUtil.scanInt();
			if (option == 1) {	
				showBooks();
			}else {
				System.out.println("Thank you For Buying");
				startApp();
			}
		case 2:
			showBooks();
		default :
			System.out.println("Input Not valid!");
			showBooks();
		}
	}
	
	
	private void cartBook(){
		System.out.println("==== Cart Book ====");
		
		int total_books = 0;
		if(!(cart.isEmpty())) {
			for(int i = 0; i< cart.size(); i++) {
				System.out.println((1+i)+"."+ cart.get(i).getItemName()+ " Qty:" + cart.get(i).getItemQty() + " Total Price: Rp. " + cart.get(i).getItemTotalPrice());
				total_price += cart.get(i).getItemTotalPrice();
				total_books++;
			}
		} else {
			System.out.println("Belum Ada Buku");
		}
		
		System.out.println("\n Total Price: Rp. "+ total_price + "\n");
		System.out.println("1. Edit Quantity");
		System.out.println("2. Remove Book");
		System.out.println("3. Remove All Book");
		System.out.println("4. Checkout");
		System.out.println("5. Back");
		
		System.out.print("Input :");
		int option = ScannerUtil.scanInt() ;
		
		switch(option){
			case 1:
				editQuantity(total_books);
				break;
			case 2:
				removeBook(total_books);
				break;
			case 3:
				removeAllBook();
				break;
			case 4:
				checkout(total_price);
				break;
			case 5:
				startApp();
				break;
			default:
				System.out.println("Input Not Valid");
				startApp();
				break;
		}
	
	}
	private void editQuantity(int total_books) {
		System.out.println("=== Edit Quantity ====");
		System.out.print("Input Nomer Buku :");
		int indexBook = ScannerUtil.scanInt() - 1;
		if(!(indexBook +1 < 1 && indexBook + 1 > total_books)){
			System.out.println("Book Not Found");
			cartBook();
		}
		System.out.print("Input Quantity :");
		int qty = ScannerUtil.scanInt();
		int price = 0;
		String name = cart.get(indexBook).getItemName();
		for(Book books: Book.values()) {
			if(books.getName() == name) {
				price = books.getPrice();
				break;
			}
		}
		int total_price = price * qty;
		Item item = new Item(name, qty , total_price);
		cart.set(indexBook, item);
		cartBook();
	}
	
	private void removeBook(int total_books) {
		System.out.println("=== Remove Book ====");
		System.out.print("Input Nomer Buku :");
		int indexBook = ScannerUtil.scanInt() - 1;
		if(!((indexBook + 1) < 1 && (indexBook + 1) > total_books)){
			System.out.println("Book Not Found");
			cartBook();
		}
		cart.remove(indexBook);
		cartBook();
	}
	
	private void removeAllBook() {
		cart.clear();
		total_price = 0;
		System.out.println("==== Succes Remove All Book ====");
		startApp();
	}
	
	private void checkout(int price) {
		double totalPrice = price;
		System.out.println("Total Payment: Rp. " + price);
		System.out.print("Use Discount (y/n) :");
		String option = ScannerUtil.scanString();
		if(option.equals("y")) {
			for(DiscountCode codes : DiscountCode.values()) {
				System.out.println(codes.getCode());
			}
			
			System.out.print("\nInput Discount Code : ");
			boolean findDiscount = false;
			String codeInput = ScannerUtil.scanString();
			for(DiscountCode codes : DiscountCode.values()) {
				if(codeInput.equals(codes.getCode())) {
					double discount = totalPrice * codes.getDiscount();
					totalPrice = totalPrice - discount;
					System.out.println("Harga Diskon : Rp. " + (int) totalPrice);
					findDiscount = true;
					break;
				}
			}
			if(!findDiscount){
				System.out.println("Yours Code Not Valid !");
				checkout(total_price);
			}
		}
		
		String time = new Time().getTime();
		String codeInvoice = new InvoiceCode().generateCodeInvoice();
		history.addHistory(codeInvoice, time , totalPrice);
		
		System.out.println("Thanks For Checkout!");
		cart.clear();
		total_price = 0;
		startApp();
	}
	
	
	private void historyBook(){
		System.out.println("=== History Payment ===");
		
		history.getHistory();
		int no = 1;
		for(ItemHistory item : history.getHistory()){
			System.out.print(no);
			System.out.print(" Invoice : " + item.getInvoiceCode());
			System.out.print(" Harga: Rp. " + (int) item.getTotal_price());
			System.out.println(" Date: " + item.getTime());
			no++;
		}
		
		
		System.out.println("\n1. Back | 2. Exit ");
		System.out.print("Input : ");
		int option = ScannerUtil.scanInt();
		switch(option) {
		case 1:
			startApp();
			break;
		case 2:
			exit();
			break;
		default :
			System.out.println("Input Not Valid!");
			historyBook();
			break;
		}
	}
	
	private void exit() {
		System.out.println("==== Exit ====");
		System.exit(0);
	}
}
