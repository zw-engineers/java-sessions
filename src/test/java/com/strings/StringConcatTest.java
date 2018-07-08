package com.strings;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringConcatTest {

    private StringConcat stringConcat;

    @Before
    public void before() {
        stringConcat = new StringConcat();
    }

    @Test
    public void should_return_a_string_concat_using_the_plus_sign() {
        assertThat(stringConcat.usePlusSymbol("Hello", "World")).isEqualTo("Hello World");
    }

    @Test
    public void should_return_a_concat_string_using_string_buffer() {
        assertThat(stringConcat.useStringBuffer("Hello", "World")).isEqualTo("Hello World");
    }

    @Test
    public void should_return_a_concat_string_using_string_builder() {
        assertThat(stringConcat.useStringBuilder("Hello", "World")).isEqualTo("Hello World");
    }

    @Test
    public void should_return_a_concat_string_using_string_joiner() {
        assertThat(stringConcat.useStringJoiner("Hello", "World")).isEqualTo("{Hello, World}");
    }

    @Test
    public void should_return_a_concar_string_using_string_joiner_2() {
        String[] strings = {"one", "two", "three"};
        assertThat(stringConcat.useStringJoiner(strings)).isEqualTo("one, two, three");
    }

}