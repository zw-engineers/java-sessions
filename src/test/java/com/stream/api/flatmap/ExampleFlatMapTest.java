package com.stream.api.flatmap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleFlatMapTest {

    private ExampleFlatMap exampleFlatMap;

    @Before
    public void before() {
        exampleFlatMap = new ExampleFlatMap();
    }

    @Test
    public void should_return_sum_of_numbers_in_a_list() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        assertThat(exampleFlatMap.sumLists(listOfLists)).isEqualTo(45);
    }
}
