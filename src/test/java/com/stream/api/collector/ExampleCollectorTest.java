package com.stream.api.collector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExampleCollectorTest {

    private ExampleCollector exampleCollector;

    @BeforeEach
    void before() {
        exampleCollector = new ExampleCollector();
    }

    @Test
    @DisplayName("Should return a list of name")
    void should_return_a_list_of_name() {
        String[] names = new String[]{"Artemas", "Lebron", "Kobe", "Michael"};
        List<String> namesList = Arrays.asList("Artemas", "Lebron", "Kobe", "Michael");
        assertThat(exampleCollector.getNamesList(names)).isEqualTo(namesList);
    }

}
