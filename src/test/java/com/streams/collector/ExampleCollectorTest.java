package com.streams.collector;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleCollectorTest {

    private ExampleCollector exampleCollector;
    String[] names;
    List<String> namesList;

    @Before
    public void before() {
        exampleCollector = new ExampleCollector();
    }

    @Test
    public void should_return_a_list_of_name() {
        names = new String[]{"Artemas", "Lebron", "Kobe", "Michael"};
        namesList = Arrays.asList("Artemas", "Lebron", "Kobe", "Michael");
        assertThat(exampleCollector.getNamesList(names)).isEqualTo(namesList);
    }

}
