package com.lawencon.parkiran;

import java.util.Random;

public class Ticket {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 3;
	public String generteTicket(){
		StringBuilder ticketCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            ticketCode.append(CHARACTERS.charAt(index));
        }

        return ticketCode.toString();
	}
}
