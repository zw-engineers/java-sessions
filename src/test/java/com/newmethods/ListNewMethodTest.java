package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListNewMethodTest {

    private ListNewMethod listNewMethod;

    @BeforeEach
    void setUp() {
        listNewMethod = new ListNewMethod();
    }

    @Test
    @DisplayName("Should return a list of strings sorted by alphabet")
    void shouldReturnAListOfSortedStrings(){
        List<String> strings = Arrays.asList("one", "two", "three", "four");
        
        List<String> sortedStrings = listNewMethod.sortedList(strings);

        assertThat(sortedStrings).containsExactly("four", "one", "three", "two");
    }

}