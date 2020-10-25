package com.stream.api.filter;

import com.stream.api.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class ExampleFilterTest {

    private ExampleFilter exampleFilter;

    @BeforeEach
    void setup() {
        exampleFilter = new ExampleFilter();
    }

    @Test
    @DisplayName("Should return the list size of people over 20 years old")
    void return_number_of_people_over_20_years_old() {
        assertEquals(2, exampleFilter.peopleOver20().size());
    }

    @Test
    @DisplayName("Should return a list of people over 20 years old")
    void return_list_of_people_over_20_years_old() {
        List<Person> people = Arrays.asList(
                new Person("Artemas", 28),
                new Person("Tom", 40)
        );
        assertEquals(people, exampleFilter.peopleOver20());
    }
}
