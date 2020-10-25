package com.stream.api.optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Example Optional Test")
class ExampleOptionalTest {

    private ExampleOptional exampleOptional;

    @BeforeEach
    void before() {
        exampleOptional = new ExampleOptional();
    }

    @Test
    @DisplayName("Should return an empty optional when null value is passed")
    void should_return_an_empty_optional_when_null_value_is_passed() {
        assertThat(exampleOptional.getOptional(null)).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("Should return 0 as a default value when optional is null")
    void should_return_0_as_a_default_value_when_optional_is_null() {
        assertThat(exampleOptional.getOptionalWithDefault(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("Should throw an excetion when empty value is passed")
    void should_throw_an_excetion_when_empty_value_is_passed() {
        assertThrows(MyException.class, () -> assertThat(exampleOptional.getOptionalWithException(null)));
    }
}
