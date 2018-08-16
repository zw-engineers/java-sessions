package com.collectionapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListNewMethodTest {

    private ListNewMethod listNewMethod;

    @BeforeEach
    void setUp() {
        listNewMethod = new ListNewMethod();
    }

    @Test
    public void shouldReturnAListOfSortedStrings(){
        List<String> expectedList = Arrays.asList("four", "one", "three", "two");
        assertEquals(expectedList, listNewMethod.sortedList());
    }

}