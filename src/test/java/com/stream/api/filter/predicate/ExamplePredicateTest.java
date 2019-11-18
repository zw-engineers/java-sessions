package com.stream.api.filter.predicate;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ExamplePredicateTest {
    private ExamplePredicate examplePredicate;

    @Before
    public void before() {
        examplePredicate = new ExamplePredicate();
    }

    @Test
    public void should_return_two_filtered_data_from_my_list() {
        List<String> list = Arrays.asList("one", "two", "three");
        assertThat(examplePredicate.filter(list).get(0)).isEqualTo(list.get(1));
    }
}
