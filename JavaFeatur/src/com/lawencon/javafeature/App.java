package com.lawencon.javafeature;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class App {

	public static void main(String[] args) {
		LocalDate tanggal = LocalDate.of(2024, 9, 26);
		tanggal = tanggal.plusDays(2L);
		System.out.println(tanggal);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String FormatDate = tanggal.format(formatter);
		System.out.println(FormatDate);

		LocalDate stringToDate = LocalDate.parse("24-12-2000", formatter);
		System.out.println(stringToDate);

		LocalDateTime time = LocalDateTime.now();
		System.out.println(time);

		ZonedDateTime zonedDateTime = time.atZone(ZoneId.of("Asia/Bangkok"));
		System.out.println(zonedDateTime);

		Consumer<String> consumer = (s) -> System.out.println(s);
		consumer.accept("hai");

		Person person = new Person();

		Optional<Person> optionalPerson = Optional.ofNullable(person);

		if (optionalPerson.isPresent()) {
			Person person2 = optionalPerson.get();
			Boolean a = person.getName() != null;
			person.getUmur();
		}
		
		
		List<Person> personList = new ArrayList<>();
		
		Person person1 = new Person();
		person1.setName("ucup");
		person1.setUmur(17);
		personList.add(person1);
		
		List<PersonRespon> personResponList = personList.stream().map(data-> {
			PersonRespon personRespon = new PersonRespon();
			personRespon.setName(data.getName());
			return personRespon;
		}).toList();
		
		
		System.out.println(personResponList.get(0).getName());
	}

}
