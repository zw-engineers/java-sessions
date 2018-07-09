package com.stringsio;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleIOTest {

    private ExampleIO exampleIO;

    @Before
    public void before() {
        exampleIO = new ExampleIO();
    }

    @Test
    public void should_return_true_when_file_location_exists_and_file_contains_ERROR_word() {
        String location = "src/main/resources/example.txt";
        assertThat(exampleIO.doesFileExist(location)).isEqualTo(true);
    }

    @Test
    public void should_return_false_when_file_location_is_invalid() {
        String location = "example.txt";
        assertThat(exampleIO.doesFileExist(location)).isEqualTo(false);
    }

    @Test(expected = NoSuchElementException.class)
    public void should_return_NoSuchElementException_when_file_does_not_contain_ERROR_word() {
        String location = "src/main/resources/people.txt";
        assertThat(exampleIO.doesFileExist(location)).isEqualTo(false);
    }
}
