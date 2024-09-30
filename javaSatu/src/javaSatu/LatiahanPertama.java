package javaSatu;

import java.util.Scanner;

public class LatiahanPertama {

	public static void main(String[] args) {
//		String text = "hai";
//		
//		if(text.equals("hai")){
//			System.out.println("Benar");
//		}else {
//			System.out.println("Salah");
//		}
//		
//		if(text.equalsIgnoreCase("Hai")){
//			System.out.println("Benar");
//		}else {
//			System.out.println("Salah");
//		}
//		
//		boolean a = true; 
//		boolean b = false; 
//		
//		if(a && b ){
//			System.out.println("print data: Benar");
//		} else {
//			System.out.println("print data: Salah");
//		}
//		
//		int a = 10 , b = 10;
//		int c = a + b ;
//		
//		switch(c) {
//		case 11: 
//			System.out.println("Hasilnya 11");
//			break;
//		case 16:
//			System.out.println("Hasilnya 16");
//			break;
//		default :
//			System.out.println("Hasilnya bukan 11 dan 16");
//			break;
//		}
//		
		
		/**
		 * 
		 * Scanner 
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Masukkan namamu: ");
		
		String nama = scan.nextLine();
		
		System.out.println("Hai Senang Berkenalan Denganmu " + nama);
		
		scan.close();
	}

}
