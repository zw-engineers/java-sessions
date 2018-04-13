package com.streams.reduction;

import com.streams.optional.MyException;
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

    @Test
    public void should_return_max_value_of_numbers_in_list() {
        List<Integer> numbers = Arrays.asList(10, 22, 3, 44, 5, 25, 75, 4);
        assertThat(exampleReduction.getMaxValueWithIdentity(numbers)).isEqualTo(75);
    }

    @Test
    public void should_return_zero_when_value_passed_in_is_empty() {
        List<Integer> numbers = Arrays.asList();
        assertThat(exampleReduction.getMaxValueWithIdentity(numbers)).isEqualTo(0);
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_null_pointer_exception_when_value_passed_in_is_null() {
        List<Integer> numbers = null;
        assertThat(exampleReduction.getMaxValueWithIdentity(numbers));
    }

    @Test
    public void should_return_max_value_of_numbers_in_list_without_identity() {
        List<Integer> numbers = Arrays.asList(10, 22, 3, 44, 5, 25, 75, 4);
        assertThat(exampleReduction.getMaxValue(numbers)).isEqualTo(75);
    }

    @Test
    public void should_return_zero_when_empty_value_is_passed() {
        List<Integer> numbers = Arrays.asList();
        assertThat(exampleReduction.getMaxValue(numbers)).isEqualTo(0);
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_an_exception_when_null_is_passed_in() throws Exception {
        assertThat(exampleReduction.getMaxValueWithException(null));
    }
}
