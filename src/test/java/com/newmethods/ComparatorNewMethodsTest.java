package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorNewMethodsTest {

    private ComparatorNewMethods comparatorNewMethods;

    @BeforeEach
    void setUp() {
        comparatorNewMethods = new ComparatorNewMethods();
    }

    @Test
    public void shouldReturnAListOfAgesSorted(){
        List<Person> expectedAgesInOrder = Arrays.asList(
                new Person("Thomas", "Jefferson"),
                new Person("Artemas", "Muzanenhamo"),
                new Person("Lemuel", "Muzanenhamo")
        );
        assertEquals(expectedAgesInOrder, comparatorNewMethods.namesInOrder());
    }
}