package com.stream.api.reduction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExampleReductionTest {

    private ExampleReduction exampleReduction;

    private final List<Integer> numbersList = asList(10, 12, 7, 9, 30, 100);

    @BeforeEach
    void before() {
        exampleReduction = new ExampleReduction();
    }

    @Test
    @DisplayName("Should return sum of all numbers in list")
    void should_return_sum_of_all_numbers_in_list() {
        assertThat(exampleReduction.getTotalSum(numbersList)).isEqualTo(168);
    }

    @Test
    @DisplayName("Should return max value of numbers in list")
    void should_return_max_value_of_numbers_in_list() {
        List<Integer> numbers = asList(10, 22, 3, 44, 5, 25, 75, 4);
        assertThat(exampleReduction.getMaxValueWithIdentity(numbers)).isEqualTo(75);
    }

    @Test
    @DisplayName("Should return zero when value passed in is empty")
    void should_return_zero_when_value_passed_in_is_empty() {
        List<Integer> numbers = List.of();
        assertThat(exampleReduction.getMaxValueWithIdentity(numbers)).isEqualTo(0);
    }

    @Test
    @DisplayName("Should throw null pointer exception when value passed in is null")
    void should_throw_null_pointer_exception_when_value_passed_in_is_null() {
        assertThrows(NullPointerException.class, () -> {
            List<Integer> numbers = null;
            assertThat(exampleReduction.getMaxValueWithIdentity(numbers));
        });
    }

    @Test
    @DisplayName("Should return max value of numbers in list without identity")
    void should_return_max_value_of_numbers_in_list_without_identity() {
        List<Integer> numbers = asList(10, 22, 3, 44, 5, 25, 75, 4);
        assertThat(exampleReduction.getMaxValue(numbers)).isEqualTo(75);
    }

    @Test
    @DisplayName("Should return zero when empty value is passed")
    void should_return_zero_when_empty_value_is_passed() {
        List<Integer> numbers = List.of();
        assertThat(exampleReduction.getMaxValue(numbers)).isEqualTo(0);
    }

    @Test
    @DisplayName("Should throw an exception when null is passed in")
    void should_throw_an_exception_when_null_is_passed_in() {
        assertThrows(NullPointerException.class, () -> assertThat(exampleReduction.getMaxValueWithException(null)));
    }
}
