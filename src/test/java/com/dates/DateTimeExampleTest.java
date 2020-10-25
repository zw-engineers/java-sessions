package com.dates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DateTimeExampleTest {

    private DateTimeExample datesExamples;

    @BeforeEach
    void before() {
        datesExamples = new DateTimeExample();
    }

    @Test
    @DisplayName("Should return people aged 18 and over")
    void should_return_people_aged_18_and_over() {
        List<Person> expectedPerson = Arrays.asList(
                new Person("Paul", LocalDate.of(1985, 6, 10))
        );
        assertThat(datesExamples.over30()).isEqualTo(expectedPerson);
    }

    @Test
    @DisplayName("Should return people aged 360 months and over")
    void should_return_people_aged_360_months_and_over() {
        List<Person> expectedPerson = Arrays.asList(
                new Person("Paul", LocalDate.of(1985, 6, 10))
        );
        assertThat(datesExamples.over360Months()).isEqualTo(expectedPerson);
    }
}
