package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CollectionNewMethodTest {

    private CollectionNewMethod collectionNewMethod;

    @BeforeEach
    void setUp() {
        collectionNewMethod = new CollectionNewMethod();
    }

    @Test
    public void shouldReturnAListOfSize3WhenAnElementIsRemoved() {
        Collection<String> expectedStrings = Arrays.asList("one", "two", "four");
        Collection<String> list = new ArrayList<>(expectedStrings);
        assertAll(
                () -> assertEquals(list, collectionNewMethod.removeElement()),
                () -> assertEquals(list.size(), collectionNewMethod.removeElement().size())
        );

    }

    @Test
    public void shouldReturnListCapitalised() {
        List<String> expectedList = Arrays.asList("one", "two", "four");
        expectedList = expectedList.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
        assertEquals(expectedList, collectionNewMethod.toUpperCase(expectedList));
    }

}