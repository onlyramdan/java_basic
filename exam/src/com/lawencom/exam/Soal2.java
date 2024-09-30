package com.lawencom.exam;

public class Soal2 {

	public static void main(String[] args) {
		Soal2 soal2 = new Soal2();
		soal2.timeTravel();
		
	}
	private void timeTravel() {
		int trueTimeline = 1000 ;
		int timelineBudiBenar = 0;
		for(int i = 1 ; i <= 1000000 ;i++ ){
			if( i % 2 == 1) {
				System.out.print("Timeline : " + i);
				System.out.println(" Budi Berhasil Menyelamatkan Ani");
				timelineBudiBenar++;
				if (timelineBudiBenar == trueTimeline ) {
					break;
				}
			} else {				
				System.out.println("Timeline : " + i);
			}
		}
	}

}
