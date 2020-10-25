package com.stream.api.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExampleMapTest {

    private ExampleMap exampleMap;

    @BeforeEach
    void before() {
        exampleMap = new ExampleMap();
    }

    @Test
    @DisplayName("Should return count of lists in a list")
    void should_return_count_of_lists_in_list(){

        List<String> list = Arrays.asList("1", "2", "3", "4", "5");

        assertThat(exampleMap.countLists(list)).isEqualTo(15);
    }
}
