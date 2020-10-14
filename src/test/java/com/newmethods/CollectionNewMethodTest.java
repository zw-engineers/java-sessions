package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionNewMethodTest {

    private CollectionNewMethod collectionNewMethod;

    @BeforeEach
    void setUp() {
        collectionNewMethod = new CollectionNewMethod();
    }

    @Test
    @DisplayName("Should return a list of size 3 when an element is removed")
    public void shouldReturnAListOfSize3WhenAnElementIsRemoved() {
        Collection<String> expectedStrings = Arrays.asList("one", "two", "four");
        Collection<String> list = new ArrayList<>(expectedStrings);
        
        Collection<String> strings = collectionNewMethod.removeElement();

        assertThat(strings).isEqualTo(list)
                .hasSize(list.size());

    }

    @Test
    @DisplayName("Should return list of strings capitalised")
    public void shouldReturnListCapitalised() {
        List<String> listOfStrings = Arrays.asList("one", "two", "three");

        List<String> stringsUpperCased = collectionNewMethod.toUpperCase(listOfStrings);

        assertThat(stringsUpperCased).containsExactly("ONE", "TWO", "THREE");
    }

}