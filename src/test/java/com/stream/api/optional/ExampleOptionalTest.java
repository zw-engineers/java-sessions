package com.stream.api.optional;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleOptionalTest {

    private ExampleOptional exampleOptional;

    @Before
    public void before() {
        exampleOptional = new ExampleOptional();
    }

    @Test
    public void should_return_an_empty_optional_when_null_value_is_passed() {
        String str = null;
        assertThat(exampleOptional.getOptional(str)).isEqualTo(Optional.empty());
    }

    @Test
    public void should_return_0_as_a_default_value_when_optional_is_null() {
        Integer integer = null;
        assertThat(exampleOptional.getOptionalWithDefault(integer)).isEqualTo(0);
    }

    @Test(expected = MyException.class)
    public void should_throw_an_excetion_when_empty_value_is_passed() throws Exception {
        Long longValue = null;
        assertThat(exampleOptional.getOptionalWithException(longValue));
    }
}
