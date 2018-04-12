package com.streams.reduction;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleReductionTest {

    private ExampleReduction exampleReduction;
    List<Integer> numbersList = Arrays.asList(10, 12, 7, 9, 30, 100);

    @Before
    public void before() {
        exampleReduction = new ExampleReduction();
    }

    @Test
    public void should_return_sum_of_all_numbers_in_list() {
        assertThat(exampleReduction.getTotalSum(numbersList)).isEqualTo(168);
    }
}
