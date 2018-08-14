package com.collectionapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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

        assertEquals(list, collectionNewMethod.removeElement());
    }

}