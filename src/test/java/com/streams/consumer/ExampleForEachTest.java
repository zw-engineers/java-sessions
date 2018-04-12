package com.streams.consumer;

import com.streams.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleForEachTest {

    private ExampleForEach exampleForEach;

    @Before
    public void before() {
        exampleForEach = new ExampleForEach();
    }

    @Test
    public void should_return_a_list_of_people_over_the_age_of_20() {
        List<Person> people = Arrays.asList(
                new Person("Tony", 10),
                new Person("James", 25),
                new Person("Mark", 38),
                new Person("Stacey", 16),
                new Person("Gemma", 18),
                new Person("Shawn", 17)
        );

        List<Person> expectedPeople = Arrays.asList(
                new Person("James", 25),
                new Person("Mark", 38),
                new Person("Gemma", 18)
        );

        assertThat(exampleForEach.getOver20(people)).isEqualTo(expectedPeople);
    }
}
