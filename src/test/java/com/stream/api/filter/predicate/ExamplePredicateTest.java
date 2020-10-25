package com.stream.api.filter.predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExamplePredicateTest {
    private ExamplePredicate examplePredicate;

    @BeforeEach
    void before() {
        examplePredicate = new ExamplePredicate();
    }

    @Test
    @DisplayName("Should return filtered data from list")
    void should_return_two_filtered_data_from_my_list() {
        List<String> list = Arrays.asList("one", "two", "three");
        assertThat(examplePredicate.filter(list).get(0)).isEqualTo(list.get(1));
    }
}
