package com.dates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.LocalDate.now;

public class DateTimeExample {

    private final LocalDate today = LocalDate.of(2018, 04, 28);

    private List<Person> getPeople() {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(
                                DateTimeExample.class.getResourceAsStream("/people.txt")
                        ));
                Stream<String> stream = reader.lines();
                ) {
            stream.map(
                    line -> {
                        String[] s = line.split(" ");
                        String name = s[0].trim();
                        int year = Integer.parseInt(s[1]);
                        Month month = Month.of(Integer.parseInt(s[2]));
                        int day = Integer.parseInt(s[3]);
                        Person person = new Person(name, LocalDate.of(year, month, day));
                        persons.add(person);
                        return persons;
                    }
            ).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }


    /**
     *
     * @return - people aged 30 years or over.
     */
    public List<Person> over30() {
        return getPeople().stream()
                .filter(person ->
                        Period.between(
                                person.getDateOfBirth(),
                                today).get(ChronoUnit.YEARS) >= 30)
                .collect(Collectors.toList());
    }

    /**
     *
     * @return - return people aged 360 months or over.
     */
    public List<Person> over360Months() {
        return getPeople().stream()
                .filter(person -> person.getDateOfBirth().until(today, ChronoUnit.MONTHS) >= 360)
                .collect(Collectors.toList());
    }
}
