package com.streams.filter;

import com.streams.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleFilterTest {

    private ExampleFilter exampleFilter;

    @Before
    public void setup() {
        exampleFilter = new ExampleFilter();
    }

    @Test
    public void return_number_of_people_over_20_years_old() {
        assertEquals(2, exampleFilter.peopleOver20().size());
    }

    @Test
    public void return_list_of_people_over_20_years_old() {
        List<Person> people = Arrays.asList(
                new Person("Artemas", 28),
                new Person("Tom", 40)
        );
        assertEquals(people, exampleFilter.peopleOver20());
    }
}
