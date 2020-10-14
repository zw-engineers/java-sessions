package com.stringsio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringConcatTest {

    private StringConcat stringConcat;

    @BeforeEach
    void before() {
        stringConcat = new StringConcat();
    }

    @Test
    @DisplayName("Should return a string concat using the plus sign")
    void should_return_a_string_concat_using_the_plus_sign() {
        String concatenatedString = stringConcat.usePlusSymbol("Hello", "World");

        assertThat(concatenatedString).isEqualTo("Hello World");
    }

    @Test
    @DisplayName("Should return a concat string using string buffer")
    void should_return_a_concat_string_using_string_buffer() {
        String concatenatedString = stringConcat.useStringBuffer("Hello", "World");

        assertThat(concatenatedString).isEqualTo("Hello World");
    }

    @Test
    @DisplayName("Should return a concat string using string builder")
    void should_return_a_concat_string_using_string_builder() {
        String concatenatedString = stringConcat.useStringBuilder("Hello", "World");

        assertThat(concatenatedString).isEqualTo("Hello World");
    }

    @Test
    @DisplayName("Should return a concat string using string joiner")
    void should_return_a_concat_string_using_string_joiner() {
        String concatenatedString = stringConcat.useStringJoiner("Hello", "World");

        assertThat(concatenatedString).isEqualTo("{Hello, World}");
    }

    @Test
    @DisplayName("Should return a concat string using string joiner 2")
    void should_return_a_concar_string_using_string_joiner_2() {
        String[] strings = { "one", "two", "three" };

        String concatenatedString = stringConcat.useStringJoiner(strings);

        assertThat(concatenatedString).isEqualTo("one, two, three");
    }
}
