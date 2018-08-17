package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapNewMethodsTest {
    private MapNewMethods mapNewMethods;

    @BeforeEach
    void setUp() {
        mapNewMethods = new MapNewMethods();
    }

    @Test
    public void shouldReturnListOfPersons(){
        List<Person> expectedPeople = Arrays.asList(
                new Person("Artemas", "Muzanenhamo"),
                new Person("John", "Smith")
        );

        assertEquals(expectedPeople, mapNewMethods.retrievePeople());
    }

}