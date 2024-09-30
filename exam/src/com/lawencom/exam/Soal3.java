package com.lawencom.exam;
import java.util.Scanner;

public class Soal3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Soal3 soal3 = new Soal3();
        soal3.kursiAngkot(scan);
        scan.close(); 
    }
    
    private void kursiAngkot(Scanner scan){
        String[][] angkot = new String[5][10]; 
        for(int i = 0; i < 5 ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                System.out.println("Input Nama Orang untuk Kursi [" + i + "][" + j + "]:");
                String orang = scan.nextLine();
                angkot[i][j] = orang;	
            }
        }
        
        System.out.println("Daftar penumpang di dalam angkot:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(angkot[i][j] + "\t");
            }
            System.out.println(); 
        }
    }
}
