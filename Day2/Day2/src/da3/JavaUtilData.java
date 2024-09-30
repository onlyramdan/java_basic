package da3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class JavaUtilData {

	public static void main(String[] args) throws ParseException{
		Date dateNow = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateNowStr = formatter.format(dateNow);
		
		System.out.println(dateNow);
		
		System.out.println(dateNowStr);
		
		//convert dari tipe string ke date
		String dateOfBirthStr = "18-11-2022";
		Date dateOfBirth = formatter.parse(dateOfBirthStr);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateOfBirth);
		
		System.out.println(dateOfBirth);
		
//		LocalDateTime localTime = LocalDateTime.now();
//		DateTimeFormatter formatter =

	}

}
