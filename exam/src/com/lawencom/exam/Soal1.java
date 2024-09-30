package com.lawencom.exam;

public class Soal1 {

    public static void main(String[] args) {
        Soal1 soal1 = new Soal1();
        soal1.gorenganBonus(20);  
    }

    private void gorenganBonus(int jumlahGorengan) {
        if(jumlahGorengan > 10) {
            int bonus = 0;
            for (int i = 1; i <= jumlahGorengan; i++) {
                if (i % 10 == 0) {  
                    bonus += 2;
                }
            }
            
            int jumlahTotal = jumlahGorengan + bonus;
            System.out.println("Jumlah Gorengan: " + jumlahGorengan);
            System.out.println("Bonus Gorengan: " + bonus);
            System.out.println("Total Gorengan (termasuk bonus): " + jumlahTotal);
            System.out.println("Total Harga Rp. " + jumlahGorengan * 1000); 
        } else {
            System.out.println("Total Harga Rp. " + jumlahGorengan * 1000);
        }
    }
}
