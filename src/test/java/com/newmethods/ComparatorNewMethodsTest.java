package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComparatorNewMethodsTest {

    private ComparatorNewMethods comparatorNewMethods;

    @BeforeEach
    void setUp() {
        comparatorNewMethods = new ComparatorNewMethods();
    }

    @Test
    @DisplayName("Should return a list of people sorted by name")
    void shouldReturnAListOfPeopleSorted(){
        List<Person> people = Arrays.asList(
                new Person("Thomas", "Jefferson"),
                new Person("Artemas", "Muzanenhamo"),
                new Person("Lemuel", "Muzanenhamo")
        );

        List<Person> peopleSorted = comparatorNewMethods.namesInOrder(people);

        assertThat(peopleSorted).isEqualTo(people);
    }
}
