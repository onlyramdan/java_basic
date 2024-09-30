package javaSatu;

import java.util.Scanner;

public class KalkulatorSederhana {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        kalkulatorSederhana(scan);
    }
    
    private static void keluarLanjut(int menu, Scanner scan) {
    	System.out.println("===== Menu =====");
        System.out.println("1. Menu Utama");
        System.out.println("2. Lanjut");
        System.out.println("3. Keluar");
    	
        System.out.print("Input Menu :");
        int c = scan.nextInt();
        if( c == 1 ) {
        	kalkulatorSederhana(scan);
        } else if (c == 2) {
        	operasi(menu , scan);
        } else {
        	System.out.println("Exit");
            scan.close();
        }
    }

    private static void kalkulatorSederhana(Scanner scan) {
        System.out.println("===== Menu =====");
        System.out.println("1. Penambahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("5. Keluar");
        System.out.print("Input Menu: ");
        int menu = scan.nextInt();

        operasi(menu, scan);
    }
    
    private static void operasi(int menu, Scanner scan) {
    	
    	switch (menu) {
        case 1:
            System.out.print("Input pertama : ");
            int a = scan.nextInt();
            System.out.print("Input kedua : ");
            int b = scan.nextInt();
            System.out.println("Hasil penambahan: " + (a + b));
            keluarLanjut(menu ,scan);
            break;
        case 2:
            System.out.print("Input pertama : ");
            a = scan.nextInt();
            System.out.print("Input kedua : ");
            b = scan.nextInt();
            System.out.println("Hasil pengurangan: " + (a - b));
            keluarLanjut(menu, scan);
            break;
        case 3:
            System.out.print("Input pertama : ");
            a = scan.nextInt();
            System.out.print("Input kedua : ");
            b = scan.nextInt();
            System.out.println("Hasil perkalian: " + (a * b));
            keluarLanjut(menu, scan);
            break;
        case 4:
            System.out.print("Input pertama : ");
            a = scan.nextInt();
            System.out.print("Input kedua : ");
            b = scan.nextInt();
            if (b != 0) {
                System.out.println("Hasil pembagian: " + (a / b));
                keluarLanjut(menu, scan);
            } else {
                System.out.println("tidak bisa dengan pembagian nol");
                keluarLanjut(menu, scan);
            }
            break;
            
        case 5:
            System.out.println("Exit");
            scan.close();
            break;
        default :
        	System.out.println("Salah! , pilih menu kembali");
        	keluarLanjut(menu, scan);
        	break;
    }
    }
}