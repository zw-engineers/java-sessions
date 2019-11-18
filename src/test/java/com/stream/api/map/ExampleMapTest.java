package com.stream.api.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleMapTest {

    private ExampleMap exampleMap;

    @Before
    public void before() {
        exampleMap = new ExampleMap();
    }

    @Test
    public void should_return_count_of_lists_in_list(){

        List<String> list = Arrays.asList("1", "2", "3", "4", "5");

        assertThat(exampleMap.countLists(list)).isEqualTo(15);
    }
}
