package com.dates;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeExampleTest {

    private DateTimeExample datesExamples;

    @Before
    public void before() {
        datesExamples = new DateTimeExample();
    }

    @Test
    public void should_return_people_aged_18_and_over() {
        List<Person> expectedPerson = Arrays.asList(
                new Person("Paul", LocalDate.of(1985, 6, 10))
        );
        assertThat(datesExamples.over30()).isEqualTo(expectedPerson);
    }

    @Test
    public void should_return_people_aged_360_months_and_over() {
        List<Person> expectedPerson = Arrays.asList(
                new Person("Paul", LocalDate.of(1985, 6, 10))
        );
        assertThat(datesExamples.over360Months()).isEqualTo(expectedPerson);
    }
}
