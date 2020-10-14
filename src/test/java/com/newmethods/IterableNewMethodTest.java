package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IterableNewMethodTest {

    private IterableNewMethod iterableNewMethod;

    @BeforeEach
    void setUp() {
        iterableNewMethod = new IterableNewMethod();
    }

    @Test
    @DisplayName("Should return names in upper case")
    void shouldReturnNamesInUpperCase() {
        List<String> expectedList = Arrays.asList("ARTEMAS", "THOMAS", "BOB");

        List<String> namesUpperCased = iterableNewMethod.names();

        assertThat(namesUpperCased).isEqualTo(expectedList);
    }
}